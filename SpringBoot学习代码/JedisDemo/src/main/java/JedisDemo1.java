import redis.clients.jedis.Jedis;

public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String result = jedis.ping();
        System.out.println(result);
        jedis.set("a","hello!world!");
        String a = jedis.get("a");
        System.out.println(a);
        jedis.close();


    }
}
