public class CyclicSort {

    /*
     * Identification
     *
     * The problem will involve an array of ‘n’ numbers containing numbers in the range of 1 to ‘n’.
     *
     * */

    public void sort(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}
