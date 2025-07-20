package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    
  public List<Integer> findDuplicates(int[] nums) {

        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                result.add(nums[j]);
            }
        }

        return result;
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
