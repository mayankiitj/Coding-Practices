package QnA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static Map<String, Integer> sellCount = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nDays = 100, pIds = 10, cIds = 4, sIds = 7, rIds = 25;
		int inputLine = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < inputLine; i++) {
			String st = sc.nextLine();
			String[] queryParam = st.split(" ");
			if (queryParam[0].equals("Q")) {
				int result = 0;
				int day_s, day_e;
				String prod, cat, state, reg;
				if (queryParam[1].contains(".")) {
					day_s = Integer.parseInt(queryParam[1].split("\\.")[0]);
					day_e = Integer.parseInt(queryParam[1].split("\\.")[1]);
				} else {
					day_s = day_e = Integer.parseInt(queryParam[1]);
				}
				if (queryParam[2].contains(".")) {
					prod = queryParam[2].split("\\.")[0];
					cat = queryParam[2].split("\\.")[1];
				} else {
					prod = queryParam[2];
					cat = "0";
				}
				if (queryParam[3].contains(".")) {
					state = queryParam[3].split("\\.")[0];
					reg = queryParam[3].split("\\.")[1];
				} else {
					state = queryParam[3];
					reg = "0";
				}

				for (int d = day_s; d <= day_e; d++) {
					String query = "" + d;
					if (prod.equals("-1")) {
						for (int j = 1; j <= pIds; j++) {
							String query1 = query + "," + j + ".0";
							if (state.equals("-1")) {
								for (int k = 1; k <= sIds; k++) {
									String query2 = query1 + "," + k + ".0";
									result += sellCount.get(query2) != null ? sellCount.get(query2) : 0;
								}
							} else {
								String query2 = query1 + "," + state + "." + reg;
								result += sellCount.get(query2) != null ? sellCount.get(query2) : 0;
							}
						}
					} else {
						query += "," + prod + "." + cat;
						if (state.equals("-1")) {
							for (int k = 1; k <= sIds; k++) {
								String query2 = query + "," + k + ".0";
								result += sellCount.get(query2) != null ? sellCount.get(query2) : 0;
							}
						} else {
							String query2 = query +"," + state + "." + reg;
							result += sellCount.get(query2) != null ? sellCount.get(query2) : 0;
						}
					}
				}

				System.out.println(result);
			} else {
				String mapKey1 = "";
				String mapKey2 = "";
				String mapKey3 = "";
				String mapKey4 = "";
				mapKey1 += queryParam[1];
				if (queryParam[2].contains(".")) {
					mapKey2 = mapKey1;
					mapKey1 += "," + queryParam[2];
					mapKey2 += "," + queryParam[2].substring(0, queryParam[2].length() - 1) + "0";
				} else {
					mapKey1 += "," + queryParam[2] + ".0";
				}

				if (queryParam[3].contains(".")) {
					mapKey4 = mapKey1;
					mapKey1 += "," + queryParam[3];
					mapKey4 += "," + queryParam[3].substring(0, queryParam[3].indexOf(".") + 1) + "0";
					if (mapKey2 != "") {
						mapKey3 = mapKey2;
						mapKey2 += "," + queryParam[3].substring(0, queryParam[3].indexOf(".") + 1) + "0";
						mapKey3 += "," + queryParam[3];
					}
				} else {
					mapKey1 += "," + queryParam[3] + ".0";
					if (mapKey2 != "") {
						mapKey2 += "," + queryParam[3] + ".0";
					}
				}

				pushToMap(mapKey1);
				pushToMap(mapKey2);
				pushToMap(mapKey3);
				pushToMap(mapKey4);

			}

		}

		for (String s : sellCount.keySet()) {
			System.out.println(s + " " + sellCount.get(s));
		}

	}

	public static void pushToMap(String key) {
		if (key == "") {
			return;
		}
		if (sellCount.get(key) == null) {
			sellCount.put(key, 1);
		} else {
			sellCount.put(key, sellCount.get(key) + 1);
		}
	}
}
