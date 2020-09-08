package comparator;

import java.util.*;

import object.Student;

public class HistoryComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getHistory() == s2.getHistory())
			return 0;
		else if (s1.getHistory() > s2.getHistory())
			return 1;
		else
			return -1;
	}
}
