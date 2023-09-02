package my.design.decorator.starbuzz;

/**
 * 调料: 卡摩卡
 * 价格: 0.20
 */
public class Mocha extends CondimentDecorator{

    private double cost;

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.20;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return beverage.cost() + getCost();
    }
}
