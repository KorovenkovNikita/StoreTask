import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStore = sc.nextInt();
        StoreFactory storeFactory = new StoreFactory();
        for (Store store : storeFactory.generateStores(numberOfStore)) {
            System.out.println("Employees:");
            System.out.println("\tNumber of SalesAssistants: " + store.getCounterSalesAssistant());
            System.out.println("\tAverage salary SalesAssistants: " + store.getAverageCounterSalarySalesAssistant() + " RUB");
            System.out.println("\tNumber of Cashier: " + store.getCounterCashier());
            System.out.println("\tAverage salary Cashier: " + store.getAverageCounterSalaryCashier() + " RUB");
            System.out.println("\tNumber of Cleaner: " + store.getCounterCleaner());
            System.out.println("\tAverage salary Cleaner: " + store.getAverageCounterSalaryCleaner() + " RUB");
            System.out.println("\t" + store.getSalaryDifferenceSalesAssistantAndCashier());
            System.out.println("\t" + store.getSalaryDifferenceSalesAssistantAndCleaner());
            System.out.println("\t" + store.getSalaryDifferenceCashierAndCleaner());
            System.out.println("Products:");
            System.out.println("\tNumber of products: " + store.getCounterProducts());
            System.out.println("\tAverage price of products: " + store.getAverageCounterProducts() + " RUB");
            System.out.println("\tMaximum price of products: " + store.getMaxPriceProducts() + " RUB");
            System.out.println("\tMinimum price of products: " + store.getMinPriceProducts() + " RUB");
            for (String theFullSalaryOfTheEmployee : store.withdrawTheFullSalaryOfTheEmployee()) {
                System.out.println(theFullSalaryOfTheEmployee);
            }
        }
    }
}


