package thread;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/28 3:42 下午
 */
public class Thread003 extends Thread{

    private Integer count;

    public Thread003(Integer count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
}
