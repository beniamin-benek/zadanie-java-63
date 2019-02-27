import java.util.Comparator;

class PriceComparator implements Comparator<PurchaseOrder> {

    @Override
    public int compare(PurchaseOrder o1, PurchaseOrder o2) {
//        if (o1.getPrice() > o2.getPrice())
//            return 1;
//        else if (o1.getPrice() < o2.getPrice())
//            return -1;
//        return 0;
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}