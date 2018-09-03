package danfeeLinearDataEstructures;

public class List<Q> implements DanfeeSimpleLinkedList<Q>, DanfeeStack<Q>, DanfeeQueue<Q> {

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
		this.size++;
		Node<Q> newNode = new Node<Q>(object, first);
		this.first = newNode;
	}

	@Override
	public void insertAt(Q object, int index) throws Exception {

		if (index == 0) {

			Node<Q> headNode = new Node<Q>(object, first);
			this.first = headNode;

		} else {
			if (index > size || index < 0) {
				throw new ArrayIndexOutOfBoundsException(index);
			} else {
				Node<Q> previousNode = first;
				Node<Q> headNode = first.getNext();
				for (int i = 1; i <= index; i++) {
					previousNode = headNode;
					headNode = headNode.getNext();
				}
				previousNode.setNext(new Node<Q>(object, headNode));
			}
		}

	}

	@Override
	public void remove(int index) throws Exception {
		
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		} else if (this.size < index) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
			Node<Q> previousNode = first;
			Node<Q> headNode = first.getNext();
			for (int i = 1; i <= index; i++) {
				previousNode = headNode;
				headNode = headNode.getNext();
			}
			previousNode.setNext(headNode.getNext());
		}
	}

	@Override
	public Q get(int index) throws Exception {

		if (this.isEmpty()) {
			throw new Exception("List is empty()");
		} else if (index > size || index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		int i = 0;
		Q val = null;
		Node<Q> temp = first;

		while (i++ <= index) {
			val = first.getVal();
			temp = temp.getNext();
		}

		return val;
	}

	// TODO STACK
	// ---------------------------------------------------------------
	// -----------------------------STACK-----------------------------
	// ---------------------------------------------------------------

	@Override
	public void push(Q value) throws Exception {

		if (hasOverFlow && isFull()) {
			throw new Exception("Stack gets overFlow");
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

	@Override
	public int getSize() {
		return size + 1;
	}

	// TODO QUEUE
	// ---------------------------------------------------------------
	// -----------------------------QUEUE-----------------------------
	// ---------------------------------------------------------------
	
	@Override
	public void enQueue(Q object) {
		Node <Q> node = new Node<Q> (object, this.first);
		first = node;
		size++;
	}

	@Override
	public Q deQueue() throws Exception {
		// TODO Auto-generated method stub
		if(this.isEmpty())
		{
			throw new Exception("List is empty");
		}else{
			Node <Q> nextNode = first.getNext();
			Q val = first.getVal();
			first = nextNode;
			return val;
		}
		
	}

}
