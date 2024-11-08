package Meals;

import Utility.Utility;

public class Drink {

    Utility util = new Utility();

    final static String[] availableSizes = {"Small", "Medium", "Large"};
    final static double[] sizePrices = {0.0, 2.0, 3.0};

    String selectedSize;
    private double price;

    public Drink(String selectedSize) {
        if (util.isValidOption(selectedSize, availableSizes)) {
            this.selectedSize = selectedSize;
        }
    }


    public Drink() {

    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "util=" + util +
                ", selectedSize='" + selectedSize + '\'' +
                ", price=" + price +
                '}';
    }
}
