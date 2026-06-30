class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Kita berjalan sampai n (artinya ada putaran tambahan ke-n untuk Tiang Siluman 0)
        for (int i = 0; i <= n; i++) {
            // Trik Tiang Siluman: jika sudah di ujung array, beri tinggi 0
            int currentHeight = (i == n) ? 0 : heights[i];

            // Selama Stack tidak kosong DAN tiang sekarang lebih pendek dari tiang di pucuk Stack...
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // 1. Ambil tinggi tiang yang sedang mentok
                int height = heights[stack.pop()];
                
                // 2. Tentukan lebar ekspansinya
                // Jika stack kosong setelah di-pop, artinya tiang ini adalah yang terpendek 
                // dan bisa meluas dari indeks 0 sampai i. Maka lebarnya adalah 'i'.
                // Jika tidak kosong, lebarnya adalah jarak antara indeks sekarang (i) dan indeks setelah pop.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // 3. Hitung luas dan perbarui rekor tertinggi
                maxArea = Math.max(maxArea, height * width);
            }

            // Masukkan indeks tiang saat ini ke dalam Stack
            stack.push(i);
        }

        return maxArea;
    }
}
