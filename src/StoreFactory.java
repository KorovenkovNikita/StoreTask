import java.util.Random;

public class StoreFactory {

    public Store[] generateStores(int numberOfStore) {
        Store[] stores = new Store[numberOfStore];
        for (int i = 0; i < stores.length; i++) {
            stores[i] = new Store(generatedName(), generateProducts(), generateEmployees(), generateOpenStatus());
        }
        return stores;
    }

    private Product[] generateProducts() {
        Random random = new Random();
        Product[] products = new Product[random.nextInt(20 - 15) + 15];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(generatedName(), random.nextInt(300 - 100) + 100);
        }
        return products;
    }

    public String generatedName() {
        int targetStringLength = 5;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            randomLetter();
            if (i == 0) {
                String stringRandomLimitedInt = String.valueOf(randomLetter()).toUpperCase();
                buffer.append(stringRandomLimitedInt);
            } else {
                buffer.append(randomLetter());
            }
        }
        return buffer.toString();
    }

    private String randomLetter() {
        String[] consonants = {"q", "w", "r", "t", "p", "l", "k", "j", "h", "g", "f", "d", "s", "z", "x", "c", "v", "b", "n", "m"};
        String[] vowels = {"a", "e", "i", "o", "u", "y"};
        Random random = new Random();
        String Letter;
        int Letter1 = random.nextInt(2);
        if (Letter1 == 1) {
            Letter = consonants[random.nextInt(consonants.length)];
        } else {
            Letter = vowels[random.nextInt(vowels.length)];
        }
        return Letter;
    }

    private Employee[] generateEmployees() {
        Random random = new Random();
        Employee[] employees = new Employee[random.nextInt(20 - 15) + 15];
        for (int i = 0; i < employees.length; i++) {
            int randOm = random.nextInt(3);
            if (randOm == 0) {
                employees[i] = new SalesAssistant(generatedName(), random.nextInt(40000 - 30000) + 30000);
            }
            if (randOm == 1) {
                employees[i] = new Cashier(generatedName(), random.nextInt(20000 - 15000) + 15000);
            }
            if (randOm == 2) {
                employees[i] = new Cleaner(generatedName(), random.nextInt(15000 - 10000) + 10000);
            }
        }
        return employees;
    }


    private boolean generateOpenStatus() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
