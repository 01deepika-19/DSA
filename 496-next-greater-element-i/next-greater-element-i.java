class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            int curr = nums1[i];
            int j = 0;
            while(j < nums2.length && curr != nums2[j]){
               j++;
            }
            int k = j + 1;
            while (k < nums2.length) {
                if (nums2[k] > curr) {
                    break;
                }
                k++;
            }
            if (k < nums2.length) {
                l.add(nums2[k]);
            } else {
                l.add(-1);
            }
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = l.get(i);
        }
        return ans;
        }
}