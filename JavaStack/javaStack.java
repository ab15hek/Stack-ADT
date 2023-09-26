package JavaStack;

public class javaStack {
    //intialize an array
    static int[] stackArray = new int[5];
    
    //set the top to -1 cause that means its empty
    static int topIndex = -1;

    // Check if the stack is empty.
    static boolean isEmpty() {
        return topIndex == -1;
    }

    // Checking if the stack is full.
    static boolean isFull() {
        return topIndex == stackArray.length - 1;
    }

    // Push function
    static void push(int num) {
        // Check if the stack is full before pushing.
        if (isFull()) {
            throw new RuntimeException("The stack is full! Cannot add more.");
        }
        //add to the topindex to move up the stack
        stackArray[++topIndex] = num;
    }

    // Pop function
    static void pop() {
        // Check if the stack is empty before popping.
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty! Cannot remove more.");
        }
        // Set the top element to 0 which removes it and we move down
        stackArray[topIndex--] = 0;
    }

    // Get the top element of the stack without removing it.
    static int top() {
        // Check if the stack is empty before retrieving the top element.
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty!");
        }
        // Return the top element from the stack.
        return stackArray[topIndex];
    }

    // Get the current size of the stack.
    static int size() {
        // The size is determined by the top index + 1.
        return topIndex + 1;
    }

    public static void main(String[] args) {
        // Push some elements onto the stack.
        push(3);
        push(1);
        push(2);
        push(6);
        push(1);

        // show da numbers in the stack.
        for (int i = 0; i < size(); i++) {
            System.out.println(stackArray[i]);
        }

        // shows the current stack size.
        System.out.println("Stack size: " + size());

        // Checking if the stack is empty and display the result.
        System.out.println("stack empty?" + isEmpty());

        //display the top element of the stack.
        System.out.println("Top element: " + top());

        
    }
}
