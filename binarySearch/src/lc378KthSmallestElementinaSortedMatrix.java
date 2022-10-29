import org.testng.annotations.Test;

public class lc378KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    //from left bottom or right top we can count how many numbers are equal or less than our target

    public int lessEqual(int[][] matrix, int target) {
        int count = 0, len = matrix.length, i = len - 1, j = 0;

        while (i >= 0 && j < len) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {2, 11, 13}, {3, 13, 15}}, 8));

    }
}
