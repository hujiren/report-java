package com.apl.jmreport.dao;

import com.apl.db.adb.AdbHelper;
import com.apl.db.adb.AdbPageVo;
import com.apl.jmreport.mapper.ReportMapper;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lmreport.po.JimuReportPo;
import com.apl.lmreport.vo.JimuReportVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author hjr start
 * @Classname JimuReportDao
 * @Date 2021/1/25 11:51
 */
@Repository
public class ReportDao extends ServiceImpl<ReportMapper, JimuReportPo> {

    @Autowired
    AdbHelper adbHelper;

    //获取列表
    public AdbPageVo<JimuReportVo> getList(PageDto pageDto, Integer isTemplate) {

        StringBuffer sql = new StringBuffer();
        sql.append("select id, code, name, type, create_by, create_time, report_brand from jimu_report.jimu_report where del_flag = 0");
        if(isTemplate.equals(1))
            sql.append(" and template = 0");
        else
            sql.append(" and template = 1");
        adbHelper.setDbType(1);
        AdbPageVo<JimuReportVo> jimuReportVoAdbPageVo = adbHelper.queryPage(sql.toString(), new Object(), JimuReportVo.class, pageDto.getPageIndex(), pageDto.getPageSize());
        return jimuReportVoAdbPageVo;
    }

    //修改状态
    public Integer updateReportStatusById(Long id) {
        String sql = "update jimu_report.jimu_report set del_flag = 1 where id = " + id;
        Integer resultInteger = adbHelper.update(sql);
        return resultInteger;
    }

    //更新
    public Integer upd(JimuReportPo jimuReportPo) throws Exception {
        Integer resultInteger = adbHelper.updateById(jimuReportPo, "jimu_report");
        return resultInteger;
    }

    //新增
    public Integer add(JimuReportPo jimuReportPo) throws Exception {
        Integer resultInteger = adbHelper.insert(jimuReportPo, "jimu_report");
        return resultInteger;
    }

    //获取详细
    public JimuReportVo get(Long id) {
        String sql = "select id, code, name, type, json_str, create_by, create_time, update_by, report_brand, " +
                "update_time, del_flag, template from jimu_report.jimu_report where id = " + id + " and del_flag = 0";
        JimuReportVo jimuReportVo = adbHelper.queryObj(sql, null, JimuReportVo.class);
        return jimuReportVo;
    }
}
