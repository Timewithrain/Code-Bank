package my.design.decorator.starbuzz;

/**
 * 意式浓缩
 * 价格: 1.99
 */
public class Espresso extends Beverage{

    private double cost;

    public Espresso() {
        description = "Espresso";
        cost = 1.99;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public double cost() {
        return getCost();
    }
}
