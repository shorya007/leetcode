class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Arrays.stream(nums).max().getAsInt();
        int result=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValidSum(nums, mid, threshold)){
                result = mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return result;
    }
        private boolean isValidSum(int[] nums,int divisor, int threshold){
        int sum=0;
        for(int num:nums){
            sum+=(num+divisor-1)/divisor;
        }
        return sum<=threshold;
    }
}