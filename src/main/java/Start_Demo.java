import redis.clients.jedis.Jedis;

public class Start_Demo {
    private Jedis jedis;

    void setUp(){
        //建立连接
        jedis = new Jedis("192.168.1.116",9810);
        //设置密码
        jedis.auth("016016");
        //选择库
        jedis.select(0);
    }
}
