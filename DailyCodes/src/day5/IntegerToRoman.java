package day5;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < values.length; i++){
            while(num >= values[i]){
                sb.append(strs[i]);
                num -= values[i];
            }
        }
        return sb.toString();

    }

    public String intToRoman1(int num) {
        String Thouzand[] = {"", "M", "MM", "MMM"};
        String Hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String Ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String One[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return Thouzand[num /1000] + Hundred[(num%1000)/100] + Ten[(num % 100)/10] + One[num % 10];
    }
}
