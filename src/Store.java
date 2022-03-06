import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private String storeName;
    private Product[] products;
    private Employee[] employees;
    private boolean openStatus;
    private int minPriceProducts;
    private int maxPriceProducts;
    private int averageCounterProducts;

    public Store(String storeName, Product[] products, Employee[] employees, boolean openStatus) {
        this.storeName = storeName;
        this.products = products;
        this.employees = employees;
        this.openStatus = openStatus;
        calculateMinMaxAveragePriceProducts();
    }

    public <T, S> String getSalaryDifferenceEmployees(T firstEmployee, S secondEmployee) {
        int averageCounterSalaryFirstEmployee = getAverageCounterEmployees(firstEmployee);
        int averageCounterSalarySecondEmployee = getAverageCounterEmployees(secondEmployee);
        if (averageCounterSalaryFirstEmployee != 0 && averageCounterSalarySecondEmployee != 0) {
            return "The " + secondEmployee.toString().substring(6) + "'s salary is more than the " + firstEmployee.toString().substring(6) + "'s salary in: " + ((int) ((float) averageCounterSalaryFirstEmployee / averageCounterSalarySecondEmployee * 100)) + " %";
        } else {
            return "One type of employee is not found...";
        }
    }

    public List<String> withdrawTheFullSalaryOfTheEmployee() {
        List<String> theFullSalaryOfTheEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Stimulated) {
                ((Stimulated) employee).calculatePremium(maxPriceProducts, products.length);
                int fullSalary = (employee.getSalary() + ((Stimulated) employee).getPremium());
                theFullSalaryOfTheEmployee.add(employee.getName() + ": " + "\n\tSalary: " + employee.getSalary() + " RUB" + "\n\tBonus: " + ((Stimulated) employee).getPremium() + " RUB" + "\n\tSalary with bonus: " + fullSalary + " RUB" + "\n");
            }
        }
        return theFullSalaryOfTheEmployee;
    }

    private void calculateMinMaxAveragePriceProducts() {
        int min = products[0].getPrice();
        int max = products[0].getPrice();
        int counterPriceProducts = 0;
        for (Product product : products) {
            min = Math.min(min, product.getPrice());
            max = Math.max(max, product.getPrice());
            counterPriceProducts += product.getPrice();
        }
        minPriceProducts = min;
        maxPriceProducts = max;
        averageCounterProducts = counterPriceProducts / products.length;
    }

    public <T> int getCounterByEmployeeType(T employeeType) {
        int counterEmployee = 0;
        for (Employee employee : employees) {
            if (employee.getClass() == employeeType) {
                counterEmployee++;
            }
        }
        return counterEmployee;
    }

    public <T> int getAverageCounterEmployees(T employeeType) {
        int counterEmployees = 0;
        int counterSalaryEmployees = 0;
        for (Employee employee : employees) {
            if (employee.getClass() == employeeType) {
                counterEmployees++;
                counterSalaryEmployees += employee.getSalary();
            }
        }
        if (counterEmployees != 0) {
            return counterSalaryEmployees / counterEmployees;
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

    public int getMinPriceProducts() {
        return minPriceProducts;
    }

    public void setMinPriceProducts(int minPriceProducts) {
        this.minPriceProducts = minPriceProducts;
    }

    public int getMaxPriceProducts() {
        return maxPriceProducts;
    }

    public void setMaxPriceProducts(int maxPriceProducts) {
        this.maxPriceProducts = maxPriceProducts;
    }

    public int getAverageCounterProducts() {
        return averageCounterProducts;
    }

    public void setAverageCounterProducts(int averageCounterProducts) {
        this.averageCounterProducts = averageCounterProducts;
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
