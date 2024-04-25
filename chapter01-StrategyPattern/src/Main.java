public class Main {
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        mallard.quack();
        mallard.swim();
        mallard.display();
        mallard.fly();

        System.out.println();

        RubberDuck rubber = new RubberDuck();
        rubber.quack();
        rubber.swim();
        rubber.display();
        rubber.fly();

        System.out.println();
        WoodenDuck wood = new WoodenDuck();
        wood.quack();
        wood.swim();
        wood.display();
        wood.fly();
    }
}