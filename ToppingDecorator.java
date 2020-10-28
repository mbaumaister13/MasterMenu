abstract class ToppingDecorator extends Meal {
    public abstract String getName();
    public abstract float getPrice();

}

class Steak extends ToppingDecorator {
    Meal meal;

    public Steak(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Steak";
    }

    public float getPrice() {
        return meal.getPrice() + 1.0f;
    }
}

class Chicken extends ToppingDecorator {
    Meal meal;

    public Chicken(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Chicken";
    }

    public float getPrice() {
        return meal.getPrice() + 1.0f;
    }
}

class Lettuce extends ToppingDecorator {
    Meal meal;

    public Lettuce(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Lettuce";
    }

    public float getPrice() {
        return meal.getPrice() + 0.25f;
    }
}

class Pico extends ToppingDecorator {
    Meal meal;

    public Pico(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Pico de Gallo";
    }

    public float getPrice() {
        return meal.getPrice() + 0.5f;
    }
}

class SourCream extends ToppingDecorator {
    Meal meal;

    public SourCream(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Sour Cream";
    }

    public float getPrice() {
        return meal.getPrice() + 0.5f;
    }
}

class Rice extends ToppingDecorator {
    Meal meal;

    public Rice(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Rice";
    }

    public float getPrice() {
        return meal.getPrice() + 1.0f;
    }
}

class Beans extends ToppingDecorator {
    Meal meal;

    public Beans(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Beans";
    }

    public float getPrice() {
        return meal.getPrice() + 1.0f;
    }
}

class Cheese extends ToppingDecorator {
    Meal meal;

    public Cheese(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Cheese";
    }

    public float getPrice() {
        return meal.getPrice() + 0.5f;
    }
}

class Mild extends ToppingDecorator {
    Meal meal;

    public Mild(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Mild Sauce";
    }

    public float getPrice() {
        return meal.getPrice() + 0.25f;
    }
}

class Medium extends ToppingDecorator {
    Meal meal;

    public Medium(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Medium Sauce";
    }

    public float getPrice() {
        return meal.getPrice() + 0.25f;
    }
}

class Hot extends ToppingDecorator {
    Meal meal;

    public Hot(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Hot Sauce";
    }

    public float getPrice() {
        return meal.getPrice() + 0.25f;
    }
}

class TacoShell extends ToppingDecorator {
    Meal meal;

    public TacoShell(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return meal.getName() + ", Taco Shell";
    }

    public float getPrice() {
        return meal.getPrice() + 0.5f;
    }
}

class DoubleTaco extends ToppingDecorator {
    Meal meal;
    Meal innerTaco;
    public DoubleTaco(Meal meal, Meal taco) {
        this.meal = meal;
        innerTaco = taco;
    }

    public String getName() {
        return (meal.getName() + "\n" + innerTaco.getName());
    }

    public float getPrice() {
        return meal.getPrice() + innerTaco.getPrice();
    }
}