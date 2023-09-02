package my.design.decorator.starbuzz;

/**
 * 低咖啡因咖啡
 * 价格: 1.05
 */
public class Decaf extends Beverage {

    private double cost;

    public Decaf() {
        description = "Decaf";
        cost = 1.05;
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
