package Java8.Threading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    //For custom lock method
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        try{
            System.out.println(Thread.currentThread().getName()+ " want to withdraw "+ amount);
            if (lock.tryLock(2500, TimeUnit.MILLISECONDS)){
                if (balance>= amount){
                    System.out.println(Thread.currentThread().getName()+" proceeding with withdraw.");

                    try {
                        Thread.sleep(4000);
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }

                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() +" "+amount + " successfully withdraw. your available balance is : "+balance);
                }else {
                    System.out.println(Thread.currentThread().getName()+ " you have not sufficient amount to withdraw.");
                }
            }else {
                System.out.println(Thread.currentThread().getName()+ " could not acquire the lock within the time.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
