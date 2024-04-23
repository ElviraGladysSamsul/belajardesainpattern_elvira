public class Unggas {
    public String nama;
    public String warna;

    public void sing() {
        System.out.println(nama + " is singing.");
    }

    public void display() {
        System.out.println(nama + " is " + warna + " in color.");
    }
}
class Sparrow extends Unggas {
    public void hop() {
        System.out.println(" is hopping on the ground.");
    }
}

class Penguin extends Unggas {
    public void swim() {
        System.out.println(" is swimming in the water.");
    }
}