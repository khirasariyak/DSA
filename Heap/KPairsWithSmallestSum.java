import java.util.*;

/*
* https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
*/

public class KPairsWithSmallestSum {

    public List<List<Integer>> kSmallestPairsBruteForce(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j});
                } else if (pq.peek()[0] > sum) {
                    pq.poll();
                    pq.offer(new int[]{sum, i, j});
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            result.add(Arrays.asList(nums1[top[1]], nums2[top[2]]));
        }

        return result;
    }
  
    public List<List<Integer>> kSmallestPairsImprovedBruteForce(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j});
                } else if (pq.peek()[0] > sum) {
                    pq.poll();
                    pq.offer(new int[]{sum, i, j});
                } else {
                    break; // Optimization since nums2 is sorted
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            result.add(Arrays.asList(nums1[top[1]], nums2[top[2]]));
        }

        return result;
    }

    public List<List<Integer>> kSmallestPairsOptimized(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<String> visited = new HashSet<>();

        pq.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0,0");

        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1], j = curr[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length && visited.add(i + "," + (j + 1))) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            if (i + 1 < nums1.length && visited.add((i + 1) + "," + j)) {
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }
        }

        return result;
    }
  
}
