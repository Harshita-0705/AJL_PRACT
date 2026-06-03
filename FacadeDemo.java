// Subsystem Classes
class CPU {
    void start() {
        System.out.println("CPU Started");
    }
}

class Memory {
    void load() {
        System.out.println("Memory Loaded");
    }
}

// Facade Class
class Computer {

    CPU cpu = new CPU();
    Memory memory = new Memory();

    void start() {
        cpu.start();
        memory.load();
    }
}

// Main Class
public class FacadeDemo {

    public static void main(String[] args) {

        Computer computer = new Computer();

        computer.start();
    }
}