package com.jemmyee.core.utils;

import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jemmyee@qq.com
 * @create 2017-02-13 17:20
 **/
public class CommonUtils {

    /** 日期格式化格式 */

    public static String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    private static Log logger = LogFactory.getLog(CommonUtils.class);

    /**
     * 检查分页查询的参数是否存在
     * @param parameter
     * @return
     */
    public static Boolean checkSearchParameter(String parameter)
    {
        Boolean flag=false;
        if (parameter!= null
                && !parameter.equals("")) {
           flag=true;
        }
        return flag;
    }
    /**
     *
     * @param "xml形状的str串"
     * @return Document 对象
     */
    public static Document StringTOXml(String str) {

        StringBuilder sXML = new StringBuilder();
        sXML.append(str);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            InputStream is = new ByteArrayInputStream(sXML.toString().getBytes("utf-8"));
            doc = dbf.newDocumentBuilder().parse(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     *
     * @param document
     * @return 某个节点的值 前提是需要知道xml格式，知道需要取的节点相对根节点所在位置
     */
    public static String getNodeValue(Document document, String nodePaht) {
        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath path = xpfactory.newXPath();
        String servInitrBrch = "";
        try {
            servInitrBrch = path.evaluate(nodePaht, document);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return servInitrBrch;
    }
//比较两个时间谁前谁后
public static boolean comparemin(Date date1,Date date2) throws ParseException
{

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time1 = formatter.format(date1);
    String time2 = formatter.format(date2);

    //如果想比较日期则写成"yyyy-MM-dd"就可以了
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //将字符串形式的时间转化为Date类型的时间
    Date a=sdf.parse(time1);
    Date b=sdf.parse(time2);
    //Date类的一个方法，如果a早于b返回true，否则返回false
//    if(a.before(b))
//        return true;
//    else
//        return false;

    if(a.getTime()-b.getTime()<0)
        return true;
    else
        return false;
}

    public static void main(String[] args) throws ParseException {
        Date d1=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2=sdf.parse("2018-10-12 09:55:00");
        boolean comparemin = comparemin(d1, d2);
        System.out.println(comparemin);
    }


    //比较两个时间谁前谁后
    public boolean comparemax(Date date1,Date date2) throws ParseException
    {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = formatter.format(date1);
        String time2 = formatter.format(date2);

        //如果想比较日期则写成"yyyy-MM-dd"就可以了
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将字符串形式的时间转化为Date类型的时间
        Date a=sdf.parse(time1);
        Date b=sdf.parse(time2);
        //Date类的一个方法，如果a早于b返回true，否则返回false
//    if(a.before(b))
//        return true;
//    else
//        return false;

        if(a.getTime()-b.getTime()>0)
            return true;
        else
            return false;
    }

    /**
     * 检查分页查询的参数是否存在
     * @param parameter
     * @return
     */
    public static Boolean checkSearchParameter(String parameter,String value)
    {
        Boolean flag=false;
        if (parameter!= null
                && !parameter.equals(value)) {
            flag=true;
        }
        return flag;
    }
    /**
     * StringDate TO g
     * @param time
     * @param format
     * @return
     */
    public static Date parseStringToDateWithFormat(String time, String format) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                format);
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }
    /**
     * Date TO String
     * @param time
     * @param format
     * @return
     */
    public static String formatDateToString(Date time, String format) {
        SimpleDateFormat sim = new SimpleDateFormat(format);
        return sim.format(time);
    }

    /**
     * 判断时间格式是否符合格式
     * @param time
     * @param format
     * @return
     */
    public static Boolean StringIfDateFormat(String time,String format){
    try{
        SimpleDateFormat format1=new SimpleDateFormat(format);
        format1.parse(time);
        }catch ( ParseException e){
        return false;
        }
        return  true;
    }
    /**
     *
     * @Description: TODO 对象转换（set/get方法、参数一致的会被转换）
     * @param target 目标对象class
     * @param baseTO 被转换对象
     * @throws
     * @author cyh
     * @date 2016年7月30日
     */
    public static <T> T changeEntity(Class<T> target, Object baseTO) {
        T obj = null;
        if(baseTO == null)
            return null;
        try {
            obj = target.newInstance();
            List<Method> targetmethods = Arrays.asList(target.getDeclaredMethods());
            List<String> methodnames = new ArrayList<String>();
            for (Method method : targetmethods)
                methodnames.add(method.getName());
            Method[] methods = baseTO.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.getName().startsWith("get")) {
                    String _tar = "set" + method.getName().substring(method.getName().indexOf("get") + 3);
                    if (methodnames.contains(_tar)) {
                        Method tarMethod = targetmethods.get(methodnames.indexOf(_tar));
                        if(tarMethod.getParameterTypes()[0].equals(method.getReturnType())){
//							logger.info("methodName:" + method.getName() + "\t" + "value:" + method.invoke(baseTO));
                            tarMethod.invoke(obj, method.invoke(baseTO));
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("解析错误", e);
        }
        return obj;
    }

    /**
     * Map转换成Xml
     *
     * @param map
     * @return
     */
    public static String map2XmlString(Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set<String> set = map.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = it.next();
            String value = map.get(key);
            sb.append("<").append(key).append(">");
            sb.append("<![CDATA[" + value + "]]>");
            sb.append("</").append(key).append(">");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     *
     * @Description: 用JSON类的parseObject来解析JSON字符串，并查找key所对应的值
     * @param str 需要解析的json字符串
     * @param key 需要超找的key值
     * @author wzh
     * @date 2017年9月14日
     */
    public static String jsonToMap(String str, String key) {
        String result = "";
        JSONObject jsonObject = JSONObject.fromObject(str);
        return jsonObject.get(key).toString();
    }

}
