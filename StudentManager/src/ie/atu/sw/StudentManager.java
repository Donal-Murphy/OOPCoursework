package ie.atu.sw;

public class StudentManager {
	private static final int INITIAL_CAPACITY = 10;
	private Student[] student = null;
	
	public StudentManager() {
		student = new Student[INITIAL_CAPACITY];
	}

	public void add(Student s) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {
				student[i] = s;
				return;
			}
		}
		int index = getExpandedIndex();
		student[index] = s;
	}
	
	private int getExpandedIndex() {
		Student[] temp = new Student[student.length * 2];
		for (int i = 0; i < student.length; i++) {
			temp[i] = student[i];
		}
		int index = student.length;
		student = temp; 
		return index;
	}
	
	public boolean delete(String sid) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].sid().equals(sid)) {
				student[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public Student getStudentbyID(String sid) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].sid().equals(sid)) {
				return student[i];
			}
		}
		return null;
	}
	
	public Student[] getStudentsByFirstName(String firstname) {
		//Count the number of matches and create an array of the right size
		int matches = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].firstname().equals(firstname)) {
				matches ++;
			}
		}
		
		//Copy all of the matches into a new array
		Student[] temp = new Student[matches];
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			if (student[i] != null && student[i].firstname().equals(firstname)) {
				temp[index] = student[i];
				index++;
			}
		}
		
		return temp;
	}
	
	public int size() {
		int total = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null) total++;
		}
		return total;
	}
}
