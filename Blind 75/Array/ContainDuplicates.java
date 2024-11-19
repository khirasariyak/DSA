
/*
* https://leetcode.com/problems/contains-duplicate/description/
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(containsDuplicateWithStream(nums));
        System.out.println(containsDuplicateWithSet(nums));
    }

    private static boolean containsDuplicateWithStream(int[] nums) {

        long count = Arrays.stream(nums)
                .distinct()
                .count();

        return count < nums.length;

    }

    private static boolean containsDuplicateWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean added = set.add(num);
            if (!added) {
                return true;
            }
        }

        return false;
    }

}
