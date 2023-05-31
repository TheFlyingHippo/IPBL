package windmillcomplete;

import java.io.*;

public class IO {
 private int[] windSpeeds;

public IO(String file) {
	try {
		String line="";
		String [] splitValues = null;
		int speeds [] = new int[100000];
		BufferedReader br = new BufferedReader(new FileReader(file));
		int count = 0;
		while((line = br.readLine()) != null) {
			String [] values  = line.split(",");
			if(values.length < 19) {
				continue;
			}
			splitValues  = values[19].split("\"");
			if (count != 0) {
			speeds[count-1] =  Integer.parseInt(splitValues[1]);
			}
			count++;
		}
		windSpeeds = new int[count];
		for(int i = 0; i<count ; i++) {
			windSpeeds[i] = speeds[i];
		}
		
		
	}
	
	catch(Exception ex) {
		System.out.println(ex);
	}
}

public int[] getWindSpeeds() {
	return windSpeeds;
}


 
 
}
