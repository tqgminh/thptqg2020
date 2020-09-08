package rank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import object.Student;

public class C00Ranking {
	public List<Student> student = new ArrayList<Student>();
	
	public C00Ranking() throws NumberFormatException, IOException {
		File file = new File("data\\C00.txt");
	    InputStream inputStream = new FileInputStream(file);
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	    BufferedReader reader = new BufferedReader(inputStreamReader);
	    String line = "";
	    while((line = reader.readLine()) != null){
	    	String[] feature = line.split("\\s+");
	        Student std = new Student(feature[0], Double.parseDouble(feature[1]), Double.parseDouble(feature[2]), Double.parseDouble(feature[3]), Double.parseDouble(feature[4]), Double.parseDouble(feature[5]), Double.parseDouble(feature[6]), Double.parseDouble(feature[7]), Double.parseDouble(feature[8]), Double.parseDouble(feature[9]), feature[10]);
	        student.add(std);
	    }
	    reader.close();
	}
	
	public static int binarySearch(List<Student> student, double target) {
		int lower = 0, upper = student.size()-1, mid;
		while(lower <= upper) {
			mid = (lower+upper)/2;
			if(student.get(mid).getC00() < target)
				upper = mid-1;
			else if(student.get(mid).getC00() > target)
				lower = mid+1;
			else
				return mid;
		}
		return -1;
	}
	
	public String rankingC00(Student std) {
		//Collections.sort(student, new A00Comparator());
		int here = binarySearch(student, std.getC00());
		System.out.println(here);
		int up = here, down = here;
		while(up >= 0) {
			if(student.get(up).getC00() == std.getC00())
				up--;
			else break;
		}
		while(down <= student.size()-1) {
			if(student.get(down).getC00() == std.getC00())
				down++;
			else break;
		}
		String res = String.format("Bạn xếp thứ %d toàn quốc, có %d thí sinh bằng điểm bạn.", up+2, down-up-1);
		return res;
	}
}
