import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author XC
 */
public class JedisTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("192.4.8.20", 6379);
        String s = jedis.get("name");
        System.out.println(s);
        System.out.println("________________俺是一条卡哇伊的分割线__________________");

        // 获取所有的key
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            String type = jedis.type(key);
            System.out.println(key + " 的类型是 " + type);
        }
        System.out.println("________________俺是一条卡哇伊的分割线__________________");

        List<String> mylist = jedis.lrange("myList", 0, -1);
        for (String s1 : mylist) {
            System.out.println(s1);
        }
    }

    @Test
    public void test2() {
        JedisPool jedisPool = new JedisPool("192.4.8.20", 6379);
        Jedis jedis = jedisPool.getResource();

        Map<String, String> mySet1 = jedis.hgetAll("myHashSet");
        Set<Map.Entry<String, String>> entries = mySet1.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("________________俺是一条卡哇伊的分割线__________________");

        List<String> mySet = jedis.lrange("myList", 0, -1);
        for (String s : mySet) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        getFile(new File("C:\\Users\\XC\\Desktop\\王庆丰\\个人\\LINUX\\上课归档\\30.redis"));
    }

    /**
     * 遍历目标文件夹下的所有文件和目录
     *
     * @param file 目标文件夹
     */
    private static void getFile(File file) {
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            if (file1.isDirectory()) {
                getFile(file1);
            }
            System.out.println(file1);
        }
    }
}
