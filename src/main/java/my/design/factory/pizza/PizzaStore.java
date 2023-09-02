package my.design.factory.pizza;

/**
 * 工厂模式--创建者
 * 抽象创建者: PizzaStore
 * 具体创建者: NYCPizzaStore, ChicagoPizzaStore, CaliforniaPizzaStore
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);
        pizza.prepare();;
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /** 工厂方法--生产产品的抽象接口 */
    public abstract Pizza createPizza(String type);

}

class NYCPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza() {
                {
                    name = "NYCStyleCheesePizza";
                    dough = "Thin Crust Dough";
                    sauce = "Marinara Sauce";
                    toppings.add("Grated Reggiano Cheese");
                }
                public String toString() { return "NYCStyleCheesePizza";}
            };
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza() {
                public String toString() { return "NYCStylePepperoniPizza";}
            };
        } else if (type.equals("clam")) {
            pizza = new ClamPizza() {
                public String toString() { return "NYCStyleClamPizza";}
            };
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza() {
                public String toString() { return "NYCStyleVeggiePizza";}
            };
        }
        return pizza;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza() {
                {
                    name = "ChicagoStyleCheesePizza";
                    dough = "Extra Thick Crust Dough";
                    sauce = "Plum Tomato Sauce";
                    toppings.add("Shredded Mozzarella Cheese");
                }
                public void cut() {
                    System.out.println("[Cut] Cutting the pizza into square slices");
                }
                public String toString() { return "ChicagoStyleCheesePizza";}
            };
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza() {
                public String toString() { return "ChicagoStylePepperoniPizza";}
            };
        } else if (type.equals("clam")) {
            pizza = new ClamPizza() {
                public String toString() { return "ChicagoStyleClamPizza";}
            };
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza() {
                public String toString() { return "ChicagoStyleVeggiePizza";}
            };
        }
        return pizza;
    }
}

class CaliforniaPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza() {
                public String toString() { return "CaliforniaStyleCheesePizza";}
            };
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza() {
                public String toString() { return "CaliforniaStylePepperoniPizza";}
            };
        } else if (type.equals("clam")) {
            pizza = new ClamPizza() {
                public String toString() { return "CaliforniaStyleClamPizza";}
            };
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza() {
                public String toString() { return "CaliforniaStyleVeggiePizza";}
            };
        }
        return pizza;
    }
}




