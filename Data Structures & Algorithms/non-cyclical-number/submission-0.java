class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        Set<Integer> set = new HashSet<>();

        while(temp!=1) {
            if(set.contains(temp)) {
                return false;
            }
            set.add(temp);

            int num = temp;
            int sum = 0;
            while(num!=0) {
                int last = num%10;
                sum+=last*last;
                num = num/10;
            }
            temp = sum;
            
        }
        return true;
        
    }
}
