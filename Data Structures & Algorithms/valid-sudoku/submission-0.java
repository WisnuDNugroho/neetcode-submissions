class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        // Loop untuk menjelajahi setiap sel di papan Sudoku (9x9)
        for (int r = 0; r < 9; r++) { // r = row (baris)
            for (int c = 0; c < 9; c++) { // c = column (kolom)
                
                char val = board[r][c];

                // Jika sel kosong (berisi '.'), kita skip/abaikan
                if (val == '.') {
                    continue;
                }

                // Hitung nomor kotak 3x3 menggunakan rumus tadi
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Buat 3 kalimat catatan untuk baris, kolom, dan kotak
                String rowNote = val + " di baris " + r;
                String colNote = val + " di kolom " + c;
                String boxNote = val + " di kotak " + boxIndex;

                // Coba masukkan ke dalam HashSet. 
                // Jika salah satu saja ditolak (!), artinya ada duplikat!
                if (!seen.add(rowNote) || !seen.add(colNote) || !seen.add(boxNote)) {
                    return false; // Sudoku TIDAK valid
                }
            }
        }

        return true; // Jika semua lolos pemeriksaan, Sudoku VALID
    }
}
