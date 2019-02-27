import java.util.Comparator;

class NameComparator implements Comparator<PurchaseOrder> {

    @Override
    public int compare(PurchaseOrder o1, PurchaseOrder o2) {
        return o1.getName().compareTo(o2.getName());
    }

}