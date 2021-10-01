/*Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;
       
        char[] chr1 = text1.toCharArray();
        char[] chr2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int i, j;
       
        int[][] lcs = new int[m + 1][n + 1];
       
        for(i = 1; i <= m; i++){
            for(j = 1; j <= n; j++){               
                    if(chr1[i - 1] == chr2[j - 1]){
                        lcs[i][j] = 1 + lcs[i - 1][j - 1];
                    }else{
                        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                    }               
            }
        }
       
        return lcs[m][n];
  }
}