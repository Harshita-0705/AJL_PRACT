// The State Design Pattern is a behavioral pattern that allows an object to change its behavior when its internal state changes, without using large if–else or switch statements.
// The object appears to change its class at runtime.
// Example:
// A Traffic Light behaves differently in Red, Yellow, and Green states.

interface State {
    void handle();
}

class RedState implements State {
    public void handle() {
        System.out.println("Red Light: STOP");
    }
}

class GreenState implements State {
    public void handle() {
        System.out.println("Green Light: GO");
    }
}

class TrafficLight {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void applyState() {
        state.handle();
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();

        light.setState(new RedState());
        light.applyState();

        light.setState(new GreenState());
        light.applyState();
    }
}