class Solution {
    public String reverseString(char [] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(arr);
    }
}
