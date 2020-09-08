package comparator;

import java.util.Comparator;

import object.Student;

public class GeographyComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getGeography() == s2.getGeography())
			return 0;
		else if (s1.getGeography() > s2.getGeography())
			return 1;
		else
			return -1;
	}
}