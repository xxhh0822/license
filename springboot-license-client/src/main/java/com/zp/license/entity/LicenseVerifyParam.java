package com.zp.license.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: license
 * @ClassName LicenseVerifyParam
 * @Description TODO
 * @date 2022/12/9 17:21
 * @Version 1.0
 */

public class LicenseVerifyParam {

    @ApiModelProperty("证书subject")
    private String subject;

    @ApiModelProperty("公钥别称")
    private String publicAlias;

    @ApiModelProperty("访问公钥库的密码")
    private String storePass;

    @ApiModelProperty("证书生成路径")
    private String licensePath;

    @ApiModelProperty("密钥库存储路径")
    private String publicKeysStorePath;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublicAlias() {
        return publicAlias;
    }

    public void setPublicAlias(String publicAlias) {
        this.publicAlias = publicAlias;
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

    public String getPublicKeysStorePath() {
        return publicKeysStorePath;
    }

    public void setPublicKeysStorePath(String publicKeysStorePath) {
        this.publicKeysStorePath = publicKeysStorePath;
    }
}