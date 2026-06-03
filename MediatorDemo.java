class ChatMediator {

    void sendMessage(String msg, User user) {
        System.out.println(user.name + " says: " + msg);
    }
}

class User {

    String name;
    ChatMediator mediator;

    User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    void send(String msg) {
        mediator.sendMessage(msg, this);
    }
}

public class MediatorDemo {

    public static void main(String[] args) {

        ChatMediator mediator = new ChatMediator();

        User user1 = new User("Rahul", mediator);

        user1.send("Hello");
    }
}
