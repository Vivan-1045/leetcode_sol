package Java8;

class thread2 implements Runnable{
    public void run(){
        System.out.println("Thread2 is running using Runnable interface...");
    }
}
class thread1 extends Thread{
    public void run(){
        System.out.println("Thread1 is running using Thread class....");
    }
}


public class implementThread {
    public static void main(String[] args) {
        thread2 o = new thread2();
        Thread t2 = new Thread(o);
        thread1 t1 = new thread1();
        t1.start();
        t2.start();
    }
}
