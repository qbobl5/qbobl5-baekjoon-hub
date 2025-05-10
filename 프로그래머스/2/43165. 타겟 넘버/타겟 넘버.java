class Solution {
    static int size;
    
    public int solution(int[] numbers, int target) {
        size = numbers.length;
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int sum, int index) {
        if(index == size) {
            if(sum == target) return 1;
            return 0;
        }
        
        return dfs(numbers, target, sum + numbers[index], index + 1)
            + dfs(numbers, target, sum - numbers[index], index + 1);
    }
}