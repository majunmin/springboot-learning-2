package com.mjm.swagger.learning.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-04 15:51
 * @since
 */
@Data
@ApiModel("用户实体")
public class User {

    @NotNull
    @ApiModelProperty("用户id")
    private Integer id;

    @NotEmpty
    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("用户性别")
    private String sex;

    @ApiModelProperty("用户年龄")
    private Integer age;
}
