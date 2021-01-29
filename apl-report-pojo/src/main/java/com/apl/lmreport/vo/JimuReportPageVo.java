package com.apl.lmreport.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author hjr start
 * @Classname JimuReportPageVo
 * @Date 2021/1/25 16:44
 */
@Data
@ApiModel(value = "报表-分页返回对象", description = "报表-分页返回对象")
public class JimuReportPageVo implements Serializable {

    private Integer resCount;

    private Integer pageSize;

    private Integer pageIndex;

    private List<JimuReportVo> jimuReportVoList;
}
