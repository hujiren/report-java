package com.apl.jmreport.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.apl.db.adb.AdbPageVo;
import com.apl.jmreport.dao.ReportDao;
import com.apl.jmreport.service.ReportService;
import com.apl.lib.constants.CommonAplConstants;
import com.apl.lib.constants.CommonStatusCode;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lib.utils.ResultUtil;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lmreport.dto.JimuReportAddDto;
import com.apl.lmreport.dto.JimuReportUpdDto;
import com.apl.lmreport.po.JimuReportPo;
import com.apl.lmreport.vo.JimuReportPageVo;
import com.apl.lmreport.vo.JimuReportVo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author hjr start
 * @Classname JimuReportServiceImpl
 * @Date 2021/1/25 11:50
 */
@Service(value = "ReportServiceImpl")
public class ReportServiceImpl implements ReportService {

    enum JimuReportServiceImplEnum{

        THE_TARGET_DATA_DOES_NOT_EXIST("THE_TARGET_DATA_DOES_NOT_EXIST", "目标数据不存在");

        private String code;
        private String msg;

        JimuReportServiceImplEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    @Autowired
    ReportDao reportDao;

    @Value(value = "${spring.datasource.druid.stat-view-servlet.loginUsername:}")
    String creater;

    @Value(value = "${apl.ip:}")
    String ip;

    @Value(value = "${apl.port}")
    String port;

    String url = "/lms-waybill/waybill/print-waybill-basic";

    //查询列表
    @Override
    public ResultUtil<JimuReportPageVo> getList(PageDto pageDto, Integer isTemplate) {
        AdbPageVo<JimuReportVo> jimuReportAdbPageVo = reportDao.getList(pageDto, isTemplate);
        JimuReportPageVo jimuReportPageVo = new JimuReportPageVo();
        if(jimuReportAdbPageVo.getList().size() < 1)
            return ResultUtil.APPRESULT(JimuReportServiceImplEnum.THE_TARGET_DATA_DOES_NOT_EXIST.code,
                    JimuReportServiceImplEnum.THE_TARGET_DATA_DOES_NOT_EXIST.msg, jimuReportPageVo);

        List<JimuReportVo> jimuReportVoList = jimuReportAdbPageVo.getList();
        jimuReportPageVo.setJimuReportVoList(jimuReportVoList);
        jimuReportPageVo.setPageIndex(pageDto.getPageIndex());
        jimuReportPageVo.setPageSize(pageDto.getPageSize());
        jimuReportPageVo.setResCount(jimuReportAdbPageVo.getRsCount());
        return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, jimuReportPageVo);
    }

    //删除
    @Override
    public ResultUtil<Boolean> delJimuReport(Long id) {
        Integer resultInteger = reportDao.updateReportStatusById(id);

        if(resultInteger > 0)
            return ResultUtil.APPRESULT(CommonStatusCode.DEL_SUCCESS, true);

        return ResultUtil.APPRESULT(CommonStatusCode.DEL_FAIL, false);
    }

    //更新
    @Override
    public ResultUtil<Boolean> updJimuReport(JimuReportUpdDto jimuReportUpdDto) throws Exception {

        ResultUtil<JimuReportVo> jimuReportVoResultUtil = get(jimuReportUpdDto.getId());
        if(null == jimuReportVoResultUtil.getData())
            return ResultUtil.APPRESULT(jimuReportVoResultUtil.getCode(), jimuReportVoResultUtil.getMsg(), false);

        JimuReportPo jimuReportPo = new JimuReportPo();
        BeanUtils.copyProperties(jimuReportUpdDto, jimuReportPo);
        jimuReportPo.setUpdateBy(creater);
        jimuReportPo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        Integer resultInteger = reportDao.upd(jimuReportPo);

        if(resultInteger > 0)
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);

        return ResultUtil.APPRESULT(JimuReportServiceImplEnum.THE_TARGET_DATA_DOES_NOT_EXIST.code,
                JimuReportServiceImplEnum.THE_TARGET_DATA_DOES_NOT_EXIST.msg, true);
    }

    //新增
    @Override
    public ResultUtil<String> addJimuReport(JimuReportAddDto jimuReportAddDto) throws Exception {
        JimuReportPo jimuReportPo = new JimuReportPo();
        BeanUtils.copyProperties(jimuReportAddDto, jimuReportPo);

        Long thisMoment = System.currentTimeMillis();
        jimuReportPo.setId(SnowflakeIdWorker.generateId());
        jimuReportPo.setCode(thisMoment.toString().replace("-", "").replace(":", "").replace(" ",""));
        jimuReportPo.setCreateBy(creater);
        jimuReportPo.setCreateTime(new Timestamp(thisMoment));
        jimuReportPo.setDelFlag(0);

        Integer resultInteger = reportDao.add(jimuReportPo);

        if(resultInteger > 0)
            return ResultUtil.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);

        return ResultUtil.APPRESULT(CommonStatusCode.SAVE_FAIL, false);
    }

    //获取详细
    @Override
    public ResultUtil<JimuReportVo> get(Long id) {
        JimuReportVo jimuReportVo = reportDao.get(id);
        if(null != jimuReportVo)
            return ResultUtil.APPRESULT(CommonStatusCode.GET_SUCCESS, jimuReportVo);

        return ResultUtil.APPRESULT(JimuReportServiceImplEnum.THE_TARGET_DATA_DOES_NOT_EXIST.code,
                JimuReportServiceImplEnum.THE_TARGET_DATA_DOES_NOT_EXIST.msg, null);
    }

    //获取运单详细
    @Override
    public JSONObject getWaybill(Long id) throws Exception {
       // + "?waybillId=" + id + "&token=" + token
        String token = CommonContextHolder.getHeader(CommonAplConstants.TOKEN_FLAG);
        HttpPost httpPost = new HttpPost();
        httpPost.setURI(new URI("http://" + ip + ":" + port + url));
        httpPost.addHeader("waybiilId", id.toString());
        httpPost.addHeader("token", token);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        ObjectInputStream ois = new ObjectInputStream(httpEntity.getContent());
        Object o = ois.readObject();
        return null;
    }
}
