abstract class Duck {
    void quack() {
        System.out.println("Kwek Kwek");
    }

    void swim() {
        System.out.println("Berenang di air");
    }

    abstract void display();

    void fly() {
        System.out.println("Terbang di udara");
    }
}

class MallardDuck extends Duck {
    @Override
    void display() {
        System.out.println("Penampilan Bebek Mallard: Tubuhnya besar dengan warna bulu hijau kebiruan, paruh kuning, dan ekor melengkung.");
    }
}

class RedHeadDuck extends Duck {
    @Override
    void display() {
        System.out.println("Penampilan Bebek Kepala Merah: Tubuhnya agak besar dengan kepala berwarna merah cerah, bulu lainnya berwarna cokelat.");
    }
}

class RubberDuck extends Duck {
    @Override
    void display() {
        System.out.println("Penampilan Bebek Karet: Terbuat dari bahan karet, berwarna kuning cerah, dan memiliki bentuk yang bulat.");
    }

    @Override
    void quack() {
        System.out.println("Bunyi seperti desis, bukan kwek");
    }

    @Override
    void fly() {
        // Tidak ada implementasi, bebek karet tidak dapat terbang
    }
}

class WoodenDuck extends Duck {
    @Override
    void display() {
        System.out.println("Penampilan Bebek Kayu: Terbuat dari kayu dengan warna cokelat tua, memiliki tampilan yang sederhana dengan detail yang terbatas.");
    }

    @Override
    void quack() {
        // Tidak ada implementasi, bebek kayu tidak dapat bersuara
    }

    @Override
    void swim() {
        System.out.println("Mengapung di air");
    }

    @Override
    void fly() {
        // Tidak ada implementasi, bebek kayu tidak dapat terbang
    }
}