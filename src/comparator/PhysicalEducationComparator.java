package comparator;

import java.util.Comparator;

import object.Student;

public class PhysicalEducationComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getPhysicalEducation() == s2.getPhysicalEducation())
			return 0;
		else if (s1.getPhysicalEducation() > s2.getPhysicalEducation())
			return 1;
		else
			return -1;
	}
}