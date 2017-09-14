/**

Represents a list of Students sorted by student ID, identified by their name and ID

@author Tyler Reiland and Kat Wallick


*/

public class SortedStudentList implements StudentList{

	private Integer[] studentID;
	private String[] studentName;

	public SortedStudentList(){
			Integer[] studentID = new Integer[0];
			String[] studentName= new String[0];

			this.studentID=studentID;
			this.studentName=studentName;
	}//constructor

	public boolean addStudent(String name, int studentID){
			if(name==null||name==""){
				return false;
			}

			int count = 0;
			//boolean notAdded = true;
			Integer[] newID = new Integer[this.studentID.length +1];
			String[] newName = new String[this.studentName.length +1];

			//checks if student ID already exists, and if it does, returns false
			boolean added=false;

			for(int i=0; i<this.studentID.length; i++){
				if(this.studentID[i]<studentID)
				{
					newID[i]=this.studentID[i];
					newName[i]=this.studentName[i];
				}
				if(studentID==this.studentID[i])
				{
					return false;
				}
				if(studentID<this.studentID[i]&&added==false)
				{
					added=true;
					newID[i]=studentID;
					newName[i]=name;
					newID[i+1]=this.studentID[i];
					newName[i+1]=this.studentName[i];
				}
				if(studentID<this.studentID[i]&&added==true)
				{
					newID[i+1]=this.studentID[i];
					newName[i+1]=this.studentName[i];
				}
			}
			if(added==false)
			{
				newName[newName.length-1]=name;
				newID[newID.length-1]=studentID;
			}




			/*
			while(count<newName.length && notAdded){
				if(this.studentID.length < 1){
					newID[0] = studentID;
					newName[0] = name;
					notAdded = false;
				}
				else{
					if(count<this.studentID.length){
						if(studentID < this.studentID[count]){
							newID[count] = this.studentID[count];
							newName[count] = this.studentName[count];
							count = count + 1;
						}
						else{
							newID[count] = studentID;
							newName[count] = name;
							notAdded = false;
						}
					}
				}
			}
			if(count==newName.length)
			{
				newID[count]=studentID;
				newName[count]=name;
			}
			else
			{
				//copies the instance variable arrays until the point where the new one is added
				for(int l=count; l<this.studentID.length; l++){
					newID[count] = this.studentID[count];
					newName[count] = this.studentName[count];
				}
				//copies the instance variable arrays after the new entry

			}
			*/
			this.studentID=newID;
			this.studentName=newName;
			return true;
			//adding the new ID to the end and setting the new arrays to be the current instance variable arrays.

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
}//SortedStudentList