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

	public SLList(int i){
		first = new IntNode(i, null);
	}

	public void addFirst(int x){
		first = new IntNode(x, first);
	}

	public void addLast(int x){
		IntNode p = first;
		// int size = this.size();
		// for(int i =0; i < size - 1; i++){
		// 	p = p.next;
		// }
		while(p.next != null){
			p = p.next;
		}
		p.next = new IntNode(x, null);
	}

	public int size(){
		IntNode p = first;
		int size = 0;
		while(p != null){
			size += 1;
			p = p.next;
		}
		return size;
	}

	/** convention */
	// private static int size(IntNode p){
	// 	if(p.next == null){
	// 		return 1;
	// 	}
	// 	return 1 + size(p.next);
	// }

	public int getFirst(){ 
		return first.item;
	}

	public static void main(String[] args){
		SLList a = new SLList(4);
		a.addFirst(5);
		a.addFirst(9);
		a.addLast(6);
		// System.out.println(a.first.item);
		// System.out.println(a.first.next);
		System.out.println(a.getFirst());

		System.out.println(a.size());
		System.out.println(a.getFirst());
		System.out.println(a.first.next.item);
		System.out.println(a.first.next.next.item);
		System.out.println(a.first.next.next.next.item);


	}
}