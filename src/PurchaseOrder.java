import java.util.Objects;

class PurchaseOrder {

    private int id;
    private String name;
    private double price;
    private OrderStatus orderStatus;

    public PurchaseOrder(int id, String name, double price, OrderStatus orderStatus) {
        this(name, price, orderStatus);
        this.id = id;
    }

    public PurchaseOrder(String name, double price, OrderStatus orderStatus) {
            this.name = name;
            this.price = price;
            this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderStatus=" + orderStatus.getOrderStatus() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, orderStatus);
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
