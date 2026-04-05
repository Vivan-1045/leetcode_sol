package Java8.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writelock = lock.writelock;
    private final Lock readlock = lock.readlock;

    private int count = 0;

    void increment(){
        
    }
}
