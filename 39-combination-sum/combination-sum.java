class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
    
        combineSum(0, target, candidates, new ArrayList<>(), result);
        return result;       
    }
   public void combineSum(
            int i,
            int target,
            int[] candidates,
            List<Integer> current,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        if (candidates[i] <= target) {

            current.add(candidates[i]);

            combineSum(
                i,
                target - candidates[i],
                candidates,
                current,
                result
            );

            current.remove(current.size() - 1);
        }

        combineSum(
            i + 1,
            target,
            candidates,
            current,
            result
        );
    }
}
