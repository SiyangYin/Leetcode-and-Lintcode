class CustomStack {
    private int[] arr;
    private int i;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        i = 0;
    }

    public void push(int x) {
        if (i < arr.length) {
            arr[i++] = x;
        }
    }

    public int pop() {
        return i >= 1 ? arr[--i] : -1;
    }

    public void increment(int k, int val) {
        for (int j = 0; j < Math.min(i, k); j++) {
            arr[j] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
