package my.design.decorator.starbuzz;

/**
 * 调料装饰器，用于装饰饮料类，通过继承Beverage类，使得调料装饰器和饮料类具有相同的类型，实现装饰器模式
 * 调料装饰器必须包含getDescription()和cost()方法
 * getDescription()方法返回调料的描述
 * cost()方法计算添加调料后的饮料价格
 */
public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();

    @Override
    public double cost() {
        return 0;
    }
}
