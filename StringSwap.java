package QnA;

public class StringSwap {

	public static void main(String args[]) {
		String a = "ABD", b = "BAD";
		int result = minSwappingOps(a, b);
		System.out.println(result);
	}

	private static int minSwappingOps(String a, String b) {
		int countOps = 0;
		int str1Count[] = new int[26];
		int str2Count[] = new int[26];
		if (a.length() != b.length()) {
			return -1;
		}

		for (int i = 0; i < a.length(); i++) {
			str1Count[a.charAt(i) - 'A']++;
		}
		for (int i = 0; i < b.length(); i++) {
			str2Count[b.charAt(i) - 'A']++;
		}
		for (int i = 0; i < 26; i++) {
			if (str1Count[i] != str2Count[i]) {
				return -1;
			}
		}
		for (int i = b.length() - 1, j = a.length() - 1; i >= 0 && j >= 0;) {

			if (b.charAt(i) == a.charAt(j)) {
				i--;
				j--;
			} else {
				countOps++;
				j--;
			}
		}
		return countOps;
	}
}