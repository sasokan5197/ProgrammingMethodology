package Problem1;
import java.util.Arrays;

public class DaryHeap {
	
	public int arity;
	public int[] heap = new int[10];
	public int size = 0;
	
	
	public DaryHeap(int d) {
		arity = d;
		Arrays.fill(heap, -999);
	}
	
	public void insert(int k) {
		if(size == heap.length) {
			doubleArray();
		}
		size++;
		heap[size-1] = k;
		swim(size - 1);
		
	}
	
	public int delMax() {
		int largest = heap[0];
		heap[0] = heap[--size];
		heap[size] = -999;
		sink(0);
		return largest;
	}
	
	int[] daryHeapsort() {
		int[] temp = new int[size];
		System.arraycopy(heap, 0, temp, 0, size);
		return temp;
	}
	
	void swim(int k) {
		
		int temp = heap[k];
		
		while(k >= 1 && temp > heap[getParent(k)]) {
			heap[k] = heap[getParent(k)];
			k = getParent(k);
		}
		heap[k] = temp;
	}
	
	void sink(int k) {
		
		int x;
		int temp = heap[k];
		while(getChild(k, 1) <= size-1) {
			x = getMaxChild(k);
			if(heap[x] > temp) {
				heap[k] = heap[x];
			}
			else break;
			k = x;
		}
		heap[k] = temp;
	}
	
	void doubleArray() {
		int[] tmp = new int[2*heap.length];
		Arrays.fill(tmp, -999);
		System.arraycopy(heap, 0, tmp, 0, heap.length);
		heap = tmp;
	}
	
	public int getParent(int index) {
		return((--index)/arity);
	}
	
	public int getChild(int parent, int num) {
		return (arity * parent) + num;
	}
	
	public int getMaxChild(int k) {
		
		int x = getChild(k,1);
		int i = 2;
		int p = getChild(k,i);
		while((i <= arity) && (p < size)) {
			if(heap[p] > heap[x]) {
				x = p;
			}
			p = getChild(k, ++i);
		}
		return x;
	}
	
	
	public static void main(String[] args) {
		/*
		DaryHeap heap = new DaryHeap(3);
		heap.insert(9);
		heap.insert(4);
		heap.insert(20);
		heap.insert(1);
		heap.insert(15);
		heap.insert(7);
		heap.insert(2);
		heap.insert(100);
		heap.insert(39);
		heap.delMax();
		*/
		
		DaryHeap heap = new DaryHeap(3);
		for(int k = 0; k<20; k++) {
			heap.insert(k);
		}
		
		
		int[] sorted = heap.daryHeapsort();
		for(int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i]+", ");
		}

	}

}