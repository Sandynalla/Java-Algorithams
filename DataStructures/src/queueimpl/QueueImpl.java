package queueimpl;

public class QueueImpl {
	
	int maxCapacity;
	int queue[];
	int front;
	int rear;
	int size;
	
	public QueueImpl(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.queue = new int[maxCapacity];
		front = 0;
		rear = 0;
		size = 0;
	}
	
	public void enQueue(int data) {
		if(!isFull()) {
			queue[rear] = data;
			rear = (rear+1)%maxCapacity; //circular queue
			size++;
		} else {
			System.out.println("Queue is full");
		}
	}
	
	public int deQueue() {
		int temp = queue[front];
		if(!isEmpty()) {
			front = (front + 1)%maxCapacity;
			size--;
		} else {
			System.out.println("Queue is empty");
		}
		return temp;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	public boolean isFull() {
		return getSize() == maxCapacity;
	}
	
	public void showQueue() {
		System.out.print("Queue: ");
		for(int i =0; i<=getSize(); i++) {
			System.out.print(queue[(front + i)%maxCapacity] + " ");
		}
	}
	
	

	public static void main(String[] args) {
		int queueSize = 5;
		QueueImpl queue = new QueueImpl(queueSize);
		
		queue.enQueue(5);
		queue.enQueue(12);
		queue.enQueue(31);
		queue.enQueue(14);
		queue.enQueue(7);
		queue.showQueue();
		
		queue.deQueue();
		queue.deQueue();
		queue.showQueue();
		
		queue.enQueue(9);
		queue.enQueue(11);
		
		queue.getSize();
		queue.showQueue();

	}

}
