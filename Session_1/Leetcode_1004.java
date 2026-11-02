class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if (k == n) return k;
        int i = 0, j = 0;
        int ans = 0;
        int zcount = 0;
        while (j < n) {
            if (nums[j] == 0) zcount++;
            if (zcount > k) {
                while (nums[i] != 0) {
                    i++;
                }
                i++;
                zcount--;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
