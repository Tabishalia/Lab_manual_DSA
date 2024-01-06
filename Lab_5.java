class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Method to INSERT node at first position
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to DELETE node from first position
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Method to DISPLAY data from Doubly Linked List
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to INSERT node at last position
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to DELETE node from last position
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Method to INSERT node at middle position
    public void insertMiddle(int data, int position) {
        Node newNode = new Node(data);
        if (position <= 0) {
            System.out.println("Invalid position. Position should be greater than 0.");
            return;
        }

        if (position == 1) {
            insertFirst(data);
        } else {
            Node current = head;
            int count = 1;
            while (count < position - 1 && current != null) {
                current = current.next;
                count++;
            }

            if (current == null) {
                System.out.println("Invalid position. Position exceeds the length of the list.");
            } else {
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
            }
        }
    }

    // Method to DELETE node from middle position
    public void deleteMiddle(int position) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (position <= 0) {
            System.out.println("Invalid position. Position should be greater than 0.");
            return;
        }

        if (position == 1) {
            deleteFirst();
        } else {
            Node current = head;
            int count = 1;
            while (count < position && current != null) {
                current = current.next;
                count++;
            }

            if (current == null) {
                System.out.println("Invalid position. Position exceeds the length of the list.");
            } else {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
            }
        }
    }

    // Method to REVERSE Doubly Linked List
    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // Method to FIND MAX number from Doubly LINKED LIST
    public int findMax() {
        if (head == null) {
            System.out.println("List is empty.");
            return Integer.MIN_VALUE;
        }

        int max = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    // Method to FIND MIN number from Doubly LINKED LIST
    public int findMin() {
        if (head == null) {
            System.out.println("List is empty.");
            return Integer.MAX_VALUE;
        }

        int min = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

        return min;
    }

    // Method to SEARCH position of data in Doubly LINKED LIST
    public int searchPosition(int data) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1; // If data is not found
    }
}

public class Lab_5 {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();

        myList.insertFirst(10);
        myList.insertFirst(5);
        myList.insertLast(20);
        myList.insertMiddle(15, 2);

        System.out.println("Original Doubly Linked List:");
        myList.display();

        myList.deleteFirst();
        myList.deleteLast();
        myList.deleteMiddle(2);

        System.out.println("Doubly Linked List after deletion:");
        myList.display();

        myList.reverse();
        System.out.println("Doubly Linked List after reversal:");
        myList.display();

        System.out.println("Maximum number in the Doubly Linked List: " + myList.findMax());
        System.out.println("Minimum number in the Doubly Linked List: " + myList.findMin());

        int searchData = 5;
        int searchPosition = myList.searchPosition(searchData);
        if (searchPosition != -1) {
            System.out.println(searchData + " found at position: " + searchPosition);
        } else {
            System.out.println(searchData + " not found in the Doubly Linked List.");
        }
    }
}
