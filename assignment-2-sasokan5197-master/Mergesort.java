package PROBLEM2;

public class Mergesort {
	
	public int[] mergesort(int[] ar) {
		if(ar.length < 2 || ar == null) {
			return ar;
		}
		
		return mergesort(ar, 0, ar.length-1);
	}
	
	public int[] mergesort(int[] ar, int low, int high) {
		if (high == low) {
			return ar;
		}
		
		int middle = (low + high)/2;
		System.out.println(middle);
		mergesort(ar, low, middle);
		mergesort(ar, middle + 1, high);
		
		
		
		
		return merge(low, middle + 1, high + 1, ar);
	}
	

	public int[] merge(int low, int middle, int high, int[] ar) {
		int x;
		x = middle;
		while(low < x && middle < high) {
			if(ar[low] < ar [middle]) {
				low++;
			}
			else {
				replace(low, middle, ar);
				middle++;
			}
		}
		
		return ar;
	}
	
	public void replace(int i, int j, int[] ar) {
		int temp = ar[j];
		while(i<j) {
			ar[j] = ar[--j];
		}
		ar[j] = temp;
	}
	
	public void printarray(int[] array) {

		for (int i = 0; i<array.length; i++) {

			System.out.println(array[i]);

		}

	}
	
	public static void main(String[] args) {
		Mergesort test = new Mergesort();
		int[] testar = {18,5,34,2,3,1,54,1,8,8,8};
		int[] sorted = test.mergesort(testar);
		System.out.println();
		test.printarray(sorted);
	}
	
}
