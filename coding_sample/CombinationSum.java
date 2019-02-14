/**
 * Combination Sum, no dups
 */
class CombinationSum {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    dfs(result, new ArrayList<Integer>(), candidates, target, 0);
    return result;
  }

  /**
   * You know what it does
   * @param result
   * @param tempResult
   * @param candidates
   * @param target
   * @param start
   */
  private void dfs(List<List<Integer>> result, List<Integer> tempResult, int[] candidates, int target, int start) {
    if(target < 0) {
      return;
    }
    if(target == 0) {
      result.add(new ArrayList<Integer>(tempResult));
      return;
    }
    for(int i = start; i < candidates.length; i++) {
      if(i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      tempResult.add(candidates[i]);
      dfs(result, tempResult, candidates, target - candidates[i], i + 1);
      tempResult.remove(tempResult.size() - 1);
    }
  }
}
