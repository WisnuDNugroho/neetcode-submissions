class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // 1. Satukan posisi dan kecepatan ke dalam satu array 2D agar tidak lepas saat di-sort
        // data[i][0] = posisi, data[i][1] = kecepatan
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // 2. Sortir mobil berdasarkan POSISI secara ASCENDING (kecil ke besar)
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        // Stack ini bertugas menyimpan "Waktu Finish" dari setiap ketua konvoi
        Stack<Double> stack = new Stack<>();

        // 3. Sisir mobil dari yang PALING DEPAN (mundur dari indeks n-1 ke 0)
        for (int i = n - 1; i >= 0; i--) {
            // Hitung waktu ideal mobil mencapai finish
            double timeToTarget = (target - cars[i][0]) / cars[i][1];

            // Jika stack tidak kosong DAN waktu mobil ini LEBIH CEPAT/SAMA dengan konvoi di depannya...
            if (!stack.isEmpty() && timeToTarget <= stack.peek()) {
                // Mobil ini sukses bergabung dengan konvoi di depannya! 
                // Kita tidak perlu push ke stack karena dia mengekor ketua konvoi di depannya.
                continue;
            } else {
                // Mobil ini terlalu lambat, tidak bisa menyusul depannya. 
                // Dia resmi jadi ketua konvoi baru! Push waktunya ke stack.
                stack.push(timeToTarget);
            }
        }

        // Jumlah armada konvoi yang sampai finish sama dengan jumlah ketua konvoi di stack
        return stack.size();
    }
}
