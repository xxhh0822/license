package com.zp.license.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: license
 * @ClassName LicenseCheckModel
 * @Description TODO
 * @date 2022/12/9 11:00
 * @Version 1.0
 */
@ApiModel("设备信息实体类")
public class LicenseCheckModel implements Serializable {

    private static final long serialVersionUID = -2314678441082223148L;

    @ApiModelProperty("可被允许的IP地址")
    private List<String> ipAddress;

    @ApiModelProperty("可被允许的MAC地址")
    private List<String> macAddress;

    @ApiModelProperty("可被允许的CPU序列号")
    private String cpuSerial;

    @ApiModelProperty("可被允许的主板序列号")
    private String mainBoardSerial;

    public List<String> getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(List<String> ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<String> getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(List<String> macAddress) {
        this.macAddress = macAddress;
    }

    public String getCpuSerial() {
        return cpuSerial;
    }

    public void setCpuSerial(String cpuSerial) {
        this.cpuSerial = cpuSerial;
    }

    public String getMainBoardSerial() {
        return mainBoardSerial;
    }

    public void setMainBoardSerial(String mainBoardSerial) {
        this.mainBoardSerial = mainBoardSerial;
    }
}