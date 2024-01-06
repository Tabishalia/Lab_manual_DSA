import java.util.Arrays;

class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    // Constructor to initialize the dynamic array with a default capacity
    public DynamicArray() {
        this.capacity = 10;
        this.array = new int[capacity];
        this.size = 0;
    }

    // Method to insert an element into the array
    public void insert(int element) {
        ensureCapacity();
        array[size++] = element;
    }

    // Method to remove an element from the array
    public void remove(int element) {
        int index = search(element);
        if (index != -1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
        }
    }

    // Method to search for an element in the array
    public int search(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // Method to find the maximum number in the array
    public int findMax() {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to find the minimum number in the array
    public int findMin() {
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Method to find common numbers in two arrays
    public void findCommon(DynamicArray otherArray) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < otherArray.size; j++) {
                if (array[i] == otherArray.array[j]) {
                    System.out.print(array[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    // Method to find the product of numbers in the array
    public long findProduct() {
        long product = 1;
        for (int i = 0; i < size; i++) {
            product *= array[i];
        }
        return product;
    }

    // Method to find the average of numbers in the array
    public double findAverage() {
        if (size == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        return (double) sum / size;
    }

    // Method to reverse the array
    public void reverse() {
        int start = 0;
        int end = size - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Method to find distinct numbers in the array
    public void findDistinct() {
        for (int i = 0; i < size; i++) {
            boolean isDistinct = true;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // Method to replace a number in the array
    public void replace(int oldNum, int newNum) {
        int index = search(oldNum);
        if (index != -1) {
            array[index] = newNum;
        }
    }

    // Method to find even numbers in the array
    public void findEvenNumbers() {
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // Method to find odd numbers in the array
    public void findOddNumbers() {
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // Method to find prime numbers in the array
    public void findPrimeNumbers() {
        for (int i = 0; i < size; i++) {
            if (isPrime(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Helper method to ensure capacity when inserting elements
    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
    }

    // Method to display the array
    public void displayArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public class Main {
        public static void main(String[] args) {
            DynamicArray dynamicArray = new DynamicArray();

            // Insert operation
            dynamicArray.insert(10);
            dynamicArray.insert(20);
            dynamicArray.insert(30);
            dynamicArray.insert(40);

            // Display array
            System.out.print("Dynamic Array: ");
            dynamicArray.displayArray();

            // Remove operation
            dynamicArray.remove(20);
            System.out.print("After removing 20: ");
            dynamicArray.displayArray();

            // Search operation
            int searchElement = 30;
            int searchResult = dynamicArray.search(searchElement);
            System.out.println(searchElement + " found at index " + searchResult);

            // Find max and min
            System.out.println("Max: " + dynamicArray.findMax());
            System.out.println("Min: " + dynamicArray.findMin());

            // Common numbers in two arrays
            DynamicArray secondArray = new DynamicArray();
            secondArray.insert(30);
            secondArray.insert(40);
            secondArray.insert(50);
            System.out.print("Common elements: ");
            dynamicArray.findCommon(secondArray);

            // Product of numbers
            System.out.println("Product: " + dynamicArray.findProduct());

            // Average of numbers
            System.out.println("Average: " + dynamicArray.findAverage());

            // Reverse array
            dynamicArray.reverse();
            System.out.print("Reversed Array: ");
            dynamicArray.displayArray();

        }
    }

}
