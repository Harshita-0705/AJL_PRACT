interface TV {
    void on();
}
class SonyTV implements TV {

    public void on() {
        System.out.println("Sony TV is ON");
    }
}

class SamsungTV implements TV {

    public void on() {
        System.out.println("Samsung TV is ON");
    }
}
class Remote {

    protected TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    public void turnOn() {
        tv.on();
    }
}
public class BridgeDemo {

    public static void main(String[] args) {

        TV sony = new SonyTV();

        Remote remote = new Remote(sony);

        remote.turnOn();
    }
}