package vsu.sokolov_aa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int index = readIntFromConsole("Write index of monotone number:");

        System.out.println("\n\nNumber is " + findMonotoneNumberWithNumberN(index));

    }

    public static boolean isNumberDigitsMonotone(int number) {
        if(number < 100) {
            return true;
        }

        /*
         * -1 if right digit is less than left one
         * 1 if right digit is bigger than left one
         * 0 if right digit equals left one
         */
        int isIncreases;
        int check = 0;
        boolean isDefined = false;

        while (number > 9) {
            isIncreases = isRightPairIncreases(number);
            number = number / 10;

            if(isIncreases != 0 && !isDefined) {
                check = isIncreases;
                isDefined = true;
            }
            if(check != isIncreases && isIncreases != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return -1 if right digit is less than left one
     *  1 if right digit is bigger than left one
     *  0 if right digit equals left one
     */
    public static int isRightPairIncreases(int number) {
        int rightDigit = number % 10;
        number =number / 10;
        int leftDigit = number % 10;

        return Integer.compare(rightDigit, leftDigit);
    }

    public static int findMonotoneNumberWithNumberN(int n) {
        int counter = 0;
        int number = 0;

        while (counter <= n) {
            if(isNumberDigitsMonotone(number)) {
                counter++;
            }
            number++;
        }

        return  number;
    }

    public static int readIntFromConsole(String message) {
        Scanner in = new Scanner(System.in);

        System.out.print("\n" + message + "   ");
        return in.nextInt();
    }

}
