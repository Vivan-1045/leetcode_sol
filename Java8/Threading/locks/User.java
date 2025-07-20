package Java8.Threading.locks;

public class User {
    public static void main(String[] args) {
        BankAccount pnb = new BankAccount();

        Runnable work = new Runnable() {
            @Override
            public void run() {
                pnb.withdraw(70);
            }
        };

        Thread t1 = new Thread(work,"Rohit");
        Thread t2 = new Thread(work,"Mohit");

        t1.start();
        t2.start();
    }
}
