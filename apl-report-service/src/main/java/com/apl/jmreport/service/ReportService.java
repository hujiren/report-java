package com.apl.jmreport.service;

import com.alibaba.fastjson.JSONObject;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lmreport.dto.JimuReportAddDto;
import com.apl.lmreport.dto.JimuReportUpdDto;
import com.apl.lmreport.vo.JimuReportPageVo;
import com.apl.lmreport.vo.JimuReportVo;

import java.net.URISyntaxException;
import java.util.List;

/**
 * @author hjr start
 * @Classname JimuReportService
 * @Date 2021/1/25 11:50
 */
public interface ReportService {

    //获取列表
    ResultUtil<JimuReportPageVo> getList(PageDto pageDto, Integer isTemplate);

    //删除
    ResultUtil<Boolean> delJimuReport(Long id);

    //更新
    ResultUtil<Boolean> updJimuReport(JimuReportUpdDto jimuReportUpdDto) throws Exception;

    //新增
    ResultUtil<String> addJimuReport(JimuReportAddDto jimuReportAddDto) throws Exception;

    //获取详细
    ResultUtil<JimuReportVo> get(Long id);

    //获取运单详细(报表)
    JSONObject getWaybill(Long id) throws URISyntaxException, Exception;
}
