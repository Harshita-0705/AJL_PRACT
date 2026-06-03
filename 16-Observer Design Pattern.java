// The Observer Design Pattern is a behavioral pattern where:
// One object (Subject) maintains a list of dependents (Observers)
// When the subject’s state changes, all observers are automatically notified

import java.util.ArrayList;
import java.util.List;

/* Observer interface */
interface Observer {
    void update(String message);
}

/* Subject interface */
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

/* ConcreteSubject */
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

/* ConcreteObserver */
class NewsChannel implements Observer {
    private String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String news) {
        System.out.println(channelName + " received news: " + news);
    }
}

/* Main class */
public class ObserverPatternDemo {
    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer channel1 = new NewsChannel("Channel A");
        Observer channel2 = new NewsChannel("Channel B");

        agency.attach(channel1);
        agency.attach(channel2);

        agency.setNews("Observer Pattern Explained!");
        agency.setNews("Breaking News: Java Design Patterns");
    }
}