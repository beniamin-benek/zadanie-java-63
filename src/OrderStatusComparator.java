import java.util.Comparator;

class OrderStatusComparator implements Comparator<PurchaseOrder> {

    @Override
    public int compare(PurchaseOrder o1, PurchaseOrder o2) {
        return Double.compare(o1.getOrderStatus().getId(), o2.getOrderStatus().getId());
    }

}