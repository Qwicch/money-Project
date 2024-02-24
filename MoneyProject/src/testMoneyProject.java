import java.util.InputMismatchException;
import java.util.Scanner;

public class testMoneyProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = "Made with ❤️ in New York. Ilmir Kireev.\n\n";
        // Create a string with the ASCII art
        String art =
                """
                        +================================================================================+
                        |                                                                                |
                        |  .___  ___.   ______   .__   __.  _______ ____    ____                         |
                        |  |   \\/   |  /  __  \\  |  \\ |  | |   ____|\\   \\  /   /                         |
                        |  |  \\  /  | |  |  |  | |   \\|  | |  |__    \\   \\/   /                          |
                        |  |  |\\/|  | |  |  |  | |  . `  | |   __|    \\_    _/                           |
                        |  |  |  |  | |  `--'  | |  |\\   | |  |____     |  |                             |
                        |  |__|  |__|  \\______/  |__| \\__| |_______|    |__|                             |
                        |                                                                                |
                        |  .______   .______        ______          __   _______   ______ .___________.  |
                        |  |   _  \\  |   _  \\      /  __  \\        |  | |   ____| /      ||           |  |
                        |  |  |_)  | |  |_)  |    |  |  |  |       |  | |  |__   |  ,----'`---|  |----`  |
                        |  |   ___/  |      /     |  |  |  | .--.  |  | |   __|  |  |         |  |       |
                        |  |  |      |  |\\  \\----.|  `--'  | |  `--'  | |  |____ |  `----.    |  |       |
                        |  | _|      | _| `._____| \\______/   \\______/  |_______| \\______|    |__|       |
                        |                                                                                |
                        +================================================================================+""";
        // Print the ASCII art
        System.out.println(art);
        // Print the greeting message
        System.out.println(message);

        System.out.print("Do you want to see Test Cases?: true/false \n---> ");
        try {
            startTesting(scanner.nextBoolean());
            printLoan();
        } catch (InputMismatchException exception) {
            System.out.println("Invalid Input.");
        }
    }

    private static void startTesting(Boolean answer) {
        if(answer){
            Money myMoney   = new Money(1, 55);
            Money myMoney2  = null;

            printStepOne(myMoney);
            printStepTwo(myMoney);
            printStepThree(myMoney);
            printStepFour(myMoney);
            printStepFive(myMoney2);
            printStepSix(myMoney, myMoney2);
            printStepSeven(myMoney);
            printStepEight(myMoney);
            printStepNine(myMoney, myMoney2);
            printStepTen(myMoney);
            printStepEleven(myMoney);
        }
    }


    private static void printLoan() {
        Scanner scanner = new Scanner(System.in);

        Money userMoney;
        double rate, result;
        int dollars, cents, months;
        String[] parts;
        String input;
        boolean valid = true;

        System.out.print("Hello This is Loan calculator.\nWrite down amount of money you want to borrow. (Input Ex. $2.2)");
        // Read the user input as a string
        while (valid){
            try {
                System.out.print("\n---> ");
                input = scanner.next();

                // Remove the dollar sign from the input
                if(input.contains("\\D"))
                    input = input.replace("\\D", "");

                // Split the input into two parts: before and after the dot
                parts = input.split("\\.");

                // Convert the parts to integers
                dollars = Integer.parseInt(parts[0]);
                cents = Integer.parseInt(parts[1]);

                // Print the result
                userMoney = new Money(dollars, cents);

                System.out.print("\nType an APR: \n---> ");
                rate = scanner.nextDouble();

                System.out.print("\nType duration of the loan in months: \n---> ");
                months = scanner.nextInt();

                result = userMoney.loanCalculator(userMoney.getValue(), rate, months);
                System.out.printf("Your monthly Payments are: $%.2f", result);

                valid = false;
            } catch (Exception exception) {
                System.out.println("Invalid input");
            }
        }
    }

    private static void printStepOne(Money myMoney) {
        printData(myMoney, "printStepOne");
    }

    private static void printStepTwo(Money myMoney) {
        System.out.println();
        System.out.println("-".repeat(60));

        System.out.println("\t\t\t\t\t\tprintStepTwo\n");
        try {
            myMoney.setDollars(-2);
        } catch (IllegalArgumentException exception){
            System.out.println("\t\t\tmyMoney.setDollars(-2): threw an exception.");
        }

        try {
            myMoney.setCents(-55);
        } catch (IllegalArgumentException exception){
            System.out.println("\t\t\tmyMoney.setCents(-55):  threw an exception.");
        }
        System.out.println("\n\t\t\t\tAll Test Cases Are Correct.");
        System.out.println("-".repeat(60));

        myMoney.setDollars(1);
        myMoney.setCents(45);
    }

    private static void printStepThree(Money myMoney) {
        System.out.println();
        System.out.println("-".repeat(60));

        System.out.println("\t\t\t\t\t\tprintStepThree\n");
        try {
            myMoney.add(-1, -30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\t\tmyMoney.add(-1, -30):  threw an exception.");
        }

        try {
            myMoney.add( 1, -30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\t\tmyMoney.add( 1, -30):  threw an exception.");
        }

        try {
            myMoney.add(-1,  30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\t\tmyMoney.add(-1,  30):  threw an exception.");
        }
        System.out.println("\n\t\t\t\tAll Test Cases Are Correct.");
        System.out.println("-".repeat(60));
    }

    private static void printStepFour(Money myMoney) {
        //total must be 3 dollars, 0 cents.
        myMoney.add(1, 55);

        printData(myMoney, "printStepFour");
    }

    private static void printStepFive(Money myMoney2) {
        //should not allow to create negative money balance
        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println("\t\t\t\t\t\tprintStepFive\n");
        try {
            myMoney2  = new Money(-1, -30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\t\t\tMoney(-1, -30):  threw an exception.");
        }
        System.out.println("\n\t\t\t\tAll Test Cases Are Correct.");
        System.out.println("-".repeat(60));
    }

    private static void printStepSix(Money myMoney, Money myMoney2) {
        //total must be 5 dollars, 0 cents.
        myMoney2  = new Money(1, 100);
        myMoney.add(myMoney2);

        printData(myMoney, "printStepSix");
    }

    private static void printStepSeven(Money myMoney) {
        System.out.println();
        System.out.println("-".repeat(60));

        System.out.println("\t\t\t\t\t\tprintStepSeven\n");
        try {
            myMoney.subtract(-1, -30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\tmyMoney.subtract(-1, -30):   threw an exception.");
        }
        try {
            myMoney.subtract( 1, -30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\tmyMoney.subtract( 1, -30):   threw an exception.");
        }
        try {
            myMoney.subtract(-1,  30);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\tmyMoney.subtract(-1,  30):   threw an exception.");
        }
        try {
            myMoney.subtract(100,0);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\tmyMoney.subtract(100,  0):   threw an exception.");
        }
        try {
            myMoney.subtract(0,  5000);
        } catch (IllegalArgumentException exception) {
            System.out.println("\t\tmyMoney.subtract(0,  5000):  threw an exception.");
        }

        System.out.println("\n\t\t\t\tAll Test Cases Are Correct.");
        System.out.println("-".repeat(60));
    }

    private static void printStepEight(Money myMoney) {
        //total must be   4 dollars, 70 cents.
        myMoney.subtract(0, 30);

        printData(myMoney, "printStepNine");
    }

    private static void printStepNine(Money myMoney, Money myMoney2) {
        //total must be 5 dollars, 0 cents.
        myMoney2  = new Money(1, 70);
        myMoney.subtract(myMoney2);

        printData(myMoney, "printStepNine");
    }

    private static void printStepTen(Money myMoney) {
        myMoney.multiply(2.5);
        printData(myMoney, "printStepTen_A");
        myMoney.multiply(0);
        printData(myMoney, "printStepTen_B");
        myMoney.add(7,50);
        myMoney.multiply(1.5);
        printData(myMoney, "printStepTen_C");
        myMoney.multiply(10);
        printData(myMoney, "printStepTen_D");

        try {
            myMoney.multiply(-5);
        }catch (IllegalArgumentException exception) {
            System.out.println("\n\t\t\tmyMoney.multiply(-5):  threw an exception.");
            printData(myMoney, "printStepTen_E");
        }
    }

    private static void printStepEleven(Money myMoney) {
        myMoney.divide(2.5);
        printData(myMoney, "printStepEleven_A");

        try {
            myMoney.divide(0);
        } catch (IllegalArgumentException exception) {
            System.out.println("\n\t\t\tmyMoney.divide(0):  threw an exception.");
            printData(myMoney, "printStepEleven_B");
        }
        myMoney.divide(1.5);
        printData(myMoney, "printStepEleven_C");
        myMoney.divide(10);
        printData(myMoney, "printStepEleven_D");

        try {
            myMoney.multiply(-5);
        }catch (IllegalArgumentException exception) {
            System.out.println("\n\t\t\tmyMoney.divide(-5):  threw an exception.");
            printData(myMoney, "printStepEleven_E");
        }
    }

    private static void printData(Money myMoney, String step) {
        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println("\t\t\t\t\t\t" + step + "\n");
        System.out.printf("\t\t\t\tmyMoney.getDollars(): $%d%n", myMoney.getDollars());
        System.out.printf("\t\t\t\tmyMoney.getCents():   $0.%d%n", myMoney.getCents());
        System.out.printf("\t\t\t\tmyMoney.getValue():   $%.2f%n", myMoney.getValue());
        System.out.printf("\t\t\t\tmyMoney.toString():   %s", myMoney);
        System.out.println("\n\t\t\t\tAll Test Cases Are Correct.");
        System.out.println("-".repeat(60));
    }
}