package com.apl.lmreport.po;

import com.apl.lib.validate.TypeValidator;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author hjr start
 * @Classname JimuReportPo
 * @Date 2021/1/25 14:34
 */
@Data
@ApiModel(value = "报表-持久化对象", description = "报表-持久化对象")
@TableName("jimu_report")
public class JimuReportPo extends Model<JimuReportPo> implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(name = "id", value = "id")
    private Long id;

    @ApiModelProperty(name = "code", value = "报表编码")
    private String code;

    @ApiModelProperty(name = "name", value = "报表名称")
    private String name;

    @ApiModelProperty(name = "type", value = "报表类型 :printinfo打印设计  datainfo数据报表 chartinfo图形报表")
    private String type;

    @ApiModelProperty(name = "jsonStr", value = "json字符串")
    private String jsonStr;

    @ApiModelProperty(name = "createBy", value = "创建人")
    private String createBy;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(name = "updateBy", value = "修改人")
    private String updateBy;

    @ApiModelProperty(name = "updateTime", value = "修改时间")
    private Timestamp updateTime;

    @ApiModelProperty(name = "delFlag", value = "修改标识 0正常 1已删除")
    private Integer delFlag;

    @ApiModelProperty(name = "template", value = "是否是模板")
    private Integer template;

    @ApiModelProperty(name = "reportBrand", value = "报表品牌:  1: jimu / 2: stimulsoft")
    private Integer reportBrand;
}
