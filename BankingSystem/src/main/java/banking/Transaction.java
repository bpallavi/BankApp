package banking;

/**
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction extends Bank implements TransactionInterface {
    private Long accountNumber;
    private Bank bank;

    /**
     * @param bank          The bank where the account is housed.
     * @param accountNumber The customer's account number.
     * @param attemptedPin  The PIN entered by the customer.
     * @throws Exception Account validation failed.
     */
    public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
        //super();
        this.accountNumber = accountNumber;
        this.bank = bank;
        if(!bank.authenticateUser(accountNumber, attemptedPin)){
            throw new Exception("Could not authenticate account " + accountNumber + " with pin: " + attemptedPin);
        }
        // complete the function

    }

    public double getBalance() {
        // complete the function
        return bank.getBalance(accountNumber);
    }

    public synchronized void credit(double amount) {
        bank.credit(accountNumber, amount);
    }

    public synchronized  boolean debit(double amount) {
        // complete the function
        return bank.debit(accountNumber, amount);
    }
}
