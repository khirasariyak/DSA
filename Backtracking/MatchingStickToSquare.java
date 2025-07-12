import java.util.Arrays;

/*
* https://leetcode.com/problems/matchsticks-to-square/description/
* */

public class MatchingStickToSquare {

    public boolean makeSquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) return false;

        int targetSide = totalLength / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, targetSide);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return Arrays.stream(sides).allMatch(side -> side == target);
        }

        int currStick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + currStick <= target) {
                sides[i] += currStick;

                if (dfs(matchsticks, index + 1, sides, target)) return true;

                sides[i] -= currStick; // backtrack
            }

            if (sides[i] == 0) break;
        }

        return false;
    }

    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
