class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    // Method to INSERT node at first position
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to DELETE node from first position
    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
    }

    // Method to Display data from Circular Linked List
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Method to INSERT node at last position
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to DELETE node from last position
    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp.next != head) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = head;
        }
    }

    // Method to INSERT node at middle position
    public void insertAtMiddle(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        Node newNode = new Node(data);
        if (head == null) {
            if (position == 1) {
                head = newNode;
                head.next = head;
            } else {
                System.out.println("Invalid position.");
            }
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Invalid position.");
                return;
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Method to DELETE node from middle position
    public void deleteAtMiddle(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            deleteAtFirst();
            return;
        }
        Node temp = head;
        Node prev = null;
        for (int i = 1; i < position; i++) {
            prev = temp;
            temp = temp.next;
            if (temp == head) {
                System.out.println("Invalid position.");
                return;
            }
        }
        prev.next = temp.next;
    }

    // Method to REVERSE Circular Linked List
    public void reverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        Node prev = null;
        Node nextNode;
        do {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        } while (current != head);
        head = prev;
    }

    // Method to FIND MAX number from Circular LINKED LIST
    public int findMax() {
        if (head == null) {
            System.out.println("List is empty.");
            return Integer.MIN_VALUE;
        }
        int max = head.data;
        Node temp = head.next;
        do {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        } while (temp != head);
        return max;
    }

    // Method to FIND MIN number from Circular LINKED LIST
    public int findMin() {
        if (head == null) {
            System.out.println("List is empty.");
            return Integer.MAX_VALUE;
        }
        int min = head.data;
        Node temp = head.next;
        do {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        } while (temp != head);
        return min;
    }

    // Method to SEARCH position of data in Circular LINKED LIST
    public int search(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        Node temp = head;
        int position = 1;
        do {
            if (temp.data == data) {
                return position;
            }
            temp = temp.next;
            position++;
        } while (temp != head);
        System.out.println("Data not found in the list.");
        return -1;
    }
}

public class Lab_4 {
    public static void main(String[] args) {
        CircularLinkedList circularList = new CircularLinkedList();

        // Insert at first
        circularList.insertAtFirst(5);
        circularList.insertAtFirst(3);
        circularList.insertAtFirst(1);

        // Display
        System.out.println("Circular Linked List:");
        circularList.display();

        // Delete from first
        circularList.deleteAtFirst();

        // Display
        System.out.println("Circular Linked List after deleting from first:");
        circularList.display();

        // Insert at last
        circularList.insertAtLast(7);

        // Display
        System.out.println("Circular Linked List after inserting at last:");
        circularList.display();

        // Delete from last
        circularList.deleteAtLast();

        // Display
        System.out.println("Circular Linked List after deleting from last:");
        circularList.display();

        // Insert at middle
        circularList.insertAtMiddle(4, 2);

        // Display
        System.out.println("Circular Linked List after inserting at middle (position 2):");
        circularList.display();

        // Delete from middle
        circularList.deleteAtMiddle(2);
    }
}
