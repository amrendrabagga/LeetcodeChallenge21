package april.week1;

public class Day4_DesignCircularQueue {
    int queue[];
    int rear = 0;
    int front = 0;
    boolean noElement;
    public Day4_DesignCircularQueue(int k) {
        queue = new int[k];
        this.noElement = true;
    }

    public boolean enQueue(int value) {
        if (!this.isFull()) {
            this.noElement = false;
            queue[rear] = value;
            rear++;
            rear = rear % queue.length;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!this.isEmpty()) {
            front++;
            front = front % queue.length;
            if (rear == front) {
                this.noElement = true;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public int Front() {
        if (!this.isEmpty()) {
            return queue[front];
        }
        else {
            return -1;
        }
    }

    public int Rear() {
        if (!this.isEmpty()) {
            if (rear == 0) {
                return queue[queue.length - 1];
            }
            else {
                return queue[rear - 1];
            }
        }
        else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.noElement;
    }

    public boolean isFull() {
        return (rear == front) && !this.noElement;
    }
}
