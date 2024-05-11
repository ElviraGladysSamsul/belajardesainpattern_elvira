**Single Responsibility Principle**
SRP, atau Prinsip Tanggung Jawab Tunggal, adalah salah satu dari lima prinsip desain dalam SOLID yang bertujuan untuk membantu pengembang perangkat lunak dalam menciptakan kode yang mudah dimengerti, dikelola, dan dikembangkan.

Prinsip Tanggung Jawab Tunggal (SRP) menyatakan bahwa sebuah kelas seharusnya hanya memiliki satu alasan untuk berubah. Artinya, sebuah kelas seharusnya hanya memiliki satu tanggung jawab atau fungsi utama. Dengan kata lain, kelas tersebut seharusnya fokus pada satu tugas atau aspek tertentu dari fungsionalitas yang diberikan, dan tidak seharusnya memiliki tanggung jawab atau ketergantungan yang berlebihan.

1. **Analisis BookService:**
* Entities (Model): Kelas Book dan Author mewakili entitas buku dan penulis dengan atribut yang sesuai. Mereka memiliki metode toString() untuk memberikan representasi string yang lebih informatif.
* Repositories: Interface BookRepo dan AuthorRepo mendefinisikan kontrak untuk operasi-operasi dasar pada entitas buku dan penulis seperti mencari dan menyimpan data. Kelas BookRepository dan AuthorRepository adalah implementasi dari repositori yang menggunakan struktur data Map untuk menyimpan data.
* Services: Kelas BookService dan AuthorService bertanggung jawab atas logika bisnis terkait buku dan penulis. Mereka menyediakan metode untuk menyimpan data, validasi, dan operasi lainnya.
* Main Program (Controller): Kelas App bertindak sebagai controller yang menginisialisasi repositori, layanan, dan berinteraksi dengan pengguna melalui metode main(). Ini juga menampilkan output hasil operasi.

2. **Analisis Product:**
* Entities (Model): Kelas Product mewakili entitas produk dengan atribut ID, nama, dan harga. Metode toString() digunakan untuk memberikan representasi string yang lebih informatif.
* Repositories: Interface ProductRepository mendefinisikan kontrak untuk operasi-operasi dasar pada entitas produk seperti mencari berdasarkan ID, menyimpan, dan mengambil semua produk. Kelas InMemoryProductRepository adalah implementasi dari repositori yang menggunakan struktur data Map untuk menyimpan produk dalam memori.
* Services: Kelas ProductService bertanggung jawab atas logika bisnis terkait produk. Ini menyediakan metode untuk menambahkan produk baru, mengambil semua produk, dan mencari produk berdasarkan ID.
* Main Program (Controller): Kelas Main bertindak sebagai controller yang menginisialisasi repositori dan layanan, menambahkan produk, dan berinteraksi dengan pengguna melalui konsol dengan menampilkan semua produk dan mencari produk berdasarkan ID.

Kode ini memisahkan peran-peran utama dalam aplikasi, menjaga prinsip SRP (Single Responsibility Principle) dengan setiap kelas memiliki tanggung jawabnya sendiri, sehingga memudahkan pemeliharaan dan pengembangan aplikasi yang lebih besar.