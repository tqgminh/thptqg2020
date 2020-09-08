package comparator;

import java.util.Comparator;

import object.Student;

public class BiologyComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getBiology() == s2.getBiology())
			return 0;
		else if (s1.getBiology() > s2.getBiology())
			return 1;
		else
			return -1;
	}
}
