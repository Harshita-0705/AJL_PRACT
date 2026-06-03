class Student implements Cloneable {

    String name;

    Student(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypeDemo {

    public static void main(String[] args) {

        try {
            Student s1 = new Student("Harshita");

            Student s2 = (Student) s1.clone();

            System.out.println("Original Student: " + s1.name);
            System.out.println("Cloned Student: " + s2.name);

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}