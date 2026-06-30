class MinStack {
    // Siapkan dua dispenser kembar
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    // Konstruktor: Inisialisasi objek saat pertama kali dibuat
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        
        // Jika minStack masih kosong, maka 'val' otomatis jadi rekor terkecil
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            // Bandingkan angka baru dengan rekor terkecil saat ini di puncak minStack
            int currentMin = Math.min(val, minStack.peek());
            minStack.push(currentMin); // Masukkan pemenang rekornya
        }
    }
    
    public void pop() {
        // Ingat prinsip paralel: kalau utama dibuang, catatan rekor di bayangan juga harus dibuang
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek(); // Mengintip angka teratas di stack utama
    }
    
    public int getMin() {
        return minStack.peek(); // Mengintip rekor terkecil secara instan O(1)
    }
}
