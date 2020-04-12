package PROBLEM4;

public class Problem4a {

    public static void main(String[] args) {

	int[] a = {9,8,3,1,0,7,3,5,4};
	Problem4a(a);


    }

    public static void Problem4a(int[] a) {

	int arraySize = a.length;

        int[] x = new int[arraySize];
        int i = 0;
        
        x = a.clone();

        while ((i+1 < arraySize) && (i < arraySize)) {
        	
            if (a[i] > a[i + 1]) {
            	
                int temp_arr = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp_arr;
                i += 2;
            } 
            else {
            	
                i++;
            }
        }
        
        System.out.println("Sorted by Minima:");
        
        for (i = 0; i<arraySize; i++){
            
        	System.out.print(a[i]+" ");
        	
        }


        int b = 0;

        while(b < x.length && b+1 < x.length){
            
        	if(x[b+1]>x[b]){
                
        		int temp = x[b];
                x[b] = x[b + 1];
                x[b + 1] = temp;
                b = b + 2;
                
            }
        	else {
                ++b;
            }
        }

        System.out.println("\n");
        
        System.out.print("Sorted by Maxima:\n");

        for (int j=0; j<x.length; j++){
        	
            System.out.print(x[j]+" ");
        }

    }
}
