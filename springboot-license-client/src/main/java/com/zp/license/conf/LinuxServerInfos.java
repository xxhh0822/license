package com.zp.license.conf;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: license
 * @ClassName LinuxServerInfos
 * @Description TODO
 * @date 2022/12/9 11:07
 * @Version 1.0
 */

public class LinuxServerInfos extends AbstractServerInfos{

    @Override
    protected List<String> getIpAddress() throws Exception {
        List<String> result = null;

        //获取所有网络接口
        List<InetAddress> inetAddresses = getLocalAllInetAddress();

        if(inetAddresses != null && inetAddresses.size() > 0){
            result = inetAddresses.stream().map(InetAddress::getHostAddress).distinct().map(String::toLowerCase).collect(Collectors.toList());
        }

        return result;
    }

    @Override
    protected List<String> getMacAddress() throws Exception {
        List<String> result = null;

        //1. 获取所有网络接口
        List<InetAddress> inetAddresses = getLocalAllInetAddress();

        if(inetAddresses != null && inetAddresses.size() > 0){
            //2. 获取所有网络接口的Mac地址
            result = inetAddresses.stream().map(this::getMacByInetAddress).distinct().collect(Collectors.toList());
        }

        return result;
    }

    @Override
    protected String getCPUSerial() throws Exception {
        //序列号
        String serialNumber = "";

        //使用dmidecode命令获取CPU序列号
        String[] shell = {"/bin/bash","-c","dmidecode -t processor | grep 'ID' | awk -F ':' '{print $2}' | head -n 1"};
        Process process = Runtime.getRuntime().exec(shell);
        process.getOutputStream().close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = reader.readLine().trim();
        if(StringUtils.isNotBlank(line)){
            serialNumber = line;
        }

        reader.close();
        return serialNumber;
    }

    @Override
    protected String getMainBoardSerial() throws Exception {
        //序列号
        String serialNumber = "";

        //使用dmidecode命令获取主板序列号
        String[] shell = {"/bin/bash","-c","dmidecode | grep 'Serial Number' | awk -F ':' '{print $2}' | head -n 1"};
        Process process = Runtime.getRuntime().exec(shell);
        process.getOutputStream().close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = reader.readLine().trim();
        if(StringUtils.isNotBlank(line)){
            serialNumber = line;
        }

        reader.close();
        return serialNumber;
    }
}