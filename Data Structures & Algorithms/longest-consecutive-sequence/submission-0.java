class Solution {
    public int longestConsecutive(int[] nums) {
        // 1. Masukkan semua angka ke dalam HashSet untuk menghilangkan duplikat
        //    sekaligus agar pencarian angka nanti super cepat.
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0; // Tempat menyimpan rekor deretan terpanjang

        // 2. Periksa setiap angka
        for (int num : set) {
            
            // Trik utama: Cek apakah angka ini adalah "AKAR" (awal deretan)
            // Jika (num - 1) TIDAK ADA di set, berarti 'num' adalah awal deretan!
            if (!set.contains(num - 1)) {
                
                int currentNum = num;
                int currentStreak = 1; // Mulai hitung panjang deretan

                // Selama angka berikutnya (+1) ada di dalam set, lanjut hitung!
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Perbarui rekor jika deretan kali ini lebih panjang
                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}
