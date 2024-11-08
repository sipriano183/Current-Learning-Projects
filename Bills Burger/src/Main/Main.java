package Main;

import Meals.Meal;
import Utility.Utility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utility util = new Utility();
        Scanner scanner = new Scanner(System.in);
        util.clearScreen();
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("Welcome to Bill's Burger joint!");
            System.out.println("Please place your order!");
            Meal meal = new Meal();
            meal.createBurger();
            System.out.println("------------------------------------------");
            meal.createDrink();
            System.out.println("------------------------------------------");
            meal.createSide();
            System.out.println("------------------------------------------");
            util.clearScreen();
            meal.reviewToppings();
            System.out.println(meal);
            System.out.println("Please press enter to issue a new order.");
            scanner.nextLine();
        }
    }
}
