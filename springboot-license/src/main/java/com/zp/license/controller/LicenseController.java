package com.zp.license.controller;

import com.zp.license.conf.AbstractServerInfos;
import com.zp.license.conf.LinuxServerInfos;
import com.zp.license.conf.WindowsServerInfos;
import com.zp.license.entity.LicenseCheckModel;
import com.zp.license.entity.LicenseCreatorParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: license
 * @ClassName LicenseController
 * @Description TODO
 * @date 2022/12/9 11:15
 * @Version 1.0
 */
@RestController
@Api(tags = "license证书")
@RequestMapping("/license")
public class LicenseController {

    /**
     * 证书生成路径
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
    * @Author: license
    * @Description: 获取服务器硬件信息
    * @DateTime: 11:18 2022/12/9
    * @Params:  osName 系统类型 windows或linux
    * @Return
    */
    @ApiOperation("获取服务器硬件信息")
    @GetMapping("/getServerInfos/{osName}")
    public LicenseCheckModel getServerInfos(@PathVariable String osName) {
        //操作系统类型
        if (StringUtils.isBlank(osName)) {
            osName = System.getProperty("os.name");
        }
        osName = osName.toLowerCase();

        AbstractServerInfos abstractServerInfos = null;

        //根据不同操作系统类型选择不同的数据获取方法
        if (osName.startsWith("windows")) {
            abstractServerInfos = new WindowsServerInfos();
        } else if (osName.startsWith("linux")) {
            abstractServerInfos = new LinuxServerInfos();
        } else {//其他服务器类型
            abstractServerInfos = new LinuxServerInfos();
        }

        return abstractServerInfos.getServerInfos();
    }

    /**
    * @Author: license
    * @Description: 生成证书
    * @DateTime: 11:18 2022/12/9
    * @Params:
    * @Return
    */
    @ApiOperation("生成证书")
    @PostMapping("/generateLicense")
    public Map<String, Object> generateLicense(@RequestBody LicenseCreatorParam param) {
        Map<String, Object> resultMap = new HashMap<>(2);

        if (StringUtils.isBlank(param.getLicensePath())) {
            param.setLicensePath(licensePath);
        }

        LicenseCreator licenseCreator = new LicenseCreator(param);
        boolean result = licenseCreator.generateLicense();

        if (result) {
            resultMap.put("result", "ok");
            resultMap.put("msg", param);
        } else {
            resultMap.put("result", "error");
            resultMap.put("msg", "证书文件生成失败！");
        }

        return resultMap;
    }




}