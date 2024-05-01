package week10.lab;

class Week10App {

	public static void main(String[] args) { // make a new list
		DoublyLinkedList addressBook = new DoublyLinkedList();
		addressBook.insertFirst(53212341212L);
		addressBook.insertFirst(53212341214L);
		addressBook.insertAfter(53212341212L, 53212341213L);
		addressBook.displayForward(); // display list forward*/
		Node edit = addressBook.findKey(53212341214L);
		edit.nameSurname = "Tom Brown";
		edit.email = "a@a.a";
		addressBook.displayForward();
		Node deleted = addressBook.deleteKey(53212341212L);
		addressBook.displayForward();
		System.out.print("deleted:");
		deleted.displayNode();
		System.out.println("");

		addressBook.insertFirst(53212341215L, "John Smith", "j@j.j");
		addressBook.displayForward();
		addressBook.findKey(53212341214L).displayNode();
		// TO DO complete Node.java and DoublyLinkedList.java
		// and remove comments listed below
		addressBook.displayForward();
		System.out.print("deleted:");
		System.out.println("");
		/////////////////////////////////////////////////////////////////////
		// TO DO write the code
		// to update the 53212341213L record with your personal information including
		///////////////////////////////////////////////////////////////////// your GSM
		addressBook.insertFirst(5388270748L, "Azra Ersoz", "azra.ersoz@std.yeditepe.edu.tr");
		////////////////////////////////////////////////////////
		addressBook.displayForward();

	}

}
