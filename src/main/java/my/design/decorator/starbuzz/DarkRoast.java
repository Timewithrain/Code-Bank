package my.design.decorator.starbuzz;

/**
 * 深烘
 * 价格: 0.99
 */
public class DarkRoast extends Beverage{

    private double cost;

    public DarkRoast() {
        description = "DarkRoast";
        cost = 0.99;
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
