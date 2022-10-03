import org.junit.Test;

public class lc62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                int up = i - 1 >= 0 ? dp[i - 1][j] : 0;
                dp[i][j] = Math.max(left + up, 1);
            }
        }
        return dp[m - 1][n - 1];
    }

//    top solution: Just specify corner cases to remove check for each element
//    public int uniquePaths(int m, int n) {
//        Integer[][] map = new Integer[m][n];
//        for(int i = 0; i<m;i++){
//            map[i][0] = 1;
//        }
//        for(int j= 0;j<n;j++){
//            map[0][j]=1;
//        }
//        for(int i = 1;i<m;i++){
//            for(int j = 1;j<n;j++){
//                map[i][j] = map[i-1][j]+map[i][j-1];
//            }
//        }
//        return map[m-1][n-1];
//    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(2, 3));
    }
}
