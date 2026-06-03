// Memento
class Memento {

    String state;

    Memento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}

// Originator
class TextEditor {

    String text;

    void setText(String text) {
        this.text = text;
    }

    Memento save() {
        return new Memento(text);
    }

    void restore(Memento memento) {
        text = memento.getState();
    }
}

// Main Class
public class MementoDemo {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.setText("Hello");

        Memento saved = editor.save();

        editor.setText("Hello World");

        System.out.println("Current: " + editor.text);

        editor.restore(saved);

        System.out.println("Restored: " + editor.text);
    }
}
