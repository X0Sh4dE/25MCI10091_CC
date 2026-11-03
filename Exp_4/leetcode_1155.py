class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        MOD = 10**9 + 7
        
        # Base case: 0 dice can only make a sum of 0 in 1 way.
        dp = [0] * (target + 1)
        dp[0] = 1
        
        # Iterate through each die
        for i in range(1, n + 1):
            next_dp = [0] * (target + 1)
            # Iterate through all possible target sums
            for j in range(1, target + 1):
                # Look back at the previous die's possibilities
                for face in range(1, k + 1):
                    if j - face >= 0:
                        next_dp[j] = (next_dp[j] + dp[j - face]) % MOD
                    else:
                        break # Optimization: if face is too large, larger faces will be too
            dp = next_dp
            
        return dp[target]
