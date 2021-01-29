package com.apl.lmreport.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author hjr start
 * @Classname JimuReportPo
 * @Date 2021/1/25 14:34
 */
@Data
@ApiModel(value = "报表-返回对象", description = "报表-返回对象")
public class JimuReportVo implements Serializable {

    @ApiModelProperty(name = "id", value = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty(name = "code", value = "报表编码")
    private String code;

    @ApiModelProperty(name = "name", value = "报表名称")
    private String name;

    @ApiModelProperty(name = "type", value = "报表类型 :printinfo打印设计  datainfo数据报表 chartinfo图形报表")
    private String type;

    @ApiModelProperty(name = "reportBrand", value = "报表品牌:  1: jimu / 2: stimulsoft")
    private Integer reportBrand;

    @ApiModelProperty(name = "createBy", value = "创建人")
    private String createBy;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(name = "updateBy", value = "修改人")
    private String updateBy;

    @ApiModelProperty(name = "updateTime", value = "修改时间")
    private Timestamp updateTime;

}
