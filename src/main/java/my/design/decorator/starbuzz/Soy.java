package my.design.decorator.starbuzz;

/**
 * 调料: 豆浆
 */
public class Soy extends CondimentDecorator{

    private double cost;

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.15;
    }

    public double getCost() {return this.cost;}

    public void setCost(double cost) {this.cost = cost;}

    @Override
    public String getDescription() {return beverage.getDescription() + ", soy";}

    public double cost() {return beverage.cost() + getCost();}

}
