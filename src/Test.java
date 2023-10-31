
/**
 * @author 25566
 * @project Algorithm
 * @date 26/10/2023
 */
public class Test {
	public static boolean  isScramble( String s1, String s2 ) {
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];

		for ( int len = 1; len <= n; len++ ) {
			for ( int i = 0; i <= n - len; i++ ) {
				for ( int j = 0; j <= n - len; j++ ) {
					if ( len == 1 ) {
						dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
					} else {
						for (int  k = i + 1; k < i + len; k++ ) {
							if ( (dp[i][j][k - i] && dp[k][k - i + j][len - (k - i)]) || (dp[i][len - (k - i) + j][k - i] && dp[k][j][len - (k - i)]) ) {
								dp[i][j][len]=true;
								break;
							}
						}
					}
				}
			}
		}
		return dp[0][0][n];
	}

}
