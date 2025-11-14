package sliding_window;

import java.util.*;

public class Leet239SlidingWindowMaximum {

    public static void main(String[] args) {
        Leet239SlidingWindowMaximum solution = new Leet239SlidingWindowMaximum();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1},1)));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxWindows = new int[nums.length-k+1];

        //will store indexes
        Deque<Integer> deque = new ArrayDeque<>();

        // slide window by 1, consider new element
        // pop from back all elements less than new element
        for(int i=0;i<nums.length;i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            // insert new element at back
            deque.addLast(i);

            // remove out of window elements from front
            while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.removeFirst();
            }

            // store element at front of deque as max
            //start from k-1 to include the first window
            if(i>=k-1) {
                maxWindows[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return maxWindows;
    }

    /*
    O(N*k) - because build-in PQ in java takes O(n) for indexOf() used while removing
     */
    public int[] maxSlidingWindow_V1(int[] nums, int k) {
        int[] maxWindows = new int[nums.length-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());

        //Initialize pq with first window
        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }

        //slide window get top element from pq and update pq
        for(int i=0;i<nums.length-k;i++) {
            //Get max element
            maxWindows[i] = pq.peek();
            //Slide window
            pq.remove(nums[i]);
            pq.add(nums[k+i]);
        }

        //Update last window
        maxWindows[nums.length-k] = pq.peek();

        return maxWindows;
    }
}
