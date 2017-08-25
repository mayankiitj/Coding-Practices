package QnA;

import java.io.File;
import java.util.Scanner;

public class PrintArrayByIndex {
	public static void main(String[] args) {
		try {
			String folder = "folder_location";
			File f = new File(folder+"1.txt");
			Scanner s = new Scanner(f);
			String[] array = new String[5];
			
			//making result string empty (initially array is null
			for(int i=0;i<array.length;i++)
				array[i] = "";
			while (s.hasNext()) {
				//scanning each line
				String line = s.nextLine();
				//spliting by closing bracket
				String arraysInLine[] = line.split("}");
				for (String index : arraysInLine) {
					//for each array removing brackets
					index = index.replaceAll("[{}]", "");
					//for counting index of particular array
					int countIndex =0;
					//for each array splitting each element by ,
					String[] data = index.split(","); 
					for (int i = 0; i < data.length; i++) {
						if(data[i] == null ||data[i].isEmpty())
							continue;
						//adding each element in array at index countIndex to resultant array as string
						array[countIndex] += data[i] + ",";
						countIndex++;
					}
				}
			}
			System.out.print(array[0]);
			// Close the input stream
			s.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
