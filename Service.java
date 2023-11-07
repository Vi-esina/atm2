package atm;
import javax.security.auth.login.AccountNotFoundException;
import java.util.*;
import java.time.LocalDateTime;

import static atm.Menu.foreignCurrency;
import static atm.Menu.language;

public class Service {

    private static Account actualAccount;
    private static Account maxAttempts;
    private static Account attempts;
    private static Account tranferAccount;
    private static List<Transaction> transactionList;

    public Service(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }


    public static boolean login(int num, int pin) {
        if (DataBase.getAccounts() != null) {
            for (int i = 0; i < DataBase.getAccounts().size(); i++) {
                if (DataBase.getAccounts().get(i) != null && num == DataBase.getAccounts().get(i).getNumberAccount() && pin == DataBase.getAccounts().get(i).getPinCode()) {
                    actualAccount = DataBase.getAccounts().get(i);
                    transactionList = new ArrayList<>();
                    return true;
                }
            }
        }
        return false;
    }

    static void registrationAccount(Language language) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            if (DataBase.getAccounts().get(i) == null) {
                DataBase.getAccounts().set(i, new Account());
                language.registrationAccountNumber();
                DataBase.getAccounts().get(i).setNumberAccount(scanner.nextInt());
                language.registrationAccountPin();
                DataBase.getAccounts().get(i).setPinCode(scanner.nextInt());
                language.registrationAccountMail();
                DataBase.getAccounts().get(i).setEmail(scanner.next());
                DataBase.getAccounts().get(i).setBalance(0);
                language.registrationAccountCreated();
                Menu.loginMenu();
                transactionList = new ArrayList<>();
                return;
            }
        }
    }

    public static void saveTransaction() {
        LocalDateTime startTime = LocalDateTime.now();
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            if (DataBase.getAccounts().get(i).getPinCode() == actualAccount.getPinCode()) {
                transactionList = new ArrayList<>();
                System.out.println(startTime);
            }
        }
    }

    public static void withdrawMoney(Language language) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        LocalDateTime startTime = LocalDateTime.now();
        double withdrawAmount = scanner.nextDouble();
        double convertAmount = withdrawAmount / foreignCurrency.getRate();
        if (convertAmount <= actualAccount.getBalance()) {
            actualAccount.setBalance((int) (actualAccount.getBalance() - convertAmount));
            System.out.println(startTime);
            transactionList.add(new Transaction("Снятие/withdrawal", convertAmount, startTime));
            language.withdrawMoneyCompletion();
        } else if (convertAmount > account.getWithdrawalLimit()) {
            language.withdrawMoneyLimit();
        } else {
            language.withdrawMoneyNotEnough();
        }
    }

    public static void addMoney(Language language) {
        Scanner scanner=new Scanner(System.in);
        LocalDateTime startTime = LocalDateTime.now();
        double addAmount = scanner.nextDouble();
        double convertAmount = addAmount / foreignCurrency.getRate();
        if (convertAmount > 0) {
            actualAccount.setBalance((int) (actualAccount.getBalance() + convertAmount));
            transactionList.add(new Transaction("Пополнение/Replenishment", convertAmount, startTime));
            System.out.println(startTime);
            language.addMoneyCreated();
        } else {
            language.addMoneyError();
        }
    }
    public static void transferMoney(Language language){
        LocalDateTime startTime = LocalDateTime.now();
        int limit=1000;
        Scanner scanner=new Scanner(System.in);
        language.textTransferNumberAccount();
       int recipientAcc=scanner.nextInt();
        language.textTransferSum();
        double tranferAmount = scanner.nextDouble();
        double convertAmount = tranferAmount / foreignCurrency.getRate();
        try {
            tranferAccount =DataBase.findByLogin(recipientAcc);
        }
       catch (AccountNotFoundException exception){
           System.out.println(exception.getMessage());
           Menu.loginMenu();
       }
        if (tranferAmount>0 && tranferAmount<limit) {
            actualAccount.setBalance((int) (actualAccount.getBalance() - tranferAmount));
            tranferAccount.setBalance((int) (tranferAccount.getBalance() + tranferAmount));
            language.addMoneyCreated();
            transactionList.add(new Transaction("Перевод/translation", convertAmount, startTime));
            System.out.println(startTime);
        } else if (tranferAmount>limit) {
            language.textTransferLimit();
        } else {
            language.textTransferIncorrect();
        }
        Menu.loginMenu();
    }
    public static void profile(){
        Scanner scanner =new Scanner(System.in);
        language.textProfileData();
        language.textProfileEmail();
        System.out.println(actualAccount.getEmail());
        language.textProfileLogin();
        System.out.println(actualAccount.getNumberAccount());
        language.textProfileChangeData();
       int number=scanner.nextInt();
        if (number == 1) {
            language.textProfileNewEmail();
            String newEmail = scanner.next();
            actualAccount.setEmail(newEmail);
            language.textProfileChangeEmail();
        } else if (number == 2) {
            language.textProfileNewLogin();
            int newLogin = scanner.nextInt();
            actualAccount.setNumberAccount(newLogin);
            language.textProfileChangeLogin();
        } else {
            language.textProfileIncorrect();
        }
    }
    public static void printTransactions(Language language) {
        LocalDateTime startTime = LocalDateTime.now();
        language.textPrintTransactionsStory();
        for (Transaction transaction : transactionList) {
            language.textPrintTransactionsType();
            System.out.println(transaction.getType());
            language.textPrintTransactionsSum();
            System.out.print(transaction.getAmount());
            System.out.print(" ");
            language.textPrintTransactionsTime();
            System.out.println(transaction.getData());
        }
    }
    public static void generateAndSavePin(Language language) {
        int newPin = (int) (Math.random() * (9999 - 1000)) + 1000;
        language.textGenerateAndSavePin();
        System.out.println((newPin));
        actualAccount.setPinCode(newPin);
        DataBase.updatePin(actualAccount.getNumberAccount(), newPin);
    }
    public static void Withdrawalimit(int num, Language language) {
        Account account=new Account();
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            language.textYourWithdrawalLimit();
            System.out.println(DataBase.getAccounts().get(i).getWithdrawalLimit());
            language.textLimitMenu();
            num = scanner.nextInt();
            if (num == 1) {
                language.textInputLimit();
                sum = scanner.nextInt();
                DataBase.getAccounts().get(i).setWithdrawalLimit(sum);
               language.textLimitChanged();
                System.out.println(DataBase.getAccounts().get(i).getWithdrawalLimit());
                Menu.continuationInput();
            } else if (num == 2) {
                account.resetWithdrawalLimit();
                language.textLimitDelete();
            } else {
                language.textStart();
                Menu.start();
            }
        }
    }
    public static void Transferlimit(Language language, int num) {
        Account account=new Account();
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            language.textYourTransferLimit();
            System.out.println(DataBase.getAccounts().get(i).getTransferLimit());
            language.textLimitMenu();
            num=scanner.nextInt();
            if (num == 1) {
                language.textInputLimit();
                sum = scanner.nextInt();
                DataBase.getAccounts().get(i).setTransferLimit(sum);
                language.textLimitChanged();
                System.out.println(DataBase.getAccounts().get(i).getTransferLimit());
                Menu.continuationInput();
            } else if (choose() == 2) {
                account.resetTransferLimit();
                language.textLimitDelete();
            } else {
                language.textStart();
                Menu.start();
            }
        }
    }


    public static void limit(Language language, int num) {

        Account account=new Account();
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            switch (num) {
                case 1:
                    Withdrawalimit(choose(), language);
                    break;
                case 2:
                    Transferlimit(language, choose());
                    break;
            }
        }
    }
    private static int choose() {
        return 0;
    }

    public static Account getActualAccount() {
        return actualAccount;
    }

    public static void setActualAccount(Account actualAccount) {
        Service.actualAccount = actualAccount;
    }

    public static Account getTranferAccount() {
        return tranferAccount;
    }

    public static void setTranferAccount(Account tranferAccount) {
        Service.tranferAccount = tranferAccount;
    }
}

 //(Math.random()*(9999-1000)+1000


