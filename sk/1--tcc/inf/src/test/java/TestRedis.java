import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRedis {
    //@Autowired
    private JedisPool pool;
    /**
     * 初始化连接池
     */
    @Before
    public void init() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(6);
        pool = new JedisPool(jedisPoolConfig, "127.0.0.1",6379,2000,"redis");
        System.out.println("连接池初始化成功");
    }
    @Test
    public void testPing(){
        // Jedis 实现了java.lang.AutoCloseable接口,所以这里可以用java 1.7 try-with-resources语法自动完成close
        try{
            Jedis jedis = pool.getResource();
            System.out.println("服务正在运行: "+jedis.ping());
        }catch (Exception ex){
            //查看服务是否运行 PING
            ex.printStackTrace();
        }
    }
    @Test
    public void testString(){
        try{Jedis jedis = pool.getResource();
            //设置 redis 字符串数据 SET 10km blog.csdn.net/10km
            jedis.set("10km", "blog.csdn.net/10km");
            // 获取存储的数据并输出
            System.out.println("redis 存储的字符串为: "+ jedis.get("10km"));
        }catch (Exception e){
              e.printStackTrace();
        }
    }

    @Test
    public void testStringGet(){
        try{Jedis jedis = pool.getResource();
            //设置 redis 字符串数据 SET 10km blog.csdn.net/10km
            String res=jedis.get("10km");
            // 获取存储的数据并输出
            System.out.println("redis 存储的字符串为: "+ jedis.get("10km"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 程序关闭时，需要调用关闭方法
     */
    @After
    public void end(){      
        if(null != pool){
            pool.destroy();
            System.out.println("连接池关闭");
        }

    }
}