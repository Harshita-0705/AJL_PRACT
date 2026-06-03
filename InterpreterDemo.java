// Expression Interface
interface Expression {
    boolean interpret(String str);
}

// Terminal Expression
class WordExpression implements Expression {

    private String word;

    WordExpression(String word) {
        this.word = word;
    }

    public boolean interpret(String str) {
        return str.equalsIgnoreCase(word);
    }
}

// Main Class
public class InterpreterDemo {

    public static void main(String[] args) {

        Expression exp = new WordExpression("Java");

        System.out.println(exp.interpret("Java"));
        System.out.println(exp.interpret("Python"));
    }
}