class Solution {

    public static int CheckWeight(int[]arr,int weight){

        int sum=0;
        int count=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sum>weight){
                count++;
                sum=arr[i];
            }else{
                sum+=arr[i];
            }
        }
        return count;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int low=weights[0];
        int heigh=0;
        for(int i=0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            heigh+=weights[i];
        }

        int minWeight=-1;
        while(low<=heigh){
            int mid=(low+heigh)/2;
            int numberOfDay=CheckWeight(weights,mid);
            if(numberOfDay<=days){
                minWeight=mid;
                heigh=mid-1;

            }else{
                low=mid+1;
            }
        }
        return minWeight;
    }
}













