class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Jika bertemu operator, ambil 2 angka teratas lalu eksekusi
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop(); // Angka kedua (kanan) keluar duluan
                int a = stack.pop(); // Angka pertama (kiri) keluar belakangan
                
                if (token.equals("+")) stack.push(a + b);
                else if (token.equals("-")) stack.push(a - b);
                else if (token.equals("*")) stack.push(a * b);
                else if (token.equals("/")) stack.push(a / b);
            } 
            // Jika berupa angka biasa, langsung dorong ke dalam stack
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // Angka terakhir yang tersisa di dalam stack adalah hasil mutlaknya
        return stack.pop();
    }
}
