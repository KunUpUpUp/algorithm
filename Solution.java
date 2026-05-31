class Solution {
    
    public int[] sortArray(int[] nums) {
        heapSort(nums, nums.length - 1);
        return nums;
    }

    // 堆排序
    public void heapSort(int[] nums, int last) {
        // 建堆，保证整个堆每部分都是大顶堆
        createHeap(nums);
        for (int i : nums) {
            System.out.print(i + "-");
        }
        System.out.println();
        for (; last > 0; last--) {
            // 换位置
            swap(nums, 0, last);
            // 重构大顶堆，帮助顶层元素找到合适位置
            motifyHeap(nums, last, 0);
        }
    }

    public void createHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            motifyHeap(nums, nums.length, i);
        }
    }

    //
    public void motifyHeap(int[] nums, int len, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int bigger = root;
        if (left < len && nums[bigger] < nums[left]) {
            bigger = left;
        }
        if (right < len && nums[bigger] < nums[right]) {
            bigger = right;
        }
        if (bigger == root)
            return;
        swap(nums, root, bigger);
        root = bigger;
        motifyHeap(nums, len, root);
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}