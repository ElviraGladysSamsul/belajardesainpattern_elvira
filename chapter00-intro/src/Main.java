//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Inheritance
        System.out.println("Inheritance Example");
        System.out.println("----------------------");
        Sparrow sp1 = new Sparrow();
        sp1.nama = "jack";
        sp1.warna = "hitam";
        sp1.hop();
        sp1.sing();
        sp1.display();

        Penguin pg1 = new Penguin();
        pg1.nama = "happy feet";
        pg1.warna = "hitam dan putih";
        pg1.swim();
        pg1.sing();
        pg1.display();

        Mhs mhs1 = new Mhs();
        mhs1.nama = "Akbar";
        mhs1.nim = "2399984648575871";

        Dosen ds1 = new Dosen();
        ds1.nama = "Reza";
        ds1.nidn = "0001059205";


        System.out.println(mhs1.nama+ " " +mhs1.nim+ " " +mhs1.password);
        System.out.println(ds1.nama+ " " +ds1.nidn+ " "+ds1.password);


        // Abstract
        System.out.println("Abstract Class Example");
        System.out.println("----------------------");
        Employee empBaru = new NewEmployee();
        empBaru.printInfo();
        empBaru.companyInfo();

        Employee empLama = new OldEmployee();
        empLama.printInfo();
        empLama.companyInfo();

        // Interface
        System.out.println("Interface Example");
        System.out.println("-----------------");
        SepedaMotor spdMotor = new SepedaMotor();
        spdMotor.speedUp();
        spdMotor.applyBrakes();

        Sepeda spd = new Sepeda();
        spd.speedUp();
        spd.applyBrakes();


        // Example of choosing between interface and abstract
        System.out.println("Example of choosing between interface and abstract");
        System.out.println("---------------------------------------------------");
        System.out.println("------Abstract------");
        ShapeAbstract bulat = new Circle(2);
        Rectangle pp = new Rectangle(2,5);
        bulat.calculateArea();
        pp.calculateArea();
        bulat.draw();
        pp.draw();

        System.out.println("------Interface------");
        Bulat bulat2 = new Bulat(2);
        PersegiPanjang pp2 = new PersegiPanjang(2,5);
        bulat2.calculateArea();
        pp.calculateArea();
        bulat2.draw();
        pp2.draw();
    }
}
