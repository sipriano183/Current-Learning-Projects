package Meals;

import Utility.Utility;

public class AlcoholicDrink extends Drink {

    Utility util = new Utility();

    static final String[] availableBeers = {"Lager", "Stout", "Porter"};
    static final double[] beerPrices = {6.0, 8.0, 10.0};

    private String selectedBeer;
    private double price;

// Beers always come in pints. A separate size from "Medium" in normal Drink
    public AlcoholicDrink(String selectedBeer) {
        if (util.isValidOption(selectedBeer, availableBeers)) {
            this.selectedBeer = selectedBeer;
            price = 0.0;
        }
    }

    @Override
    public double getPrice() {
        for (int i = 0; i < availableBeers.length ; i++) {
            if (availableBeers[i].equalsIgnoreCase(selectedBeer)) {
                this.price += beerPrices[i];
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
                selectedBeer;
    }
}
