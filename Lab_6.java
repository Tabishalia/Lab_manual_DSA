public class Lab_6 {
    private static final int MAX_SIZE = 100;
    private int[] stackArray;
    private int top;

    public Lab_6() {
        stackArray = new int[MAX_SIZE];
        top = -1;
    }

    // Method to push data into the stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push data, stack is full");
            return;
        }
        stackArray[++top] = data;
    }

    // Method to pop data from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop data, stack is empty");
            return -1; // Return a sentinel value indicating an empty stack
        }
        return stackArray[top--];
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a sentinel value indicating an empty stack
        }
        return stackArray[top];
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to find the maximum number in the stack
    public int findMax() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a sentinel value indicating an empty stack
        }

        int max = stackArray[0];
        for (int i = 1; i <= top; i++) {
            if (stackArray[i] > max) {
                max = stackArray[i];
            }
        }
        return max;
    }

    // Method to find the minimum number in the stack
    public int findMin() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a sentinel value indicating an empty stack
        }

        int min = stackArray[0];
        for (int i = 1; i <= top; i++) {
            if (stackArray[i] < min) {
                min = stackArray[i];
            }
        }
        return min;
    }

    // Method to find the average of numbers in the stack
    public double findAverage() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a sentinel value indicating an empty stack
        }

        int sum = 0;
        for (int i = 0; i <= top; i++) {
            sum += stackArray[i];
        }
        return (double) sum / (top + 1);
    }

    // Method to search for a value and return its position in the stack
    public int search(int value) {
        for (int i = 0; i <= top; i++) {
            if (stackArray[i] == value) {
                return i;
            }
        }
        return -1; // Return -1 if the value is not found
    }

    // Method to print even/odd numbers in the stack
    public void printEvenOdd() {
        System.out.print("Even numbers in the stack: ");
        for (int i = 0; i <= top; i++) {
            if (stackArray[i] % 2 == 0) {
                System.out.print(stackArray[i] + " ");
            }
        }

        System.out.println();

        System.out.print("Odd numbers in the stack: ");
        for (int i = 0; i <= top; i++) {
            if (stackArray[i] % 2 != 0) {
                System.out.print(stackArray[i] + " ");
            }
        }

        System.out.println();
    }

    // Method to reverse the data in the stack
    public void reverse() {
        int[] reversedStack = new int[MAX_SIZE];
        int index = 0;

        for (int i = top; i >= 0; i--) {
            reversedStack[index++] = stackArray[i];
        }

        // Copy reversed stack back to the original stack
        for (int i = 0; i <= top; i++) {
            stackArray[i] = reversedStack[i];
        }
    }

    public static void main(String[] args) {
        Lab_6 stack = new Lab_6();

        // Example usage of the stack methods
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek after pop: " + stack.peek());

        stack.push(50);
        stack.push(60);
        stack.push(70);

        System.out.println("Max in stack: " + stack.findMax());
        System.out.println("Min in stack: " + stack.findMin());
        System.out.println("Average in stack: " + stack.findAverage());

        int searchValue = 50;
        int position = stack.search(searchValue);
        System.out.println("Position of " + searchValue + " in stack: " + position);

        stack.printEvenOdd();

        System.out.println("Original stack:");
        for (int i = 0; i <= stack.top; i++) {
            System.out.print(stack.stackArray[i] + " ");
        }

        stack.reverse();

        System.out.println("\nReversed stack:");
        for (int i = 0; i <= stack.top; i++) {
            System.out.print(stack.stackArray[i] + " ");
        }
    }
}
