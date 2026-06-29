class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            for (int j = heights.length - 1; j >= 0; j--){
                if (i > j){
                    continue;
                }
                int p = heights[i] > heights[j] ? heights[j] : heights[i];
                int pxl = (p * (j-i));
                if(pxl > max){
                    max = pxl;
                }
            }
        }

        return max;
    }
}
