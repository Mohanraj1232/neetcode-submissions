class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        helper(0, nums, new ArrayList<>(), res);

        return res;
    }

    private void helper(int ind, int[] nums,
            List<Integer> cur,
            List<List<Integer>> res) {

        res.add(new ArrayList<>(cur));

        for (int i = ind; i < nums.length; i++) {

            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);

            helper(i + 1, nums, cur, res);

            cur.remove(cur.size() - 1);
        }
    }
}