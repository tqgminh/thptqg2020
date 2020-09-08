package object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PhysicsStudent {
	public String[] score = {"0", "0.25", "0.5", "0.75", "1", "1.25", "1.5", "1.75", "2", "2.25", "2.5", "2.75", "3", "3.25", "3.5", "3.75", "4", "4.25", "4.5", "4.75", "5", "5.25", "5.5", "5.75", "6", "6.25", "6.5", "6.75", "7", "7.25", "7.5", "7.75", "8", "8.25", "8.5", "8.75", "9", "9.25", "9.5", "9.75", "10"};
	public int[] number = new int[41];
	
	public PhysicsStudent() throws NumberFormatException, IOException {
		File file = new File("data\\PhysicsChart.txt");
	    InputStream inputStream = new FileInputStream(file);
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	    BufferedReader reader = new BufferedReader(inputStreamReader);
	    String line = "";
	    int i = 0;
	    while((line = reader.readLine()) != null){
	    	int x = Integer.parseInt(line);
	    	number[i] = x;
	    	i++;
	    }
	    reader.close();
	}
}
