package QnA;

public class PalindromePartition {
	static String str = "ababbbabbababa";

	static void findPalindrome(boolean[][] p, int len) {
		for (int i = 0; i < len; i++) {
			p[i][i] = true;
		}
		for (int l = 2; l <= len; l++) {
			for (int i = 0; i < len - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j) && l == 2) {
					p[i][j] = true;
				} else if (str.charAt(i) == str.charAt(j) && p[i + 1][j - 1]) {
					p[i][j] = true;
				} else {
					p[i][j] = false;
				}
			}
		}
	}

	public static int minPartition(String str) {
		int len = str.length();
		int c[] = new int[len];
		boolean p[][] = new boolean[len][len];
		findPalindrome(p, len);
		for (int i = 0; i < len; i++) {

			if (p[0][i] == true){
				c[i] = 0;
				continue;}
			c[i] = Integer.MAX_VALUE;
			for (int k = i - 1; k >= 0; k--) {
				if (p[k][i]) {
					c[i] = c[i] > c[k] + 1 ? c[k] + 1 : c[i];
				}
			}
		}
		return c[len - 1];
	}

	public static void main(String args[]) {
		int partition = minPartition(str);
		System.out.println(partition);
	}
}
