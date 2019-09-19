package com.jemmyee.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


//@Configuration
@PropertySource(value="classpath:zfbinfo.properties")
public class SwiftpassConfig {

    @Value("${open_api_domain}")
    public static String openApiDomain;

    @Value("${mcloud_api_domain}")
    public static String mcloudApiDomain;

    @Value("${pid}")
    public static String pid;

    @Value("${appid}")
    public static String appid;

    @Value("${private_key}")
    public static String privateKey;

    @Value("${public_key}")
    public static String publicKey;

    @Value("${alipay_public_key}")
    public  static String alipayPublicKey;

    @Value("${sign_type}")
    public static String signType;

    @Value("${max_query_retry}")
    public static Integer maxQueryRetry;

    @Value("${query_duration}")
    public static Long queryDuration;

    @Value("${max_cancel_retry}")
    public static Integer maxCancelRetry;

    @Value("${cancel_duration}")
    public static Long cancelDuration;

    @Value("${heartbeat_delay}")
    public static Long heartbeatDelay;

    @Value("${heartbeat_duration}")
    public static Long heartbeatDuration;

}
