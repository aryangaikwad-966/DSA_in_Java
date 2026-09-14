class Solution {
    public int maximumCandies(int[] candies, long k) {

        int left = 0;
        int right = 0;

        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canGive(candies, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean canGive(int[] candies, long k, int mid) {

        if (mid == 0) {
            return true;
        }

        long children = 0;

        for (int candy : candies) {
            children += candy / mid;

            if (children >= k) {
                return true;
            }
        }

        return false;
    }
}