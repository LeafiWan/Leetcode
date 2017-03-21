/**
 * Created by linfeng on 20/03/2017.
 */
public class Solution {
    public int jump(int[] nums) {
        if (null == nums || nums.length == 1) {
            return 0;
        }
        // init
        int len = nums.length;
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = nums[i] + i >= len ? len - 1 : nums[i] + i; j > i; j--) {
                if (cost[j] == 0) {
                    cost[j] = cost[i] + 1;
                } else {
                    break;
                }
                if (j == len - 1) {
                    return cost[j];
                }
            }
        }
        return cost[len-1];
    }

    public static void main(String[] args) {
        Solution m2 = new Solution();
        int[] nums = {0};
        System.out.println(m2.jump(nums));
    }
}
