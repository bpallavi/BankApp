package banking;

import java.util.List;

/**
 * Account implementation for commercial (business) customers.<br><br>
 * <p>
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
    private List<Person> authorizedUsers;


    public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
        super(company, accountNumber, pin, startingDeposit);
        // complete the function
    }

    /**
     * @param person The authorized user to add to the account.
     */
    protected void addAuthorizedUser(Person person) {
        authorizedUsers.add(person);
        // complete the function
    }

    /**
     * @param person
     * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
     */
    public boolean isAuthorizedUser(Person person) {
        // complete the function
        for(Person authPerson: authorizedUsers){
            if(authPerson.getFirstName().equalsIgnoreCase(person.getFirstName()) && authPerson.getLastName().equalsIgnoreCase(person.getLastName())){
                return true;
            }
        }
        return false;
    }
}
