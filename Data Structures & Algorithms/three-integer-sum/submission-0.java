class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // 1. Urutkan dulu dari kecil ke besar
        Arrays.sort(nums);

        // Loop untuk mengunci Angka Pertama (nums[i])
        for (int i = 0; i < nums.length - 2; i++) {
            
            // ANTIDUPLIKAT 1: Jika angka pertama sama dengan angka sebelumnya, skip!
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pasang dua pointer di sisa kanan array
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                // Kasus 1: Jumlahnya PAS 0
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Geser kedua pointer mendekati tengah
                    left++;
                    right--;

                    // ANTIDUPLIKAT 2: Skip angka kedua jika sama dengan sebelumnya
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // ANTIDUPLIKAT 3: Skip angka ketiga jika sama dengan setelahnya
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } 
                // Kasus 2: Kekecilan, geser kiri ke kanan cari yang lebih besar
                else if (total < 0) {
                    left++;
                } 
                // Kasus 3: Kegedean, geser kanan ke kiri cari yang lebih kecil
                else {
                    right--;
                }
            }
        }
        return res;
    }
}
