class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n]; // Default isinya adalah 0 semua
        
        // Stack ini bertugas menjadi "Ruang Tunggu" yang menyimpan INDEKS HARI
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Selama Ruang Tunggu tidak kosong, DAN suhu hari ini (temperatures[i]) 
            // LEBIH HANGAT daripada suhu orang di pucuk antrean...
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                
                int prevDayIndex = stack.pop(); // Keluarkan orang tersebut dari antrean
                
                // Hitung selisih jarak harinya
                result[prevDayIndex] = i - prevDayIndex;
            }
            
            // Masukkan indeks hari ini ke Ruang Tunggu
            stack.push(i);
        }

        return result;
    }
}
