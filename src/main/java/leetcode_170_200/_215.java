package leetcode_170_200;

import org.junit.Test;

public class _215 {

	@Test
	public void test() {
		int[] nums = {-1,2,0};
		System.out.println(findKthLargest(nums, 3));
	}

    /**
     * 有界最小堆的应用
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest(int[] nums, int k) {
    	LimitedMinHeap limitedMinHeap = new LimitedMinHeap(k);
    	for (int element : nums) {
    		limitedMinHeap.insert(element);
	    }
        return limitedMinHeap.top();
    }

	/**
	 * 有界最小堆
	 */
	private static class LimitedMinHeap {
    	private int[] nums;
    	private int capacity;
    	private int size;

    	public LimitedMinHeap(int capacity) {
    		this.capacity = capacity + 1;
    		this.nums = new int[this.capacity];
    		this.size = 1;
	    }

	    public void insert(int element) {
    		if (size < capacity) {
    			nums[size] = element;
    			flowUp(size);
    			size++;
		    } else {
    			if (element >= nums[1]){
    				nums[1] = element;
    				flowDown(1);
			    }
		    }
	    }

	    private void flowUp(int i) {
    		int element = nums[i];

    		while (i > 1 && nums[i/2] > element) {
				nums[i] = nums[i / 2];
				i = i / 2;
		    }

		    nums[i] = element;
	    }

	    private void flowDown(int i) {
			int element = nums[i];

			while (i * 2 < size) {
				if ((i * 2 + 1 >= size || (nums[i * 2] <= nums[2 * i + 1])) && nums[i * 2] < element) {
					nums[i] = nums[i * 2];
					i = 2 * i;
				}
				else if (i * 2 + 1 < size && nums[i * 2] > nums[2 * i + 1] && nums[2 * i + 1] < element) {
					nums[i] = nums[i * 2 + 1];
					i = 2 * i + 1;
				} else {
					break;
				}
			}

			nums[i] = element;
	    }

	    public int top() {
    		return nums[1];
	    }
    }
}
