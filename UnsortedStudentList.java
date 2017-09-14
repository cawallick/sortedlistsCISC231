
/**

Represents an unsorted list of Students, identified by their name and ID

@author YOUR NAME HERE


*/

public class UnsortedStudentList implements StudentList{

	private Integer[] studentID;
	private String[] studentName;

	public UnsortedStudentList(){
		Integer[] studentID = new Integer[0];
		String[] studentName= new String[0];

		this.studentID=studentID;
		this.studentName=studentName;
	}//constructor

	public boolean addStudent(String name, int studentID){
		if(name==null||name==""){
			//System.out.println("input does not contain a name");
			return false;
		}
		Integer[] newID = new Integer[this.studentID.length +1];
		String[] newName = new String[this.studentName.length +1];
		for( int k=0; k<this.studentID.length ; k++){
			if (this.studentID[k] == studentID){
				return false;
			}
		}
		for( int i=0; i<this.studentID.length ; i++){
			newID[i]=this.studentID[i];
		}
		for(int j=0; j<this.studentName.length; j++){
			newName[j]= this.studentName[j];
		}
		//creating new arrays and giving them the same inputs as the previous ones.

		newID[this.studentID.length]=studentID;
		newName[this.studentName.length]=name;
		this.studentID=newID;
		this.studentName=newName;
		return true;
		//setting the new arrays to be the current instance variable arrays.
	}//addStudent

	public String prettyStr(){
		String prettyString="";
		for(int i=0; i<this.studentID.length; i++){
			prettyString= prettyString+this.studentName[i]+" "+this.studentID[i]+'\n';
		}
		return prettyString;
	}//prettyStr

	public String  removeStudent(int studentID){
		int count = 0;
		boolean targetNotReached = true;
		boolean boundsGood = true;

		if(this.studentID.length < 1){return null;}
		//count will hold the index where the student is found
		//targetNotReached will be false when the student is found
		//boundsGood ensures that we only check legal bounds

		String[] newStudent = new String[this.studentName.length-1];
		Integer[] newID = new Integer[this.studentID.length-1];
		String savedName;


		while(targetNotReached&&boundsGood){
			if(this.studentID[count] == studentID){
				targetNotReached = false;
			}
			else{
				count = count + 1;
			}
			if(count>=this.studentID.length){
				boundsGood=false;
			}
		}
		if(!boundsGood){
			return null;
		}
		for(int i=0; i<this.studentID.length; i++){
			if(i<count){
				newStudent[i]=this.studentName[i];
				newID[i]=this.studentID[i];
			}
			if(i>count){
				newStudent[i-1]=this.studentName[i];
				newID[i-1]=this.studentID[i];
			}
		}
		//initializing new arrays that do not contain the target

		savedName = this.studentName[count];
		this.studentID = newID;
		this.studentName = newStudent;
		return savedName;
	}//removeStudent

	public String  studentLookup(int studentID){
		int count = 0;
		boolean targetNotReached = true;
		boolean boundsGood = true;

		while(targetNotReached&&boundsGood){
			if(this.studentID[count] == studentID){
				targetNotReached = false;
			}
			else{
				count = count + 1;
			}
			if(count>=this.studentID.length){
				boundsGood=false;
			}
		}
		if(!boundsGood){
			return null;
		}

		return this.studentName[count];
	}//studentLookup

}//UnsortedStudentList