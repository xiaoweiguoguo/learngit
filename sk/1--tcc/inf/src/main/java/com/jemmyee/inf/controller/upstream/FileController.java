package com.jemmyee.inf.controller.upstream;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * 文件服务
 * @author jemmyee
 * @create 2017-06-07
 **/
@Api(value="alipay", description="支付宝支付")
@Controller("FileController")
@RequestMapping("/payment")
public class FileController {
    /** 版本号 */
    public static String VERSION_NUMBER="2017.11.16.10";
    /** 文件名称 */
    public static String VERSION_File="kkpk.jar";
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    //取得根目录路径
    public final String rootPath = getClass().getResource("/").getFile().toString();
    public final String ROOT = rootPath.replace("target/classes","src/main/webapp/WEB-INF/upload");

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    /**
     * 获取阿里二维码
     */
    @ApiOperation(value="获取支付宝二维码",notes="获取支付宝二维码")
    @RequestMapping(value="/getAlipayCode",method= RequestMethod.POST)
    @ResponseBody
    public String  getAlipayCode(@RequestBody Vo vo, HttpServletRequest req, HttpSession session) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipay.com/gateway.do",
                "2018051060110233",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCgNwD68X+MMG+EPxUMn2+O9R7cuYakMj4dkB82rlN/bfKqz0KZRNGGKaKVQEPA+Qt0RitDKkA6Y55pCnHLux1mbyOyM+Tqd2N7l22Ymfy6gST+aqZtNuldWNzaJgCpu3uGL/Fof8JvJJHxf05f6tBHUtinotaWklYlND/ekQy38eEk8IkTB8jmDB3W+w53L4nInYBKfXrFgT8TloAfAv/hvZvvpclcD8ALKHpAWAH3Xpe3VmlyPE0OVyoxa7K1vIbpDPG1CG2MPl63EBrwAlkRQ43fiFd/BB/JzSCK2h1ArtkelhxXjClk01DduG/lbZ93vQHohnqhH4H0rUs0bHg/AgMBAAECggEATZr3FZbfIoffrJ5l0sxz3DptrZsMVgKkReumwvTkKyiV0Bk++ED2gNcwEr2jVBkObE8E667Ol7njZJwTjQzg69pP3yT18IDOJnKuOqn0Wl7uDXKZlPNxTK8bo2ufDJhs+A3HEMg55V5Ad0skKp/yLWo62dCtwxe1NKY/fc6i64IugvK3xXVV9VE6IO4CgoGdz+arXBkzD+RAJEseSmlzq99+8SEqJn627Btrac9Dgs9Suw8jCRhZeRTI24iADoxeP5n0LEzhSLhbj8VWgqJnEPRXMg2vEgGQoJxhLGkVNadPVjLZzMFHu6r5NN5VUeubaC651qkr0Ibo2GeF9WxSAQKBgQDvmt1R+s8M7BZgP3TyTDIRSn5chZd5pAY+mkkV3hNOLy0e0bsQwRvubXCTI9f7vOF2DWvkfcF1GSyib92ovgl67cXR/KgIUHDAK+DKKgtmQcHBqiHUhicgDH8eMdi/iun9edmCuXXxi5yqVsVnGX+lF+pAp3eTHMoh4WT0V+i3AQKBgQCrLXimVvXxVRWnxMunFjk/nHrN2KbBTzn8zNqn6KJ8eIQ5eAKMevqMkkGcqxQvugCTGcKqPgXXunjsaWCXkUvE+dlMbSs3CWNpJB/WguD1q6ZogcctSrXdtwXJkaN6Fx3W0SUlKimRhgRQe5Ubvt23w+RBEc9D87HzNItwaM5vPwKBgGEdcOUgdjlzm2Ipdjoa/hQaEHtpvkqUW9+V41eUqlh/MJeURHD3BF4wR3esCIfFN9EEgZ2cBwRyTrAMDViupeMIaqzA7k5oZDrPzg3C2tn4fxMC5TFhqowH5KIVbBe+szaE489jYlWj070K7HnsUNtWhSDtf77F5Xu0Apoy42UBAoGAUzydOmV22o9BJH9xeCI6XFA+9vGuxLk9vUvv104sFNKVmUxeEOmMA+bquMAH5N1RgjY4jofyV2B5hJwJOCqS6YmEvMEpDm4mRO4n/StPMKbzGEZjEAcQQGvLCKUlFS1AeUDiCxxhcj30wx4U95TsQ3uh9nIukyBhG54lX9fW6gkCgYEAyAc3UNA//PxXXtJIb6hRPajXIzHtr5FRW9ehplO3M8HftK7gIlnZq14PFDdTEQeEEwWrgJnXLf7jZ8dEsJLqTlzJEvJbEvnlQsUPjYnAFCPGnXY0miNXbQtM0bRex3Dhg3ZLEM7beQ64HCckW8qKypM8l6T7jdq2cqJVN7aiDnA=",
                "json","utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm+yo3ERDT2qaGUi0HY1upCF6W8S/BnFX06c2NVD7k0eGADlzUoeBwix1PiuCQt+ulYzzaStVGTF/6Ia9FFKSJrf8mxa3LggylMMoKy9+gLiHeFfcyJ/KDswmp1RUkNFOGSeYDMpSNl1ES66smS1qFpOzvs6x1ROOR9+9IIbmVa7j4i3TArJvd8kQDllPzMZR3YUlq5LOii9bHp95IEZa4cOlZxhOtMJKaq5VQrBoWOzTlFEgas2ex2BYDUsnMaxQYfeHHiwZf/XNODiJ39dCo0ZrcPItjGd6E3Z52Oy3ZNnZK6d5r/mo/wjDrgbweZN0GeR/bnEXzHlfbysYURrs8wIDAQAB",
                "RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+ vo.getOutTradeNo()+"\"," +
                "\"seller_id\":\""+""+"\"," +
                "\"total_amount\":"+vo.getTotalAmount()+"," +
                "\"discountable_amount\":"+vo.getUndiscountableAmount()+"," +
                "\"subject\":\""+vo.getSubject()+"\"," +
                "\"body\":\""+vo.getBody()+"\"," +
                "\"operator_id\":\""+vo.getOperatorId()+"\"," +
                "\"store_id\":\""+vo.getStoreId()+"\"," +
                "\"terminal_id\":\"NJ_T_001\"," +
                "\"timeout_express\":\"5m\"" +
                "}");
        System.out.println(request.getBizContent());
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            log.info("停车场二维码生成调用阿里接口成功");
            System.out.println("调用成功");
        } else {
            log.error("停车场二维码生成调用阿里接口失败");
            System.out.println("调用失败");
        }
        log.info("停车场二维码生成调用阿里接口返回码====="+response.getCode());
        if (response.getCode().equals("10000")) {
            System.out.println( response.getOutTradeNo()+"***"+ response.getQrCode());
            return  response.getQrCode();
        }else {
            System.out.println( response.getOutTradeNo()+"***"+ response.getQrCode());
            return  "20000";
        }
    }

    /**
     * 主动确定是否支付成功
     * @param outTradeNo 给支付宝的订单号ID
     * @return
     */
    @ApiOperation(value="主动确定是否支付成功",notes="主动确定是否支付成功")
    @RequestMapping(value="/isturepaymentsuccess",method= RequestMethod.POST)
    @ResponseBody
    public  boolean getPayStruts(String outTradeNo){
        log.info("支付宝主动确定是否支付成功订单号======"+outTradeNo);
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(
                    "https://openapi.alipay.com/gateway.do",
                    "2018051060110233",
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCgNwD68X+MMG+EPxUMn2+O9R7cuYakMj4dkB82rlN/bfKqz0KZRNGGKaKVQEPA+Qt0RitDKkA6Y55pCnHLux1mbyOyM+Tqd2N7l22Ymfy6gST+aqZtNuldWNzaJgCpu3uGL/Fof8JvJJHxf05f6tBHUtinotaWklYlND/ekQy38eEk8IkTB8jmDB3W+w53L4nInYBKfXrFgT8TloAfAv/hvZvvpclcD8ALKHpAWAH3Xpe3VmlyPE0OVyoxa7K1vIbpDPG1CG2MPl63EBrwAlkRQ43fiFd/BB/JzSCK2h1ArtkelhxXjClk01DduG/lbZ93vQHohnqhH4H0rUs0bHg/AgMBAAECggEATZr3FZbfIoffrJ5l0sxz3DptrZsMVgKkReumwvTkKyiV0Bk++ED2gNcwEr2jVBkObE8E667Ol7njZJwTjQzg69pP3yT18IDOJnKuOqn0Wl7uDXKZlPNxTK8bo2ufDJhs+A3HEMg55V5Ad0skKp/yLWo62dCtwxe1NKY/fc6i64IugvK3xXVV9VE6IO4CgoGdz+arXBkzD+RAJEseSmlzq99+8SEqJn627Btrac9Dgs9Suw8jCRhZeRTI24iADoxeP5n0LEzhSLhbj8VWgqJnEPRXMg2vEgGQoJxhLGkVNadPVjLZzMFHu6r5NN5VUeubaC651qkr0Ibo2GeF9WxSAQKBgQDvmt1R+s8M7BZgP3TyTDIRSn5chZd5pAY+mkkV3hNOLy0e0bsQwRvubXCTI9f7vOF2DWvkfcF1GSyib92ovgl67cXR/KgIUHDAK+DKKgtmQcHBqiHUhicgDH8eMdi/iun9edmCuXXxi5yqVsVnGX+lF+pAp3eTHMoh4WT0V+i3AQKBgQCrLXimVvXxVRWnxMunFjk/nHrN2KbBTzn8zNqn6KJ8eIQ5eAKMevqMkkGcqxQvugCTGcKqPgXXunjsaWCXkUvE+dlMbSs3CWNpJB/WguD1q6ZogcctSrXdtwXJkaN6Fx3W0SUlKimRhgRQe5Ubvt23w+RBEc9D87HzNItwaM5vPwKBgGEdcOUgdjlzm2Ipdjoa/hQaEHtpvkqUW9+V41eUqlh/MJeURHD3BF4wR3esCIfFN9EEgZ2cBwRyTrAMDViupeMIaqzA7k5oZDrPzg3C2tn4fxMC5TFhqowH5KIVbBe+szaE489jYlWj070K7HnsUNtWhSDtf77F5Xu0Apoy42UBAoGAUzydOmV22o9BJH9xeCI6XFA+9vGuxLk9vUvv104sFNKVmUxeEOmMA+bquMAH5N1RgjY4jofyV2B5hJwJOCqS6YmEvMEpDm4mRO4n/StPMKbzGEZjEAcQQGvLCKUlFS1AeUDiCxxhcj30wx4U95TsQ3uh9nIukyBhG54lX9fW6gkCgYEAyAc3UNA//PxXXtJIb6hRPajXIzHtr5FRW9ehplO3M8HftK7gIlnZq14PFDdTEQeEEwWrgJnXLf7jZ8dEsJLqTlzJEvJbEvnlQsUPjYnAFCPGnXY0miNXbQtM0bRex3Dhg3ZLEM7beQ64HCckW8qKypM8l6T7jdq2cqJVN7aiDnA=",
                    "json","UTF-8",
                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm+yo3ERDT2qaGUi0HY1upCF6W8S/BnFX06c2NVD7k0eGADlzUoeBwix1PiuCQt+ulYzzaStVGTF/6Ia9FFKSJrf8mxa3LggylMMoKy9+gLiHeFfcyJ/KDswmp1RUkNFOGSeYDMpSNl1ES66smS1qFpOzvs6x1ROOR9+9IIbmVa7j4i3TArJvd8kQDllPzMZR3YUlq5LOii9bHp95IEZa4cOlZxhOtMJKaq5VQrBoWOzTlFEgas2ex2BYDUsnMaxQYfeHHiwZf/XNODiJ39dCo0ZrcPItjGd6E3Z52Oy3ZNnZK6d5r/mo/wjDrgbweZN0GeR/bnEXzHlfbysYURrs8wIDAQAB",
                    "RSA2");
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//            request.setBizContent("{\"out_trade_no\":\""+outTradeNo+"\",\"trade_no\":\"null\"}");
            request.setBizContent("{\"out_trade_no\":\""+outTradeNo+"\"}");
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                if(response.getTradeStatus().equals("TRADE_SUCCESS")){
                    log.info("支付宝主动确定是否支付成功调用支付宝接口成功，订单号======="+outTradeNo);
                    return true;
                }else {
                    log.error("支付宝主动确定是否支付成功调用支付宝接口失败，订单号======="+outTradeNo);
                    return false;
                }
            } else {
                log.error("支付宝主动确定是否支付成功调用支付宝接口，失败了，订单号======="+outTradeNo+"response.getTradeStatus()=="+response.getTradeStatus());
            }
        } catch (AlipayApiException e) {
            log.error("支付宝主动确定是否支付成功调用支付宝接口报异常了，订单号======="+outTradeNo);
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
