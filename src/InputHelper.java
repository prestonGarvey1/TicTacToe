import java.util.Scanner;

public class InputHelper {

    //getNonZeroLenString method returns a string of non-zero length back to user
    public static String getNonZeroLenString(Scanner scan, String prompt) {
        boolean valid = false;
        String userInput;

        System.out.println(prompt);
        do {
            userInput = scan.nextLine();
            if (userInput.length() > 0) {
                valid = true;
            } else {
                System.out.println("Error - Must enter string of non-zero length");
            }
        } while (!valid);
        return userInput;
    }

    //The getInt method returns a valid int value back to the user
    public static int getInt(Scanner scan, String prompt) {
        boolean valid = false;
        int userInput = 0;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                userInput = scan.nextInt();
                valid = true;

            } else {
                System.out.println("Error - Must enter integer value");
                scan.nextLine();
            }
        } while (!valid);

        return userInput;
    }

    //Same thing as getInt but within a certain range of a minimum and maximum
    public static int getRangedInt(Scanner scan, String prompt, int min, int max) {
        boolean valid = false;
        int userInput = 0;

        System.out.println(prompt);
        do {

            if (scan.hasNextInt()) {
                userInput = scan.nextInt();
                if (userInput >= min && userInput <= max) {
                    valid = true;
                } else {
                    System.out.println("Error - Input must be between " + min + " and " + max);
                    scan.nextLine();
                }
            } else {
                System.out.println("Error - Must enter integer value");
                scan.nextLine();
            }

        } while (!valid);

        return userInput;
    }
    //The getDouble method returns a valid double value back to the user
    public static double getDouble(Scanner scan, String prompt) {
        boolean valid = false;
        double userInput = 0;

        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                userInput = scan.nextDouble();
                valid = true;

            } else {
                System.out.println("Error - Must enter double value");
                scan.nextLine();
            }
        } while (!valid);

        return userInput;
    }
    //Same thing as getDouble but within a certain range of a minimum and maximum
    public static double getRangedDouble(Scanner scan, String prompt, double min, double max) {
        boolean valid = false;
        double userInput = 0;

        System.out.println(prompt);
        do {

            if (scan.hasNextDouble()) {
                userInput = scan.nextDouble();
                if (userInput >= min && userInput <= max) {
                    valid = true;
                } else {
                    System.out.println("Error - Input must be between " + min + " and " + max);
                    scan.nextLine();
                }
            } else {
                System.out.println("Error - Must enter double value");
                scan.nextLine();
            }

        } while (!valid);

        return userInput;
    }
    // getPositiveNonZeroInt returns a non-zero integer value
    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        boolean valid = false;
        int userInput = 0;

        System.out.println(prompt);
        do {
            userInput = 0;
            if (scan.hasNextInt()) {
                userInput = scan.nextInt();
                if (userInput > -1) {
                    valid = true;
                } else {
                    System.out.println("Error - Must enter positive value");
                }
            } else {
                System.out.println("Error - Must enter integer value");
            }
        } while (!valid);

        return userInput;
    }
    // getYNConfirm returns a boolean and prompts the user to answer Y (yes) or N (no)
    public static boolean getYNConfirm(Scanner scan, String prompt){
        boolean valid = false;
        boolean YN = false;
        String userInput;

        System.out.println(prompt);
        do {

            if (scan.hasNextLine()) {
                userInput = scan.nextLine();
                if (userInput.equalsIgnoreCase("y")) {
                    valid = true;
                    YN = true;
                } else if (userInput.equalsIgnoreCase("n")) {
                    valid = true;
                    YN = false;
                } else {
                    System.out.println("Error - Must enter Y or N input");
                }
            } else {
                System.out.println("Error - Must enter String input");
            }

        } while (!valid);
        return YN;

    }

    public static String getRegExString(Scanner scan, String prompt, String regExPattern) {
        boolean valid = false;
        String userInput;

        System.out.println(prompt);
        do {
            userInput = scan.nextLine();
            if (userInput.matches(regExPattern)) {
                valid = true;
            } else {
                System.out.println("Error - Must match specified pattern");
            }

        } while (!valid);

        return userInput;
    }
}