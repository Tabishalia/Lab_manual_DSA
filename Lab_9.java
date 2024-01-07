class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Method to push data into the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to the stack");
    }

    // Method to pop data from the stack
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop from an empty stack.");
            return;
        }
        int poppedData = top.data;
        top = top.next;
        System.out.println(poppedData + " popped from the stack");
    }

    // Method to peek at the top element of the stack
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek into an empty stack.");
            return;
        }
        System.out.println("Top element of the stack: " + top.data);
    }

    // Helper method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

public class Lab_9 {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Pushing elements into the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking at the top element
        stack.peek();

        // Popping elements from the stack
        stack.pop();
        stack.pop();

        // Peeking after popping
        stack.peek();

        // Popping from an empty stack
        stack.pop();
    }
}
