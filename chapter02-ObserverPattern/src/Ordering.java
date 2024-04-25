import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Kelas Ordering
class Ordering {
    private String customer;
    private String seller;
    private String orderNo;
    private BigDecimal price;
    private String product;
    private int totalItem;

    // getter dan setter
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}

// Antarmuka Subscriber
interface Subscriber {
    void consume(Ordering ordering);
}

// Kelas StockUpdater
class StockUpdater implements Subscriber {
    @Override
    public void consume(Ordering ordering) {
        System.out.println("Stok produk " + ordering.getProduct() + " dari pesanan " + ordering.getOrderNo() +
                " telah diperbarui sebanyak " + ordering.getTotalItem() + " unit");
    }
}

// Kelas InvoiceCreation
class InvoiceCreation implements Subscriber {
    @Override
    public void consume(Ordering ordering) {
        System.out.println("Faktur dari pesanan " + ordering.getOrderNo() + " telah dibuat");
    }
}

// Antarmuka Publisher
interface Publisher {
    Publisher addSubscriber(Subscriber subscriber);
    Publisher removeSubscriber(Class<? extends Subscriber> subscriberClass);
    void produce(Ordering ordering);
}

// Kelas OrderCreationPublisher
class OrderCreationPublisher implements Publisher {
    Map<Class<? extends Subscriber>, Subscriber> subscribers = new HashMap<>();

    @Override
    public Publisher addSubscriber(Subscriber subscriber) {
        this.subscribers.put(subscriber.getClass(), subscriber);
        return this;
    }

    @Override
    public Publisher removeSubscriber(Class<? extends Subscriber> subscriberClass) {
        subscribers.remove(subscriberClass);
        return this;
    }

    @Override
    public void produce(Ordering ordering) {
        subscribers.forEach((aClass, subscriber) -> {
            subscriber.consume(ordering);
        });
    }
}

// Kelas OrderCreation
class OrderCreation {
    private final Publisher publisher;

    OrderCreation(Publisher publisher) {
        this.publisher = publisher;
    }

    public void createOrder(Ordering ordering) {
        System.out.println("Pesanan " + ordering.getOrderNo() + " berhasil dibuat");
        this.publisher.produce(ordering);
    }
}

// Kelas Utama
class Demo {
    public static void main(String[] args) {
        Publisher publisher = new OrderCreationPublisher()
                .addSubscriber(new StockUpdater())
                .addSubscriber(new InvoiceCreation());

        OrderCreation orderCreation = new OrderCreation(publisher);

        // Membuat pesanan pertama
        Ordering order1 = new Ordering();
        order1.setCustomer("Elvira");
        order1.setSeller("Gladys");
        order1.setOrderNo("xyz-888");
        order1.setPrice(BigDecimal.TEN);
        order1.setProduct("Susu");
        order1.setTotalItem(10);
        orderCreation.createOrder(order1);

        System.out.println();

        // Membuat pesanan kedua
        Ordering order2 = new Ordering();
        order2.setCustomer("Mumut");
        order2.setSeller("Rahma");
        order2.setOrderNo("abc-123");
        order2.setPrice(BigDecimal.valueOf(20));
        order2.setProduct("Roti");
        order2.setTotalItem(5);
        orderCreation.createOrder(order2);
    }
}
