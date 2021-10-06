package vsu.sokolov_aa;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int index = readIntFromConsole("Write index of monotone number:");

        System.out.println("\n\nNumber is " + findMonotoneNumberWithNumberN(index));
    }

    public static boolean isNumberDigitsMonotone(int number) {
        int temp = number;

        if(number < 100) {
            return true;
        }

        /*
         * -1 if right digit is less than left one
         * 1 if right digit is bigger than left one
         * 0 if right digit equals left one
         */
        int isIncreases;
        int isPreviousPairIncreasing;

        isPreviousPairIncreasing = isRightPairIncreases(number);

        while (number > 10) {
            isIncreases = isRightPairIncreases(number);
            number =number / 10;

            if(isPreviousPairIncreasing + isIncreases == 0 && isIncreases != 0) {
                return false;

            }
        }

        System.out.println(temp +"\n\n");

        return true;
    }


    /**
     * @return -1 if right digit is less than left one
     * @return 1 if right digit is bigger than left one
     * @return 0 if right digit equals left one
     */
    public static int isRightPairIncreases(int number) {
        int rightDigit = number % 10;
        number =number / 10;
        int leftDigit = number % 10;


        if (rightDigit > leftDigit) {
            return 1;
        } else if (rightDigit < leftDigit) {
            return -1;
        } else {
            return 0;
        }
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
