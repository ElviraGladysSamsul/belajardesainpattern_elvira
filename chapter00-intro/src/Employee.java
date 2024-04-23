abstract class Employee {
    abstract void printInfo();

    void companyInfo(){
        System.out.println("Employee of PT.Suka Suka");
    }
}

class NewEmployee extends Employee {
    @Override
    void printInfo() {
        String name = "Andy";
        int age = 21;
        float salary = 200.2F;

        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);
    }
}

class OldEmployee extends Employee {
    @Override
    void printInfo() {
        String name = "Anisa";
        int age = 41;
        float salary = 500.2F;

        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);
    }
}