class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lab_3 {
    private Node head;

    // Method to insert a node at the first position
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to delete a node from the first position
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // Method to display data from the linked list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to insert a node at the last position
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to delete a node from the last position
    public void deleteLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Method to insert a node at the middle position
    public void insertMiddle(int data, int position) {
        if (position <= 0) {
            insertFirst(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 1; i < position && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    // Method to delete a node from the middle position
    public void deleteMiddle(int position) {
        if (position <= 0 || head == null || head.next == null) {
            deleteFirst();
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null && current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    // Method to reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Method to find the maximum number in the linked list
    public int findMax() {
        int max = Integer.MIN_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    // Method to find the minimum number in the linked list
    public int findMin() {
        int min = Integer.MAX_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    // Method to search the position of data in the linked list
    public int searchPosition(int data) {
        int position = 1;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lab_3 list = new Lab_3();
        list.insertFirst(10);
        list.insertFirst(5);
        list.insertLast(20);
        list.insertMiddle(15, 2);
        list.displayList();

        list.reverse();
        System.out.println("Reversed list:");
        list.displayList();

        System.out.println("Max number: " + list.findMax());
        System.out.println("Min number: " + list.findMin());

        int searchData = 15;
        int position = list.searchPosition(searchData);
        if (position != -1) {
            System.out.println(searchData + " found at position " + position);
        } else {
            System.out.println(searchData + " not found in the list");
        }
    }
}
