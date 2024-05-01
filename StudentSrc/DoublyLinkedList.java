package week10.lab;

// Additional TO DO
// replace all (assumes non-empty list) with suitable exception 
// for a robust program 

class DoublyLinkedList {

	private Node first; // ref to first item
	private Node last; // ref to last item

	public DoublyLinkedList() {
		first = null; // no items on list yet
		last = null;
	}

	/**
	 * true if no nodes
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * insert at front of list
	 * 
	 * @param Gsm
	 */
	public void insertFirst(long Gsm) {
		Node newNode = new Node(Gsm); // make new node

		if (isEmpty()) // if empty list,
			last = newNode; // newnode <-- last
		else
			first.previous = newNode; // newnode <-- old first
		newNode.next = first; // newnode --> old first
		first = newNode; // first --> newnode
	}

	/**
	 * insert at front of list
	 * 
	 * @param Gsm
	 * @param name
	 * @param email
	 *
	 */
	public void insertFirst(long Gsm, String name, String email) {
		// below ~~~~~~~~~~~~~~~~~ V toDo
		// TO DO
		Node newNode = new Node(Gsm, name, email); // make new node

		if (isEmpty()) 
			last = newNode; 
		
		else
			first.previous = newNode; 
			newNode.next = first; 
		first = newNode;
		// above ~~~~~~~~~~~~~~~~~ A toDo
	}

	

	/**
	 * insert at end of list
	 * 
	 * @param Gsm
	 */
	public void insertLast(long Gsm) {
		Node newNode = new Node(Gsm); // make new node
		if (isEmpty()) // if empty list,
			first = newNode; // first --> newnode
		else {
			last.next = newNode; // old last --> newnode
			newNode.previous = last; // old last <-- newnode
		}
		last = newNode; // newnode <-- last
	}

	/**
	 * delete first node
	 * 
	 * @return
	 */
	public Node deleteFirst() {
		// (assumes non-empty list)
		Node temp = first;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		else
			first.next.previous = null; // null <-- old next
		first = first.next; // first --> old next
		return temp;
	}

	/**
	 * delete last node
	 * 
	 * @return
	 */
	public Node deleteLast() {
		// (assumes non-empty list)
		Node temp = last;
		if (first.next == null) // if only one item
			first = null; // first --> null
		else
			last.previous.next = null; // old previous --> null
		last = last.previous; // old previous <-- last
		return temp;
	}

	/**
	 * insert dd just after key
	 * 
	 * @param key
	 * @param Gsm
	 * @return
	 */
	public boolean insertAfter(long key, long Gsm) {
		// (assumes non-empty list)
		Node current = first; // start at beginning
		while (current.GSM != key) // until match is found,
		{
			current = current.next; // move to next node
			if (current == null)
				return false; // didn't find it
		}
		Node newNode = new Node(Gsm); // make new node

		if (current == last) {
			// if last node
			newNode.next = null; // newnode --> null
			last = newNode; // newnode <-- last
		} else {
			// not last node
			newNode.next = current.next; // newnode --> old next
											// newnode <-- old next
			current.next.previous = newNode;
		}
		newNode.previous = current; // old current <-- newnode
		current.next = newNode; // old current --> newnode
		return true; // found it, did insertion
	}

	/**
	 * delete item w/ given key
	 * 
	 * @param key
	 * @return
	 */
	public Node deleteKey(long key) {
		// (assumes non-empty list)
		Node current = first; // start at beginning
		while (current.GSM != key) // until match is found,
		{
			current = current.next; // move to next node
			if (current == null)
				return null; // didn't find it
		}
		if (current == first) // found it; first item?
			first = current.next; // first --> old next
		else // not first
				// old previous --> old next
			current.previous.next = current.next;

		if (current == last) // last item?
			last = current.previous; // old previous <-- last
		else // not last
				// old previous <-- old next
			current.next.previous = current.previous;
		return current; // return value
	}

	/**
	 * find item w/ given key
	 * 
	 * @param key
	 * @return
	 */
	public Node findKey(long key) {
		// (assumes non-empty list)
		Node current = first; // start at beginning
		while (current.GSM != key) // until match is found,
		{
			current = current.next; // move to next node
			if (current == null)
				return null; // didn't find it
		}
		return current; // return value
	}

	/**
	 * delete item w/ given key
	 * 
	 * @param key
	 * @return
	 */
	public Node findKey(String key) {
		// below ~~~~~~~~~~~~~~~~~ V toDo
		// TO DO
		Node current = first; // start at beginning
		while (current.email != key) // until kmatch is found,
		{
			current = current.next; // move to next node
			if (current == null)
				return null; // didn't find it
		}
		return current; // return value
		// above ~~~~~~~~~~~~~~~~~ A toDo
	}

	public void displayForward() {
		System.out.println("List (first-->last):");
		Node current = first; // start at beginning
		while (current != null) // until end of list,
		{
			current.displayNode(); // display data
			current = current.next; // move to next node
		}
		System.out.println("");
	}

	public void displayBackward() {
		System.out.println("List (last-->first):");
		Node current = last; // start at end
		while (current != null) // until start of list,
		{
			current.displayNode(); // display data
			current = current.previous; // move to previous node
		}
		System.out.println("");
	}
}