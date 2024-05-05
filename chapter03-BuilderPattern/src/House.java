public class House {
    private String lantai, dinding, atap, pintu;

    public House() {
    }

    public String getLantai() {
        return lantai;
    }

    public void setLantai(String lantai) {
        this.lantai = lantai;
    }

    public String getDinding() {
        return dinding;
    }

    public void setDinding(String dinding) {
        this.dinding = dinding;
    }

    public String getAtap() {
        return atap;
    }

    public void setAtap(String atap) {
        this.atap = atap;
    }

    public String getPintu() {
        return pintu;
    }

    public void setPintu(String pintu) {
        this.pintu = pintu;
    }

    @Override
    public String toString() {
        return "House Properties"
                + "\n-----------"
                + "\nLantai: " + getLantai()
                + "\nDinding: " + getDinding()
                + "\nAtap: " + getAtap()
                + "\nPintu: " + getPintu();
    }
}

class HouseBuilder {
    private House house;

    public HouseBuilder() {
        this(new House());
    }

    public HouseBuilder(House house) {
        this.house = house;
    }

    public HouseBuilder lantai(String lantai) {
        house.setLantai(lantai);
        return this;
    }

    public HouseBuilder dinding(String dinding) {
        house.setDinding(dinding);
        return this;
    }

    public HouseBuilder atap(String atap) {
        house.setAtap(atap);
        return this;
    }

    public HouseBuilder pintu(String pintu) {
        house.setPintu(pintu);
        return this;
    }

    public House getResult() {
        return house;
    }
}

class HouseDirector {
    private static HouseDirector director = null;

    private HouseDirector() {
    }

    public static synchronized HouseDirector getInstance() {
        if (director == null) {
            director = new HouseDirector();
        }
        return director;
    }

    public House rumahMewah() {
        HouseBuilder builder = new HouseBuilder();
        builder.lantai("Marmer").dinding("Marmer").atap("Baja Ringan").pintu("Kaca Kuning");

        return builder.getResult();
    }

    public House rumahBiasa() {
        HouseBuilder builder = new HouseBuilder();
        builder.lantai("Keramik").dinding("Batako").atap("Genteng").pintu("Kayu");

        return builder.getResult();
    }

    public House rumahSederhana() {
        HouseBuilder builder = new HouseBuilder();
        builder.lantai("Tegel").dinding("Anyaman Bambu").atap("Jerami").pintu("Papan");

        return builder.getResult();
    }
}

class DemoMain {
    public static void main(String[] args) {
        // Membuat direktor House
        HouseDirector director = HouseDirector.getInstance();

        // Membuat rumah Mewah
        House rumahMewah = director.rumahMewah();
        System.out.println("Rumah Mewah:");
        System.out.println(rumahMewah);

        // Membuat rumah Biasa
        House rumahBiasa = director.rumahBiasa();
        System.out.println("\nRumah Biasa:");
        System.out.println(rumahBiasa);

        // Membuat rumah Sederhana
        House rumahSederhana = director.rumahSederhana();
        System.out.println("\nRumah Sederhana:");
        System.out.println(rumahSederhana);
    }
}
