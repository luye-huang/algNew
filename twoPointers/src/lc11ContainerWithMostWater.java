public class lc11ContainerWithMostWater {
    //双指针，只移动短指针。因为根据公式Math.max(ret, (right - left) * Math.min(height[left], height[right]))，
    //移动长的一定会更小
    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            ret = Math.max(ret, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return ret;
    }
}
