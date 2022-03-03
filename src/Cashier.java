public class Cashier extends Employee implements Stimulated {
    private int premium;

    public Cashier(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void calculatePremium(int maxPriceProducts, int counterProducts) {
        this.premium = maxPriceProducts * counterProducts;
    }

    @Override
    public int getPremium() {
        return premium;
    }
}

