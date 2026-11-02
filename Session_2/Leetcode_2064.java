class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for (int q : quantities) {
            if (q > high) high = q;
        }
        int output = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dis(n, quantities, mid)) {
                output = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return output;
    }

    public boolean dis(int n, int[] quantities, int mid) {
        int stores = 0;
        for (int q : quantities) {
            stores += (q + mid - 1) / mid;
            if (stores > n)
                return false;
        }
        return true;
    }
}
