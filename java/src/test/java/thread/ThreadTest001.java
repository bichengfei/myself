package thread;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/6/28 3:24 下午
 */
public class ThreadTest001 {

    public volatile Integer count = 0;

    @Test
    public void test001() {
        Thread001 thread001 = new Thread001();
        thread001.setName("thread001");
        thread001.start();
    }

    @Test
    public void test002() {
        Thread002 thread002 = new Thread002(count);
        Thread002 thread003 = new Thread002(count);
        for (; count < 100; count++) {
            if (count % 2 == 0) {
                thread002.start();
            } else {
                thread003.start();
            }
        }

    }

    @Test
    public void test003() throws InterruptedException {
        AtomicInteger a = new AtomicInteger(1);
        new Thread(() -> {
            for (int b = 1; a.get() < 100; b++) {
                System.out.println(Thread.currentThread().getName() + ": " + a.getAndIncrement());
            }
        }).start();

        new Thread(() -> {
            for (int b = 1; a.get() < 100; b++) {
                System.out.println(Thread.currentThread().getName() + ": " + a.getAndIncrement());
            }
        }).start();

        Thread.sleep(5000);
    }

    @Test
    public void test004() throws InterruptedException {
        AtomicInteger a = new AtomicInteger(1);
        new Thread(() -> {
            for (int b = 1; a.get() < 100; b++) {
                System.out.println(Thread.currentThread().getName() + ": " + a.getAndIncrement());
            }
        }).start();

        new Thread(() -> {
            for (int b = 1; a.get() < 100; b++) {
                System.out.println(Thread.currentThread().getName() + ": " + a.getAndIncrement());
            }
        }).start();

        Thread.sleep(5000);
    }

    @Test
    public void test005() throws InterruptedException {
        class Count {
            int a = 1;

            int get() {
                return a;
            }

            synchronized int getAndAdd() {
                int b = a;
                a++;
                return b;
            }
        }

        Count count = new Count();

        new Thread(() -> {
            while (count.get() < 100) {
                System.out.println(Thread.currentThread().getName() + ": " + count.getAndAdd());
            }
        }).start();

        new Thread(() -> {
            while (count.get() < 100) {
                System.out.println(Thread.currentThread().getName() + ": " + count.getAndAdd());
            }
        }).start();

        Thread.sleep(5000);
    }

    @Test
    public synchronized void test006() throws InterruptedException {
        new Thread(() -> {
            for (int b = 1; b < 100; b = b + 2) {
                System.out.println(Thread.currentThread().getName() + ": " + b);
                try {
                    this.notify();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int b = 2; b < 100; b = b + 2) {
                System.out.println(Thread.currentThread().getName() + ": " + b);
                try {
                    this.notify();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);
    }

    @Test
    public void test007() throws InterruptedException {
        class TestThread implements Runnable {
            int i = 1;

            @Override
            public void run() {
                while (i < 100) {
                    synchronized (this) {
                        notify();
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        i++;

                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        TestThread testThread = new TestThread();
        Thread thread001 = new Thread(testThread);
        Thread thread002 = new Thread(testThread);

        thread001.start();
        thread002.start();

        Thread.sleep(15000);
    }

    @Test
    public void test008() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            return i;
        });

        for (int i = 0;i < 100;i ++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 20) {
                new Thread(task).start();
            }
        }

        System.out.println(task.get());
    }

    @Test
    public void test009() throws ExecutionException, InterruptedException {
        class Task implements Callable<Integer> {

            @Override
            public Integer call() {
                return 1;
            }
        }

        FutureTask<Integer> task = new FutureTask<>(new Task());
        new Thread(task).start();
        System.out.println(task.get());
    }

    @Test
    public void test010() throws InterruptedException {
        class Task implements Callable<Integer> {

            int i = 1;

            @Override
            public Integer call() throws InterruptedException {
                synchronized (this) {
                    for (; i < 100; ) {
                        System.out.println(Thread.currentThread().getName() + ": " + i ++);
                        notify();
                        wait();
                    }
                }
                return i;
            }
        }

        Task task = new Task();
        FutureTask<Integer> futureTask001 = new FutureTask<>(task);
        FutureTask<Integer> futureTask002 = new FutureTask<>(task);
        Thread thread001 = new Thread(futureTask001);
        Thread thread002 = new Thread(futureTask002);

        thread001.start();
        thread002.start();

        Thread.sleep(1000);
    }

    @Test
    public void test011() throws InterruptedException {
        class Task implements Callable<Integer> {

            int i = 1;

            @Override
            public Integer call() throws InterruptedException {
                synchronized (this) {
                    for (; i < 100; ) {
                        System.out.println(Thread.currentThread().getName() + ": " + i ++);
                        notify();
                        wait();
                    }
                }
                return i;
            }
        }

        Task task = new Task();
        FutureTask<Integer> futureTask001 = new FutureTask<>(task);
        Thread thread001 = new Thread(futureTask001);
        Thread thread002 = new Thread(futureTask001);

        thread001.start();
        thread002.start();

        Thread.sleep(1000);
    }

    @Test
    public void test012() throws InterruptedException {
        class Data {
            Integer a;

            public Integer getA() {
                return a;
            }

            public void setA(Integer a) {
                this.a = a;
            }
        }

        class MyThread extends Thread {

            private Data obj;

            public MyThread(Data obj) {
                this.obj = obj;
            }

            @Override
            public void run() {
                synchronized (obj) {
                    while (obj.getA() < 100) {
                        System.out.println(Thread.currentThread().getName() + ": " + obj.getA());
                        obj.setA(obj.getA() + 1);
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
        obj.setA(1);

        Thread thread001 = new MyThread(obj);
        Thread thread002 = new MyThread(obj);

        thread001.start();
        thread002.start();

        Thread.sleep(1000);
    }

}