package Meals;

import Utility.Utility;

import java.util.Scanner;

class Burger {

    Utility util = new Utility();
    Scanner scanner = new Scanner(System.in);

    // These arrays are just to store the valid values for the fields that will be passed in the constructor
    final static String[] validMeatTypes = {"Short Rib", "Chuck", "Chicken", "Veg"};
    final static double[] meatPrices = {12.00, 10.00, 8.00, 11.00};
    final static String[] validSizes = {"160g", "200g"};
    final static double[] sizePrices = {1.00, 2.50};
    final static String[] validDoneness = {"Rare", "Medium", "Well Done"};


    String selectedMeat;
    double price;
    String selectedSize;
    String selectedDoneness;
    Toppings toppings;

    // Constructor uses the isValidOption to validate if the valued passed when instantiating the object.
    public Burger(String selectedMeat, String selectedSize, String selectedDoneness) {
        this.price = 0.0;
        if (util.isValidOption(selectedMeat, validMeatTypes)) {
            this.selectedMeat = selectedMeat;
        }
        if (util.isValidOption(selectedSize + "g", validSizes) || selectedSize.equals("90")) {
            this.selectedSize = selectedSize;
        }
        if (util.isValidOption(selectedDoneness, validDoneness)) {
            this.selectedDoneness = selectedDoneness;
        }
    }

    public String getSelectedMeat() {
        return selectedMeat;
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public String getSelectedDoneness() {
        return selectedDoneness;
    }

    public double getPrice() {
        return price + toppings.getTotalPrice();
    }

    public double calculatePrice() {
        for (int i = 0; i < validMeatTypes.length ; i++) {
            if (validMeatTypes[i].equalsIgnoreCase(selectedMeat)) {
                this.price += meatPrices[i];
            }
        }
        for (int i = 0; i < validSizes.length ; i++) {
            if (validSizes[i].equalsIgnoreCase(selectedSize + "g")) {
                this.price += sizePrices[i];
            }
        }
        return this.price;
    }

    public static void displayDonenessOptions() {
        System.out.print("Available doneness options: ");
        for (int i = 0; i < validDoneness.length; i++) {
            if (i == validDoneness.length -1 ) {
                System.out.printf("%s.%n", validDoneness[i]);
            } else {
                System.out.printf("%s, ", validDoneness[i]);
            }
        }
    }

    public void addToppings () {
        System.out.print("You can select up to three toppings! Each topping costs $2.00: ");
        String selectedQuantity = scanner.nextLine();
        while (!util.isValidOption(selectedQuantity, Toppings.availableQuantity)) {
            System.out.print("Invalid option. Please select again: ");
            selectedQuantity = scanner.nextLine();
        }
        util.displayTypeOptions(Toppings.availableTypes);
        switch (selectedQuantity) {
            case "1" -> {
                System.out.print("Select your topping: ");
                String option = scanner.nextLine();
                while (!util.isValidOption(option, Toppings.availableTypes)) {
                    System.out.print("Invalid option. Please select again: ");
                    option = scanner.nextLine();
                }
                this.toppings = new Toppings(selectedQuantity, option);
            }
            case "2" -> {
                System.out.print("Select your first option: ");
                String optionOne = scanner.nextLine();
                while (!util.isValidOption(optionOne, Toppings.availableTypes)) {
                    System.out.print("Invalid option. Please select again: ");
                    optionOne = scanner.nextLine();
                }
                System.out.print("Select your second option: ");
                String optionTwo = scanner.nextLine();
                while (!util.isValidOption(optionTwo, Toppings.availableTypes)) {
                    System.out.print("Invalid option. Please select again: ");
                    optionTwo = scanner.nextLine();
                }
                this.toppings = new Toppings(selectedQuantity, optionOne, optionTwo);
            }
            case "3" -> {
                System.out.print("Select your first option: ");
                String optionOne = scanner.nextLine();
                while (!util.isValidOption(optionOne, Toppings.availableTypes)) {
                    System.out.print("Invalid option. Please select again: ");
                    optionOne = scanner.nextLine();
                }
                System.out.print("Select your second option: ");
                String optionTwo = scanner.nextLine();
                while (!util.isValidOption(optionTwo, Toppings.availableTypes)) {
                    System.out.print("Invalid option. Please select again: ");
                    optionTwo = scanner.nextLine();
                }
                System.out.print("Select your third option: ");
                String optionThree = scanner.nextLine();
                while (!util.isValidOption(optionThree, Toppings.availableTypes)) {
                    System.out.print("Invalid option. Please select again: ");
                    optionThree = scanner.nextLine();
                }
                this.toppings = new Toppings(selectedQuantity, optionOne, optionTwo, optionThree);
            }
        }
    }

    void reviewToppings() {
        switch (toppings.getSelectedQuantity()) {
            case "1" -> System.out.println("Toppings -> " + toppings.getSelectedTypeOne().substring(0,1).toUpperCase() + toppings.getSelectedTypeOne().substring(1));
            case "2" -> {
                System.out.printf("Toppings -> %s, %s.%n",
                        toppings.getSelectedTypeOne().substring(0,1).toUpperCase() + toppings.getSelectedTypeOne().substring(1),
                        toppings.getSelectedTypeTwo().substring(0,1).toUpperCase() + toppings.getSelectedTypeTwo().substring(1));
            }
            case "3" -> {
                System.out.printf("Toppings -> %s, %s, %s.%n",
                        toppings.getSelectedTypeOne().substring(0,1).toUpperCase() + toppings.getSelectedTypeOne().substring(1),
                        toppings.getSelectedTypeTwo().substring(0,1).toUpperCase() + toppings.getSelectedTypeTwo().substring(1),
                        toppings.getSelectedTypeThree().substring(0,1).toUpperCase() + toppings.getSelectedTypeThree().substring(1));
            }
        }

    }

    @Override
    public String toString() {
        return "Your burger -> " +
                "Meat -> " + selectedMeat + "\n" +
                "Size -> " + selectedSize + "\n" +
                "Doneness -> " + selectedDoneness + "\n";
    }
}
