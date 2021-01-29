package com.apl.lmreport.dto;

import com.apl.lib.validate.TypeValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author hjr start
 * @Classname JimuReportPo
 * @Date 2021/1/25 14:34
 */
@Data
@ApiModel(value = "报表-新增对象", description = "报表-新增对象")
public class JimuReportUpdDto implements Serializable {

    @ApiModelProperty(name = "id", value = "id", required = true)
    private Long id;

    @ApiModelProperty(name = "name", value = "报表名称", required = true)
    @NotBlank(message = "报表名称不能为空")
    private String name;

    @ApiModelProperty(name = "type", value = "报表类型 :printinfo打印设计  datainfo数据报表 chartinfo图形报表", required = true)
    @NotBlank(message = "报表类型不能为空")
    private String type;

    @ApiModelProperty(name = "jsonStr", value = "json字符串")
    private String jsonStr;

    @ApiModelProperty(name = "template", value = "是否是模板 0是 1不是", required = true)
    @NotNull(message = "是否是模板不能为空")
    @TypeValidator(value = {"0","1"}, message = "是否是模板值只能为0或者1")
    private Integer template;
}
