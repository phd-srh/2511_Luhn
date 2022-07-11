package model;

import java.util.ArrayList;
import java.util.List;

public class Luhn {

    // kopiert aus:
    // https://de.wikipedia.org/wiki/Luhn-Algorithmus
    public static boolean check(int[] digits) {
        return getCheckingDigit(digits) % 10 == 0;
    }

    public static int getCheckingDigit(int[] digits) {
        int sum = 0;
        int length = digits.length;

        for (int i = 0; i < length; i++) {
            int digit = digits[length - i - 1];
            if (i % 2 == 1) {
                digit *= 2;
            }

            sum += (digit > 9) ? digit - 9 : digit;
        }

        return sum % 10;
    }

    public static boolean check(long number) {
        List<Integer> digitList = new ArrayList<>();
        while (number > 0) {
            digitList.add(0, (int)(number % 10));
            number /= 10;
        }

        int[] digits = new int[ digitList.size() ];
        for (int i=0; i<digitList.size(); i++)
            digits[i] = digitList.get(i);

        return check( digits );
    }

    public static boolean check(String number) {
        int[] digits = new int[ number.length() ];
        for (int i=0; i<number.length(); i++)
            digits[i] = number.charAt(i) - '0';
        return check( digits );
    }

    public static String generate(String nummer) {
        int length = nummer.length();
        int[] digits = new int[ length+1 ];
        for (int i=0; i<length; i++)
            digits[i] = nummer.charAt(i) - '0';
        digits[length] = 0;
        int checkDigit = (10 - getCheckingDigit(digits));
        if (checkDigit == 10) checkDigit = 0;
        return nummer + checkDigit;
    }

}
