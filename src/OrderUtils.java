import java.util.Collections;
import java.util.List;

class OrderUtils {

    static void addToOrders (List<PurchaseOrder> purchaseOrders, PurchaseOrder order) {
        purchaseOrders.add(new PurchaseOrder(purchaseOrders.size() + 1, order.getName(), order.getPrice(),order.getOrderStatus()));
    }

    static void changeOrderStatus (int id, List<PurchaseOrder> purchaseOrders) {
        if (!checkID(id, purchaseOrders))
            System.out.println("Zamówienie o indeksie " + id + " nie istnieje.");
        else {
            for (int i = 0; i < purchaseOrders.size(); i++) {
                if (purchaseOrders.get(i).getId() == id) {
                    switch (purchaseOrders.get(i).getOrderStatus()) {
                        case ZLOZONE:
                            purchaseOrders.get(i).setOrderStatus(OrderStatus.PRZYGOTOWANE);
                            System.out.println("Zamówienie o indeksie " + (i + 1) + " zmienilo status na: Przygowane do wysyłki");
                            break;
                        case PRZYGOTOWANE:
                            purchaseOrders.get(i).setOrderStatus(OrderStatus.TRANSPORT);
                            System.out.println("Zamówienie o indeksie " + (i + 1) + " zmienilo status na: W transporcie.");
                            break;
                        case TRANSPORT:
                            purchaseOrders.get(i).setOrderStatus(OrderStatus.ZREALIZOWANE);
                            System.out.println("Zamówienie o indeksie " + (i + 1) + " zmienilo status na: Zrealizowane.");
                            break;
                        case ANULOWANE:
                            System.out.println("To zmówienie zostało już anulowane.");
                            break;
                        case ZREALIZOWANE:
                            System.out.println("To zmówienie zostało już zrealizowane.");
                            break;
                    }
                }
            }
        }
    }

    static void cancelOrder(int id, List<PurchaseOrder> purchaseOrders) {
        if (!checkID(id, purchaseOrders))
            System.out.println("Zamówienie o indeksie " + id + " nie istnieje.");
        else {
            for (int i = 0; i < purchaseOrders.size(); i++) {
                if (purchaseOrders.get(i).getId() == id) {
                    if (purchaseOrders.get(i).getOrderStatus() == OrderStatus.ZLOZONE || purchaseOrders.get(i).getOrderStatus() == OrderStatus.PRZYGOTOWANE) {
                        purchaseOrders.get(i).setOrderStatus(OrderStatus.ANULOWANE);
                        System.out.println("Zamówienie o indeksie " + (i + 1) + " zostało anulowane.");
                    } else if (purchaseOrders.get(i).getOrderStatus() != OrderStatus.ZLOZONE && purchaseOrders.get(i).getOrderStatus() != OrderStatus.PRZYGOTOWANE) {
                        System.out.println("Zamówienia o indeksie " + (i + 1) + " nie można anulować.");
                    }
                }
            }
        }
    }

    static void sortByName(List<PurchaseOrder> purchaseOrder) {
        Collections.sort(purchaseOrder, new NameComparator());
    }

    static void sortByPrice(List<PurchaseOrder> purchaseOrder) {
        Collections.sort(purchaseOrder, new PriceComparator());
    }

    static void sortByStatus(List<PurchaseOrder> purchaseOrder) {
        Collections.sort(purchaseOrder, new OrderStatusComparator());
    }

    private static boolean checkID (int id, List<PurchaseOrder> purchaseOrders) { //sprawdza, czy zamowienie o indeksie podanym przez użytkownika znajduje się na liście
        for (int i = 0; i < purchaseOrders.size(); i++) {
            if (purchaseOrders.get(i).getId() == id)
                return true;
        }
        return false;
    }

}