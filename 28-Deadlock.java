// A deadlock occurs when two threads hold one resource and wait for the other, causing both to wait forever.

class Producer extends Thread {

    private final Object resource1;
    private final Object resource2;

    Producer(Object r1, Object r2) {
        resource1 = r1;
        resource2 = r2;
    }

    public void run() {
        synchronized (resource1) {
            System.out.println("Producer locked Resource 1");

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (resource2) {
                System.out.println("Producer locked Resource 2");
            }
        }
    }
}

class Consumer extends Thread {

    private final Object resource1;
    private final Object resource2;

    Consumer(Object r1, Object r2) {
        resource1 = r1;
        resource2 = r2;
    }

    public void run() {
        synchronized (resource2) {
            System.out.println("Consumer locked Resource 2");

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (resource1) {
                System.out.println("Consumer locked Resource 1");
            }
        }
    }
}

public class DeadlockDemo {

    public static void main(String[] args) {

        Object resource1 = "Buffer";
        Object resource2 = "Queue";

        Producer producer = new Producer(resource1, resource2);
        Consumer consumer = new Consumer(resource1, resource2);

        producer.start();
        consumer.start();
    }
}