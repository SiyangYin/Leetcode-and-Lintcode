class Bank {
    private long[] b;
    public Bank(long[] balance) {
        b = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > b.length || account2 > b.length || money > b[account1 - 1]) {
            return false;
        }
        else {
            b[account1 - 1] -= money;
            b[account2 - 1] += money;
            return true;
        }
    }

    public boolean deposit(int account, long money) {
        if (account > b.length) {
            return false;
        }
        else {
            b[account - 1] += money;
            return true;
        }
    }

    public boolean withdraw(int account, long money) {
        if (account > b.length || money > b[account - 1]) {
            return false;
        }
        else {
            b[account - 1] -= money;
            return true;
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }
}
