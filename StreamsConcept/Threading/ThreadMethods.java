package StreamsConcept.Threading;

public class ThreadMethods extends Thread{

    public ThreadMethods(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1;i<=7;i++){
//            String a = "";
//            for (int j = 0;j<100000;j++){
//                a+="a";
//            }
            System.out.println(Thread.currentThread().getName()+" -Priority : "+ Thread.currentThread().getPriority()+" count : "+i);
            Thread.yield(); // Gives chance to each thread
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                System.out.println(e);
//            }
//            System.out.println(i);
        }

        while (true){
            System.out.println("Hello java");
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        ThreadMethods t1 = new ThreadMethods("Rohit");
//        ThreadMethods t2 = new ThreadMethods("Sobhit");
//        ThreadMethods t3 = new ThreadMethods("Mohit");

//        t1.start();
//        t1.join();
//
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t3.setPriority(Thread.MIN_PRIORITY);

//        t1.start();
//        t2.start();
//        t3.start();

        ThreadMethods t1 = new ThreadMethods("t1");
        ThreadMethods t2 = new ThreadMethods("t2");

        t1.setDaemon(true); //Since we set t1 thread as Daemon, JVM can't wait to finish of t1
//        t2.start();
        t1.start();

        System.out.println("main End");
    }

}
