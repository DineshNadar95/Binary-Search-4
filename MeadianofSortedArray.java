//Time complexity=O(log min(n,m))
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = nums1.length;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (1+n1+n2)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(l1 <= R2 && l2 <= R1){
                if((n1+n2) % 2 == 0){
                    return (Math.max(l1, l2) +Math.min(R1, R2))/2;
                }else{
                    return Math.max(l1, l2);
                }
            }else if(l2 > R1){
                low =  partX + 1;
            }else{
                high = partX - 1;
            }              
            
        }
        return -1;
    }
}