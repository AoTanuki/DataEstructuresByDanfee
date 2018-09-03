package danfeeLinearDataEstructures;
public class Node<S> {

	private S val;
	private Node<S> next;
	
	public Node(S val, Node<S> next) {
		super();
		this.val = val;
		this.next = next;
	}

	public S getVal() {
		return val;
	}

	public void setVal(S val) {
		this.val = val;
	}

	public Node<S> getNext() {
		return next;
	}

	public void setNext(Node<S> next) {
		this.next = next;
	}
	
	
}
