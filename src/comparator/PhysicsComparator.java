package comparator;

import java.util.*;

import object.Student;

public class PhysicsComparator implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		if (s1.getPhysics() == s2.getPhysics())
			return 0;
		else if (s1.getPhysics() > s2.getPhysics())
			return 1;
		else
			return -1;
	}
}
