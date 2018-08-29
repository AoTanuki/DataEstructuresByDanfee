package danfeeLinearDataEstructures;
public class List <Q> implements DanfeeSimpleLinkedList<Q> {

	private int size;
	private Node <Q> first;
	
	public List()
	{
		this.first= null;
		this.size = -1;
	}
	
	
	@Override
	public void add(Q object) {
		
		//TODO Test it
		this.size++;
		Node newNode = new Node<Q>(object, null);
		if(first == null)
		{
			first.setNext(newNode);
		}else
		{
			Node next = first;
			while(next!=null)
			{
				next = next.getNext();
				
				if(next == null)
				{
					next = newNode;
				}
			}
		}
	}

	@Override
	public void remove(int index) throws ArrayIndexOutOfBoundsException {
		// TODO Test it
		
		if(this.size<index)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		int i = 0;
		Node previous = null;
		Node head = first;
		Node Next = null;
		while (i++<=index)
		{
			previous = head;
//			head = 
		}
		
	}

	@Override
	public void get(int index) {
		// TODO Auto-generated method stub
		
	}

}
