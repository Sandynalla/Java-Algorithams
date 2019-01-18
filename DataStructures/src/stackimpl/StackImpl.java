package stackimpl;

public class StackImpl {
	int maxCapacity;
	int stack[];
	int top;

	public StackImpl(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.stack = new int[maxCapacity];
		top = 0;
	}
	
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is full");
		} else {
			stack[top] = data;
			top++;

		}
	}
	
	public int pop() {
		int temp = 0;
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			top--;
			temp = stack[top];
			stack[top] = 0;
		}
		return temp;
	}
	
	public void show() {
		System.out.println("Stacks: ");
		for(int n: stack) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public void peek() {
		int data = stack[top -1];
		System.out.println(data);
	}
	
	public boolean isEmpty() {
		return top <=0;
	}
	
	public boolean isFull() {
		return top == maxCapacity;
	}
	
	public int size() {
		return top;
	}
	
	
	public static void main(String[] args) {
		int capacity = 5;
		StackImpl stack = new StackImpl(capacity);
		
		stack.push(12);
		stack.push(14);
		stack.push(18);
		stack.push(21);
		
		stack.show();
		stack.pop();
		stack.pop();
		stack.show();
		stack.size();
		stack.peek();

	}

}
