import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class MenuUtils {

    static void readOptionFromUser(List<PurchaseOrder> orders) {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        System.out.println("Lista zamówień: " + orders + "\n");

        do {
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("1: Posortuj po nazwie,\n2: Posortuj po cenie,\n3: Posortuj po statusie\n4: Zmień stan zamówienia\n5: Dodaj zamówienie\n6: Anuluj zamownenie\n7: Koniec");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Błąd. Wprowadź cyfrę z zakresu [1,6].");
                scanner.nextLine();
            }
            switch (option) {
            case 1:
                OrderUtils.sortByName(orders);
                System.out.println("Posortowano po nazwie.");
                System.out.println("Lista zamówień: " + orders + "\n");
                break;
            case 2:
                OrderUtils.sortByPrice(orders);
                System.out.println("Posortowano po cenie.");
                System.out.println("Lista zamówień: " + orders + "\n");
                break;
            case 3:
                OrderUtils.sortByStatus(orders);
                System.out.println("Posortowano po statusie.");
                System.out.println("Lista zamówień: " + orders + "\n");
                break;
            case 4:
                chageStatus(orders);
                System.out.println("Lista zamówień: " + orders + "\n");
                break;
            case 5:
                addOrder(orders);
                System.out.println("Lista zamówień: " + orders + "\n");
                break;
            case 6:
                cancelOrder(orders);
                System.out.println("Lista zamówień: " + orders + "\n");
                break;
            case 7:
                break;
            default:
                System.out.println("Wybrałeś nieistniejącą opcję. Spróbuj ponownie:");
            }
        } while (option != 7);
    }

    private static void addOrder(List<PurchaseOrder> orders) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Podaj nazwę produktu: ");
            String name = scanner.nextLine();
            System.out.print("Podaj wartość zamówienia: ");
            double price = scanner.nextDouble(); scanner.nextLine();
            OrderUtils.addToOrders(orders, new PurchaseOrder(name,price, OrderStatus.ZLOZONE));
            System.out.println("Dodano zamówienie.");
        } catch (InputMismatchException e) {
            System.err.println("Niepoprawne dane.");
        }
    }

    private static void chageStatus(List<PurchaseOrder> orders) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id zamowienia, któremu chcesz zmienić status.");
        try {
            int id = scanner.nextInt(); scanner.nextLine();
            OrderUtils.changeOrderStatus(id,orders);
        } catch (InputMismatchException e) {
            System.err.println("Niepoprawne dane.");
        }
    }

    private static void cancelOrder(List<PurchaseOrder> orders) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id zamowienia, które chcesz anulować.");
        try {
            int id = scanner.nextInt(); scanner.nextLine();
            OrderUtils.cancelOrder(id,orders);
        } catch (InputMismatchException e) {
            System.err.println("Niepoprawne dane.");
        }
    }

}