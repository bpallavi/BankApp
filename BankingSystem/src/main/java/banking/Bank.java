package banking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private Map<Long, Account> accounts;
       long accountNum;

    public Bank() {
        accounts = new LinkedHashMap<>();
        accountNum = 1;
        // complete the function
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        if(accounts.containsKey(accountNumber)){
            return accounts.get(accountNumber);
        }
        return null;
    }

    public synchronized Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
       // accountNum++;
        System.out.println("------"+accountNum);
        Long accountNumber = genrateAccountNumber();
        CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }



    public synchronized Long openConsumerAccount(Person person, int pin, double startingDeposit) {
      //  accountNum++;
        System.out.println("*******"+accountNum);
        Long accountNumber = genrateAccountNumber();
        ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public synchronized boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
        Account account = accounts.get(accountNumber);
        if(account != null && account.validatePin(pin))
            return true;
        else
            return false;
    }

    public synchronized double getBalance(Long accountNumber) {
        Account account = accounts.get(accountNumber);
        return account.getBalance();
    }

    public synchronized void credit(Long accountNumber, double amount) {
        // complete the function
        Account account = accounts.get(accountNumber);
        account.creditAccount(amount);
    }

    public synchronized boolean debit(Long accountNumber, double amount) {
        // complete the function
        Account account = accounts.get(accountNumber);
        return account.debitAccount(amount);
    }

    private synchronized Long genrateAccountNumber() {
       // return accountNum;
        return accountNum++;
    }
}
