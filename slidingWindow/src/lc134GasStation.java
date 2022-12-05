import org.junit.Test;


public class lc134GasStation {

    //When the accumulated balance of gas is great than zero, expand the window. If not, shrink the window. When the length of the window is equal to gas array, return the right boundary or left boundary.
    //The only subtlety here is that the right bounday is expanded in circle.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0, right = 0, accGas = 0, accLen = 0, len = gas.length;
        while (left < len) {
            if (accGas >= 0) {
                if (accLen == len) {
                    return right;
                }
                accGas += gas[right] - cost[right];
                right = right == len - 1 ? 0 : right + 1;
                accLen++;
            } else {
                accGas -= gas[left] - cost[left];
                left++;
                accLen = accLen == 0 ? 0 : accLen - 1;
                right = Math.max(left, right);
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
//        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
