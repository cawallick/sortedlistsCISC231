//Tyler Reiland and Kat Wallick

public interface StudentList{

	/**
	adds the student with the given name and ID to the StudentList.

		@param name the name of the student to be added
		@param studentID the ID of the student to be added

		@return true, if the student was successfully added to the list, false otherwise.
	*/
	public boolean addStudent(String name, int studentID);

	/**
	Output the contents of the list.

		@return A string that when printed gives a "nice" list of all the students and
		student IDs (i.e., don't string them together on one line without spaces).
	*/
	public String prettyStr();

	/**
	removes the student from the StudentList.

			@param studentID the student ID of the student to be removed

			@return the name of the studentif the student was successfully removed from the list, null otherwise.
	*/
	public String  removeStudent(int studentID);

	/**
	retrieves the name of a student associated with the given student ID.

		@param studentID an integer representing a student's ID

		@return A string containg the student's name, null otherwise

	*/
	public String  studentLookup(int studentID);



}