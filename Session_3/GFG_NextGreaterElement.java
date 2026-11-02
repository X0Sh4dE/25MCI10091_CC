import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> output = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            output.add(-1);
        }
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            if (!st.isEmpty()) {
                output.set(i, st.peek());
            }
            st.push(arr[i]);
        }

        return output;
    }
}
