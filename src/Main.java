import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStore = sc.nextInt();
        StoreFactory storeFactory = new StoreFactory();
        for (Store store : storeFactory.generateStores(numberOfStore)) {
            System.out.println("Employees:");
            System.out.println("\tNumber of SalesAssistants: " + store.getCounterByEmployeeType(SalesAssistant.class));
            System.out.println("\tAverage salary SalesAssistants: " + store.getAverageCounterEmployees(SalesAssistant.class) + " RUB");
            System.out.println("\tNumber of Cashier: " + store.getCounterByEmployeeType(Cashier.class));
            System.out.println("\tAverage salary Cashier: " + store.getAverageCounterEmployees(Cashier.class) + " RUB");
            System.out.println("\tNumber of Cleaner: " + store.getCounterByEmployeeType(Cleaner.class));
            System.out.println("\tAverage salary Cleaner: " + store.getAverageCounterEmployees(Cleaner.class) + " RUB");
            System.out.println("\t" + store.getSalaryDifferenceEmployees(Cashier.class, SalesAssistant.class));
            System.out.println("\t" + store.getSalaryDifferenceEmployees(Cleaner.class, SalesAssistant.class));
            System.out.println("\t" + store.getSalaryDifferenceEmployees(Cleaner.class, Cashier.class));
            System.out.println("Products:");
            System.out.println("\tNumber of products: " + store.getProducts().length);
            System.out.println("\tAverage price of products: " + store.getAverageCounterProducts() + " RUB");
            System.out.println("\tMaximum price of products: " + store.getMaxPriceProducts() + " RUB");
            System.out.println("\tMinimum price of products: " + store.getMinPriceProducts() + " RUB");
            for (String theFullSalaryOfTheEmployee : store.withdrawTheFullSalaryOfTheEmployee()) {
                System.out.println(theFullSalaryOfTheEmployee);
            }
        }
    }
}


