import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        bank.addCustomer("Fahrial", "Azhari");
        bank.getCustomer(0).addAccount(new Account(500000.0));
        bank.getCustomer(0).addAccount(new Account(1500000.0)); 

        bank.addCustomer("lionel", "ronaldo");
        bank.getCustomer(1).addAccount(new Account(2500000.0));

        boolean running = true;

        while (running) {
    
            System.out.println("1. Lihat Daftar Nasabah & Rekening");
            System.out.println("2. Tambah Nasabah");
            System.out.println("3. Buka Rekening Baru");
            System.out.println("4. Setor atau Tarik Tunai");
            System.out.println("5. Keluar");
            System.out.println("==============================================");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- DAFTAR NASABAH ---");
                    int totalCustomers = bank.getNumOfCustomers();
                    if (totalCustomers == 0) {
                        System.out.println("tidak ada nasabah.");
                    } else {
                        for (int i = 0; i < totalCustomers; i++) {
                            Customer c = bank.getCustomer(i);
                            System.out.println("[" + (i + 1) + "] " + c.getFirstName() + " " + c.getLastName());
                            System.out.println("    Jumlah Rekening: " + c.getNumOfAccounts());
                            for (int j = 0; j < c.getNumOfAccounts(); j++) {
                                System.out.println("      -> Rekening " + (j + 1) + " Saldo: Rp " + c.getAccount(j).getBalance());
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- TAMBAH NASABAH ---");
                    System.out.print("Masukkan Nama Depan : ");
                    String firstName = scanner.nextLine();
                    System.out.print("Masukkan Nama Belakang: ");
                    String lastName = scanner.nextLine();

                    bank.addCustomer(firstName, lastName);
                    System.out.println("Berhasil menambahkan nasabah " + firstName + " " + lastName);
                    break;

                case 3:
                    System.out.println("\n--- BUKA REKENING ---");
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("Masukan Nama dahulu!");
                        break;
                    }
            
                    System.out.print("Masukkan Nomor Nasabah (1 - " + bank.getNumOfCustomers() + "): ");
                    int inputNomor = scanner.nextInt();
                    
                    int idxCust = inputNomor - 1;
                    Customer selectedCust = bank.getCustomer(idxCust);

                    if (selectedCust != null) {
                        System.out.print("Masukkan Setoran Awal (Rp): ");
                        double initBal = scanner.nextDouble();
                        selectedCust.addAccount(new Account(initBal));
                        System.out.println("Rekening anda berhasil dibuka " + selectedCust.getFirstName() + "!");
                    } else {
                        System.out.println("Nomor nasabah tidak valid / tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- TRANSAKSI ATM ---");
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("Tidak ada nasabah terdaftar.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Nasabah (1 - " + bank.getNumOfCustomers() + "): ");
                    int inputCustNo = scanner.nextInt();
                
                    int cIndex = inputCustNo - 1;
                    Customer custATM = bank.getCustomer(cIndex);

                    if (custATM == null) {
                        System.out.println("Nomor nasabah tidak valid.");
                        break;
                    }

                    if (custATM.getNumOfAccounts() == 0) {
                        System.out.println("Nasabah ini belum memiliki rekening.");
                        break;
                    }

                    System.out.print("Pilih Nomor Rekening (1 - " + custATM.getNumOfAccounts() + "): ");
                    int inputAccNo = scanner.nextInt();
                
                    int aIndex = inputAccNo - 1;
                    Account accATM = custATM.getAccount(aIndex);

                    if (accATM != null) {
                        System.out.println("\nSaldo Anda saat ini: Rp " + accATM.getBalance());
                        System.out.println("1. Setor Tunai (Deposit)");
                        System.out.println("2. Tarik Tunai (Withdraw)");
                        System.out.print("Pilih Aksi (1/2): ");
                        int aksi = scanner.nextInt();

                        if (aksi == 1) {
                            System.out.print("Masukkan jumlah setoran: Rp ");
                            double depo = scanner.nextDouble();
                            if (accATM.deposit(depo)) {
                                System.out.println("Setor tunai berhasil! Saldo baru: Rp " + accATM.getBalance());
                            } else {
                                System.out.println("Setor tunai gagal! Jumlah harus lebih besar dari 0.");
                            }
                        } else if (aksi == 2) {
                            System.out.print("Masukkan jumlah penarikan: Rp ");
                            double wd = scanner.nextDouble();
                            if (accATM.withdraw(wd)) {
                                System.out.println("Penarikan berhasil! Saldo tersisa: Rp " + accATM.getBalance());
                            } else {
                                System.out.println("Penarikan gagal! Saldo tidak mencukupi atau nominal salah.");
                            }
                        } else {
                            System.out.println("Pilihan aksi tidak valid.");
                        }
                    } else {
                        System.out.println("Nomor rekening tidak valid.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("\nTerima kasih telah menggunakan Sistem ATM Bank!");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid! Masukkan angka 1 - 5.");
                    break;
            }
        }

        scanner.close();
    }
}