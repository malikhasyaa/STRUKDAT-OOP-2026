# STRUKDAT-OOP-2026



# Tugas Modul 2 STRUKDAT  

**
|Nama | Malikha Syarifa Dewi  |
|--|--|
|NRP   |5027251032  
Kelas  |A

Contoh serderhana yaitu Food program untuk memahami konsep OOP di Java. Terdapat dua jenis menu yaitu `Makanan` dan `Minuman`, keduanya dijadikan satu class `Food` yang menyimpan informasi umum seperti nama dan harga serta cara penyajiannya. 

1. **Class & Object** 
 Class adalah kerangka atau template. Food disini mendefinisikan bahwa semua makanan atau minuman punya nama, harga. 

```java
abstract class  Food  {
private  String nama;  
```
Object adalah instance dari suatu class.
```java
Food f1 = new Makanan("Nasi Goreng", 15000, "besar");
Food f3 = new Minuman("Es Teh", 5000, "dingin");
```
f1 dan f3 adalah dua object yang berbeda tapi masih satu tipe Food. 

2. **Konstruktor ** 
Konstruktor adalah yang pertama kali dipanggil setelah object itu dibuat. konstruktor ini tugasnya untuk mengisi data awal. Konstruktor memiliki nama yang sama dengan nama kelas dan tidak punya return type. 
```java
// Konstruktor Food (induk)
public Food(String nama, int harga) {
    this.nama = nama;
    this.harga = harga;
}

// Konstruktor Makanan (anak) — pakai super() untuk ambil dari induk
public Makanan(String nama, int harga, String porsi) {
    super(nama, harga);
    this.porsi = porsi;
}
```

3. **4 Pilar OOP** 
		a. Encapsulation 
			Data nama dan harga di class Food disembunyikan menggunakan private sehingga tidak bisa diakses secara langsung dari luar. solusinya harus menggunaka getter.
	```java 		 
	private String nama;
	private int harga;
	public String getNama() { return nama; }  // satu-satunya cara baca data
	public int getHarga()   { return harga; }
	```

	b. Abstraction 
	Abstraction adalah menampilkan informasi yang penting dan menyembunyikan detailnya. contohnya itu pada kode ini,  Food itu cuman ide, kita ngga bisa milih tanpa tau makananya apa, yang bisa dipesan itu Makanan atau Minuman yang spesifik. Untuk serve() dikosongkan di Food karena itu cara penyajianya makanan dan minuman itu berbeda.

	```java
	abstract class Food {
    public abstract void serve(); // wajib diisi turunannya
	}
	```
	c. Inheritance 
	Inheritance adalah suatu fitur atau proses dimana class baru dibuat dari class yang sudah ada. 
	```java 
	class Makanan extends Food { ... } 
	class Minuman extends Food { ... }  // mewarisi Food
	```
	adanya inheritance kita tidak perlu nulis ulang atribute di setiap class.

	d. Polymorpshim 
	Polymorpshim adalah satu method yang sama tapi punya hasil beda tergatung object. 
	```java
	f1.serve(); 
	f3.serve(); 
	```
	 pada kode ini `serve()` dipanggil sama, tapi hasilnya beda, kalau hasil objectnya `Makanan` hasilnya "disajikan dalam porsi besar". kalau `Minuman` hasilnya "disajikan dingin" 
6. **Cara Menjalankan** 
```branch
	javac FoodApp.java
	java FoodApp
```

**Outputt:** 
 ```java 
	 === MENU ===
	Nasi Goreng - Rp15000
	Mie Ayam - Rp12000
	Es Teh - Rp5000
	Kopi Susu - Rp18000

	=== PESANAN ===
	Nasi Goreng disajikan dalam porsi besar
	Es Teh disajikan dingin
	Kopi Susu disajikan panas
```
