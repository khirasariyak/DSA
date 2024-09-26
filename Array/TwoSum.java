import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/two-sum/
* */

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(target - arr[i])) {
                return new int[]{i, map.get(target - arr[i])};
            } else {
                map.put(arr[i], i);
            }

        }

        return new int[]{};
    }

}
