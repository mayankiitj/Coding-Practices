package QnA;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
*/
import java.util.*;


class string {
    public static void main(String args[] ) throws Exception {
       String[] format_code = new String[5];  
		Map<String, Integer> store_req = new HashMap<String, Integer>();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {

			String input = s.nextLine();
			if(input.startsWith("Started")){
				System.out.println(input);
				String[] tokens = input.split(" ");
				if(store_req.get(tokens[1])!=null){
					store_req.put(tokens[1],store_req.get(tokens[1])+1);
				}
				else{
					store_req.put(tokens[1],1);
				}
				tokens[2] = tokens[2].substring(1, tokens[2].length()-1);
				if(store_req.get(tokens[2])!=null){
					store_req.put(tokens[2],store_req.get(tokens[2])+1);
				}
				else{
					store_req.put(tokens[2],1);
				}
				if(store_req.get(tokens[4])!=null){
					store_req.put(tokens[4],store_req.get(tokens[4])+1);
				}
				else{
					store_req.put(tokens[4],1);
				}
			}
			else if(input.contains("Processing")){
				String[] tokens = input.split(" ");
				String format = tokens[tokens.length-1];
				if(format.equalsIgnoreCase("as")){
					if(store_req.get("HTML")!=null){
						store_req.put("HTML",store_req.get("HTML")+1);
					}
					else{
						store_req.put("HTML", 1);
					}
				}
				else{
					if(store_req.get(format)!=null){
						store_req.put(format,store_req.get(format)+1);
					}
					else{
						store_req.put(format, 1);
					}
				}
			}
			else if(input.startsWith("Completed")){
				String[] tokens = input.split(" ");
				if(store_req.get(tokens[1])!=null){
					store_req.put(tokens[1],store_req.get(tokens[1])+1);
				}
				else{
					store_req.put(tokens[1], 1);
				}
			}
			else if (input.startsWith("********")){
				int count=0;
				while(s.hasNext()){
					format_code[count]=s.nextLine().split(" ")[0];
					count++;
				}
			}
			

		}
        for(int i=0;i<5;i++){
            if(store_req.get(format_code[i])!=null){
                System.out.println(store_req.get(format_code[i]));
            }
            else{
                System.out.println(0);
            }
            
        }
       
       }
}
