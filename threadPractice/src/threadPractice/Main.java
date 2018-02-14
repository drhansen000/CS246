package threadPractice;

public class Main {

    public static void main(String[] args) {
        //instantiate the variables
        HeartBeat heart = new HeartBeat();
        CountEven even  = new CountEven();
        CountOdd  odd   = new CountOdd();

        //create the threads
        Thread heartThread = new Thread(heart);
        Thread evenThread  = new Thread(even);
        Thread oddThread   = new Thread(odd);

        //start the threads
        heartThread.start();
        evenThread.start();
        oddThread.start();

        //make sure that nothing happens after this point until the specified threads finish
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        heartThread.stop();
        System.out.println("All finished!");

    }
}
