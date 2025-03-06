class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int ans=0;
        HashMap<Integer,Integer>Map = new HashMap<>();
        Map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(Map.containsKey(sum-k)){
                ans+=Map.get(sum-k);
            }
            Map.put(sum,Map.getOrDefault(sum,0)+1);
        }
          return ans;
        
    }
}