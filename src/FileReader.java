import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class FileReader {

    static List<PurchaseOrder> readFromFile(String patchname) throws FileNotFoundException {

        File file = new File(patchname);
        Scanner scanner = new Scanner(file);
        String order;
        List<PurchaseOrder> orders = new LinkedList<>();

        while (scanner.hasNextLine()) {
            order = scanner.nextLine();
            String[] dataFromFile = order.split(";");
            orders.add(new PurchaseOrder(Integer.valueOf(dataFromFile[0]), dataFromFile[1], Double.valueOf(dataFromFile[2]), OrderStatus.valueOf(dataFromFile[3])));
        }

        return orders;

    }
}