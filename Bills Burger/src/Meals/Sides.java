package Meals;

import Utility.Utility;

public class Sides {

    Utility util = new Utility();

    static final String[] availableSizes = {"Small", "Medium", "Large"};
    static final double[] sizePrices = {4.0, 6.0, 8.0};
    static final String[] availableOptions = {"French Fries", "Onion Rings", "Chicken Nuggets"};

    private double price;
    private String selectedSize;
    private String selectedOption;

    public Sides(String selectedSize, String selectedOption) {
        if (util.isValidOption(selectedSize, availableSizes)) {
            this.selectedSize = selectedSize;
        }
        if (util.isValidOption(selectedOption, availableOptions)) {
            this.selectedOption = selectedOption;
        }
        price = 0.0;
    }

    public double getTotalPrice() {
        switch (selectedSize) {
            case "Small", "small" -> price = 4.0;
            case "Medium", "medium" -> price = 6.0;
            case "Large", "large" -> price = 8.0;
            default -> {
                return 0.0;
            }
        }
        return price;
    }

    @Override
    public String toString() {
        return "Selected side dish -> " +
                selectedOption + "\n" +
                "Size -> " +
                selectedSize;
    }
}
