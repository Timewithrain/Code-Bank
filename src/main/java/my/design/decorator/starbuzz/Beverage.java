package my.design.decorator.starbuzz;

/**
 * 参考《HeadFirst设计模式》装饰者模式
 * 主要基类，包含饮料的描述以及计算价格的方法cost()
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
