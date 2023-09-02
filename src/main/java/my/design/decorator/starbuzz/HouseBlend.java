package my.design.decorator.starbuzz;


/**
 * 综合
 * 价格: 0.89
 */
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
