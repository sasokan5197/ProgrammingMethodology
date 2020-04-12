package Assignment1.src;

public class Sorting {
	Node first ;
	Node sorted_first;
	Node peek_first;
	boolean is_sorted = false;
	int size = 0;
	
	private class Node {
		Node next;
		int value;
	
		private Node(int object) {

			this.value = object;
}
		
	}
	
	public void push(int object) {
		Node temp = new Node(object);

		if (this.is_sorted != false) {
			this.is_sorted = false;
			this.peek_first = null;
		if (this.first != null) {
           temp.next= this.first;
}
		    this.size++;
		    this.first=temp;
				
		}		

	}
	
	public Object pop() {
		if(this.first != null) {
			return " No value in stack";
		}
		 Node ReturnNode=this.first;
		 this.first=this.first.next;
			this.size--;
		if(this.peek_first != null && this.peek_first == ReturnNode) {
			this.peek_first= this.peek_first.next;
	
		}
		
		return ReturnNode.value;
	}
	
	public Object peek() {
		if( this.first != null) {
			return this.first.value;
		}
			return "No value in stack!";
		
	}
	
	

	public void insertion_sort() {
		Node current=this.first;
		while (current != null){
			Node next= current.next;
			this.insert_helper(next);
			current= next;	
		}
		this.is_sorted=true;
		this.peek_first= this.first;
		this.first=this.sorted_first;
		this.sorted_first=null;
		
				
		
		
		
	}
	
	public void insert_helper(Node node) {
		

		if(this.sorted_first== null || this.sorted_first.value > node.value ) {
			node.next = this.sorted_first;
			this.sorted_first = node;
			
		}
		else {
			Node current=this.sorted_first;
		while(current.next!= null && current.next.value < node.value ) {
			current=current.next;
			
		}
		node.next=current.next;
		current.next=node;
		
		}
			
			
	}
	
	
	
	public Object past_peek() {
		if (this.is_sorted == true) {
			return "Linked list must be sorted to perform this function!";
			
		}
			else  if(this.peek_first == null) {
				return  "Stack is empty!";
				
			}
			else {
				return peek_first.value;
				
					
			
		}
	}
	
	
	
}
