package Meals;

import Utility.Utility;
public class Toppings {

    Utility util = new Utility();

    static final String[] availableTypes = {"Onions", "Bacon", "Cheese", "Lettuce", "Pickles"};
    static final String[] availableQuantity = {"1", "2", "3", "5"};

    private double price;
    private String selectedQuantity;
    private String selectedTypeOne;
    private String selectedTypeTwo;
    private String selectedTypeThree;
    private String selectedTypeFour;
    private String selectedTypeFive;

    public Toppings(String selectedQuantity, String selectedTypeOne) { // Called by selecting 1 topping when building burger
        if(util.isValidOption(selectedQuantity, availableQuantity)) {
            this.selectedQuantity = selectedQuantity;
        }
        if(util.isValidOption(selectedTypeOne, availableTypes)) {
            this.selectedTypeOne = selectedTypeOne;
        }
        this.selectedTypeTwo = "";
        this.selectedTypeThree = "";
    }

    public Toppings(String selectedQuantity, String selectedTypeOne, String selectedTypeTwo) { // Called by selecting 2 toppings
        if(util.isValidOption(selectedQuantity, availableQuantity)) {
            this.selectedQuantity = selectedQuantity;
        }
        if(util.isValidOption(selectedTypeOne, availableTypes)) {
            this.selectedTypeOne = selectedTypeOne;
        }
        if(util.isValidOption(selectedTypeTwo, availableTypes)) {
            this.selectedTypeTwo = selectedTypeTwo;
        }
        this.selectedTypeThree = "";
    }

    public Toppings(String selectedQuantity, String selectedTypeOne, String selectedTypeTwo, String selectedTypeThree) { // 3 toppings
        if(util.isValidOption(selectedQuantity, availableQuantity)) {
            this.selectedQuantity = selectedQuantity;
        }
        if(util.isValidOption(selectedTypeOne, availableTypes)) {
            this.selectedTypeOne = selectedTypeOne;
        }
        if(util.isValidOption(selectedTypeTwo, availableTypes)) {
            this.selectedTypeTwo = selectedTypeTwo;
        }
        if(util.isValidOption(selectedTypeThree, availableTypes)) {
            this.selectedTypeThree = selectedTypeThree;
        }
    }

// Called only with Deluxe Burger, includes all toppings
    public Toppings() {
        this.selectedQuantity = "5";
        this.selectedTypeOne = "Onions";
        this.selectedTypeTwo = "Bacon";
        this.selectedTypeThree = "Cheese";
        this.selectedTypeFour = "Lettuce";
        this.selectedTypeFive = "Pickles";
    }

    public String getSelectedQuantity() {
        return selectedQuantity;
    }

    public String getSelectedTypeOne() {
        return selectedTypeOne;
    }

    public String getSelectedTypeTwo() {
        return selectedTypeTwo;
    }

    public String getSelectedTypeThree() {
        return selectedTypeThree;
    }

    public String getSelectedTypeFour() {
        return selectedTypeFour;
    }

    public String getSelectedTypeFive() {
        return selectedTypeFive;
    }

    public double getTotalPrice() {
        switch(selectedQuantity) {
            case "1" -> price = 2.0;
            case "2" -> price = 4.0;
            case "3" -> price = 6.0;
            case "5" -> price = 10;
            default -> price = 0;
        }
        return price;
    }

    public String getToppings() {
        double quantity = Double.parseDouble(selectedQuantity);
        for (int i = 0; i < quantity; i++) {
            if (availableTypes[i].equals(selectedTypeOne) || (availableTypes[i].equals(selectedTypeTwo) || (availableTypes[i].equals(selectedTypeThree)))) {
                return ", " + availableTypes[i];
            }
        }
        return "";
    }
}
