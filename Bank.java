public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        this.customers = new Customer[10];
        this.numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers++] = new Customer(f, l);
        } else {
            System.out.println("Gagal: Kapasitas nasabah bank sudah penuh!");
        }
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int customerIndex) {
        if (customerIndex >= 0 && customerIndex < numberOfCustomers) {
            return customers[customerIndex];
        }
        return null;
    }
}