package PROBLEM1;

import java.io.*; 
import java.util.*; 
class Problem1Sort{
private int[] array;
public Problem1Sort(int[] array ) {
	this.array=array;
}




	
	public void helperSort(int[] array, int e) {

		int n = array.length;
		int[] out = new int[n];
		int[] count = new int[10];

		for (int x = 0; x < 10 ;x++) {
			count[x] = 0;
		}

		for (int x = 0; x < n; x++) {
            count[(array[x]/e)%10]++;
        }

        for (int x = 1; x < 10; x++) {
        	count[x] += count[x-1];
        }

        for (int x = n - 1; x >= 0; x--) {
        	out[count[ (array[x]/e)%10 ] - 1] = array[x]; 
        	count[(array[x]/e)%10]--;
        }

        for (int x = 0; x < n; x++) 
            array[x] = out[x];
 
	}

	public void Sort() {

		int n = array.length;

		int max_num = 0;
		for (int x = 0; x < n; x++) {
			if (array[x] > max_num) {
				max_num = array[x];
			}
		}

		for (int e = 1; max_num / e > 0; e*=10) {
			this.helperSort(array, e);
		}
	}
	
	

	public void printarray() {

		for (int i = 0; i<array.length; i++) {

			System.out.println(array[i]);

		}

	}


public static void main(String[] args) {
	
	int[]array= {12,4,6,8};
	Problem1Sort x = new Problem1Sort(array);
	x.Sort();
	x.printarray();
	
}
}
	




