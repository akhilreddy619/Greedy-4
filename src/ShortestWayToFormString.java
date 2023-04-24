// Time Complexity : O(Source * Target)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Take idx for source and iterate over each char in target. When ever idx
 * reaches end, make it 0. compare each char with idx char of source. if not
 * equal, increment idx and check if it reaches 0, then increment count. at each
 * iteration also, check if idx reached 0. finally return count.
 *
 */
class Solution {
	public int shortestWay(String source, String target) {
		boolean[] present = new boolean[26];
		for (char c : source.toCharArray())
			present[c - 'a'] = true;

		for (char c : target.toCharArray()) {
			if (!present[c - 'a'])
				return -1;
		}
		int m = source.length();
		int idx = 0;

		int count = 0;
		for (char c : target.toCharArray()) {
			if (idx == 0) {
				count++;
			}

			while (source.charAt(idx) != c) {
				idx = (idx + 1) % m;
				if (idx == 0) {
					count++;
				}
			}
			idx = (idx + 1) % m;
		}
		return count;
	}
}
