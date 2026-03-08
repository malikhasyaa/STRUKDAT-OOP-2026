abstract class Food {
    // ENCAPSULATION — data disembunyiin pake private
    private String nama;
    private int harga;

    // KONSTRUKTOR
    public Food(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    // getter — satu-satunya cara baca data dari luar
    public String getNama() { return nama; }
    public int getHarga() { return harga; }

    // abstract method — wajib diisi oleh turunannya
    public abstract void serve();

    public void info() {
        System.out.println(nama + " - Rp" + harga);
    }
}

// INHERITANCE — Makanan mewarisi Food
class Makanan extends Food {
    private String porsi;

    public Makanan(String nama, int harga, String porsi) {
        super(nama, harga); // ambil dari Food
        this.porsi = porsi;
    }

    // POLYMORPHISM — serve() versi Makanan
    @Override
    public void serve() {
        System.out.println(getNama() + " disajikan dalam porsi " + porsi);
    }
}

// INHERITANCE — Minuman mewarisi Food
class Minuman extends Food {
    private String suhu;

    public Minuman(String nama, int harga, String suhu) {
        super(nama, harga);
        this.suhu = suhu;
    }

    // POLYMORPHISM — serve() versi Minuman, hasilnya beda!
    @Override
    public void serve() {
        System.out.println(getNama() + " disajikan " + suhu);
    }
}

// MAIN
public class FoodApp {
    public static void main(String[] args) {

        // Membuat object
        Food f1 = new Makanan("Nasi Goreng", 15000, "besar");
        Food f2 = new Makanan("Mie Ayam", 12000, "sedang");
        Food f3 = new Minuman("Es Teh", 5000, "dingin");
        Food f4 = new Minuman("Kopi Susu", 18000, "panas");

        System.out.println("=== MENU HARI INI ===");
        f1.info();
        f2.info();
        f3.info();
        f4.info();

        System.out.println("\n=== PESANAN ===");
        f1.serve(); // Polymorphism — tiap object manggil serve() beda hasilnya
        f3.serve();
        f4.serve();
    }
}