// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Pick top row 1st element and check for possible rotations needed to make all
 * equal. In each check if both top and bottom are not equal then return -1. If
 * top element is not equal to 0th element of top, then increment top rotations
 * else check if bottom element is not matching then increment bottom rotations.
 * Take the minimum of both the top and bottom rotations. This way we can say
 * that if which would be the least rotation possible.
 *
 */
class Solution {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int rotations = check(tops, bottoms, tops[0]);
		if (rotations != -1 || tops[0] == bottoms[0])
			return rotations;
		return check(tops, bottoms, bottoms[0]);
	}

	public int check(int[] tops, int[] bottoms, int x) {
		int rotA = 0, rotB = 0;
		for (int i = 0; i < tops.length; i++) {
			if (tops[i] != x && bottoms[i] != x)
				return -1;
			else if (tops[i] != x)
				rotA++;
			else if (bottoms[i] != x)
				rotB++;
		}
		return Math.min(rotA, rotB);
	}
}