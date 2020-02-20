public class SwedishIDmain {
	public static void main(String[] args) {
		SwedishID id1 = new SwedishID("19270414-4506");
		SwedishID id2 = new SwedishID("19270414-8671");
		SwedishID id3 = new SwedishID("19801214-7727");
		SwedishID id4 = new SwedishID("19811218-9876");
		SwedishID id5 = new SwedishID("19770525-1111");
		System.out.print(id1.showID() + " is a ");
		if(id1.isFemale())
			System.out.println("female.");
		else
			System.out.println("male.");
		System.out.print(id2.showID() + " is a ");
		if(id2.isFemale())
			System.out.println("female.");
		else
			System.out.println("male.");
		if(id1.comparedTo(id2) == 0)
			System.out.println("Yes, " + id1.showID() + " and " + id2.showID() + " are the same.");
		if(id1.comparedTo(id3) < 0)
			System.out.println(id1.showID() + " is older than " + id3.showID());
		if(id3.comparedTo(id1) > 0)
			System.out.println(id3.showID() + " is younger than " + id1.showID());
		if(id1.validID())
			System.out.println(id1.showID() + " is valid");
		else
			System.out.println(id1.showID() + "is not valid");
		if(id4.validID())
			System.out.println(id4.showID() + " is valid");
		else
			System.out.println(id4.showID() + " is not valid");
		if(id5.validID())
			System.out.println(id5.showID() + " is valid");
		else
			System.out.println(id5.showID() + " is not valid");
	}

}
