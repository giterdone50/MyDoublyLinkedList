public class MyDoublyLinkedList<E> {
	Node head;
	Node tail;
	
	public MyDoublyLinkedList(){
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	class Node{
		E data;
		Node next;
		Node prev;
		
		//no input
		public Node(){
			data = null;
			next = null;
			prev = null;
		}
		
		//    >>>>>>>>>>>>>>>>>>>  data to add and where to add
		public Node(E newData, int index) {
			Node current = head;
			int counter = 1;
			while(counter-1 != index) {
				current = current.next;
				counter++;
			}
			data = newData;
			this.next = current.next;
			current.next.prev = this;
			current.next = this;
			this.prev = current;
		}
	}
	
	//  >>>>>>>>>>>>>>>>>>>> start methods
	public void addFirst(E item) {
		Node newone = new Node(item, 0);
	}
	
	//   >>>>>>>>>>>>>>>> work on addLast
	public void addLast(E item) {
		//TODO: add code here

		Node richard = new Node();
		richard.data = item;
		richard.next = tail;
		richard.prev = tail.prev;
		tail.prev.next = richard;
		//lose 0th element
		tail.prev = richard;
		
	}
	
//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	  public void change(E newitem, int ind) {
		  //TODO: code here
		  Node current= head.next;
		  //System.out.println(current.data);
		  int counter = 1;
		  while(counter-1 != ind) {
			  current = current.next;
			  counter++;
		  }
		  //   >>>>>>>>>>>>>>>>>>>>>>>>   System.out.println(current.data);
		  current.data = newitem;
     }
	 //  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	  
	  public int size () {
		  // todo :  get the size of the list
		  Node current = head;
		  int count =0;
		  while(current !=null) {
			  count ++;
			  current=current.next;
		  }
		 
	 //  >>>>>>>>>>>>>>>>>>>>>   -2 is subtract from head and tail
		  return count-2;
	  }

	public void add(E item, int index) {
		@SuppressWarnings("unused")
		Node newone = new Node(item, index);
	}
	
	public void removeFirst() {
		//TODO: add code fore removing first element in the list (one right after head)
		//public  deleteFirst(list node head) {
		Node current= head.next;
		head.next=current.next;
		current.prev=null;
		current.next.prev=head;
		current.next=null;
	}
	
	public void removeLast() {
		//add code here
		Node current= tail.prev;
		tail.prev=current.prev;
		current.next=null;
		//current.next.prev=current.next;
		current.prev.next=tail;
		current.prev=null;
	}
		
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public void remove(int index) {
		
		Node current= head;
		//System.out.println(current.data);
			int counter = 1;
		while(counter-1 != index) {
			current = current.next;
			counter++;
		}
		
		current = current.next;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.prev = null;
		current.next = null;
	}
	
	//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public void traverseForward() {
		Node current = head.next;
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}

	}
	
	public E getData(int index) {    // used this code structure with Index call to generate insert change at Index code
		if(index == -1) {
			return head.data;
		}
		else if(index == -2) {
			return tail.data;
		}
		Node current = head;
		int counter = 1;
		while(counter-1 != index) {
			current = current.next;
			counter++;
		}
		return current.next.data;
	}
	
	
	public void traverseBackward() {
		//TODO: start from tail and print out the list
		Node current = tail.prev;
		while(current.prev != null) {
			System.out.println(current.data);
			current = current.prev;
		}

	}
	
	public static void main(String[] args) {
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<String>();
		//TODO: tests here
//		list.addFirst("John");
//		list.addFirst("Jackie");
//		System.out.println(list.getData(-1));
//		System.out.println(list.getData(0));
//		System.out.println(list.getData(1));
//		System.out.println(list.getData(-2));
		list.addFirst("Thomas");
		list.addFirst("Jackie");
		list.addFirst("John");
		list.add("Ryan", 2);
		list.add("Rambo", 4);    //   inserted at end
		list.traverseForward();
		System.out.println();
		
		list.addLast("Richard");
		list.traverseForward();
		System.out.println();
		
		list.traverseBackward();
		System.out.println();
				
	//	list.traverseForward();
		System.out.println();
		
		System.out.println(list.size());
		System.out.println();
		
		list.removeFirst();
		list.traverseForward();
		System.out.println();
		
		list.removeLast();
		list.traverseForward();
		
		System.out.println();
		list.remove(2);
		list.traverseForward();
		
		System.out.println();
		list.remove(1);
		list.traverseForward();
		
		System.out.println();
		list.change("Jambo", 1);
		list.traverseForward();
		
		System.out.println();
		list.change("Richard", 1);
		list.traverseForward();
	    
			
	}
}
