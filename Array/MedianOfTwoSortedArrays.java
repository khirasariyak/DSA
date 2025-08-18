package Array;

/*
* https://leetcode.com/problems/median-of-two-sorted-arrays/
* */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        int median1 = 0;
        int median2 = 0;

        for (int count = 0; count < (len1 + len2) / 2 + 1; count++) {
            median2 = median1;
            if (i < len1 && j < len2) {
                if (nums1[i] > nums2[j]) {
                    median1 = nums2[j];
                    j++;
                } else {
                    median1 = nums1[i];
                    i++;
                }
            } else if (i < len1) {
                median1 = nums1[i];
                i++;
            } else {
                median1 = nums2[j];
                j++;
            }
        }

        if ((len1 + len2) % 2 == 1) {
            return (double) median1;
        } else {
            return (median1 + median2) / 2.0;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0;
        int r = A.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }

}
