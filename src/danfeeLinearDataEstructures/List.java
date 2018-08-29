package danfeeLinearDataEstructures;

public class List<Q> implements DanfeeSimpleLinkedList<Q>, DanfeeStack<Q> {

	/**
	 * Size indicates Structure's size
	 */
	private int size;

	/**
	 * First can indicates the first element in a simple linked list; Head, in queue
	 * or Top in stack
	 */
	private Node<Q> first;

	/**
	 * OverFlow is an specific attribute for stack. it indicates what is the maximum
	 * size for stack
	 */
	private int overFlow;

	/**
	 * HasOverFlow indicate if the data structure size has an overflow.
	 */
	private boolean hasOverFlow;

	public List() {
		this.first = null;
		this.size = -1;
	}

	// TODO SIMPLE LINKED LIST
	// ----------------------------------------------------------------------------
	// -----------------------------SIMPLE LINKED LIST-----------------------------
	// ----------------------------------------------------------------------------
	@Override
	public void add(Q object) {

		// TODO Test it
		this.size++;
		Node newNode = new Node<Q>(object, null);
		if (first == null) {
			first.setNext(newNode);
		} else {
			Node next = first;
			while (next != null) {
				next = next.getNext();

				if (next == null) {
					next = newNode;
				}
			}
		}
	}

	@Override
	public void remove(int index) throws ArrayIndexOutOfBoundsException {
		// TODO Test it

		if (this.size < index) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		int i = 0;
		Node previous = null;
		Node head = first;
		Node Next = null;
		while (i++ <= index) {
			previous = head;
//			head = 
		}

	}

	@Override
	public void get(int index) {
		// TODO Auto-generated method stub

	}

	// TODO STACK
	// ---------------------------------------------------------------
	// -----------------------------STACK-----------------------------
	// ---------------------------------------------------------------

	@Override
	public void push(Q value) throws Exception {

		if (hasOverFlow && isFull()) {
			throw new Exception ("Stack gets overFlow");
		} else {
			// grow stack's size
			size++;
			// create a new node. its "next" relation is the, actually, first node
			Node<Q> newNode = new Node<Q>(value, first);
			// Assign that new node as first node.
			first = newNode;
		}
	}

	@Override
	public Q pop() throws Exception {

		Q value = null;
		if (isEmpty()) {
			throw new Exception("Stack gets under flow");
		} else {
			// Decrease stack's size
			size--;
			// assign the value to return
			value = first.getVal();
			// To remove first node
			first = first.getNext();
		}

		return value;
	}

	// TODO preguntar si uno debe controlar las excepciones aqui, por ejemplo, si es
	// vacio uno deberia enviar una excepcion que diga que esta vacio o un null
	// pointer pero eso se debe hacer aqui?
	@Override
	public Q peek() throws Exception {
		
		if (isEmpty()) {
			
			throw new Exception("Stack is empty");
			
		} else {
			return first.getVal();
		}
	}

	@Override
	public boolean isFull() {
		boolean isFull = false;

		if (hasOverFlow && size == overFlow)
			isFull = true;
		return isFull;
	}

	@Override
	public boolean isEmpty() {
		return size == -1;
	}

	@Override
	public void setOverFlow(int overFlow) {
		this.overFlow = overFlow;

	}

	@Override
	public void setHasOverFlow(boolean hasOverFlow) {
		this.hasOverFlow = hasOverFlow;

	}

	@Override
	public boolean hasOverFlow() {
		return this.hasOverFlow;
	}

	@Override
	public int getOverFlow() {
		return this.overFlow;
	}

	@Override
	public void toAbleOverFlow(int overflow) {
		hasOverFlow = true;

	}

	@Override
	public void toDisableOverFlow() {
		hasOverFlow = false;
	}

}
