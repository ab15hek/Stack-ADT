package languageRecognizer;

public class recognizer {

    static String recognizeLanguage(String inputString) {
        char[] stack = new char[inputString.length()];
        int top = -1; // Initialize the top of the stack to -1

        for (char c : inputString.toCharArray()) {
            if (c == '0') {
                top++;
                stack[top] = '0'; // Push '0' onto the stack
            } else if (c == '1') {
                if (top >= 0 && stack[top] == '0') {
                    top--; // Pop '0' from the stack
                } else {
                    return "No";  // Unrecognized string
                }
            } else {
                return "No";  // Unrecognized character
            }
        }

        if (top == -1) {
            return "Yes";  // String belongs to the language
        } else {
            return "No";   // Unrecognized string
        }
    }
    public static void main(String[] args) {
        // Test cases for recognizing strings in the language L = {0^n 1^n : where n ≥ 1}
        String[] testCases = {
            "1110000"
        };

        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            String result = recognizeLanguage(testCase);
            System.out.println("Result: " + result);
            System.out.println();
        }
    }
}