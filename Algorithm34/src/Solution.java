/**
 * Created by linfeng on 20/03/2017.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null) {
            return result;
        }
        result[0] = biSearch(nums, target, 0, nums.length - 1, true);
        result[1] = biSearch(nums, target, 0, nums.length - 1, false);
        return result;
    }

    private int biSearch(int[] nums, int target, int start, int end, boolean left) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        if (start > end) {
            return -1;
        }

        int len = end - start + 1;
        int mid = len / 2 + start;

        if (nums[mid] == target) {
            if (left) {
                int result = biSearch(nums, target, start, mid - 1, left);
                if (result == -1) {
                    return mid;
                } else {
                    return result;
                }
            } else {
                int result = biSearch(nums, target, mid + 1, end, left);
                if (result == -1) {
                    return mid;
                } else {
                    return result;
                }
            }
        } else if (nums[mid] > target) {
            return biSearch(nums, target, start, mid - 1, left);
        } else {
            return biSearch(nums, target, mid + 1, end, left);
        }
    }
}
