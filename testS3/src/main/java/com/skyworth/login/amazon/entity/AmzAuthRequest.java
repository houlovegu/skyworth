package com.skyworth.login.amazon.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AmzAuthRequest
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 8:36
 * @Version 1.0
 **/
@ApiModel
@Data
public class AmzAuthRequest implements Serializable {

    @ApiModelProperty("access_token")
    private String access_token;

    @ApiModelProperty("token_type")
    private String token_type;

    @ApiModelProperty("expires_in")
    private Long expires_in;

    @ApiModelProperty("scope")
    private String scope;
}
