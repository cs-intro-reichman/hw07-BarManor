/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		//// Uncomment the version of binomial that you want to test
 
		
    	//System.out.println("" + binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		// Testing the optimized binomial implementation:
		 System.out.println("" + binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	// Computes the Binomial function, basic version.
	/*public static int binomial(int n, int k) {
     if (k > n) return 0;
     if (k == 0 || n == 0) return 1;
     return binomial(n - 1, k) + binomial(n - 1, k - 1);
    }*/
	
	// Computes the Binomial function, efficiently
	public static long binomial(int n, int k) {
		//// This function creates a 2D array, say memo, 
		//// and then initializes all its elements to -1.
		//// It then calls binomial(n, k, memo), which does all the heavy lifiting.
		//// Replace the following statement with your code.
		long [][] memo = new long[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {	
			for (int j = 0; j <= k; j++) {
				memo[i][j] = -1;
			}
		}
		return binomial(n, k, memo);
	}

	private static long binomial(int n, int k, long[][] memo) {
        if (k > n) return 0;
        if (n == 0 || k == 0) return 1;

        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        // Removed the (int) cast; both terms and storage are now long
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}



