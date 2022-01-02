public class FooBar {
    
    private final int n;
    private boolean runFoo;
    
    public FooBar(int n) {
        this.n = n;
        runFoo = true;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // wait until bar() is running
                if (!runFoo) {
                    wait();
                }
                
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                runFoo = false;
                notify();
            }
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // wait until foo() is running
                if (runFoo) {
                    wait();
                }
                
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                runFoo = true;
                notify();
            }
        }
    }
    
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(4);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
    
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        
        t1.start();
        t2.start();
    }
}