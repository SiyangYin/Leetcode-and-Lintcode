class FooBar {
    private int n;
    private boolean foo;
    
    public FooBar(int n) {
        this.n = n;
        foo = true;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (foo) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    foo = false;
                    notify();
                    wait();
                }
            }
            
        }
        notify();
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!foo) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    foo = true;
                    notify();
                    wait();
                }
            }
            
        }
        notify();
    }
}

class Main {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        
        Thread t2 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        
        t2.start();
        t1.start();
    }
}