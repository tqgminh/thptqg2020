package object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EnglishStudent {
	public String[] score = {"0", "0.2", "0.4", "0.6", "0.8", "1", "1.2", "1.4", "1.6", "1.8", "2", "2.2", "2.4", "2.6", "2.8", "3", "3.2", "3.4", "3.6", "3.8", "4", "4.2", "4.4", "4.6", "4.8", "5", "5.2", "5.4", "5.6", "5.8", "6", "6.2", "6.4", "6.6", "6.8", "7", "7.2", "7.4", "7.6", "7.8", "8", "8.2", "8.4", "8.6", "8.8", "9", "9.2", "9.4", "9.6", "9.8", "10"};
	public int[] number = new int[51];
	
	public EnglishStudent() throws NumberFormatException, IOException {
		File file = new File("data\\EnglishChart.txt");
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
