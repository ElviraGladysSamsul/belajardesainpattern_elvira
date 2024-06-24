// Bird.java
interface Bird {
    String getFood();
    double getFlyDistance();
    String getSleepBehavior();
}

// Pigeon.java
class Pigeon implements Bird {
    @Override
    public String getFood() {
        return "fruits";
    }

    @Override
    public double getFlyDistance() {
        return 700;
    }

    @Override
    public String getSleepBehavior() {
        return "on elevated perches at night";
    }
}

// Flamingo.java
class Flamingo implements Bird {
    @Override
    public String getFood() {
        return "larva";
    }

    @Override
    public double getFlyDistance() {
        return 373;
    }

    @Override
    public String getSleepBehavior() {
        return "one leg";
    }
}

// CommonOstrich.java
interface CommonOstrich {
    default String getFood() {
        return "plants";
    }

    String neckColor();
}

// SomaliOstrich.java
class SomaliOstrich implements CommonOstrich {
    @Override
    public String neckColor() {
        return "grey-blue";
    }
}

// NorthAfricanOstrich.java
class NorthAfricanOstrich implements CommonOstrich {
    @Override
    public String neckColor() {
        return "pink";
    }
}

// Main.java
public class BirdBehavior {
    public static void main(String[] args) {
        // Test Pigeon
        Bird pigeon = new Pigeon();
        System.out.println("Pigeon food: " + pigeon.getFood());
        System.out.println("Pigeon fly distance: " + pigeon.getFlyDistance());
        System.out.println("Pigeon sleep behavior: " + pigeon.getSleepBehavior());
        System.out.println();

        // Test Flamingo
        Bird flamingo = new Flamingo();
        System.out.println("Flamingo food: " + flamingo.getFood());
        System.out.println("Flamingo fly distance: " + flamingo.getFlyDistance());
        System.out.println("Flamingo sleep behavior: " + flamingo.getSleepBehavior());
        System.out.println();

        // Test SomaliOstrich
        CommonOstrich somaliOstrich = new SomaliOstrich();
        System.out.println("Somali Ostrich food: " + somaliOstrich.getFood());
        System.out.println("Somali Ostrich neck color: " + somaliOstrich.neckColor());
        System.out.println();

        // Test NorthAfricanOstrich
        CommonOstrich northAfricanOstrich = new NorthAfricanOstrich();
        System.out.println("North African Ostrich food: " + northAfricanOstrich.getFood());
        System.out.println("North African Ostrich neck color: " + northAfricanOstrich.neckColor());
        System.out.println();
    }
}
