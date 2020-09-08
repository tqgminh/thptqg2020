package object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class D01Student {
	public String[] score = new String[30];
	public int[] number = new int[30];
	
	public D01Student() throws NumberFormatException, IOException {
		for(int i = 0; i < 30; i++)
			score[i] = "<="+Integer.toString(i+1);
		File file = new File("data\\D01Chart.txt");
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
