package day7;

public class ValidNumber {
    public static void main(String[] args) {
        String s = "1E9";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if(Character.toLowerCase(s.charAt(i)) == 'e') {
                if(eSeen || !numberSeen)
                    return false;
                numberSeen = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && Character.toLowerCase(s.charAt(i-1)) != 'e')
                    return false;
            } else
                return false;
        }
        return numberSeen;
    }
}
