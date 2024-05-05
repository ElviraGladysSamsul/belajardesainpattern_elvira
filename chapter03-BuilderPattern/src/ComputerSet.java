class Computer {
    // Definisi kelas Computer
}

public class ComputerSet {
    private Computer computer;
    private String keyboard, mouse, speaker, monitor;

    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    public String getKeyboard() {
        return keyboard;
    }
    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
    public String getMouse() {
        return mouse;
    }
    public void setMouse(String mouse) {
        this.mouse = mouse;
    }
    public String getSpeaker() {
        return speaker;
    }
    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
    public String getMonitor() {
        return monitor;
    }
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}

class ComputerSetBuilder {
    private ComputerSet computerSet;

    public ComputerSetBuilder() {
        this(new ComputerSet());
    }
    public ComputerSetBuilder(ComputerSet computerSet) {
        this.computerSet = computerSet;
    }
    public void computer(Computer computer) {
        computerSet.setComputer(computer);
    }
    public void keyboard(String keyboard) {
        computerSet.setKeyboard(keyboard);
    }
    public void mouse(String mouse) {
        computerSet.setMouse(mouse);
    }
    public void speaker(String speaker) {
        computerSet.setSpeaker(speaker);
    }
    public void monitor(String monitor) {
        computerSet.setMonitor(monitor);
    }
    public ComputerSet getResult() {
        return computerSet;
    }
    public void resetBuilder() {
        computerSet = new ComputerSet();
    }
}

class Demo {
    public static void main(String[] args) {
        // Membuat objek Computer
        Computer computer = new Computer();

        // Membuat objek ComputerSetBuilder
        ComputerSetBuilder builder = new ComputerSetBuilder();

        // Mengatur komponen-komponen dari ComputerSet menggunakan builder
        builder.computer(computer);
        builder.keyboard("Standard Keyboard");
        builder.mouse("Optical Mouse");
        builder.speaker("Stereo Speaker");
        builder.monitor("LCD Monitor");

        // Mendapatkan hasil dari builder
        ComputerSet computerSet = builder.getResult();

        // Menampilkan hasil
        System.out.println("Computer Set Components:");
        System.out.println("Computer: " + computerSet.getComputer());
        System.out.println("Keyboard: " + computerSet.getKeyboard());
        System.out.println("Mouse: " + computerSet.getMouse());
        System.out.println("Speaker: " + computerSet.getSpeaker());
        System.out.println("Monitor: " + computerSet.getMonitor());
    }
}
