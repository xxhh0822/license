package com.zp.license.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: license
 * @ClassName LicenseCreatorParam
 * @Description TODO
 * @date 2022/12/9 11:02
 * @Version 1.0
 */
@ApiModel("生成证书实体类")
public class LicenseCreatorParam implements Serializable {

    private static final long serialVersionUID = 2832129012982731724L;

    @ApiModelProperty("证书subject")
    private String subject;

    @ApiModelProperty("密钥别称")
    private String privateAlias;

    @ApiModelProperty("密钥密码")
    private String keyPass;

    @ApiModelProperty("访问秘钥库的密码")
    private String storePass;

    @ApiModelProperty("证书生成路径")
    private String licensePath;

    @ApiModelProperty("密钥库存储路径")
    private String privateKeysStorePath;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("证书生效时间")
    private Date issuedTime = new Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("证书失效时间")
    private Date expiryTime;

    @ApiModelProperty("用户类型")
    private String consumerType = "user";

    @ApiModelProperty("用户数量")
    private Integer consumerAmount = 1;

    @ApiModelProperty("描述信息")
    private String description = "";

    @ApiModelProperty("额外的服务器硬件校验信息")
    private LicenseCheckModel licenseCheckModel;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrivateAlias() {
        return privateAlias;
    }

    public void setPrivateAlias(String privateAlias) {
        this.privateAlias = privateAlias;
    }

    public String getKeyPass() {
        return keyPass;
    }

    public void setKeyPass(String keyPass) {
        this.keyPass = keyPass;
    }

    public String getStorePass() {
        return storePass;
    }

    public void setStorePass(String storePass) {
        this.storePass = storePass;
    }

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public String getPrivateKeysStorePath() {
        return privateKeysStorePath;
    }

    public void setPrivateKeysStorePath(String privateKeysStorePath) {
        this.privateKeysStorePath = privateKeysStorePath;
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public Integer getConsumerAmount() {
        return consumerAmount;
    }

    public void setConsumerAmount(Integer consumerAmount) {
        this.consumerAmount = consumerAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenseCheckModel getLicenseCheckModel() {
        return licenseCheckModel;
    }

    public void setLicenseCheckModel(LicenseCheckModel licenseCheckModel) {
        this.licenseCheckModel = licenseCheckModel;
    }
}