public interface Kendaraan {
    void speedUp();
    void applyBrakes();
}

class SepedaMotor implements Kendaraan {

    @Override
    public void speedUp() {
        System.out.println("berjalan dengan mesin");
    }

    @Override
    public void applyBrakes() {
        System.out.println("berhenti dengan mematikan mesin");
    }
}

class Sepeda implements Kendaraan {

    @Override
    public void speedUp() {
        System.out.println("berjalan dengan dikayuh");
    }

    @Override
    public void applyBrakes() {
        System.out.println("berhenti dengan menekan rem");
    }
}