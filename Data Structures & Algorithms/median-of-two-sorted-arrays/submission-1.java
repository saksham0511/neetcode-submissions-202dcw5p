class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double median;
        if (m <= n) {
            median = median(nums1, nums2);
        } else {
            median = median(nums2, nums1);
        }
        return median;
    }

    private double median(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int high = m;
        int low = 0;
        while (high >= low) {
            int mid1 = low + (high-low)/2;
            int mid2 = (m + n + 1) / 2 - mid1;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                return (m+n) % 2 == 0 ? (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2 : Math.max(l1, l2);
            } else if (l2 > r1) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }
        return 0.00;
    }

}
