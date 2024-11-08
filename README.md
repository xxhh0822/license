# 授权认证服务
## springboot-license 是生成授权文件
## springboot-license-client 校验授权服务
```xml
keytool -genkey -keysize 1024 -keyalg DSA -validity 3650 -alias "privateKey" -keystore "privateKeys.keystore" -storepass "ygzwms5656" -keypass "ygzwms5656" -dname "CN=localhost, OU=localhost, O=localhost, L=SH, ST=SH, C=CN"

keytool -exportcert -alias "privateKey" -keystore "privateKeys.keystore" -storepass "ygzwms5656" -file "certfile.cer"

keytool -import -alias "publicCert" -file "certfile.cer" -keystore "publicCerts.keystore" -storepass "ygzwms5656"
```
### 根据获取的硬件信息生成`license.lic`证书

> 以下参数需修改
>
> 1. licensePath 和 privateKeysStorePath 位置
> 2. licenseCheckModel中四个参数的信息，必须修改

```json
# windows环境
{
    "subject": "ygzwms",
    "privateAlias": "privateKey",
    "keyPass": "ygzwms5656", 
    "storePass": "ygzwms5656",
    "licensePath": "D:/wms/license.lic", 
    "privateKeysStorePath": "D:/wms/privateKeys.keystore",
    "issuedTime": "2022-12-09 00:00:00", 
    "expiryTime": "2099-12-09 00:00:00", 
    "consumerType": "user", 
    "consumerAmount": 1, 
    "description": "这是证书描述信息", 
    "licenseCheckModel": {  
        "ipAddress": [
            "192.168.27.1"
        ],
        "macAddress": [
            "EC-63-D7-3F-62-95"
        ],
        "cpuSerial": "BFEBFBFF000806D1",
        "mainBoardSerial": "PF2XE9FC"
    }
}

# linux环境
{
    "subject": "ygzwms",
    "privateAlias": "privateKey",
    "keyPass": "ygzwms5656", 
    "storePass": "ygzwms5656",
    "licensePath": "/wms/license.lic", 
    "privateKeysStorePath": "/wms/privateKeys.keystore",
    "issuedTime": "2022-12-09 00:00:00", 
    "expiryTime": "2099-12-09 00:00:00", 
    "consumerType": "user", 
    "consumerAmount": 1, 
    "description": "这是证书描述信息", 
    "licenseCheckModel": {  
        "ipAddress": [
            "192.168.27.1"
        ],
        "macAddress": [
            "EC-63-D7-3F-62-95"
        ],
        "cpuSerial": "BFEBFBFF000806D1",
        "mainBoardSerial": "PF2XE9FC"
    }
}
# linux 
{
    "subject": "ygzwms",
    "privateAlias": "privateKey",
    "keyPass": "ygzwms5656", 
    "storePass": "ygzwms5656",
    "licensePath": "/ygz/wms/license/license.lic", 
    "privateKeysStorePath": "/ygz/wms/license/privateKeys.keystore",
    "issuedTime": "2022-12-09 00:00:00", 
    "expiryTime": "2099-12-09 00:00:00", 
    "consumerType": "user", 
    "consumerAmount": 1, 
    "description": "这是证书描述信息", 
    "licenseCheckModel": {  
        "ipAddress": [
            "172.24.11.55"
        ],
        "macAddress": [
            "00-16-3E-03-6A-60"
        ],
        "cpuSerial": "54 06 05 00 FF FB 8B 0F",
        "mainBoardSerial": "95fdcef8-8805-4035-9a89-bf53fbe22759"
    }
}
```
