class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Insert element at the front
    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        // Move front backward circularly
        front = (front - 1 + capacity) % capacity;

        deque[front] = value;
        size++;

        return true;
    }

    // Insert element at the rear
    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        deque[rear] = value;

        // Move rear forward circularly
        rear = (rear + 1) % capacity;

        size++;

        return true;
    }

    // Delete element from the front
    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    // Delete element from the rear
    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        // Move rear backward circularly
        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    // Get front element
    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return deque[front];
    }

    // Get rear element
    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        int index = (rear - 1 + capacity) % capacity;

        return deque[index];
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if deque is full
    public boolean isFull() {
        return size == capacity;
    }
}


// Main class
public class Main {

    public static void main(String[] args) {

        MyCircularDeque myCircularDeque =
                new MyCircularDeque(3);

        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));

        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());

        System.out.println(myCircularDeque.deleteLast());

        System.out.println(myCircularDeque.insertFront(4));

        System.out.println(myCircularDeque.getFront());
    }
}