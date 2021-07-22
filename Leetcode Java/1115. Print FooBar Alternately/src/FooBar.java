public class FooBar {
    
    private int n;
    private boolean runFoo;
    
    public FooBar(int n) {
        this.n = n;
        runFoo = true;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // wait until bar() is running
                while (!runFoo) {
                    wait();
                }
                
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                runFoo = false;
                notifyAll();
            }
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // wait until foo() is running
                while (runFoo) {
                    wait();
                }
                
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                runFoo = true;
                notifyAll();
            }
        }
    }
    
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}