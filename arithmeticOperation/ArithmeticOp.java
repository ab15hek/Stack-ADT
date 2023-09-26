package arithmeticOperation;

public class ArithmeticOp {

    //initialized an array 
    static char[] operationStack = new char[10];

        // checking to see that 
    static boolean containsBrackets(char[] expressionChars) {
        for (char c : expressionChars) {
            if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
                return true;
            }
        }
        return false;
    }

    // checking if open bracket
    static boolean isOpenBracket(char character) {
        return (character == '(' || character == '[' || character == '{');
    }

    // checking if close bracket
    static boolean isCloseBracket(char character) {
        return (character == ')' || character == ']' || character == '}');
    } 
    
     // check if allowed
    static boolean isValidCharacter(char character) {
        return (Character.isDigit(character) ||
                character == '+' || character == '-' || character == '*' || character == '/' ||
                character == '(' || character == ')' || character == '[' || character == ']' ||
                character == '{' || character == '}');
    }
    // Function to check if open/close brackets are in order
    static boolean areBracketsMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
    // validation code
    static boolean validateor(String expression) {
        //stack to keep track of brackets. 
        operationStack = new char[expression.length()];
        char[] expressionChars = expression.toCharArray(); // need to convert the input string to an array of characters

        // if there are no brackets we are returning false 
        if (!containsBrackets(expressionChars)) {
            return false;
        }

        for (int i = 0; i < expressionChars.length; i++) {
            char currentChar = expressionChars[i];

            // Check if the current character is one of the allowed characters
            if (!isValidCharacter(currentChar)) {
                throw new RuntimeException("Invalid character found: " + currentChar);
            }

            // If it's an opening bracket, push it onto the stack
            if (isOpenBracket(currentChar)) {
                push(currentChar);
            } 
            // If it's a closing bracket, check for a matching opening bracket on the stack
            else if (isCloseBracket(currentChar)) {
                if (isEmpty()) {
                    return false; // Closing bracket with no corresponding opening bracket
                }

                char openBracket = pop();
                if (!areBracketsMatching(openBracket, currentChar)) {
                    return false; // Mismatched brackets
                }
            }
        }

        // checking for any unclosed brackets 
        return isEmpty();
    }

    // same functions from 1 
    static void push(char element) {
        boolean isFull = false;
        for (int i = 0; i < operationStack.length; i++) {
            if (operationStack[i] == '\u0000') { //\u0000 is a null character 
                operationStack[i] = element;
                isFull = false;
                break;
            }
            isFull = true;
        }
        if (isFull) {
            throw new RuntimeException("Stack is full!!");
        }
    }

    // Function to check if the stack is empty
    static boolean isEmpty() {
        int size = -1; // Initialize the size to -1 (indicating an empty stack)
        for (int i = 0; i < operationStack.length; i++) {
            if (operationStack[i] != '\u0000') {
                size++;
            }
        }
        return size == -1;
    }

    // Function to pop an element from the stack
    static char pop() {
        boolean isEmpty = true;
        char popped = '\u0000';
        for (int i = operationStack.length - 1; i >= 0; i--) {
            if (operationStack[i] != '\u0000') {
                isEmpty = false;
                popped = operationStack[i];
                operationStack[i] = '\u0000';
                break;
            }
            isEmpty = true;
        }
        if (isEmpty) {
            throw new RuntimeException("Stack is empty!!");
        }
        return popped;
    }
    public static void main(String[] args) {
        //testing testing 
        String arithmeticExpression = "((((()))))))(((()))))(((()))){)}";
        System.out.println("Is the arithmetic expression valid: " + validateor(arithmeticExpression));
    }
}
