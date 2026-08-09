class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int zeroes = 0;
        int prod = 1;
        for(int num:nums) {
            zeroes+=(num==0)?1:0;
            if(num!=0) {
                prod*=num;
            }
        }

        for(int i=0; i<n; i++) {
            int curr = nums[i];

            if((curr==0 && zeroes==1)) {
                arr[i] = prod;
            }
            else if(zeroes>1) {
                arr[i] = 0;
            }
            else if(curr!=0 && zeroes>0){
                arr[i] = 0;
            }
            else {
                arr[i] = prod/nums[i];
            }
        
        }
        return arr;

        
    }
}  
