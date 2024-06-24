**Interface Segregation Principle**
Interface Segregation Principle (ISP) adalah salah satu prinsip dalam SOLID yang menyatakan bahwa sebuah interface tidak boleh memaksa klien untuk bergantung pada metode yang tidak mereka gunakan. Prinsip ini mendorong pembuatan beberapa interface yang lebih spesifik, dibandingkan membuat satu interface besar yang mencakup semua metode.

**Analisis UserGatewayExample:**
1. **Interface UserGateway:**
Interface ini mendefinisikan operasi dasar yang diharapkan dari semua jenis pengguna: signIn(), signOut(), dan getUserName().
3. **Interface UserBankGateway:**
Interface ini memperluas UserGateway dan menambahkan operasi terkait dengan bank: getBankList(), addBank(String bankName), dan removeBank(String bankName).
5. **Interface UserAddressGateway:**
Interface ini memperluas UserGateway dan menambahkan operasi terkait dengan alamat: getAddressList(), addAddress(String address), removeAddress(String address), dan getMainAddress().
7. **Implementasi UserBankGatewayImpl:**
Kelas ini mengimplementasikan UserBankGateway dan menyediakan implementasi spesifik untuk operasi terkait bank.
9. **Implementasi UserAddressGatewayImpl:**
Kelas ini mengimplementasikan UserAddressGateway dan menyediakan implementasi spesifik untuk operasi terkait alamat.
11. **Kelas UserProcessor:**
Kelas ini menggunakan UserBankGateway dan UserAddressGateway melalui injeksi metode. Metode addUserBank(), addUserAddress(), dan printUserName() menggunakan UserGateway untuk melakukan operasi yang diperlukan.
13. **Kelas UserGatewayExample (Main class):**
Kelas ini adalah titik masuk aplikasi. Membuat instance dari UserProcessor, UserBankGateway, dan UserAddressGateway. Kemudian, menggunakan UserProcessor untuk menambahkan bank, alamat, dan mencetak nama pengguna.


**Analisis VehicleExample:**
1. **Interface Vehicle:**
Interface ini mendefinisikan metode dasar yang diharapkan dari semua kendaraan, yaitu startEngine(), stopEngine(), dan getVehicleType().
2. **Interface Car, Motorcycle, dan Boat:**
Interface ini memperluas interface Vehicle dan menambahkan metode spesifik yang hanya relevan untuk masing-masing jenis kendaraan.
* Car menambahkan getNumberOfDoors() dan hasAirConditioning().
* Motorcycle menambahkan hasSideCar() dan isOffRoad().
* Boat menambahkan hasSail() dan getMaxSpeedOnWater().
3. **Implementasi Sedan, SportsBike, dan Yacht:**
Masing-masing class mengimplementasikan interface yang sesuai dan menyediakan implementasi dari metode-metode yang ditentukan.
* Sedan mengimplementasikan Car.
* SportsBike mengimplementasikan Motorcycle.
* Yacht mengimplementasikan Boat.
4. Class VehicleProcessor:
Class ini menggunakan metode yang didefinisikan dalam interface untuk menguji objek Car, Motorcycle, dan Boat.
5. Class VehicleExample:
Class ini membuat objek Sedan, SportsBike, dan Yacht, kemudian menggunakan VehicleProcessor untuk menguji masing-masing kendaraan.