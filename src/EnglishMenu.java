package atm.src;

public class EnglishMenu implements Language{
    @Override
    public void textLoginMenu() {
        System.out.println("1 Создать аккаунт/Create an account");
        System.out.println("2 Войти в аккаунт/Sign in");
        System.out.println("Выберите операцию/Choose an operation");
    }

    @Override
    public void textCriticalBalance() {
        System.out.println("Your balance is critically low. Top up your account");
    }

    @Override
    public void textLoginDefault() {
        System.out.println("Выберите корректное значение/Choose the correct value");
    }

    @Override
    public void textLanguage() {
        System.out.println("Выберите язык/Choose language: ");
        System.out.println("1 Русский/Russian");
        System.out.println("2 Английский/English");
    }

    @Override
    public void textCheckUser() {
        System.out.println("Enter your account number and PIN code");
    }

    @Override
    public void textCheckUserInvalid() {
        System.out.println("Invalid PIN code. If you enter the PIN code incorrectly more than 3 times, the card will be blocked. Attempts left: ");
    }

    @Override
    public void textCheckUserBlocked() {
        System.out.println("Your card is blocked. Contact your bank.");
    }

    @Override
    public void textCheckUserAllowed() {
        System.out.println("Access is allowed");
    }

    @Override
    public void textStart() {
        System.out.println("1 View balance");
        System.out.println("2 Cash withdrawal");
        System.out.println("3 Account replenishment");
        System.out.println("4 Exit");
        System.out.println("5 Change PIN code");
        System.out.println("6 Limits");
        System.out.println("7 Operation History");
        System.out.println("8 funds transfer");
        System.out.println("9 profile");
        System.out.println("Select operation");
    }

    @Override
    public void textCheckInput() {
        System.out.println("The balance is: ");
    }

    @Override
    public void textCheckInputWithdraw() {
        System.out.println("Enter the amount to withdraw");
    }

    @Override
    public void textCheckInputAddMoney() {
        System.out.println("Enter the amount to top up");
    }

    @Override
    public void textCheckInputLimits() {
        System.out.println("1 Withdrawal limit");
        System.out.println("2 Transfer limit");
        System.out.println("Select operation");
    }

    @Override
    public void textContinuationInput() {
        System.out.println("Continue?");
        System.out.println("1 Yes");
        System.out.println("2 No");
    }

    @Override
    public void textContinuationInputCompletion() {
        System.out.println("ATM operation completed");
    }

    @Override
    public void registrationAccountNumber() {
        System.out.println("Введите номер аккаунта/Enter your account number: ");
    }

    @Override
    public void registrationAccountPin() {
        System.out.println("Введите Ваш пин-код/Enter your PIN: ");
    }

    @Override
    public void registrationAccountMail() {
        System.out.println("Введите Вашу почту/Enter your mail");
    }

    @Override
    public void registrationAccountCreated() {
        System.out.println("Аккаунт успешно создан/Account created successfully");
    }

    @Override
    public void withdrawMoneyCompletion() {
        System.out.println("The operation was successful");
    }

    @Override
    public void withdrawMoneyLimit() {
        System.out.println("Limit exceeded");
    }

    @Override
    public void withdrawMoneyNotEnough() {
        System.out.println("Insufficient funds");
    }

    @Override
    public void addMoneyCreated() {
        System.out.println("Operation completed successfully");
    }

    @Override
    public void addMoneyError() {
        System.out.println("Ошибка/Error");
    }

    @Override
    public void textPrintTransactionsStory() {
        System.out.println("История транзакций/Transaction history: ");
    }

    @Override
    public void textPrintTransactionsType() {
        System.out.print("Operation type: ");
    }

    @Override
    public void textPrintTransactionsSum() {
        System.out.print(" ******* " + "Amount: " );
    }

    @Override
    public void textPrintTransactionsTime() {
        System.out.print(" BYN " + "*******" + " Operation time: ");
    }

    @Override
    public void textGenerateAndSavePin() {
        System.out.print("Your new pin code: ");
    }

    @Override
    public void textYourTransferLimit() {
        System.out.print("Your transfer limit: ") ;
    }

    @Override
    public void textYourWithdrawalLimit() {
        System.out.print("Your withdrawal limit: ");
    }

    @Override
    public void textLimitMenu() {
        System.out.println("1 Change limit");
        System.out.println("2 Remove limit");
        System.out.println("3 Exit to main menu");
    }

    @Override
    public void textInputLimit() {
        System.out.println("Enter the amount to change the limit");
    }

    @Override
    public void textLimitChanged() {
        System.out.print("Your limit has been changed: ");
    }

    @Override
    public void textLimitDelete() {
        System.out.println("Your limit has been removed");
    }


    @Override
    public void textProfileData() {
        System.out.println("**** Personal information *** ");
    }

    @Override
    public void textProfileEmail() {
        System.out.print("Mail: ");
    }

    @Override
    public void textProfileLogin() {
        System.out.print("Login: ");
    }

    @Override
    public void textProfileChangeData() {
        System.out.println("1 Change mail");
        System.out.println("2 Change login");
    }

    @Override
    public void textProfileNewEmail() {
        System.out.print("Enter new email: ");
    }

    @Override
    public void textProfileNewLogin() {
        System.out.print("Enter new login: ");
    }

    @Override
    public void textProfileChangeEmail() {
        System.out.println("Mail successfully changed!");
    }

    @Override
    public void textProfileChangeLogin() {
        System.out.println("Login changed successfully!");
    }

    @Override
    public void textProfileIncorrect() {
        System.out.println("Invalid input!");
    }

    @Override
    public void textTransferNumberAccount() {
        System.out.println("Enter the account number for the transfer");
    }

    @Override
    public void textTransferSum() {
        System.out.println("Enter transfer amount");
    }

    @Override
    public void textTransferLimit() {
        System.out.println("Transfer limit exceeded");
    }

    @Override
    public void textTransferIncorrect() {
        System.out.println("Incorrect amount to transfer");
    }
}
