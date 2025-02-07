package day3.InnerClass;

public class BackAccount {
    private double saldo;

    public BackAccount(double saldo){this.saldo = saldo;}

    public class Transaction {
        private double total;

        public Transaction(double total){this.total = total;}

        public void hitungTotal(){
            saldo += total;
            System.out.println("Transaksi sukses, saldo saat ini : " + saldo);
        }
    }

    public static void main(String[] args) {
        // memasukan saldo dengan nilai awal : 1000
        BackAccount account = new BackAccount(1000);
        // membuat object transaksi dari innerClass dan lakukan transaksi 500
        BackAccount.Transaction transaction = account.new Transaction(500);
        // panggil method
        transaction.hitungTotal();
    }
}
