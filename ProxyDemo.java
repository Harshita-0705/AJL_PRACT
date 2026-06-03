// Subject Interface
interface Internet {
    void connect();
}

// Real Object
class RealInternet implements Internet {

    public void connect() {
        System.out.println("Connected to Internet");
    }
}

// Proxy Class
class ProxyInternet implements Internet {

    private RealInternet internet = new RealInternet();

    public void connect() {
        System.out.println("Checking Access...");
        internet.connect();
    }
}

// Main Class
public class ProxyDemo {

    public static void main(String[] args) {

        Internet internet = new ProxyInternet();

        internet.connect();
    }
}