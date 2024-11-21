# Thea's Brieftasche

## Deskripsi

Thea's Brieftasche adalah aplikasi manajemen keuangan (versi lite wkwk). Saya membuat ini awalnya untuk projek ujian kuliah, walaupun akhirnya saya masih belum tau. Aplikasi ini bisa menambah transaksi baru, baik pemasukan dan pengeluaran. Aplikasi ini menyediakan fitur untuk menambah user baru, mencatat transaksi, dan melihat saldo akun dan detail dari user itu.

## Fitur

- **Manajemen Pengguna**: Tambahkan pengguna baru dengan informasi seperti nama pengguna, kata sandi, alamat, tanggal lahir, dan PIN.
- **Manajemen Transaksi**: Tambahkan transaksi baru dengan jenis transaksi (pemasukan atau pengeluaran), jumlah, catatan, dan tanggal.
- **Validasi Data**: Validasi data pengguna dan transaksi untuk memastikan integritas data.
- **Penyimpanan Data**: Simpan dan muat data pengguna dan transaksi dari file.

## Struktur Folder

project ini memiliki struktur folder sebagai berikut:

- `src`: Folder untuk menyimpan kode sumber.
  - `BackEnd`: Berisi kelas-kelas yang mengelola logika bisnis dan data.
    - `Account.java`: Mengelola informasi akun pengguna dan transaksi.
    - `Address.java`: Menyimpan informasi alamat pengguna.
    - `Brieftasche.java`: Mengelola daftar pengguna dan validasi data.
    - `Date.java`: Menyimpan informasi tanggal.
    - `PasswordSecurity.java`: Mengelola keamanan kata sandi pengguna.
    - `PinSecurity.java`: Mengelola keamanan PIN pengguna.
    - `Security.java`: Antarmuka untuk kelas keamanan.
    - `Transaction.java`: Menyimpan informasi transaksi.
    - `TransactionType.java`: Enum untuk jenis transaksi (pemasukan atau pengeluaran).
    - `User.java`: Menyimpan informasi pengguna.
  - `FrontEnd`: Berisi kelas-kelas yang mengelola antarmuka pengguna.
    - `DashboardPage.java`: Halaman utama yang menampilkan saldo dan daftar transaksi.
    - `UserPage.java`: Halaman untuk mengelola informasi pengguna.
    - `NewTransactionPage.java`: Halaman untuk menambahkan transaksi baru.
    - `InsertPinPage.java`: Halaman untuk memverifikasi PIN pengguna.
- `bin`: Folder untuk menyimpan file output yang telah dikompilasi.
- `.vscode`: Folder untuk menyimpan pengaturan Visual Studio Code.
- `README.md`: File ini yang berisi informasi tentang project.

## Cara Menggunakan

1. **Kloning Repositori**:
   ```sh
   git clone https://github.com/tearamizu/Thea_Brieftcase.git
   cd Thea_Brieftcase
   javac -d bin src/**/*.java
   ```
2. **Buka project di Visual Studio Code Atau Terminal**:
   ```code .
   ```
   
3. **Jalankan Aplikasi**:
   ```javac -d bin src/**/*.java
   java -cp bin App
   ```
   ataau

    ``java -jar Thea_Brieftasche.jar
    ```

## Manajemen Dependensi

Anda dapat mengelola dependensi project menggunakan tampilan `JAVA PROJECTS` di Visual Studio Code. Untuk informasi lebih lanjut, kunjungi [sini](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Kontribusi

Jika Anda ingin berkontribusi pada project ini, jangan. Mending di fork aja wkakwkaw.

## Lisensi

project ini dilisensikan di bawah [MIT License](LICENSE).