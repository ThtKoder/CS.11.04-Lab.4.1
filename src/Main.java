import java.lang.module.FindException;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
       int firstCount = 0;
       int secondCount = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                firstCount++;
            }
            else if(str.charAt(i) == ')'){
                secondCount++;
            }
        }
        return firstCount == secondCount;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num){
        String number = String.valueOf(num);
        String finalReturn = "";
        for(int i = 0; i < number.length(); i++){
            char ch = number.charAt(i);
            finalReturn= ch+finalReturn;
        }
        return finalReturn;
    }

    public static String encryptThis(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String result = "";
        int start = 0;

        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                String word = input.substring(start, i);
                //this substring allows the final string to appear backwards (as it is the index after, then of the char)

                if (word.length() == 1) {
                    result += (int) word.charAt(0) + " ";
                    //if the string is only one char, simply return that char + space
                } else if (word.length() == 2) {
                    result += (int) word.charAt(0) + String.valueOf(word.charAt(1)) + " ";
                    //string is two chars similar to one char, but backwards
                } else {
                    result += (int) word.charAt(0) + String.valueOf(word.charAt(word.length() - 1))
                            + word.substring(2, word.length() - 1) + word.charAt(1) + " ";
                    //uses 'valueOf' to identify ascii values
                    //with the help of a source was able to find out how to arrange the terms in the right order
                    //using the 'word' substring
                }
                start = i + 1;
                //increments 'start' the first term in the substring to ensure backwards substring
            }
        }

        return result.trim();
        //is a cool new function that can help trim strings to a given length
    }


    // 4. decipherThis
    public static String decipherThis(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        //similar to encryptThis, first throwaway case

        String result = "";
        int start = 0;

        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                String word = input.substring(start, i);
                String first = "";
                int j = 0;

                for (int k = 0; k < word.length() && Character.isDigit(word.charAt(k)); k++) {
                    first += word.charAt(k);
                    j = k;
                }
                //removes the digit

                if (!first.isEmpty()) {
                    int asciiCode = Integer.parseInt(first);
                    //takes the ascii and turns back into a letter
                    String remainingChars = word.substring(j + 1);
                    //other chars that need to be 'parsed' or rearranged

                    if (remainingChars.length() <= 1) {
                        result += String.valueOf((char) asciiCode) + remainingChars + " ";
                        //a case where there is only one (or fewer) chars, but similar to the below function
                        //simply where the chars are basically mixed from back to front
                    } else {
                        result += String.valueOf((char) asciiCode) + remainingChars.charAt(remainingChars.length() - 1)
                                + remainingChars.substring(1, remainingChars.length() - 1) + remainingChars.charAt(0) + " ";
                        //similar to encrypt this, this else function passes the characters reversely
                    }
                }
                start = i + 1;
            }
        }

        return result.trim();
    }
}