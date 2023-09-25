package src.JavaStack;

public class JavaStack {

    static int[] stackArray = new int[5]; // define and initialize an empty array of size 5 to work with

    public static void main(String[] args) {

        size();
        isEmpty();
        push(1);
        isEmpty();
        top();
        push(2);
        top();
        push(3);
        top();
        push(4);
        push(5);
        top();
       // push(6); // this will throw error saying stack is full

        for(int i=0; i<stackArray.length; i++){
            System.out.println(stackArray[i]);
        }
        pop();
        pop();
        pop();
        pop();
        pop();
       // pop(); // this will throw error saying stack is empty
        for(int i=0; i<stackArray.length; i++){
            System.out.println(stackArray[i]);
        }
        top();
    }


    static void push(int num){
        boolean isFull = false;
        for(int i=0; i<stackArray.length; i++){
            if(stackArray[i] == 0){ //check if we have space to push to array, consider value 0 as empty
                isFull = false;
                stackArray[i] = num; //push to an empty index
                break;
            }
            isFull = true;
        }
        if(isFull){
            throw new RuntimeException("Stack is full!!");
        }
    }

    static void pop(){
        boolean empty = false;
        for(int i=0; i<stackArray.length; i++){
            if(stackArray[i] != 0){ //check if stack is empty, consider value 0 as empty
                empty = false;
                stackArray[i] = 0; //remove the number and set to 0
                break;
            }
            empty = true;
        }
        if(empty){
            throw new RuntimeException("Stack is empty!!");
        }
    }

    static void top(){
        int size = -1; //set initial size to -1.
        // - 1: empty, 0: only one element, (n-1): full
        // n: overflow
        //n is a size of an array
        for(int i=0; i<stackArray.length; i++){
            if(stackArray[i] != 0){ //check if stack is empty, consider value 0 as empty
                size++;
            }
        }
        if(size == -1){
            System.out.println("Stack is empty!");
        }else if( size == 0){
            System.out.println("Stack has only one element!");
        }else if(size < stackArray.length - 1){
            System.out.println("Stack is full!!");
        }else {
            System.out.println("Stack is overflow!");
        }
    }

    static void size(){
        System.out.println("Size of a stack is: " + stackArray.length);
    }

    static void isEmpty(){
        int size = 0; //set initial size to -1.
        // - 1: empty, 0 or more not empty
        for(int i=0; i<stackArray.length; i++){
            if(stackArray[i] != 0){ //check if stack is empty, consider value 0 as empty
                size++;
            }
        }
        if(size == -1){
            System.out.println("Stack is empty!");
        }else {
            System.out.println("Stack is not empty!");
        }
    }
}
