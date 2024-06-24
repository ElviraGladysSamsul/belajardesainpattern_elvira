**Liskov Substitution Principle**
Liskov Substitution Principle (LSP) adalah salah satu prinsip dalam SOLID yang menyatakan bahwa objek dari suatu kelas harus dapat diganti dengan objek dari kelas turunannya tanpa mengganggu fungsionalitas program yang benar. Dengan kata lain, objek yang diwarisi harus dapat digunakan sebagai pengganti objek induknya tanpa mengubah perilaku yang diharapkan.

**Analisis BirdBehavior:**
1. **Interface Bird:**
Mendefinisikan metode-metode yang harus diimplementasikan oleh semua jenis burung: getFood(), getFlyDistance(), dan getSleepBehavior().
2. **Kelas Pigeon dan Flamingo:**
Implementasi dari Bird, menyediakan perilaku khusus untuk masing-masing jenis burung.
3. **Interface CommonOstrich:**
Memiliki metode getFood() dan neckColor(), dengan implementasi default untuk getFood(), yang mewakili burung unta secara umum.
4. **Kelas SomaliOstrich dan NorthAfricanOstrich:**
Implementasi dari CommonOstrich, masing-masing menyediakan warna leher yang berbeda dan menerapkan metode neckColor().
5. **Kelas BirdBehavior (Main):**
* Digunakan untuk menguji fungsionalitas dari berbagai jenis burung dan burung unta.
* Objek pigeon dan flamingo dapat digunakan di mana pun objek Bird diperlukan.
* Objek somaliOstrich dan northAfricanOstrich dapat digunakan di mana pun objek CommonOstrich diperlukan.


**Analisis BirdBehavior:**
1. **Interface Animal:**
   Interface Animal mendefinisikan tiga metode: getSound(), getFood(), dan getHabitat(). Ini adalah perilaku umum yang diharapkan dari semua hewan.
2. **Class Dog, Cat, Cow, Lion, dan Elephant:**
   Masing-masing class mengimplementasikan interface Animal dan menyediakan implementasi dari metode getSound(), getFood(), dan getHabitat():
   Dog: Suara "Bark", makan "Meat", habitat "Domestic".
   Cat: Suara "Meow", makan "Fish", habitat "Domestic".
   Cow: Suara "Moo", makan "Grass", habitat "Farm".
   Lion: Suara "Roar", makan "Meat", habitat "Savannah".
   Elephant: Suara "Trumpet", makan "Plants", habitat "Forest".
3. Class AnimalBehavior:
   Dalam AnimalBehavior, kita membuat objek dari berbagai subclass (seperti Dog, Cat, Cow, Lion, dan Elephant), yang kemudian diperlakukan sebagai objek Animal. Ini menunjukkan bahwa kita bisa menggantikan subclass manapun dimana saja Animal diharapkan, tanpa mempengaruhi perilaku program.
