package comparator;

import java.util.*;

import object.Student;

public class MathComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getMath() == s2.getMath())
			return 0;
		else if (s1.getMath() > s2.getMath())
			return 1;
		else
			return -1;
	}
}
