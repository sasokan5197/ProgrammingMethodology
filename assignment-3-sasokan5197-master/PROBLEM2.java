


package assignment;
import java.lang.*;

class node{
	
	int val;
	node left = null;
	node right = null;
	boolean init = false;
	
	public node(int x) {
		val = x;
		init = true;
	}
	
	public node() {
		init = false;
	}
	
	public node(node a) {
		this.val = a.val;
		this.left = a.left;
		this.right = a.right;
		this.init = true;
	}
	
	public void assign(int a) {
		init = true;
		val = a;
	}
}

class BST {
	
	node root = null;
	int num;
	int comps = 0;
	int current;
	int[] arr = new int[10];	
	public BST() {
		num = 0;
	}
	
	public void put(int[] a) {
		for(int i = 0; i < a.length; i++) {
			put(a[i]);
		}
		
	}
	
	public void put(int a) {
		num++;
		root = putr(root, a);
	}
	
	public node putr(node root, int a) {
		if(root == null) {
			root = new node(a);
			return root;
		}
		if(a <= root.val) {
			root.left = putr(root.left, a);
		}
		else if(a > root.val) {
			root.right = putr(root.right, a);
		}
		return root;
	}
	
	public int search(int key) {
		comps = 0;
		node found;
		found = searchr(root, key);
		if(found == null) {
			System.out.println("Value not found!");
			System.out.println("Made "+comps+" comparisons.");
			return 0;
		}
		System.out.println("Found in "+comps+" comparisons.");
		return 0;
		
		
	}
	
	public node searchr(node root, int key) {
		if(root == null || root.val == key) {
			comps++;
			return root;
		}
		if(key < root.val) {
			comps++;
			return searchr(root.left, key);
		}
		comps++;
		return searchr(root.right, key);
	}
	
	public int returnSize() {
		return num;
	}
	
	public int[] sortedTree() {
		arr = new int[num];
		current = 0;
		sortedTreer(root);
		return arr;
	}
	
	public void sortedTreer(node root) {
		if(root != null) {
			sortedTreer(root.left);
			arr[current] = root.val;
			current++;
			sortedTreer(root.right);
		}
	}
	
	public BST balanceTreeOne() {
		this.sortedTree();
		BST balanced = new BST();
		balanced.root = balanceTreeOner(arr, 0, arr.length-1);
		balanced.num=num;
		return balanced;
	}
	
	public node balanceTreeOner(int[] ar, int begin, int end) {
		if(begin>end) {
			return null;
		}
		int middle = (begin + end)/2;
		node newroot = new node(ar[middle]);
		newroot.left = balanceTreeOner(ar,begin,middle-1);
		newroot.right = balanceTreeOner(ar,middle+1,end);
		return newroot;
		
	}
	
	public node rotateRight(node h) {
		if(h.left == null) {
			return h;
		}
		node x = h.left;
		h.left = x.right;
		x.right = h;
		return x;
		
	}
	
	public node rotateLeft(node h) {
		if(h.right == null) {
			return h;
		}
		node x = h.right;
		h.right = x.left;
		x.left = h;
		return x;
	}
	
	public void transformToList() {
		
		
		while(root.left != null) {
			root = rotateRight(root);
		}
		node cur = root;
		node last;
		while(cur.right != null) {
			last = cur;
			cur = cur.right;
			while(cur.left != null) {
				last.right = rotateRight(cur);
			}
		}
		
		
		
	}
	
	public void balanceTreeTwo() {
		this.transformToList();
		int M = (int) ((num + 1) - Math.pow(2, Math.floor(Math.log(num)/Math.log(2))));
		root = rotateLeft(root);
		node last = root;
		node cur = last.right;
		for(int i = 1; i<M; i++) {
			last.right = rotateLeft(cur);
			last = last.right;
			cur = last.right;
		}
		int K = (int) (Math.log(num)/Math.log(2) - 1);
		root = rotateLeft(root);
		last = root;
		cur = last.right;
		for(int i = 1; i<K; i++) {
			last.right = rotateLeft(cur);
			last = last.right;
			cur = last.right;
		}
	}


	
	
/*//	public static void main(String[] args) {
		int[] ar = {1,4,2,6,3,8};
		BST test = new BST();
		test.put(10);
		test.put(ar);
		test.put(13);
		test.put(8);
		test.put(16);
		test.put(17);
		test.put(4);
		test.search(0);
		System.out.println(test.returnSize());
		int[] arr = test.sortedTree();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		BST newtree = test.balanceTreeOne();
		System.out.println(newtree.returnSize());
		newtree.balanceTreeTwo();
		System.out.println();
		newtree.search(10);
		
	}*/

}

