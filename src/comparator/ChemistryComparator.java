package comparator;

import java.util.*;

import object.Student;

public class ChemistryComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getChemistry() == s2.getChemistry())
			return 0;
		else if (s1.getChemistry() > s2.getChemistry())
			return 1;
		else
			return -1;
	}
}