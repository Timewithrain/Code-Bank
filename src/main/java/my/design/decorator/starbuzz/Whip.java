package my.design.decorator.starbuzz;

/**
 * 调料: 奶泡
 * 价格: 0.10
 */
public class Whip extends CondimentDecorator {

    private double cost;

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.10;
    }

    public double getCost() {return this.cost;}

    public void setCost(double cost) {this.cost = cost;}

    @Override
    public String getDescription() {return beverage.getDescription() + ", Whip";}

    public double cost() {return beverage.cost() + getCost();}

}
