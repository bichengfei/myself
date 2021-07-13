package thread;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/28 3:42 下午
 */
public class Thread001 extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
