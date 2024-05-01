package week10.lab;

class Tree {

	public String ASD; // data item
	public long GSM; // data item
	public String mail; // data item
	public Node next; // next node in list
	public Node previous; // previous node in list

	public Tree(long Gsm) {
		GSM = Gsm;
	}

	public Tree(long Gsm, String Name, String Email) {
		System.out.println("hello");
		// below ~~~~~~~~~~~~~~~~~ V toDo
		// TODO Here

		// above ~~~~~~~~~~~~~~~~~ A toDo
	}

	public void displayNode() {
		System.out.println(nameSurname + " " + GSM + " " + email);
	}

}
