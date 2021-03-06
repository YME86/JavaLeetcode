/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.30%)
 * Likes:    1078
 * Dislikes: 0
 * Total Accepted:    82.9K
 * Total Submissions: 315K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        // dp[i][j] 表示从 i 到 j 是否为回文串
        // 状态转移方程: dp[i][j] = (dp[i+1][j-1] && s[i]==s[j])
        boolean[][] dp = new boolean[s.length()][s.length()];
        String sub = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                // j-i==1 说明字符串长度为1
                if ((dp[i + 1][j - 1] || j - i == 1) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i + 1 > sub.length()) {
                        sub = s.substring(i, j + 1);
                    }
                }
            }
        }
        return sub.equals("") ? s.substring(0, 1) : sub;
    }
}