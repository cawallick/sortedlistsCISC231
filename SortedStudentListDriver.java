/**

A class to test the SortedStudentList

@author YOUR NAME HERE


*/


public class SortedStudentListDriver{

	public static void main(String[] args){

		StudentList list = new SortedStudentList();

		String[] names = new String[]{"Cat", "Dog", "Hamster", "", null};
		Integer[] id = new Integer[]{1234, 0, -3145, 1234, 12};
		//Tests studentLookup on a non-existing student

		System.out.print("Adding 3 expected values of Names and ID's to list (with one negative ID and one zero), followed by an empty name then a null name.\nExpected: true, true, true, false, false. Actual: ");
		for(int i=0; i<names.length; i++){
			System.out.print(list.addStudent(names[i], id[i])+" ");
			System.out.println(list.prettyStr());
		}
		System.out.println("\n");

		System.out.println("Expecting list to contain: Cat, Dog Hamster. prettyStr() to check: ");

		System.out.println(list.prettyStr());

		list.removeStudent(0);
		System.out.println("After removing one ID, we expect the list to contain only Cat and Hamster. prettyStr() to check: ");
		System.out.println(list.prettyStr());

		System.out.print("After removing the ID we try removing it again. Expect: null Actual: ");
		System.out.println(list.removeStudent(0));
		System.out.println();

		System.out.print("StudentLookup on a non-existing student. Expected: null. Actual: ");
		System.out.println(list.studentLookup(314));
		System.out.println();

		System.out.print("StudentLookup on an existing student. Expected: Cat. Actual: ");
		System.out.println(list.studentLookup(1234));
		System.out.println();

		list.removeStudent(1234);
		list.removeStudent(-3145);
		System.out.println("After removing all the students to make the list empty we use prettyStr() to check (stars to mark): ");
		System.out.println("*" + list.prettyStr() + " *");
		System.out.println();

		System.out.print("Now that the list is empty, we try to remove a student again. Expect: null. Acutal: ");
		System.out.println(list.removeStudent(12));
		System.out.println();

	}//main

}//class