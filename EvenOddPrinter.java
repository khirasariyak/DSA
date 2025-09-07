public class EvenOddPrinter {

    private static int counter = 1;
    private static final Object lock = new Object();
    private static final int limit = 10;

    static class evenThread extends Thread {

        @Override
        public void run() {
            while (counter < limit) {
                synchronized (lock) {
                    if (counter % 2 == 0) {
                        System.out.println("Even Thread: " + counter);
                        counter++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    static class oddThread extends Thread {

        @Override
        public void run() {
            while (counter < limit) {
                synchronized (lock) {
                    if (counter % 2 != 0) {
                        System.out.println("Odd Thread: " + counter);
                        counter++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread even = new evenThread();
        Thread odd = new oddThread();
        even.start();
        odd.start();
    }

}
