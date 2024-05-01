package week10.lab;

class Node {

	public String nameSurname; // data item
	public long GSM; // data item
	public String email; // data item
	public Node next; // next node in list
	public Node previous; // previous node in list

	public Node(long Gsm) {
		GSM = Gsm;
	}

	public Node(long Gsm, String Name, String Email) {
		System.out.println("hello");
		// below ~~~~~~~~~~~~~~~~~ V toDo
		// TODO Here
		this.GSM = Gsm;
		this.nameSurname = Name;
		this.email = Email;
		// above ~~~~~~~~~~~~~~~~~ A toDo
	}

	public void displayNode() {
		System.out.println(nameSurname + " " + GSM + " " + email);
	}

}
