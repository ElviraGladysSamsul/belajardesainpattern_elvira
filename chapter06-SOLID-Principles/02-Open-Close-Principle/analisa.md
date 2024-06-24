**Open-Close Principle**
Open-Closed Principle (OCP) adalah prinsip desain dalam pengembangan perangkat lunak yang mengatakan bahwa sebuah entitas perangkat lunak (misalnya, kelas, modul, atau fungsi) harus terbuka untuk perluasan (open) tetapi tertutup untuk modifikasi (closed). Artinya, kita dapat memperluas fungsionalitas entitas tanpa mengubah kode yang sudah ada.

Ini berarti bahwa saat mengubah atau memperluas fitur atau perilaku suatu sistem, seharusnya tidak perlu memodifikasi kode yang sudah ada. Sebaliknya, kita harus dapat menambahkan fungsionalitas baru tanpa merusak kode yang sudah ada.

Implementasi OCP biasanya melibatkan penggunaan pola desain seperti polimorfisme, warisan, dan penggunaan antarmuka untuk memungkinkan entitas menjadi terbuka untuk perluasan dengan menambahkan kelas baru tanpa mengubah kelas yang sudah ada. Ini membantu menjaga fleksibilitas dan memudahkan pemeliharaan dan pengembangan sistem yang lebih besar.

**Analisis BookSummaryService:**
1. **Interface BookRepo**: Menyediakan operasi dasar untuk mengakses buku, seperti mengambil buku berdasarkan kategori, penulis, tanggal rilis, dan semua buku.
2. **Class Book**: Merepresentasikan buku dengan properti seperti kategori, penulis, harga, dan tanggal rilis. Ini juga menyediakan konstruktor, getter, dan setter untuk properti-propertinya.
3. **Class BookReq**: Digunakan untuk merepresentasikan permintaan ringkasan buku dengan dua properti: tipe pengelompokan dan nilai pengelompokan. Ini membantu dalam menentukan bagaimana buku dikelompokkan.
4. **Interface BookGroupStrategy**: Mendefinisikan strategi pengelompokan buku dengan metode `getBookSummary()` yang mengambil objek `BookReq` sebagai argumen dan mengembalikan objek `BookSummary`.
5. **Class BookSummary**: Merepresentasikan hasil ringkasan buku dengan properti seperti nama kelompok, total buku, dan total harga buku.
6. **Class BookSummaryByCategory, BookSummaryByReleaseDate, BookSummaryByAuthor**: Implementasi dari `BookGroupStrategy` yang mengelompokkan buku berdasarkan kategori, tanggal rilis, dan penulis masing-masing. Mereka menggunakan objek `BookRepo` untuk mengakses data buku dan menghitung total harga buku dalam kelompok.
7. **Class BookRepoImpl**: Implementasi dari `BookRepo` dengan data dummy. Ini menyediakan akses ke data buku dan implementasi metode-metodenya untuk mengambil buku berdasarkan kategori, penulis, tanggal rilis, atau semua buku.
8. **Class BookGroupFactory**: Digunakan untuk membuat objek `BookGroupStrategy` berdasarkan jenis pengelompokan yang diberikan. Ini membantu dalam menerapkan pola desain Factory untuk menciptakan objek strategi dengan lebih fleksibel.
9. **Class BookSummaryService**: Menyediakan layanan untuk mencetak ringkasan buku berdasarkan permintaan yang diberikan. Ini menggunakan objek `BookGroupFactory` untuk membuat strategi yang sesuai dan kemudian mencetak hasilnya.
10. **Main class**: Digunakan untuk demonstrasi penggunaan kelas-kelas yang ada. Ini membuat objek `BookRepoImpl`, `BookSummaryService`, dan memanggil metode `printSummary()` dengan berbagai permintaan buku. Juga menangani pengecualian yang mungkin muncul selama eksekusi.

**Analisis ProductManagementSystem:**
1. **Interface ProductRepo**: Menyediakan operasi dasar untuk mengakses produk, seperti mengambil produk berdasarkan kategori, merek, tanggal penjualan, dan semua produk.
2. **Class Product**: Merepresentasikan produk dengan properti seperti kategori, merek, harga, dan tanggal penjualan. Ini juga menyediakan konstruktor, getter, dan setter untuk properti-propertinya.
3. **Class ProductReq**: Digunakan untuk merepresentasikan permintaan ringkasan produk dengan dua properti: tipe pengelompokan dan nilai pengelompokan. Ini membantu dalam menentukan bagaimana produk dikelompokkan.
4. **Interface ProductGroupStrategy**: Mendefinisikan strategi pengelompokan produk dengan metode `getProductSummary()` yang mengambil objek `ProductReq` sebagai argumen dan mengembalikan objek `ProductSummary`.
5. **Class ProductSummary**: Merepresentasikan hasil ringkasan produk dengan properti seperti nama kelompok, total produk, dan total penjualan.
6. **Class ProductSummaryByCategory, ProductSummaryByBrand, ProductSummaryBySaleDate**: Implementasi dari `ProductGroupStrategy` yang mengelompokkan produk berdasarkan kategori, merek, dan tanggal penjualan masing-masing. Mereka menggunakan objek `ProductRepo` untuk mengakses data produk dan menghitung total penjualan dalam kelompok.
7. **Class ProductRepoImpl**: Implementasi dari `ProductRepo` dengan data dummy. Ini menyediakan akses ke data produk dan implementasi metode-metodenya untuk mengambil produk berdasarkan kategori, merek, tanggal penjualan, atau semua produk.
8. **Class ProductGroupFactory**: Digunakan untuk membuat objek `ProductGroupStrategy` berdasarkan jenis pengelompokan yang diberikan. Ini membantu dalam menerapkan pola desain Factory untuk menciptakan objek strategi dengan lebih fleksibel.
9. **Class ProductSummaryService**: Menyediakan layanan untuk mencetak ringkasan produk berdasarkan permintaan yang diberikan. Ini menggunakan objek `ProductGroupFactory` untuk membuat strategi yang sesuai dan kemudian mencetak hasilnya.
10. **Main class**: Digunakan untuk demonstrasi penggunaan kelas-kelas yang ada. Ini membuat objek `ProductRepoImpl`, `ProductSummaryService`, dan memanggil metode `printSummary()` dengan berbagai permintaan produk. Juga menangani pengecualian yang mungkin muncul selama eksekusi.