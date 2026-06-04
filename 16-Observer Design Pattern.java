interface Observer {
    void update();
}
interface Subject {
    void setObserver(Observer o);
    void notifyObserver();
}
class Bulb implements Observer {

    public void update() {
        System.out.println("Bulb is ON");
    }
}
class Switch implements Subject {

    private Observer observer;

    public void setObserver(Observer o) {
        this.observer = o;
    }

    public void notifyObserver() {
        observer.update();
    }
}
public class ObserverDemo {

    public static void main(String[] args) {

        Switch sw = new Switch();
        Observer bulb = new Bulb();

        sw.setObserver(bulb);   // attach
        sw.notifyObserver();    // switch ON
    }
}