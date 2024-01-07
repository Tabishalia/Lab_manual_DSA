class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Method to enqueue (insert) data into the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued into the queue");
    }

    // Method to dequeue (remove) data from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue from an empty queue.");
            return;
        }
        int dequeuedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println(dequeuedData + " dequeued from the queue");
    }

    // Method to peek at the front element of the queue
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek into an empty queue.");
            return;
        }
        System.out.println("Front element of the queue: " + front.data);
    }

    // Helper method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

public class Lab_10 {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Peek at the front element
        queue.peek();

        // Dequeue elements from the queue
        queue.dequeue();
        queue.dequeue();

        // Peek after dequeue
        queue.peek();

        // Dequeue from an empty queue
        queue.dequeue();
    }
}
