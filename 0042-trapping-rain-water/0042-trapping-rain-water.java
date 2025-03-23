class Solution {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int leftmax = 0;
        int rightmax= 0;
        int trap=0;

        while ( i < j ) {
            if (height[i] < height[j] ) {
                if ( leftmax > height[i] ){
                    trap += leftmax - height[i] ; 
                }
                leftmax = Math.max(leftmax , height[i]);
                i++;
            }
            else {
                if (rightmax > height[j] ) {
                    trap += rightmax - height[j];
                }
                rightmax = Math.max(rightmax , height[j]);
                j--;
            }
        } 
        return trap ;     
    }
}