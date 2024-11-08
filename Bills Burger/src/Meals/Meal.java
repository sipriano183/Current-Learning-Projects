package Meals;

import Utility.Utility;

import java.util.Scanner;

public class Meal {


    private Burger burger;
    private Drink drink;
    private Sides sides;
    private double finalPrice;

    Scanner scanner = new Scanner(System.in);
    Utility util = new Utility();

    // Creates a burger within the meal.
    public void createBurger() {
        System.out.print("Enter your burger type. We serve Full burgers or Smash burgers: ");
        String typeOption = scanner.nextLine();
        while (!typeOption.toLowerCase().contentEquals("smash") && !typeOption.toLowerCase().contentEquals("full") || !util.isNotNumber(typeOption)) {
            System.out.println("Invalid option. Please insert again: ");
            typeOption = scanner.nextLine();
        }
        System.out.println("Select your meat! ");
        util.displayMenu(Burger.validMeatTypes, Burger.meatPrices);
        System.out.print("Choice: ");
        String meat = scanner.nextLine();
        while (!util.isValidOption(meat, Burger.validMeatTypes )) {
            System.out.print("Invalid option. Please select again: ");
            meat = scanner.nextLine();
        }
        if (typeOption.equalsIgnoreCase("smash")) {
            System.out.println("Smash burgers are smaller (90g) and can only be made well done.");
            this.burger = new Smash(meat);
            System.out.println("Current burger price: $" + burger.calculatePrice());
        } else {
            System.out.println("Select your burger size! ");
            System.out.print("Choice: ");
            util.displayMenu(Burger.validSizes, Burger.sizePrices);
            String size = scanner.nextLine();
            while (!util.isValidOption(size + "g", Burger.validSizes)) {
                System.out.print("Invalid option. Please select again: ");
                size = scanner.nextLine();
            }
            System.out.print("Select how done your meat will be! ");
            Burger.displayDonenessOptions();
            String doneness = scanner.nextLine();
            while (!util.isValidOption(doneness, Burger.validDoneness)) {
                System.out.print("Invalid option. Please select again: ");
                doneness = scanner.nextLine();
            }
            this.burger = new Full(meat, size, doneness);
            System.out.println("Current burger price: $" + burger.calculatePrice());
        }
        burger.addToppings();
        System.out.println("Review your options:");
        System.out.printf("Meat -> %s%nSize -> %sg%nDoneness -> %s%n",
                burger.getSelectedMeat().substring(0,1).toUpperCase() + burger.getSelectedMeat().substring(1),
                burger.getSelectedSize(),
                burger.getSelectedDoneness().substring(0,1).toUpperCase() + burger.getSelectedDoneness().substring(1));
        burger.reviewToppings();
        System.out.println("Total burger price: $" + (burger.getPrice() + burger.toppings.getTotalPrice()));
    }

    public void createDrink() {
        System.out.print("We have Soft Drinks and we have Alcoholic Drinks, pick whichever you like: ");
        String typeOption = scanner.nextLine();
        while (!typeOption.toLowerCase().contentEquals("soft") && !typeOption.toLowerCase().contentEquals("alcoholic") || !util.isNotNumber(typeOption)) {
            System.out.println("Invalid option. Please insert again.");
            typeOption = scanner.nextLine();
        }
        if (typeOption.charAt(0) == 's' || typeOption.charAt(0) == 'S') {
            util.displayMenu(SoftDrink.validTypes, SoftDrink.typePrices);
            System.out.print("Select your soft drink: ");
            String softDrink = scanner.nextLine();
            while (!util.isValidOption(softDrink, SoftDrink.validTypes)) {
                System.out.print("Invalid option. Please select again: ");
                softDrink = scanner.nextLine();
            }
            System.out.print("Which size do you prefer? ");
            util.displayMenu(Drink.availableSizes, Drink.sizePrices);
            String drinkSize = scanner.nextLine();
            while (!util.isValidOption(drinkSize, Drink.availableSizes)) {
                System.out.print("Invalid option. Please select again: ");
                drinkSize = scanner.nextLine();
            }
            System.out.printf("Review your options: %nType ->%s%nSize ->%s.%n",
                    softDrink.substring(0,1).toUpperCase() + softDrink.substring(1),
                    drinkSize.substring(0,1).toUpperCase() + drinkSize.substring(1));
            this.drink = new SoftDrink(drinkSize, softDrink);
            System.out.println("Total drink price: $" + drink.getPrice());
        } else {
            util.displayMenu(AlcoholicDrink.availableBeers, AlcoholicDrink.beerPrices);
            System.out.print("Select your beer: ");
            String beer = scanner.nextLine();
            while (!util.isValidOption(beer, AlcoholicDrink.availableBeers)) {
                System.out.print("Invalid option. Please select again: ");
                beer = scanner.nextLine();
            }
            System.out.println("Beers are always served in pints.");
            System.out.printf("Review your options: %s.%n", beer.substring(0,1).toUpperCase() + beer.substring(1));
            this.drink = new AlcoholicDrink(beer);
            System.out.println("Total drink price: $" + drink.getPrice());
        }
    }

    public void createSide() {
        System.out.print("Pick a side dish to go with your burger! ");
        util.displayTypeOptions(Sides.availableOptions);
        String typeOption = scanner.nextLine();
        while (!util.isValidOption(typeOption, Sides.availableOptions)) {
            System.out.print("Invalid option. Please select again: ");
            typeOption = scanner.nextLine();
        }
        System.out.print("Select the size of your side! ");
        util.displayMenu(Sides.availableSizes, Sides.sizePrices);
        String sizeOption = scanner.nextLine();
        while (!util.isValidOption(sizeOption, Sides.availableSizes)) {
            System.out.print("Invalid option. Please select again: ");
            sizeOption = scanner.nextLine();
        }
        System.out.printf("Review your choice: %nSide option -> %s%nSize -> %s%n", typeOption.substring(0,1).toUpperCase() + typeOption.substring(1), sizeOption.substring(0,1).toUpperCase() + sizeOption.substring(1));
        this.sides = new Sides(sizeOption, typeOption);
        System.out.println("Total side price: $" + sides.getTotalPrice());
    }

    public String getFinalPrice() {
        return String.valueOf(burger.getPrice() + drink.getPrice() + sides.getTotalPrice());
    }

    public void reviewToppings() {
        switch (burger.toppings.getSelectedQuantity()) {
            case "1" -> System.out.println("Toppings -> " + burger.toppings.getSelectedTypeOne().substring(0,1).toUpperCase() + burger.toppings.getSelectedTypeOne().substring(1));
            case "2" -> {
                System.out.printf("Toppings -> %s, %s.%n",
                        burger.toppings.getSelectedTypeOne().substring(0,1).toUpperCase() + burger.toppings.getSelectedTypeOne().substring(1),
                        burger.toppings.getSelectedTypeTwo().substring(0,1).toUpperCase() + burger.toppings.getSelectedTypeTwo().substring(1));
            }
            case "3" -> {
                System.out.printf("Toppings -> %s, %s, %s.%n",
                        burger.toppings.getSelectedTypeOne().substring(0,1).toUpperCase() + burger.toppings.getSelectedTypeOne().substring(1),
                        burger.toppings.getSelectedTypeTwo().substring(0,1).toUpperCase() + burger.toppings.getSelectedTypeTwo().substring(1),
                        burger.toppings.getSelectedTypeThree().substring(0,1).toUpperCase() + burger.toppings.getSelectedTypeThree().substring(1));
            }
        }

    }

    @Override
    public String toString() {
        return burger.toString() + "\n" +
                drink.toString() + "\n" +
                sides.toString() + "\n" +
                "Total price -> " + "\n" +
                "$" + getFinalPrice();
    }
}
