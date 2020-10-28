import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Scanner;

public class MenuController {
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        System.out.println("Welcome to MasterMenu! What would you like to do?");
        while(true) {
            System.out.println("1) Walk up to Taco Stand");
            System.out.println("2) Leave");

            try {
                choice = scnr.nextInt();
            } catch (Exception e) {
                System.err.println("That's not a valid choice!");
                scnr.nextLine();
                continue;
            }

            switch (choice) {
                case 2:
                    System.out.println("Thanks for coming!");
                    return;
                case 1:
                    Order total = OrderMenu();
                    System.out.println("");
                    total.printMeal();
                    System.out.println("");
                    System.out.println("Total price: $" + total.getTotal());
                    break;
                default:
                    System.err.println("That's not a valid choice!");
                    continue;
            }
        }
    }

    public static Order OrderMenu() {
        int choice2;
        Order totalOrder = new Order();
        totalOrder.setName("Total Order: ");
        while (true) {
            totalOrder.printMeal();
            System.out.println("\nWhat would you like to order?");
            System.out.println("1) Taco");
            System.out.println("2) Burrito");
            System.out.println("3) Bowl");
            System.out.println("4) Taco Salad");
            System.out.println("5) Double-Decker Taco");
            System.out.println("6) Order of Tacos (3 Tacos)");
            System.out.println("7) Traveler's Pack (2 Individual Tacos + 1 Burrito)");
            System.out.println("8) Sampler Pack (1 Taco + 1 Burrito + 1 Bowl)");
            System.out.println("9) Party Platter (3 Orders of Tacos + 2 Burritos + 1 Bowl)");
            System.out.println("0) I'm done!");

            try {
                choice2 = scnr.nextInt();
            } catch (Exception e) {
                System.err.println("That's not a valid choice!");
                scnr.nextLine();
                continue;
            }

            if(choice2 < 0 || choice2 > 9) {
                System.err.println("That's not a valid choice!");
                continue;
            } else if (choice2 == 0) {
                break;
            }

            totalOrder.addMeal(orderController(choice2));
        }
        return totalOrder;
    }

    public static Order orderController(int choice) {
        Order newMeal = new Order();
        switch(choice) {
            case 1:
                Meal taco = new Taco();
                taco = proteinController(taco);
                taco = toppingController(taco);
                taco = sauceController(taco);
                newMeal.addMeal(taco);
                break;
            case 2:
                Meal burrito = new Burrito();
                burrito = proteinController(burrito);
                burrito = toppingController(burrito);
                burrito = sauceController(burrito);
                newMeal.addMeal(burrito);
                break;
            case 3:
                Meal bowl = new Bowl();
                bowl = proteinController(bowl);
                bowl = toppingController(bowl);
                bowl = sauceController(bowl);
                newMeal.addMeal(bowl);
                break;
            case 4:
                Meal tacoSalad = new Bowl();
                tacoSalad = new TacoShell(new TacoShell(new TacoShell(tacoSalad)));
                tacoSalad = proteinController(tacoSalad);
                tacoSalad = toppingController(tacoSalad);
                tacoSalad = sauceController(tacoSalad);
                newMeal.addMeal(tacoSalad);
                break;
            case 5:
                Meal doubleDecker = new Taco("Outer Taco");
                doubleDecker = proteinController(doubleDecker);
                doubleDecker = toppingController(doubleDecker);
                doubleDecker = sauceController(doubleDecker);

                Meal innerTaco = new Taco("Inner Taco");
                innerTaco = proteinController(innerTaco);
                innerTaco = toppingController(innerTaco);
                innerTaco = sauceController(innerTaco);

                doubleDecker = new DoubleTaco(doubleDecker, innerTaco);
                newMeal.addMeal(doubleDecker);
                break;
            case 6:
                newMeal.addMeal(orderOfTacos(new Taco(), new Taco(), new Taco()));
                break;
            case 7:
                newMeal.setName("Traveler's Pack");
                Meal travTaco1 = new Taco();
                travTaco1 = proteinController(travTaco1);
                travTaco1 = toppingController(travTaco1);
                travTaco1 = sauceController(travTaco1);
                newMeal.addMeal(travTaco1);

                Meal travTaco2 = new Taco();
                travTaco2 = proteinController(travTaco2);
                travTaco2 = toppingController(travTaco2);
                travTaco2 = sauceController(travTaco2);
                newMeal.addMeal(travTaco2);

                Meal travBurrito = new Burrito();
                travBurrito = proteinController(travBurrito);
                travBurrito = toppingController(travBurrito);
                travBurrito = sauceController(travBurrito);
                newMeal.addMeal(travBurrito);
                break;
            case 8:
                newMeal.setName("Sampler Pack");
                Meal sampTaco = new Taco();
                sampTaco = proteinController(sampTaco);
                sampTaco = toppingController(sampTaco);
                sampTaco = sauceController(sampTaco);
                newMeal.addMeal(sampTaco);

                Meal sampBurrito = new Burrito();
                sampBurrito = proteinController(sampBurrito);
                sampBurrito = toppingController(sampBurrito);
                sampBurrito = sauceController(sampBurrito);
                newMeal.addMeal(sampBurrito);

                Meal sampBowl = new Bowl();
                sampBowl = proteinController(sampBowl);
                sampBowl = toppingController(sampBowl);
                sampBowl = sauceController(sampBowl);
                newMeal.addMeal(sampBowl);
                break;
            case 9:
                newMeal.setName("Party Platter");
                newMeal.addMeal(orderOfTacos(new Taco(), new Taco(), new Taco()));
                newMeal.addMeal(orderOfTacos(new Taco(), new Taco(), new Taco()));
                newMeal.addMeal(orderOfTacos(new Taco(), new Taco(), new Taco()));

                Meal partyBurrito1 = new Burrito();
                partyBurrito1 = proteinController(partyBurrito1);
                partyBurrito1 = toppingController(partyBurrito1);
                partyBurrito1 = sauceController(partyBurrito1);
                newMeal.addMeal(partyBurrito1);

                Meal partyBurrito2 = new Burrito();
                partyBurrito2 = proteinController(partyBurrito2);
                partyBurrito2 = toppingController(partyBurrito2);
                partyBurrito2 = sauceController(partyBurrito2);
                newMeal.addMeal(partyBurrito2);

                Meal partyBowl = new Bowl();
                partyBowl = proteinController(partyBowl);
                partyBowl = toppingController(partyBowl);
                partyBowl = sauceController(partyBowl);
                newMeal.addMeal(partyBowl);
                break;
            default:
                System.err.println("That's not a valid choice!");
                break;
        }

        return newMeal;
    }

    public static Meal proteinController(Meal meal) {
        int proteinChoice;
        Meal protein = meal;
        while(true) {
            System.out.println("Any proteins for your " + protein.getName());
            System.out.println("0) No Thanks");
            System.out.println("1) Steak");
            System.out.println("2) Chicken");
            System.out.println("3) Beans");

            try {
                proteinChoice = scnr.nextInt();
            } catch (Exception e) {
                System.err.println("That's not a valid choice!");
                scnr.nextLine();
                continue;
            }

            if(proteinChoice < 0 || proteinChoice > 3) {
                System.err.println("That's not a valid choice!");
                continue;
            }

            switch(proteinChoice) {
                case 0:
                    return protein;
                case 1:
                    protein = new Steak(protein);
                    break;
                case 2:
                    protein = new Chicken(protein);
                    break;
                case 3:
                    protein = new Beans(protein);
                    break;
                default:
                    System.err.println("That's not a valid choice!");
                    break;
            }
        }
    }

    public static Meal toppingController(Meal meal) {
        int toppingChoice;
        Meal topping = meal;
        while(true) {
            System.out.println("Any toppings for your " + topping.getName());
            System.out.println("0) No Thanks");
            System.out.println("1) Lettuce");
            System.out.println("2) Pico de Gallo");
            System.out.println("3) Sour Cream");
            System.out.println("4) Rice");
            System.out.println("5) Cheese");

            try {
                toppingChoice = scnr.nextInt();
            } catch (Exception e) {
                System.err.println("That's not a valid choice!");
                scnr.nextLine();
                continue;
            }

            if(toppingChoice < 0 || toppingChoice > 5) {
                System.err.println("That's not a valid choice!");
                continue;
            }

            switch(toppingChoice) {
                case 0:
                    return topping;
                case 1:
                    topping = new Lettuce(topping);
                    break;
                case 2:
                    topping = new Pico(topping);
                    break;
                case 3:
                    topping = new SourCream(topping);
                    break;
                case 4:
                    topping = new Rice(topping);
                    break;
                case 5:
                    topping = new Cheese(topping);
                    break;
                default:
                    System.err.println("That's not a valid choice!");
                    break;
            }
        }
    }

    public static Meal sauceController(Meal meal) {
        int sauceChoice;
        Meal sauce = meal;
        while(true) {
            System.out.println("Any sauces for your " + sauce.getName());
            System.out.println("0) No Thanks");
            System.out.println("1) Mild");
            System.out.println("2) Medium");
            System.out.println("3) Hot");

            try {
                sauceChoice = scnr.nextInt();
            } catch (Exception e) {
                System.err.println("That's not a valid choice!");
                scnr.nextLine();
                continue;
            }

            if (sauceChoice < 0 || sauceChoice > 3) {
                System.err.println("That's not a valid choice!");
                continue;
            }

            switch (sauceChoice) {
                case 0:
                    return sauce;
                case 1:
                    sauce = new Mild(sauce);
                    break;
                case 2:
                    sauce = new Medium(sauce);
                    break;
                case 3:
                    sauce = new Hot(sauce);
                    break;
                default:
                    System.err.println("That's not a valid choice!");
                    break;
            }
        }
    }

    public static Order orderOfTacos(Meal taco1, Meal taco2, Meal taco3) {
        Order tacos = new Order();
        tacos.setName("Order of Tacos");
        Meal t1 = taco1;
        Meal t2 = taco2;
        Meal t3 = taco3;

        t1 = proteinController(t1);
        t1 = toppingController(t1);
        t1 = sauceController(t1);

        t2 = proteinController(t2);
        t2 = toppingController(t2);
        t2 = sauceController(t2);

        t3 = proteinController(t3);
        t3 = toppingController(t3);
        t3 = sauceController(t3);

        tacos.addMeal(t1);
        tacos.addMeal(t2);
        tacos.addMeal(t3);

        return tacos;
    }
}
