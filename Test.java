package QnA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Test {
	public static void main(String args[]) throws ParseException, FileNotFoundException {
		Map<Long, Long> pair = new HashMap<Long, Long>();
		File file = new File("/home/local/NEXTEDUCATION/mayankagrawal/Syllabus.csv");
		InputStream objectData = new FileInputStream(file);
		BufferedReader br = null;

		int count = 0;

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(objectData));
			while ((line = br.readLine()) != null) {
				if (!line.split(",")[1].equals("NULL")  && line.split(",")[1] != null)
					pair.put(Long.parseLong(line.split(",")[0]), Long.parseLong(line.split(",")[1]));
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("LN Syllabus table Count " + count);

		System.exit(0);
		System.out.println("HH:MM".substring(3, 5));
		List<Integer> l = new ArrayList<>();
		l.set(3, 4);
		l.set(1, 2);
		for (int i : l)
			System.out.println(i);

		System.exit(0);

		Stack<Character> st = new Stack<Character>();
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			String input = s.next();

			int c = 0;
			for (int i = input.length() - 1; i >= 0; i--) {
				if (input.charAt(i) == '[') {
					String r = "";
					while (st.peek() != ']') {
						r += st.pop();
					}
					String temp = "";
					while (i >= 1 && input.charAt(i - 1) >= 48 && input.charAt(i - 1) <= 57) {
						temp += input.charAt(i - 1);
						i--;
					}
					c = Integer.parseInt(temp);
					st.pop();

					String string = "";
					for (int j = 0; j < c; j++) {
						string += r;
					}
					for (int k = string.length() - 1; k >= 0; k--) {
						st.push(string.charAt(k));
					}
				} else {
					st.push(input.charAt(i));
				}
			}
			while (!st.isEmpty())
				System.out.print(st.pop());
			System.out.println();

		}

	}
}
