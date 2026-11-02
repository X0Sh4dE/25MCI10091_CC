class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            if (num > high) high = num;
        }
        if (threshold == nums.length) return high;
        int output = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            for (int el : nums) {
                sum += (el + mid - 1) / mid;
            }
            if (sum <= threshold) {
                output = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return output;
    }
}
