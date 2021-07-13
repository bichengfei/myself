import org.junit.Test;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/7/12 2:49 下午
 */
public class Test001 {

    @Test
    public void test001() {
        Set<HostAndPort> cluster = new HashSet<>();
        cluster.add(new HostAndPort("10.21.0.38", 6381));
        cluster.add(new HostAndPort("10.21.0.38", 6382));
        cluster.add(new HostAndPort("10.21.0.39", 6381));
        cluster.add(new HostAndPort("10.21.0.39", 6382));
        cluster.add(new HostAndPort("10.21.0.39", 6381));
        cluster.add(new HostAndPort("10.21.0.40", 6382));

        DefaultJedisClientConfig config = DefaultJedisClientConfig.builder()
                .connectionTimeoutMillis(4000).socketTimeoutMillis(4000).password("DingNuo@20210525").build();
        JedisCluster jCluster = new JedisCluster(cluster);
        String str = jCluster.get("1cd5765ae-2223-4419-aaa4-ae595c1dec0c");
        System.out.println(str);
    }

    @Test
    public void test002() {

    }

}
