import java.util.List;
import java.util.ArrayList;

public class Order extends Meal {
    private String name = "";
    private float total = 0.0f;
    private List<Meal> order = new ArrayList<Meal>();

    @Override
    public void printMeal() {
        if(name != "") {
            System.out.println(name);
        }

        for(Meal meal:order) {
            meal.printMeal();
        }
    }

    public float getTotal() { //This isn't working and I have absolutely no idea why
        for(Meal meal:order) {
            total += meal.getPrice();
        }
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMeal(Meal meal) {
        order.add(meal);
    }

    public void removeMeal(Meal meal) {
        order.remove(meal);
    }
}
