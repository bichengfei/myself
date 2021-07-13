package thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/29 2:35 下午
 */
public class ThreadTest002 {

    @Test
    public void test001() throws InterruptedException {
        class ThreadTest extends Thread {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }

        ThreadTest thread = new ThreadTest();
        thread.start();

        Thread.sleep(1000);
    }

    @Test
    public void test002() throws InterruptedException {
        class Target implements Runnable {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }

        Target target = new Target();
        Thread thread = new Thread(target);
        thread.start();

        Thread.sleep(1000);
    }

    @Test
    public void test003() throws InterruptedException {
        class Target<T> implements Callable<T> {

            @Override
            public T call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return null;
            }
        }

        Target target = new Target();
        FutureTask<Integer> task = new FutureTask<>(target);
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(1000);
    }

    @Test
    public void test004() throws InterruptedException {
        class Data {
            Integer a;
        }

        class MyThread extends Thread {

            private Data obj;

            public MyThread(Data obj) {
                this.obj = obj;
            }

            @Override
            public void run() {
                synchronized (obj) {
                    while (obj.a < 101) {
                        System.out.println(Thread.currentThread().getName() + ": " + obj.a++);
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        Data obj = new Data();
        obj.a = 1;

        Thread thread001 = new MyThread(obj);
        Thread thread002 = new MyThread(obj);

        thread001.start();
        thread002.start();

        Thread.sleep(1000);
    }

    @Test
    public void test005() throws InterruptedException {
        class Target implements Runnable {

            int a = 1;

            @Override
            public synchronized void run() {
                while (a < 101) {
                    System.out.println(Thread.currentThread().getName() + ": " + a++);
                    notify();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Target target = new Target();

        Thread thread001 = new Thread(target);
        Thread thread002 = new Thread(target);

        thread001.start();
        thread002.start();

        Thread.sleep(1000);
    }

    @Test
    public void test006() throws InterruptedException {
        class Task implements Callable<Integer> {

            int a = 1;

            @Override
            public synchronized Integer call() throws Exception {
                while (a < 101) {
                    System.out.println(Thread.currentThread().getName() + ": " + a++);
                    notify();
                    wait();
                }
                return a;
            }
        }

        Task task = new Task();
        FutureTask<Integer> task001 = new FutureTask<>(task);
        FutureTask<Integer> task002 = new FutureTask<>(task);

        Thread thread001 = new Thread(task001);
        Thread thread002 = new Thread(task002);

        thread001.start();
        thread002.start();

        Thread.sleep(1000);
    }

}
