package Java8.Threading;


//Thread creation using Runnable interface
class usingInterface implements Runnable{
    @Override
    public void run() {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("java "+Thread.currentThread().getName());

    }
}

//Thread creation using Thread class
public class Hello extends Thread{
        @Override
        public void run(){

                System.out.println("World "+Thread.currentThread().getName());

        }

    public static void main(String[] args) throws InterruptedException{
        System.out.println(Thread.currentThread().getName());
        Hello t = new Hello();
        usingInterface t1 = new usingInterface();
        Thread T1 = new Thread(t1);

        System.out.println(t.getState());
        System.out.println(T1.getState());

        t.start();
        T1.start();

        System.out.println(t.getState());
        System.out.println(T1.getState());

        Thread.currentThread().sleep(2000);



    }

}
