interface Quackable {
    void quack();
}

interface Flyable {
    void fly();
}

abstract class Duck {
    abstract void display();

    void swim() {
        System.out.println("Berenang");
    }
}

class MallardDuck extends Duck implements Quackable, Flyable {
    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }

    @Override
    public void fly() {
        System.out.println("Terbang tinggi di langit biru");
    }

    @Override
    void display() {
        System.out.println("Bebek Mallard memiliki tubuh besar dengan bulu berwarna hijau kebiruan dan sayap lebar.");
    }
}

class RedheadDuck extends Duck implements Quackable, Flyable {
    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }

    @Override
    public void fly() {
        System.out.println("Terbang di angkasa dengan gagahnya");
    }

    @Override
    void display() {
        System.out.println("Bebek Kepala Merah memiliki kepala berwarna merah cerah yang mencolok dan bulu berwarna cokelat.");
    }
}

class RubberDuck extends Duck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak Squeak");
    }

    @Override
    void display() {
        System.out.println("Bebek Karet berwarna kuning cerah dengan bentuk yang elastis dan fleksibel.");
    }
}

class WoodenDuck extends Duck {
    @Override
    void display() {
        System.out.println("Bebek Kayu terbuat dari kayu dengan tampilan yang sederhana dan alami.");
    }
}

class ToyDuck extends Duck implements Flyable {
    @Override
    public void fly() {
        System.out.println("Terbang dengan gaya mainan");
    }

    @Override
    void display() {
        System.out.println("Bebek Mainan memiliki penampilan yang ceria dan warna-warni.");
    }
}