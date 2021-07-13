package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/7/5 6:50 下午
 */
public class V2exTest {

    @Test
    public void test001() throws InterruptedException, SQLException {
        Connection conn = DbUtil.getCon();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int total = 10;
        CountDownLatch latch = new CountDownLatch(total);
        for (int i = 0;i < total;i ++) {
            threadPool.execute(() -> {
                try {
                    Statement statement = conn.createStatement();
                    Long currTime = System.currentTimeMillis();
                    int[] yearArr = new int[]{2019, 2020, 2021};
                    Long index = currTime % 3;
                    int year = yearArr[index.intValue()];
                    Long month = currTime % 12 + 1L;
                    Long day = currTime % 28 + 1L;
                    String date = year + "-" + month.intValue() + "-" + day.intValue();
                    String addDate = year + "-" + month.intValue() + "-" + (day.intValue() + 1);
                    Long R11L = currTime % 100123;
                    String R11 = R11L.toString();
                    Boolean bool = statement.execute("INSERT INTO t_v2_data (day, R11, add_day) VALUES ('" + date + "', '" + R11 + "', '" + addDate + "')");

                    latch.countDown();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
        }

        latch.await();
        conn.close();
    }

}
