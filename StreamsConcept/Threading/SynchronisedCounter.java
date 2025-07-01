package StreamsConcept.Threading;

class Counter{
    private int count = 0;

    public synchronized void increament(){
        count++;
    }

    public  int getCount(){
        return count;
    }
}

class MyThread extends Thread{
    private Counter counter;
    public MyThread(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for (int i = 0;i<500;i++){
            counter.increament();
        }
    }
}

public class SynchronisedCounter {
    public static void main(String[] args) {
        Counter count = new Counter();
        MyThread t1 = new MyThread(count);
        MyThread t2 = new MyThread(count);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count.getCount());
    }
}
