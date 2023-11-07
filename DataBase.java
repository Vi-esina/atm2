package atm;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static atm.Menu.*;

public class DataBase {
    private static List<Account> accounts;


    static {
        accounts = new ArrayList<>();
        addAccount();
    }

    private static void addAccount() {
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account("User", i, i + 1234, (int) Math.random() * 1000));
        }
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(Account[] accounts) {
        DataBase.accounts = List.of(accounts);
    }

    public static void updatePin(int accountNumber, int newPin) {
        for (Account account : accounts) {
            if (account.getNumberAccount() == accountNumber) {
                account.setPinCode(newPin);
                break;
            }
        }
    }

    public static Account findByLogin(int recipientAcc) throws AccountNotFoundException {
        for (int i = 0; i < accounts.size(); i++) {
            if (recipientAcc == accounts.get(i).getNumberAccount()) {
                return accounts.get(i);
            }

        }
        throw new AccountNotFoundException(String.format("Аккаунт с номером: %s не найден", recipientAcc));
    }

    static void checkUser() {
        if (accounts != null) {
            for (int i = 0; i < accounts.size(); i++) {
                Account account = new Account(3);
                while (account.getAttempts() < account.getMaxAttempts()) {
                    language.textCheckUser();
                    if (Service.login(choose(), choose())) {
                        language.textCheckUserAllowed();
                        language.textStart();
                        start();
                        break;
                    } else {
                        account.incrementAttempts();
                        language.textCheckUserInvalid();
                        System.out.println((account.getMaxAttempts() - account.getAttempts()));
                        ;
                        if (account.getMaxAttempts() == account.getAttempts()) {
                            language.textCheckUserBlocked();
                        }
                    }
                }
            }
        }
    }
}

