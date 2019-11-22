package com.neusoft.graduation.component;

/**
 * @ClassName StaticParam
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/11/20 15:45
 * Version 1.0
 **/
public class StaticParam {
    /**
     * 手机验证部分配置
     */
    // 设置超时时间-可自行调整
    final static String defaultConnectTimeout  = "sun.net.client.defaultConnectTimeout";
    final static String defaultReadTimeout = "sun.net.client.defaultReadTimeout";
    final static String Timeout = "10000";
    // 初始化ascClient需要的几个参数
    final static String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
    final static String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
    // 替换成你的AK (产品密)
    final static String accessKeyId = "LTAI4FjJozdLfiXfJbYiphVg";// 你的accessKeyId,填你自己的 上文配置所得  自行配置
    final static String accessKeySecret = "INTEMrgoG586zD54eYUneGx2MGw2M9";// 你的accessKeySecret,填你自己的 上文配置所得 自行配置
    // 必填:短信签名-可在短信控制台中找到
    final static String SignName = "小菜菜平台";    // 阿里云配置你自己的短信签名填入
    // 必填:短信模板-可在短信控制台中找到
    final static String TemplateCode = "SMS_177549058"; // 阿里云配置你自己的短信模板填入

}
