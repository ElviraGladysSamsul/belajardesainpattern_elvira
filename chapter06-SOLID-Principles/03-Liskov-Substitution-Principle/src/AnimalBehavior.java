interface Animal {
    String getSound();
    String getFood();
    String getHabitat();
}

// Dog.java
class Dog implements Animal {
    @Override
    public String getSound() {
        return "Bark";
    }

    @Override
    public String getFood() {
        return "Meat";
    }

    @Override
    public String getHabitat() {
        return "Domestic";
    }
}

// Cat.java
class Cat implements Animal {
    @Override
    public String getSound() {
        return "Meow";
    }

    @Override
    public String getFood() {
        return "Fish";
    }

    @Override
    public String getHabitat() {
        return "Domestic";
    }
}

// Cow.java
class Cow implements Animal {
    @Override
    public String getSound() {
        return "Moo";
    }

    @Override
    public String getFood() {
        return "Grass";
    }

    @Override
    public String getHabitat() {
        return "Farm";
    }
}

// Lion.java
class Lion implements Animal {
    @Override
    public String getSound() {
        return "Roar";
    }

    @Override
    public String getFood() {
        return "Meat";
    }

    @Override
    public String getHabitat() {
        return "Savannah";
    }
}

// Elephant.java
class Elephant implements Animal {
    @Override
    public String getSound() {
        return "Trumpet";
    }

    @Override
    public String getFood() {
        return "Plants";
    }

    @Override
    public String getHabitat() {
        return "Forest";
    }
}

// AnimalBehavior.java
public class AnimalBehavior {
    public static void main(String[] args) {
        // Test Dog
        Animal dog = new Dog();
        System.out.println("Dog sound: " + dog.getSound());
        System.out.println("Dog food: " + dog.getFood());
        System.out.println("Dog habitat: " + dog.getHabitat());
        System.out.println();

        // Test Cat
        Animal cat = new Cat();
        System.out.println("Cat sound: " + cat.getSound());
        System.out.println("Cat food: " + cat.getFood());
        System.out.println("Cat habitat: " + cat.getHabitat());
        System.out.println();

        // Test Cow
        Animal cow = new Cow();
        System.out.println("Cow sound: " + cow.getSound());
        System.out.println("Cow food: " + cow.getFood());
        System.out.println("Cow habitat: " + cow.getHabitat());
        System.out.println();

        // Test Lion
        Animal lion = new Lion();
        System.out.println("Lion sound: " + lion.getSound());
        System.out.println("Lion food: " + lion.getFood());
        System.out.println("Lion habitat: " + lion.getHabitat());
        System.out.println();

        // Test Elephant
        Animal elephant = new Elephant();
        System.out.println("Elephant sound: " + elephant.getSound());
        System.out.println("Elephant food: " + elephant.getFood());
        System.out.println("Elephant habitat: " + elephant.getHabitat());
        System.out.println();
    }
}
