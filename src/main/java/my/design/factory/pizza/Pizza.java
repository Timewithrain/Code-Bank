package my.design.factory.pizza;

import java.util.ArrayList;

/**
 * 工厂模式--产品类
 * 抽象产品: Pizza
 * 具体产品: NYCStyleCheesePizza, ChicagoStyleCheesePizza, ...
 */
public abstract class Pizza {

    String name;
    String dough;  // 生面团
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("[Prepare]Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.printf("Adding toppings:");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.printf(" " + toppings.get(i));
        }
        System.out.println();
    }

    public void bake() {
        System.out.println("[Bake] Bake for 25min at 350");
    }

    public void cut() {
        System.out.println("[Cut] Cutting pizza into diagonal slices");
    }

    public void box() {
        System.out.println("[Box] Place Pizza in official box");
    }

    public String getName() {
        return name;
    }

    public abstract String toString();

}

class CheesePizza extends Pizza{
    public String toString() {
        return "CheesePizza";
    }
}

class GreekPizza extends Pizza {
    public String toString() {
        return "GreekPizza";
    }
}

class PepperoniPizza extends Pizza {
    public String toString() {
        return "PepperoniPizza";
    }
}

class ClamPizza extends Pizza {
    public String toString() {
        return "ClamPizza";
    }
}

class VeggiePizza extends Pizza {
    public String toString() {
        return "VeggiePizza";
    }
}
