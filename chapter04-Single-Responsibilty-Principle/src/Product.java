import java.util.*;

// Entities
class Product {
    private int id; // ID produk
    private String name; // Nama produk
    private double price; // Harga produk

    // Constructor, getters, and setters
    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Metode untuk memberikan representasi string produk yang lebih informatif
    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + name + ", Harga: Rp." + price;
    }
}

// Repositories
interface ProductRepository {
    Product findById(int id); // Mencari produk berdasarkan ID
    void save(Product product); // Menyimpan produk
    List<Product> findAll(); // Mengambil semua produk
}

class InMemoryProductRepository implements ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();
    private static int counter = 0;

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        int id = generateUniqueId();
        product.setId(id);
        products.put(id, product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    // Metode untuk menghasilkan ID unik untuk produk
    private int generateUniqueId() {
        return ++counter;
    }
}

// Services
class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    // Metode untuk menambahkan produk baru
    public void addProduct(String name, double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productRepo.save(product);
    }

    // Metode untuk mendapatkan semua produk
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Metode untuk mencari produk berdasarkan ID
    public Product findProductById(int id) {
        return productRepo.findById(id);
    }
}

// Main Program
class Main {
    public static void main(String[] args) {
        // Inisialisasi repositori dan layanan
        ProductRepository productRepo = new InMemoryProductRepository();
        ProductService productService = new ProductService(productRepo);

        // Menambahkan produk
        productService.addProduct("Laptop", 8000);
        productService.addProduct("Smartphone", 5000);
        productService.addProduct("Headphones", 1000);

        // Mengambil dan mencetak semua produk
        List<Product> allProducts = productService.getAllProducts();
        System.out.println("Semua Produk:");
        for (Product product : allProducts) {
            System.out.println(product);
        }

        // Mencari produk berdasarkan ID
        int productIdToFind = 2;
        Product foundProduct = productService.findProductById(productIdToFind);
        if (foundProduct != null) {
            System.out.println("\nProduk ditemukan: " + foundProduct);
        } else {
            System.out.println("\nProduk tidak ditemukan dengan ID: " + productIdToFind);
        }
    }
}
