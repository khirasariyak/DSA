package Array;

/*
* https://leetcode.com/problems/median-of-two-sorted-arrays/
* */

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArraysBetter(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; //total size

        // required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1;
        int ind2el = -1;

        // apply the merge step
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) {
                    ind1el = a[i];
                }
                if (cnt == ind2) {
                    ind2el = a[i];
                }
                cnt++;
                i++;
            } else {
                if (cnt == ind1) {
                    ind1el = b[j];
                }
                if (cnt == ind2) {
                    ind2el = b[j];
                }
                cnt++;
                j++;
            }
        }

        //copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1) {
                ind1el = a[i];
            }
            if (cnt == ind2) {
                ind2el = a[i];
            }
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) {
                ind1el = b[j];
            }
            if (cnt == ind2) {
                ind2el = b[j];
            }
            cnt++;
            j++;
        }

        //Find the median:
        if (n % 2 == 1) {
            return ind2el;
        }

        return ((double)(ind1el + ind2el)) / 2.0;
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
