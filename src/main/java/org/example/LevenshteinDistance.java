package org.example;

public class LevenshteinDistance {

    // Method to calculate Levenshtein Distance between two strings
    public static int calculate(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialize dp table
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;  // Min. operations = j (all insertions)
                } else if (j == 0) {
                    dp[i][j] = i;  // Min. operations = i (all deletions)
                } else {
                    // Choose the minimum among insert, delete, or substitute
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1),  // Substitution
                            Math.min(dp[i - 1][j] + 1,    // Deletion
                                    dp[i][j - 1] + 1));  // Insertion
                }
            }
        }
        return dp[len1][len2];
    }
}
