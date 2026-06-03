// Command Interface
interface Command {
    void execute();
}

// Receiver
class Light {

    void turnOn() {
        System.out.println("Light is ON");
    }
}

// Concrete Command
class LightOnCommand implements Command {

    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Invoker
class RemoteControl {

    Command command;

    RemoteControl(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

// Main Class
public class CommandDemo {

    public static void main(String[] args) {

        Light light = new Light();

        Command command = new LightOnCommand(light);

        RemoteControl remote = new RemoteControl(command);

        remote.pressButton();
    }
}