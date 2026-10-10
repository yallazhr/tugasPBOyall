"INI TUGAS SAYA COMITNYA PAKE LAPTOPNYA TRI PILARI UTAMA SULAN KARENA LAPTOP SAYA MATI TOTAL DARI RABU DAN SEKARANG LAPTOP SAYA MASIH DI TEMPAT SERVICE" 
# 3D - Latihan/Eksplorasi Materi Array dan ArrayList (Sistem Manajemen Bank & ATM)


Repositori ini berisi implementasi program Java berkonsep **Object-Oriented Programming (OOP)** untuk latihan pemodelan Sistem Perbankan dan ATM Sederhana mengelola hubungan/asosiasi antar objek menggunakan **Array** (sesuai materi slide *PBO 7: Array & ArrayList*).

---

## 📌 Penjelasan Struktur Kelas & Kode

1. **`Account`**:
   - Menyimpan informasi saldo nasabah (`balance`) dengan proteksi enkapsulasi (`private`).
   - Menyediakan metode `getBalance()`, `deposit(double amount)`, dan `withdraw(double amount)` lengkap dengan pengujian validasi nominal transaksi.

2. **`Customer`**:
   - Menyimpan data pribadi nasabah (`firstName`, `lastName`).
   - Mengelola koleksi akun/rekening nasabah menggunakan **Array** (`Account[]`) dengan kapasitas maksimal 5 rekening per nasabah.
   - Menyediakan metode `addAccount()`, `getAccount()`, dan `getNumOfAccounts()`.

3. **`Bank`**:
   - Mengelola sekumpulan data nasabah perbankan menggunakan **Array** (`Customer[]`) dengan kapasitas maksimal 10 nasabah.
   - Menyediakan fungsi penambahan nasabah `addCustomer()`, mengambil objek nasabah berdasarkan indeks `getCustomer()`, dan menghitung jumlah nasabah `getNumOfCustomers()`.

4. **`Main`**:
   - Menjalankan antarmuka interaktif CLI (Command Line Interface) berbasis perulangan `while` dan `switch-case` untuk simulasi transaksi ATM.
   - Mengimplementasikan navigasi berbasis **1-index** (dimulai dari angka 1) untuk memudahkan interaksi *user*.

---

## 🛠️ Library Tambahan yang Digunakan

- **`java.util.Scanner`**: Digunakan di kelas `Main` untuk membaca masukan interaktif dari pengguna melalui terminal/konsol (*console input*).

---

## 📸 Screenshot Hasil Eksekusi Program

Berikut adalah tampilan antarmuka interaktif saat program dijalankan di terminal:

![Screenshot Eksekusi ATM](Hasil/Menu_Buka.png)
![Screenshot Eksekusi ATM](Hasil/Menu_Lihat.png)
![Screenshot Eksekusi ATM](Hasil/Menu_Tambah.png)
![Screenshot Eksekusi ATM](Hasil/Menu_Setor_Tarik.png)


---

