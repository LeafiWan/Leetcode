/**
 * Created by linfeng on 20/03/2017.
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (null == nums) {
            return -1;
        }
        return biSearch(nums, target, 0, nums.length - 1);
    }

    public int biSearch(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (target == nums[start]) {
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
        boolean leftMass = nums[start] > nums[mid];
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            if (leftMass) {
                return biSearch(nums, target, start, mid - 1);
            } else {
                if (nums[start] > target) {
                    return biSearch(nums, target, mid + 1, end);
                } else {
                    return biSearch(nums, target, start, mid - 1);
                }
            }
        } else {
            if (leftMass) {
                if (nums[start] > target) {
                    return biSearch(nums, target, mid + 1, end);
                } else {
                    return biSearch(nums, target, start, mid - 1);
                }
            } else {
                return biSearch(nums, target, mid + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        Solution m2 = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(m2.search(nums, 0));
    }
}
