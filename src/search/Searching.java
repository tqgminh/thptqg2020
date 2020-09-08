package search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import object.Student;


public class Searching {
	
	public List<Student> student = new ArrayList<Student>();
	
	public Searching() throws NumberFormatException, IOException {
		for(int i = 1; i <= 64; i++) {
			File file = new File("data\\"+parseMaSoGD(i)+".txt");
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
	}
	
	public Searching(String maNN) throws NumberFormatException, IOException {
		for(int i = 1; i <= 64; i++) {
			File file = new File("data\\"+parseMaSoGD(i)+".txt");
	        InputStream inputStream = new FileInputStream(file);
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	        BufferedReader reader = new BufferedReader(inputStreamReader);
	        String line = "";
	        while((line = reader.readLine()) != null){
	            String[] feature = line.split("\\s+");
	            Student std = new Student(feature[0], Double.parseDouble(feature[1]), Double.parseDouble(feature[2]), Double.parseDouble(feature[3]), Double.parseDouble(feature[4]), Double.parseDouble(feature[5]), Double.parseDouble(feature[6]), Double.parseDouble(feature[7]), Double.parseDouble(feature[8]), Double.parseDouble(feature[9]), feature[10]);
	            if(std.getCodeForeignerLanguage().compareTo(maNN) == 0)
	            	student.add(std);
	        }
	        reader.close();
		}
	}
	
	public static double parsePoint(String point) {
		if(point.compareTo("-") == 0)
			return 0; 
		return Double.parseDouble(point);
	}
	
	public static String parseSBD(int sbd) {
		if(sbd < 10000000)
			return "0"+Integer.toString(sbd);
		else
			return Integer.toString(sbd);
	}
	
	public static String parseMaSoGD(int ma) {
		if(ma < 10)
			return "0"+Integer.toString(ma);
		else
			return Integer.toString(ma);
	}
	
	public boolean testIdentification(String sobaodanh) {
		if(sobaodanh.length() != 8)
			return false;
		else {
			for(int i = 0; i < sobaodanh.length(); i++) {
				if(sobaodanh.charAt(i) > '9' || sobaodanh.charAt(i) < '0')
					return false;
			}
			return true;
		}
	}
	
	public static int binarySearch(List<Student> student, String target) {
		int lower = 0, upper = student.size()-1, mid;
		while(lower <= upper) {
			mid = (lower+upper)/2;
			if(student.get(mid).getIdentification().compareTo(target) > 0)
				upper = mid-1;
			else if(student.get(mid).getIdentification().compareTo(target) < 0)
				lower = mid+1;
			else
				return mid;
		}
		return -1;
	}
	
	public Student searchStudent(String sobaodanh) throws NumberFormatException, IOException {
		if(testIdentification(sobaodanh)) {
			if(binarySearch(student, sobaodanh) == -1) {
				System.out.println("Khong tim thay so bao danh "+sobaodanh);
				return null;
			}
			else
				return student.get(binarySearch(student, sobaodanh));
		}
		else {
			System.out.println("So bao danh khong hop le "+sobaodanh);
			return null;
		}
	}
	
	
}
