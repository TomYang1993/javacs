public class IntNode{
	public int item;
	public IntNode next;

	public IntNode(int i, IntNode n){
		item = i;
		next = n;
	}

	public void addAdjacent(){
		IntNode p = this;

		if(p == null){
			return;
		}

		IntNode r = p;

		while(r.next != null){

			if(r.item == r.next.item){
				r.next = r.next.next;
				r.item = r.item * 2;
				r = p;
			}
			else{
				r= r.next;
			}
		}
	}

	public static void main(String[] args){
		IntNode temp = new IntNode(5, null);
		temp = new IntNode(6, temp);
		temp = new IntNode(4, temp);
		temp = new IntNode(2, temp);
		temp = new IntNode(1, temp);
		temp = new IntNode(1, temp);
		temp = new IntNode(2, temp);

		temp.addAdjacent();

		System.out.println(temp.item);
		System.out.println(temp.next.item);
		System.out.println(temp.next.next.item);
		System.out.println(temp.next.next.next.item);
		System.out.println(temp.next.next.next.next.item);


	}
}

	