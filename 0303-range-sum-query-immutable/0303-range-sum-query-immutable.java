class NumArray {

    public int[] sumArr;
    public int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            sumArr[i] = sumArr[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sumArr[right] - sumArr[left] + nums[left];
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */