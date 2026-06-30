class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;  // Benteng tertinggi di sisi kiri
        int rightMax = 0; // Benteng tertinggi di sisi kanan
        
        int totalWater = 0;

        while (left < right) {
            // ATURAN EMAS: Selalu proses dari sisi yang bentengnya LEBIH RENDAH
            if (height[left] < height[right]) {
                
                // Jika tiang saat ini mengalahkan benteng kiri, perbarui bentengnya
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } 
                // Jika lebih pendek dari benteng, air pasti tergenang di atasnya!
                else {
                    totalWater += leftMax - height[left];
                }
                left++; // Geser maju
                
            } else {
                // Proses sisi kanan jika tiang kanan lebih rendah/sama dengan kiri
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--; // Geser mundur
            }
        }

        return totalWater;
    }
}
