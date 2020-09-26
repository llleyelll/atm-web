package th.ac.ku.atm.model;

public class Transaction {
    private int bankAccountId;
    private TransactionType type;
    private double amount;

    public Transaction(int bankAccountId, TransactionType type, double amount) {
        this.bankAccountId = bankAccountId;
        this.type = type;
        this.amount = amount;
    }

    public Transaction(int id, double amount, TransactionType type) {
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "bankAccountId=" + bankAccountId +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
