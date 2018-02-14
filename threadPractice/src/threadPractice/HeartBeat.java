package threadPractice;

public class HeartBeat implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Beat");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
