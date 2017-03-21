/**
 * Created by linfeng on 21/03/2017.
 */
public class Solution {

    private static final int BITS_NUM = 32;

    public int singleNumber(int[] nums) {
        if (null == nums) {
            return 0;
        }
        int[] rNumArr = new int[BITS_NUM];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < BITS_NUM; j++) {
                int bit = (nums[i] >> j) & 1;
                rNumArr[j] = (rNumArr[j] + bit) % 3;
            }
        }
        int result = 0;
        for (int i = BITS_NUM - 1; i >= 0; i--) {
            result |= (rNumArr[i] << i);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1};
        System.out.println(s.singleNumber(nums));
    }
}
