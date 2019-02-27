public enum OrderStatus {

    ZLOZONE(1, "Złożone"),
    PRZYGOTOWANE(2 ,"Przygotowane do wysyłki"),
    TRANSPORT(3, "W transporcie"),
    ZREALIZOWANE(4,"Zrealizowane"),
    ANULOWANE(5,"Anulowane");

    int id;
    String orderStatus;

    OrderStatus(int id, String orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}