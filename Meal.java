public abstract class Meal {
    String name = "Default Meal";
    float price = 0.0f;

    public void printMeal() {
        System.out.println(getName() + "\nPrice: $" + getPrice());
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}