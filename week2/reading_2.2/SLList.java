public class SLList{
	private class IntNode{
		public int item;
		public IntNode next;
	
		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}
	

	public IntNode first;
	private int size;

	/** method for creating empty list though has edge cases when addLast method was used, NullPointerException */
	public SLList(){
		first = null;
		size = 0;
	}

	public SLList(int i){
		first = new IntNode(i, null);
		size = 1;
	}

	public void addFirst(int x){
		first = new IntNode(x, first);
		size += 1;
	}

	public void addLast(int x){

		if(first == null){
			first = new IntNode(x, null);
			return;
		}

		IntNode p = first;
		// int size = this.size();
		// for(int i =0; i < size - 1; i++){
		// 	p = p.next;
		// }
		while(p.next != null){
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;

	}

	/** size method 1. hacky way */
	// public int size(){
	// 	IntNode p = first;
	// 	int size = 0;
	// 	while(p != null){
	// 		size += 1;
	// 		p = p.next;
	// 	}
	// 	return size;
	// }


	/** size method 2. works but not efficient */
	// public int size(){
	// 	return size(first);
	// }

	/** convention helper method*/
	// private static int size(IntNode p){
	// 	if(p.next == null){
	// 		return 1;
	// 	}
	// 	return 1 + size(p.next);
	// }

	public int getFirst(){ 
		return first.item;
	}

	/** using caching method, oop programming, everything is controlled by object  */
	public int size(){
		return size;
	}

	public static void main(String[] args){


		SLList a = new SLList();
		a.addLast(4);
		a.addFirst(5);
		a.addFirst(9);
		a.addLast(6);
		// System.out.println(a.first.item);
		// System.out.println(a.first.next);

		System.out.println(a.size());
		System.out.println(a.getFirst());
		System.out.println(a.first.item);
		System.out.println(a.first.next.item);
		System.out.println(a.first.next.next.item);
		System.out.println(a.first.next.next.next.item);

	}
}