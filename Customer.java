public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccounts;

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
        this.accounts = new Account[5];
        this.numberOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account acct) {
        if (numberOfAccounts < 5) {
            accounts[numberOfAccounts++] = acct;
        } else {
            System.out.println("Gagal: Maksimal 5 rekening per nasabah telah tercapai!");
        }
    }

    public Account getAccount(int accountIndex) {
        if (accountIndex >= 0 && accountIndex < numberOfAccounts) {
            return accounts[accountIndex];
        }
        return null;
    }

    public int getNumOfAccounts() {
        return numberOfAccounts;
    }
}