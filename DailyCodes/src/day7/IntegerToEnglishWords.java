package day7;

import java.util.Stack;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int num = 12345;
        System.out.println(numberToWords(num));
        System.out.println(numberToWords1(num));
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] units = {
                "",        // 0
                "One",     // 1
                "Two",     // 2
                "Three",   // 3
                "Four",    // 4
                "Five",    // 5
                "Six",     // 6
                "Seven",   // 7
                "Eight",   // 8
                "Nine",    // 9
                "Ten",     // 10
                "Eleven",  // 11
                "Twelve",  // 12
                "Thirteen",// 13
                "Fourteen",// 14
                "Fifteen", // 15
                "Sixteen", // 16
                "Seventeen",// 17
                "Eighteen",// 18
                "Nineteen" // 19
        };
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] suffix = {"", "Thousand", "Million", "Billion"};

        Stack<String> stack = new Stack<>();

        int index = 0;
        while (num > 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                String chunkStr = chunkToWords(chunk, units, tens).trim();
                if (!chunkStr.isEmpty()) {
                    stack.push(chunkStr + " " + suffix[index]);
                }
            }
            num /= 1000;
            index++;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    private static String chunkToWords(int chunk, String[] units, String[] tens) {
        StringBuilder chunkResult = new StringBuilder();

        int hundred = chunk / 100;
        int ten = (chunk % 100) / 10;
        int unit = chunk % 10;

        if (hundred > 0) {
            chunkResult.append(units[hundred]).append(" Hundred ");
        }

        if (ten == 1) {
            chunkResult.append(units[ten * 10 + unit]).append(" ");
        } else {
            if (ten > 1) {
                chunkResult.append(tens[ten]).append(" ");
            }
            if (unit > 0) {
                chunkResult.append(units[unit]).append(" ");
            }
        }

        return chunkResult.toString();
    }

    public static String numberToWords2(int num) {
        if (num == 0) return "Zero";

        String[] units = {
                "",        // 0
                "One",     // 1
                "Two",     // 2
                "Three",   // 3
                "Four",    // 4
                "Five",    // 5
                "Six",     // 6
                "Seven",   // 7
                "Eight",   // 8
                "Nine",    // 9
                "Ten",     // 10
                "Eleven",  // 11
                "Twelve",  // 12
                "Thirteen",// 13
                "Fourteen",// 14
                "Fifteen", // 15
                "Sixteen", // 16
                "Seventeen",// 17
                "Eighteen",// 18
                "Nineteen" // 19
        };
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] hundreds = {"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
                "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
        String[] suffix = {"", "Thousand", "Million", "Billion"};

        Stack<String> stack = new Stack<>();

        int index = 0;
        while (num > 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                String chunkStr = chunkToWords(chunk, units, tens, hundreds).trim();
                if (!chunkStr.isEmpty()) {
                    stack.push(chunkStr + " " + suffix[index]);
                }
            }
            num /= 1000;
            index++;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    private static String chunkToWords(int chunk, String[] units, String[] tens, String[] hundreds) {
        StringBuilder chunkResult = new StringBuilder();

        int hundred = chunk / 100;
        int ten = (chunk % 100) / 10;
        int unit = chunk % 10;

        if (hundred > 0) {
            chunkResult.append(hundreds[hundred]).append(" ");
        }

        if (ten == 1) {
            chunkResult.append(units[ten * 10 + unit]).append(" ");
        } else {
            if (ten > 1) {
                chunkResult.append(tens[ten]).append(" ");
            }
            if (unit > 0) {
                chunkResult.append(units[unit]).append(" ");
            }
        }

        return chunkResult.toString().trim();
    }


    private static final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String numberToWords1(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private static String helper(int num) {
        String result = " ";
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
}
