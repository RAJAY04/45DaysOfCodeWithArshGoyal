package day12;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        int l1 = a.length() - 1, l2 = b.length() - 1;
        int carry = 0;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 && l2 >= 0) {
            int sum = (arr1[l1--] - '0') + (arr2[l2--] - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        while (l1 >= 0) {
            int sum = (arr1[l1--] - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        while (l2 >= 0) {
            int sum = (arr2[l2--] - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
