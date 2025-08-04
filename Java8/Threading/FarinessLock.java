package Java8.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FarinessLock {
    private final Lock lock = new ReentrantLock(true);

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " access the resources.");
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " release the resources.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FarinessLock demo = new FarinessLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                demo.accessResource();
            }
        };

        Thread t1 = new Thread(task,"Thread1");
        Thread t2 = new Thread(task,"Thread2");
        Thread t3 = new Thread(task,"Thread3");

        t1.start();
        t2.start();
        t3.start();
    }

}
