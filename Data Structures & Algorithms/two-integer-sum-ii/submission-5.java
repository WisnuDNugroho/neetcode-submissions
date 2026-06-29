class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers.length; j++){
                System.out.println(i + " : " + j);
                System.out.println(numbers[i] + " + " + numbers[j]);
                if(i != j && numbers[i] + numbers[j] == target){
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}
