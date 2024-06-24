import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Interface ProductRepo untuk mendefinisikan operasi dasar untuk mengakses produk
interface ProductRepo {
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsBySaleDate(String saleDate);
    List<Product> getAllProducts();
}

// Class Product untuk merepresentasikan produk
class Product {
    private String category;
    private String brand;
    private double price;
    private String saleDate;

    // Constructor, getter, dan setter untuk Product
    public Product(String category, String brand, double price, String saleDate) {
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.saleDate = saleDate;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getSaleDate() {
        return saleDate;
    }
}

// Class ProductReq untuk merepresentasikan permintaan ringkasan produk
class ProductReq {
    private String groupingType;
    private String groupingValue;

    // Constructor untuk ProductReq
    public ProductReq(String groupingType, String groupingValue) {
        this.groupingType = groupingType;
        this.groupingValue = groupingValue;
    }

    public String getGroupingType() {
        return groupingType;
    }

    public String getGroupingValue() {
        return groupingValue;
    }
}

// Interface ProductGroupStrategy untuk mendefinisikan strategi pengelompokan produk
interface ProductGroupStrategy {
    ProductSummary getProductSummary(ProductReq req) throws Exception;
}

// Class ProductSummary untuk merepresentasikan hasil ringkasan produk
class ProductSummary {
    private String groupName;
    private int totalProducts;
    private double totalSales;

    // Constructor untuk ProductSummary
    public ProductSummary(String groupName, int totalProducts, double totalSales) {
        this.groupName = groupName;
        this.totalProducts = totalProducts;
        this.totalSales = totalSales;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public double getTotalSales() {
        return totalSales;
    }
}

// Class ProductSummaryByCategory untuk strategi pengelompokan berdasarkan kategori
class ProductSummaryByCategory implements ProductGroupStrategy {
    private final ProductRepo productRepo;

    // Constructor untuk ProductSummaryByCategory
    public ProductSummaryByCategory(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductSummary getProductSummary(ProductReq req) {
        List<Product> products = productRepo.getProductsByCategory(req.getGroupingValue());
        double totalSales = products.stream().mapToDouble(Product::getPrice).sum();
        return new ProductSummary("Kategori", products.size(), totalSales);
    }
}

// Class ProductSummaryByBrand untuk strategi pengelompokan berdasarkan merek
class ProductSummaryByBrand implements ProductGroupStrategy {
    private final ProductRepo productRepo;

    // Constructor untuk ProductSummaryByBrand
    public ProductSummaryByBrand(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductSummary getProductSummary(ProductReq req) {
        List<Product> products = productRepo.getProductsByBrand(req.getGroupingValue());
        double totalSales = products.stream().mapToDouble(Product::getPrice).sum();
        return new ProductSummary("Merek", products.size(), totalSales);
    }
}

// Class ProductSummaryBySaleDate untuk strategi pengelompokan berdasarkan tanggal penjualan
class ProductSummaryBySaleDate implements ProductGroupStrategy {
    private final ProductRepo productRepo;

    // Constructor untuk ProductSummaryBySaleDate
    public ProductSummaryBySaleDate(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductSummary getProductSummary(ProductReq req) {
        List<Product> products = productRepo.getProductsBySaleDate(req.getGroupingValue());
        double totalSales = products.stream().mapToDouble(Product::getPrice).sum();
        return new ProductSummary("Tanggal Penjualan", products.size(), totalSales);
    }
}

// Class ProductRepoImpl untuk implementasi ProductRepo dengan data dummy
class ProductRepoImpl implements ProductRepo {
    private List<Product> products;

    // Constructor untuk ProductRepoImpl dengan beberapa data dummy
    public ProductRepoImpl() {
        products = new ArrayList<>();
        products.add(new Product("Elektronik", "Samsung", 5000, "2023-01-01"));
        products.add(new Product("Makanan", "Indomie", 2500, "2022-05-10"));
        products.add(new Product("Pakaian", "Nike", 3000, "2021-12-20"));
        products.add(new Product("Elektronik", "Apple", 1000, "2023-02-15"));
        products.add(new Product("Makanan", "Silverqueen", 1500, "2020-07-25"));
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsBySaleDate(String saleDate) {
        return products.stream()
                .filter(product -> product.getSaleDate().equalsIgnoreCase(saleDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}

// Class ProductGroupFactory untuk membuat strategi pengelompokan
class ProductGroupFactory {
    private final ProductRepo productRepo;

    // Constructor untuk ProductGroupFactory
    public ProductGroupFactory(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // Method untuk membangun strategi berdasarkan jenis pengelompokan
    public ProductGroupStrategy buildStrategy(String grouping) throws Exception {
        if ("kategori".equalsIgnoreCase(grouping)) {
            return new ProductSummaryByCategory(productRepo);
        } else if ("merek".equalsIgnoreCase(grouping)) {
            return new ProductSummaryByBrand(productRepo);
        } else if ("tanggalPenjualan".equalsIgnoreCase(grouping)) {
            return new ProductSummaryBySaleDate(productRepo);
        } else {
            throw new Exception("Tidak ada pengelompokan yang ditemukan");
        }
    }
}

// Class ProductSummaryService untuk mencetak ringkasan produk
class ProductSummaryService {
    private final ProductRepo productRepo;

    // Constructor untuk ProductSummaryService
    public ProductSummaryService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // Method untuk mencetak ringkasan produk berdasarkan permintaan
    public void printSummary(ProductReq req) throws Exception {
        ProductGroupFactory productGroupFactory = new ProductGroupFactory(productRepo);
        ProductGroupStrategy strategy = productGroupFactory.buildStrategy(req.getGroupingType());

        ProductSummary products = strategy.getProductSummary(req);
        System.out.println("Nama kelompok = " + products.getGroupName());
        System.out.println("Total produk = " + products.getTotalProducts());
        System.out.println("Total penjualan = " + products.getTotalSales());
        System.out.println();
    }
}

// Main class untuk demonstrasi penggunaan
class Demo {
    public static void main(String[] args) {
        try {
            ProductRepo productRepo = new ProductRepoImpl(); // Implementasi ProductRepo
            ProductSummaryService summaryService = new ProductSummaryService(productRepo);

            // Gunakan nilai pengelompokan yang sesuai dengan data yang ada
            ProductReq reqCategory = new ProductReq("kategori", "Elektronik");
            summaryService.printSummary(reqCategory);

            ProductReq reqSaleDate = new ProductReq("tanggalPenjualan", "2023-01-01");
            summaryService.printSummary(reqSaleDate);

            ProductReq reqBrand = new ProductReq("merek", "Samsung");
            summaryService.printSummary(reqBrand);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
