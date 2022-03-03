import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private String storeName;
    private Product[] products;
    private Employee[] employees;
    private boolean openStatus;

    public Store(String storeName, Product[] products, Employee[] employees, boolean openStatus) {
        this.storeName = storeName;
        this.products = products;
        this.employees = employees;
        this.openStatus = openStatus;
    }

    public String getSalaryDifferenceSalesAssistantAndCashier() {
        if (getAverageCounterSalaryCashier() != 0 && getAverageCounterSalarySalesAssistant() != 0) {
            return "The SalesAssistant's salary is more than the Cashier's salary in: " + (int) ((float) getAverageCounterSalaryCashier() / getAverageCounterSalarySalesAssistant() * 100) + " %";
        } else {
            return "One type of employee is missing...";
        }
    }

    public String getSalaryDifferenceSalesAssistantAndCleaner() {
        if (getAverageCounterSalaryCleaner() != 0 && getAverageCounterSalarySalesAssistant() != 0) {
            return "The SalesAssistant's salary is more than the Cleaner's salary in: " + (int) ((float) getAverageCounterSalaryCleaner() / getAverageCounterSalarySalesAssistant() * 100) + " %";
        } else {
            return "One type of employee is missing...";
        }
    }

    public String getSalaryDifferenceCashierAndCleaner() {
        int averageCounterSalaryCleaner = getAverageCounterSalaryCleaner();
        int averageCounterSalaryCashier = getAverageCounterSalaryCashier();
        if (averageCounterSalaryCleaner != 0 && averageCounterSalaryCashier != 0) {
            return "The Cashier's salary is more than the Cleaner's salary in: " + (int) ((float) averageCounterSalaryCleaner / averageCounterSalaryCashier * 100) + " %";
        } else {
            return "One type of employee is missing...";
        }
    }

    public List<String> withdrawTheFullSalaryOfTheEmployee() {
        List<String> theFullSalaryOfTheEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Stimulated) {
                ((Stimulated) employee).calculatePremium(getMaxPriceProducts(), getCounterProducts());
                int fullSalary = (employee.getSalary()+((Stimulated) employee).getPremium());
                theFullSalaryOfTheEmployee.add(employee.getName()+": "+"\n\tSalary: "+employee.getSalary()+" RUB"+"\n\tBonus: "+((Stimulated) employee).getPremium()+" RUB"+"\n\tSalary with bonus: "+fullSalary+" RUB"+"\n");
            }
        }
        return theFullSalaryOfTheEmployee;
    }

    public int getMinPriceProducts() {
        int min = 300;
        for (Product product : products) {
            min = Math.min(min, product.getPrice());
        }
        return min;
    }

    public int getMaxPriceProducts() {
        int max = 0;
        for (Product product : products) {
            max = Math.max(max, product.getPrice());
        }
        return max;
    }

    public int getCounterProducts() {
        int counterProducts = 0;
        for (Product product : products) {
            counterProducts++;
        }
        return counterProducts;
    }

    public int getAverageCounterProducts() {
        int counterProducts = 0;
        int counterPriceProducts = 0;
        for (Product product : products) {
            counterProducts++;
            counterPriceProducts += product.getPrice();
        }
        if (counterProducts != 0) {
            return counterPriceProducts / counterProducts;
        } else {
            return 0;
        }
    }

    public int getCounterSalesAssistant() {
        int counterSalesAssistant = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesAssistant) {
                counterSalesAssistant++;
            }
        }
        return counterSalesAssistant;
    }

    public int getAverageCounterSalarySalesAssistant() {
        int counterSalesAssistant = 0;
        int counterSalarySalesAssistant = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesAssistant) {
                counterSalesAssistant++;
                counterSalarySalesAssistant += employee.getSalary();
            }
        }
        if (counterSalesAssistant != 0) {
            return counterSalarySalesAssistant / counterSalesAssistant;
        } else {
            return 0;
        }
    }

    public int getCounterCashier() {
        int counterCashier = 0;
        for (Employee employee : employees) {
            if (employee instanceof Cashier) {
                counterCashier++;
            }
        }
        return counterCashier;
    }

    public int getAverageCounterSalaryCashier() {
        int counterCashier = 0;
        int counterSalaryCashier = 0;
        for (Employee employee : employees) {
            if (employee instanceof Cashier) {
                counterCashier++;
                counterSalaryCashier += employee.getSalary();
            }
        }
        if (counterCashier != 0) {
            return counterSalaryCashier / counterCashier;
        } else {
            return 0;
        }
    }

    public int getCounterCleaner() {
        int counterCleaner = 0;
        for (Employee employee : employees) {
            if (employee instanceof Cleaner) {
                counterCleaner++;
            }
        }
        return counterCleaner;
    }

    public int getAverageCounterSalaryCleaner() {
        int counterCleaner = 0;
        int counterSalaryCleaner = 0;
        for (Employee employee : employees) {
            if (employee instanceof Cleaner) {
                counterCleaner++;
                counterSalaryCleaner += employee.getSalary();
            }
        }
        if (counterCleaner != 0) {
            return counterSalaryCleaner / counterCleaner;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "\n" + "StoreName: " + storeName + "\n" +
                "\tProducts: " + Arrays.toString(products) + "\n" +
                "\tEmployees: " + Arrays.toString(employees) + "\n" +
                "\tOpenStatus: " + openStatus + "\n";
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public boolean isOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(boolean openStatus) {
        this.openStatus = openStatus;
    }
}
