package com.zp.license.conf;

import java.net.InetAddress;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: license
 * @ClassName WindowsServerInfos
 * @Description TODO
 * @date 2022/12/9 11:06
 * @Version 1.0
 */

public class WindowsServerInfos extends AbstractServerInfos {

    /**
    * @Author: license
    * @Description: 获取IP地址
    * @DateTime: 18:01 2022/12/9
    * @Params:
    * @Return
    */
    @Override
    protected List<String> getIpAddress() throws Exception {
        List<String> result = null;

        //获取所有网络接口
        List<InetAddress> inetAddresses = getLocalAllInetAddress();

        if (inetAddresses != null && inetAddresses.size() > 0) {
            result = inetAddresses.stream().map(InetAddress::getHostAddress).distinct().map(String::toLowerCase).collect(Collectors.toList());
        }

        return result;
    }

    /**
    * @Author: license
    * @Description: 获取mac地址
    * @DateTime: 18:01 2022/12/9
    * @Params:
    * @Return
    */
    @Override
    protected List<String> getMacAddress() throws Exception {
        List<String> result = null;

        //1. 获取所有网络接口
        List<InetAddress> inetAddresses = getLocalAllInetAddress();

        if (inetAddresses != null && inetAddresses.size() > 0) {
            //2. 获取所有网络接口的Mac地址
            result = inetAddresses.stream().map(this::getMacByInetAddress).distinct().collect(Collectors.toList());
        }

        return result;
    }

    /**
     * @Author: license
     * @Description: 获取cpu序列号
     * @DateTime: 18:01 2022/12/9
     * @Params:
     * @Return
     */
    @Override
    protected String getCPUSerial() throws Exception {
        //序列号
        String serialNumber = "";

        //使用WMIC获取CPU序列号
        Process process = Runtime.getRuntime().exec("wmic cpu get processorid");
        process.getOutputStream().close();
        Scanner scanner = new Scanner(process.getInputStream());

        if (scanner.hasNext()) {
            scanner.next();
        }

        if (scanner.hasNext()) {
            serialNumber = scanner.next().trim();
        }

        scanner.close();
        return serialNumber;
    }

    /**
     * @Author: license
     * @Description: 获取主板序列号
     * @DateTime: 18:01 2022/12/9
     * @Params:
     * @Return
     */
    @Override
    protected String getMainBoardSerial() throws Exception {
        //序列号
        String serialNumber = "";

        //使用WMIC获取主板序列号
        Process process = Runtime.getRuntime().exec("wmic baseboard get serialnumber");
        process.getOutputStream().close();
        Scanner scanner = new Scanner(process.getInputStream());

        if (scanner.hasNext()) {
            scanner.next();
        }

        if (scanner.hasNext()) {
            serialNumber = scanner.next().trim();
        }

        scanner.close();
        return serialNumber;
    }
}