package Utility;

// I wanted to stash all the checkers that I created in a separate class, to import accordingly
public class Utility {

    // Same thing but for Strings, I could not manage to use Object as a generic type to not re-write code
    public boolean isValidOption(String option, String[] optionsArray) {
        for (String validOption : optionsArray) {
            if (validOption.equalsIgnoreCase(option)) {
                return true;
            }
        }
        return false;

    }

    public void displayMenu(String[] items, double[] prices) {
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%s -> $%.2f%n", items[i], prices[i]);
        }
    }


// Since we will be selecting sizes on sides, drinks and burgers, I wanted to re-use this logic here
    public void displaySizeOptions(String[] validSizes) {
        System.out.print("Available size options: ");
        for (int i = 0; i < validSizes.length; i++) {
            if (i == validSizes.length -1 ) {
                System.out.printf("%s.%n", validSizes[i]);
            } else {
                System.out.printf("%s, ", validSizes[i]);
            }
        }
    }

    public void displayTypeOptions(Object[] validOptions) {
        System.out.print("Available options: ");
        for (int i = 0; i < validOptions.length; i++) {
            if (i == validOptions.length -1 ) {
                System.out.printf("%s.%n", validOptions[i]);
            } else {
                System.out.printf("%s, ", validOptions[i]);
            }
        }
    }

    public boolean isNotNumber (String value) {
        try {
            Double.parseDouble(value);
            Integer.parseInt(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // For UNIX-based systems
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the screen.");
        }
    }

}
