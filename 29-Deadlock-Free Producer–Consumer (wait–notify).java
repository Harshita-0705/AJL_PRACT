// wait() releases the lock and pauses the thread until notify() is called.
// This prevents circular waiting and hence deadlock.
class Producer extends Thread {
    private final Object resource;
    private boolean consumed = false;

    Producer(Object r) {
        resource = r;
    }

    public void run() {
        synchronized (resource) {
            System.out.println("Producer produced item");

            while (!consumed) {
                try {
                    resource.wait();
                } catch (Exception e) {}
            }
            System.out.println("Producer resumes after consumption");
        }
    }
}

class Consumer extends Thread {
    private final Object resource;

    Consumer(Object r) {
        resource = r;
    }

    public void run() {
        synchronized (resource) {
            System.out.println("Consumer consuming item");
            resource.notify();
        }
    }
}

public class DeadlockFreeProducerConsumer {
    public static void main(String[] args) {
        Object resource = new Object();
        new Producer(resource).start();
        new Consumer(resource).start();
    }
}