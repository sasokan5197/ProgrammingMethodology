package Assignment1.src;


public class ArbitraryArrayQueue {
	Object[] object;
	int front;
	int rear;
	int size;
	int data;
	int capacity;

	public ArbitraryArrayQueue() {
		this.capacity = 10;
		this.size = 0;
		this.object = new Object[capacity];
		this.front = capacity / 2;
		this.rear = capacity / 2 + 1;

	}

	public void push(Object data) {
		this.object[front] = data;
		this.front--;
		this.size++;
		if (this.front < 0) {
			Object[] temp = new Object[this.capacity * 2];
			for (int i = 0; i < this.capacity; i++) {
				temp[i + this.capacity / 2] = object[i];

			}
			this.front = this.capacity / 2;
			this.rear = this.capacity / 2 + size;
			this.capacity = this.capacity * 2;
			this.object = temp;

		}
	}

	public void Enqueue(Object data) {
		this.object[rear] = data;
		this.rear++;
		this.size++;
		if (this.rear > this.capacity - 1) {
			Object[] temp = new Object[this.capacity * 2];
			for (int i = 0; i < this.capacity; i++) {
				temp[i + this.capacity / 2] = object[i];

			}
			this.front = this.capacity / 2;
			this.rear = this.capacity / 2 + size;
			this.capacity = this.capacity * 2;
			this.object = temp;
		}

	}

	public Object pop() {
		Object temp = this.object[front];
		if (temp == null) {
			return " No items in this queue";
		}
		this.front++;
		this.size--;
		return temp;

	}

	public Object Dequeue() {
		Object temp = this.object[rear];
		if (temp == null) {
			return " No items in this queue";

		}
		this.rear--;
		this.size--;
		return temp;

	}

	public Object Traverse(int index) {
		try {
			Object temp = this.object[index];
			if (temp == null) {
				return " No items in this index";

			} else {
				return temp;

			}
		} catch (IndexOutOfBoundsException e) {
			return " No items in this index";
		}

	}
}
