public class User {
    public String nama;
    public String email;
    public String alamat;
    public String no_hp;
    public int umur;
    public String password;

    User(){
        this.password = "123456";
    }

    public void getName() {
        System.out.println("getName");
    }

    public void hashPass(){
        System.out.println("hashPass");
    }
}

class Dosen extends User {
    public String nip;
    public String nidn;
}

class Mhs extends User {
    public String nim;
}