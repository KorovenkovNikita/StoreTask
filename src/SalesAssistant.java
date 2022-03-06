public class SalesAssistant extends Employee implements Stimulated {
    private int premium;

    public SalesAssistant(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void calculatePremium(int maxPriceProducts, int counterProducts) {
        int x = maxPriceProducts / 100 * counterProducts;
        int premium = (int) (getSalary() * 0.01 * x);
        if (x <= 25) {
            this.premium = premium;
        } else {
            x = 25;
            this.premium = (int) (getSalary() * 0.01 * x);
        }
    }

    @Override
    public int getPremium() {
        return premium;
    }

}


