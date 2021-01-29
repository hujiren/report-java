package com.apl.jmreport.controller;

import com.apl.jmreport.service.ReportService;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtil;
import com.apl.lmreport.vo.JimuReportPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjr start
 * @Classname ReportController
 * @Date 2021/1/29 11:13
 */
@RestController
@RequestMapping("/report")
@Api(value = "报表", tags = "报表")
public class ReportController {
    
    @Autowired
    ReportService reportService;

    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查询报表" , notes = "分页查询报表")
    @ApiImplicitParam(name = "isTemplate", value = "是否是模板", required = true, paramType = "query")
    public ResultUtil<JimuReportPageVo> getList(PageDto pageDto, Integer isTemplate){
        return reportService.getList(pageDto, isTemplate);
    }

    @PostMapping("/del")
    @ApiOperation(value =  "删除报表" , notes = "删除报表")
    @ApiImplicitParam(name = "id", value = "运单id", required = true, paramType = "query")
    public ResultUtil<Boolean> delJimuReport(Long id){
        return reportService.delJimuReport(id);
    }
}
