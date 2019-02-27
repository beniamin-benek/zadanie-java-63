import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

class Main {

    public static void main(String[] args) {

        List<PurchaseOrder> purchaseOrders = new LinkedList<>();

        try {
            purchaseOrders = FileReader.readFromFile("orders.csv");
        } catch (FileNotFoundException e) {
            System.err.println("Nie udało się wczytać pliku.");
        }

        MenuUtils.readOptionFromUser(purchaseOrders);

    }
}