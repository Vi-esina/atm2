package atm.src;


public class Account {
    private String email;
    protected int numberAccount;
    protected int pinCode;
    private int balance;
    private int withdrawalLimit;
    private int transferLimit;
    private Transaction[] transactions;
    private int sender;
    private int receiver;
    private int maxAttempts;
    private int attempts;

    public Account(String email, int numberAccount, int pinCode, int balance) {
        this.email = email;
        this.numberAccount = numberAccount;
        this.pinCode = pinCode;
        this.balance = balance;
        this.withdrawalLimit = 1000;
        this.transferLimit = 1000;

    }

    public Account() {
    }

    public Account(int maxAttempts) {
        this.maxAttempts = 3;
        this.attempts = 0;
    }

    public void resetTransferLimit() {
        this.transferLimit = 0; // обнуляем лимит
    }

    public void resetWithdrawalLimit() {
        this.withdrawalLimit = 0; // обнуляем лимит
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(int withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public int getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(int transferLimit) {
        this.transferLimit = transferLimit;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public void incrementAttempts() {
                attempts++;
            }
        }

