package Java8.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterentLock {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Calling inner method.");
            innerMethod();
        }finally {
            System.out.println("lock is unlocked now.");
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner method called successfully.");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenterentLock demo = new ReenterentLock();
        demo.outerMethod();
    }
}
