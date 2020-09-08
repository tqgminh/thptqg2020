package comparator;

import java.util.*;

import object.Student;

public class LiteratureComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getLiterature() == s2.getLiterature())
			return 0;
		else if (s1.getLiterature() > s2.getLiterature())
			return 1;
		else
			return -1;
	}
}