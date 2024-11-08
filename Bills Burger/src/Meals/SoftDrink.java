package Meals;

import Utility.Utility;

public class SoftDrink extends Drink {

    Utility util = new Utility();

    static final String[] validTypes = {"Soda", "Juice", "Water"};
    static final double[] typePrices = {4.0, 4.5, 3.5};

    private String selectedType;
    private double price;

    public SoftDrink(String selectedSize, String selectedType) {
        super(selectedSize);
        if (util.isValidOption(selectedType, validTypes)) {
            this.selectedType = selectedType;
        }
    }

    @Override
    public double getPrice() {
        for (int i = 0; i < validTypes.length ; i++) {
            if (validTypes[i].equalsIgnoreCase(selectedType)) {
                this.price += typePrices[i];
            }
        }
        for (int i = 0; i < availableSizes.length; i++) {
            if (availableSizes[i].equalsIgnoreCase(selectedSize)) {
                this.price += sizePrices[i];
            }
        }
        return this.price;
    }

    @Override
    public String toString() {
        return "Selected drink -> " +
                selectedType +
                "Selected size -> " + "\n" +
                selectedSize;
    }
}
