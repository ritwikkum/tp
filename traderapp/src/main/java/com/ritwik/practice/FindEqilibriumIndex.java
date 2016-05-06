package com.ritwik.practice;

/**
 * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such
 * that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. A[0]
 * + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1]. Sum of zero elements is assumed to be equal to 0. This can
 * happen if P = 0 or if P = N−1.
 *
 * For example, consider the following array A consisting of N = 8 elements:
 *
 * A[0] = -1 A[1] = 3 A[2] = -4 A[3] = 5 A[4] = 1 A[5] = -6 A[6] = 2 A[7] = 1 P = 1 is an equilibrium index of this
 * array, because:
 *
 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7] P = 3 is an equilibrium index of this array, because:
 *
 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7] P = 7 is also an equilibrium index, because:
 *
 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0 and there are no elements with indices greater than 7.
 *
 * P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function
 * should return −1 if no equilibrium index exists.
 *
 * For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
 *
 * Assume that:
 *
 * N is an integer within the range [0..100,000]; each element of array A is an integer within the range
 * [−2,147,483,648..2,147,483,647]. Complexity:
 *
 * expected worst-case time complexity is O(N); expected worst-case space complexity is O(N), beyond input storage (not
 * counting the storage required for input arguments). Elements of input arrays can be modified
 */

public class FindEqilibriumIndex {


    private static void solution1(final int[] arr) {
        System.out.println("solution1");
        int index, m, lsum, rsum;
        for (index = 0; index < arr.length; ++index) {
            lsum = 0;
            rsum = 0;
            for (m = 0; m < index; ++m) {
                lsum += arr[m];
            }
            for (m = index + 1; m < arr.length; ++m) {
                rsum += arr[m];
            }
            if (lsum == rsum) {
                System.out.println(index);
            }
        }
    }

    private static void solution2(final int[] arr) {
        System.out.println("solution2");
        long[] sumFromBeg = new long[arr.length];
        sumFromBeg[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumFromBeg[i] = sumFromBeg[i - 1] + arr[i];
        }

        int[] sumFromEnd = arr;
        for (int i = sumFromEnd.length - 2; i >= 0; i--) {
            sumFromEnd[i] = sumFromEnd[i] + sumFromEnd[i + 1];
        }

        for (int i = 1; i < sumFromEnd.length; i++) {
            if (sumFromEnd[i] == sumFromBeg[i]) {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {-1, 3, -4, 5, 1, -6, 2, 1};
        solution1(arr);
        solution2(arr);
    }

}
