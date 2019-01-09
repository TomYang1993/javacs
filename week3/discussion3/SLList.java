public class SLList {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}

		
	}

	private IntNode first;

	public void addFirst(int x) {
		first = new IntNode(x, first);
	}

	public void insert(int item, int position){
		if(first == null){
			addFirst(item);
			return;
		}
		IntNode currentNode = first;
		IntNode prev = first;
		while(position != 0 && currentNode != null){
			prev = currentNode;
			currentNode = currentNode.next;
			position--;
		}
		prev.next = new IntNode(item, currentNode);

	}

	public void reverse(){
		
		/** don't care about the first field, using two pointers to track nodes
		one is front, one is nextnode
		once remainder node reference is held, just assign nextnode's next field refrence to front
		remainder node is kept and order is right, then increase nextnode and front by one position and repeat
		*/

		IntNode front = null;
		IntNode nextNode = first;
		while(nextNode != null){
			/** hold reference */
			IntNode remainder = nextNode.next;

			/** the key step in the whole function*/
			nextNode.next = front;

			/** increase steps */
			front = nextNode;

			nextNode = remainder;
		}
		first = front;
	}


	public IntNode reverse(IntNode x){

		if(x == null || x.next == null){

			return x;
		}
		IntNode reversed = reverse(x.next);
		x.next.next = x;
		x.next = null;
		return reversed;
	}


	public void reverse(IntNode x){
		first = reverse(first);
	}

}
