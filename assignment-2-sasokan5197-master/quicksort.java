package PROBLEM3; 

class node{
	int val;
	node next = null;
	node last = null;
	
	public node(int x) {
		val = x;
	}
	
	public void print() {
		if(this.next != null) {
			System.out.println(this.val+"-->"+this.next.val);
		}
	}
	
}

class LinkedList{
	node head;
	node tail;
	node cur;
	int count = 1;
	
	public LinkedList() {
		count = 0;
	}
	
	public void printList() {
		node curx = head;
		while(curx.next != null) {
			System.out.print(curx.val+" , ");
			curx = curx.next;
		}
		System.out.println(curx.val);
	}
	
	public void add(int x) {
		node n = new node(x);
		if(head == null) {
			head = n;
			tail = n;
			return;
		}
		cur = head;
		
		while(cur.next != null) {
			cur = cur.next;
		}
		
		n.last = cur;
		cur.next = n;
		tail = n;
		count++;
	}
	
	public void swap(node x, node i) {
		int temp = x.val;
		x.val = i.val;
		i.val = temp;
		//System.out.println("Swapping "+x.val+" and "+i.val+"!");
	}
	
	public void shuffle() {
		System.out.println("Shuffling...");
		node cur1, cur2;
		int rand1, rand2;
		for(int i = 0; i < 50; i++) {
			cur1 = head;
			cur2 = head;
			rand1 = (int) (Math.random() * (count));
			rand1++;
			rand2 = (int) (Math.random() * (count));
			rand2++;
			for(int j = 0; i < rand1; i++) {
				cur1 = cur1.next;
			}
			for(int k = 0; k < rand2; k++) {
				cur2 = cur2.next;
			}
			swap(cur1,cur2);
			
		}
		this.printList();
		cur = head;
		
	}
	
	
	public void riabx(node i, node x) { /*remove i add before x*/
		if(i.last != null && i.next != null) {
			i.last.next = i.next;
			i.next.last = i.last;
		}
		if(i.next == null) {
			i.last.next = null;
			tail = i.last;
		}
		if(i.last == null) {
			i.next.last = null;
			head = i.next;
		}
		if(x.last != null) {
			x.last.next = i;
			i.last = x.last;
			x.last = i;
			i.next = x;
		}
		if(x.last == null) {
			x.last = i;
			i.next = x;
			i.last = null;
			head = i;
		}
		System.out.println("Removing "+i.val+" and adding before "+x.val);
	}
	
	public void riaax(node i, node x) { /*remove i add after x*/
		if(i.last != null && i.next != null) {
			i.last.next = i.next;
			i.next.last = i.last;
		}
		if(i.next == null) {
			i.last.next = null;
			tail = i.last;
		}
		if(i.last == null) {
			i.next.last = null;
			head = i.next;
		}
		if(x.next != null) {
			x.next.last = i;
			i.next = x.next;
			x.next = i;
			i.last = x;
		}
		if(x.next == null) {
			x.next = i;
			i.last = x;
			i.next = null;
			tail = i;
		}
		System.out.println("Removing "+i.val+" and adding after "+x.val);
	}
	
	public void partition(node start, node finish) {
		if(start.next == null) {
			return;
		}
		if(start == finish || (start.next == finish && start.val <= finish.val)) {
			return;
		}
		if(start.next == finish && start.val > finish.val) {
			swap(start,finish);
			return;
		}
		Boolean started = false;
		node temphead = start;
		node part = start;
		node nextstart = null;
		node leq = null;
		cur = start.next;
		while(cur.next != null && cur.next != finish) {
			if(cur.val == part.val) {
				System.out.println(cur.val+" = "+part.val);
				node temp;
				temp = cur.next;
				riabx(cur,part);
				if(!started) {
					nextstart = cur;
				}
				cur = temp;
			}
			else if(cur.val < part.val) {
				System.out.println(cur.val+" < "+part.val);
				node temp;
				temp = cur.next;
				if(leq != null) {
					riabx(cur,leq);
				}
				riabx(cur,head);
				started = true;
				nextstart = cur;
				cur = temp;
			}
			else {
				System.out.println(cur.val+ " > " + part.val);
				cur = cur.next;
			}
		}
		
		if(cur.next != null) {
			cur = cur.next;
		}
		if(cur.val == part.val) {
			System.out.println(cur.val+" = "+part.val);
			riabx(cur,part);
			leq = cur;
		}
		else if(cur.val < part.val) {
			System.out.println(cur.val+" < "+part.val);
			riabx(cur,head);
		}
		if(nextstart == null) {
			nextstart = start;
		}
		this.printList();
		if(leq != null) {
			this.partition(nextstart, leq);
		}
		else if(nextstart != null){
			this.partition(nextstart, part);
		}
		if(part.next != null) {
			this.partition(part.next, finish);
		}
	}
	
	
	
	public void quicksort() {
		this.shuffle();
		if(head == null || head.next == null) {
			return;
		}
		
		this.partition(head,tail);
		
		
		
	}
		}