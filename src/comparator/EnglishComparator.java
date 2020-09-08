package comparator;

import java.util.Comparator;

import object.Student;

public class EnglishComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getForeignerLanguage() == s2.getForeignerLanguage())
			return 0;
		else if (s1.getForeignerLanguage() > s2.getForeignerLanguage())
			return 1;
		else
			return -1;
	}
}