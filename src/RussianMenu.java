package atm.src;

public class RussianMenu implements Language{
    @Override
    public void textLoginMenu() {
        System.out.println("1 Создать аккаунт/Create an account");
        System.out.println("2 Войти в аккаунт/Sign in");
        System.out.println("Выберите операцию/Choose an operation");}

    @Override
    public void textCriticalBalance() {
        System.out.println("У Вас критически низкий баланс. Пополните Ваш счет");
    }

    @Override
    public void textLoginDefault() { System.out.println("Выберите корректное значение/Choose the correct value");}
    @Override
    public void textLanguage() {
        System.out.println("Выберите язык/Choose language: ");
        System.out.println("1 Русский/Russian");
        System.out.println("2 Английский/English");
    }
    @Override
    public void textCheckUser() { System.out.println("Введите номер аккаунта и пин-код");}
    @Override
    public void textCheckUserInvalid() { System.out.println("Неверный PIN-код. При неверном вводе PIN-код более 3-х раз, карта будет заблокирована. Попыток осталось: ");}

    @Override
    public void textCheckUserBlocked() {
        System.out.println("Ваша карта заблокирована. Обратитесь в банк.");
    }

    @Override
    public void textCheckUserAllowed() { System.out.println("Доступ разрешен");}
    @Override
    public void textStart() {
        System.out.println("1 Просмотр баланса");
        System.out.println("2 Выдача наличных");
        System.out.println("3 Пополнение счета");
        System.out.println("4 ЗАавершить работу");
        System.out.println("5 Сменить пин-код");
        System.out.println("6 Лимиты");
        System.out.println("7 История операций");
        System.out.println("8 перевод средств");
        System.out.println("9 профиль");
        System.out.println("Выберите операцию ");
    }
    @Override
    public void textCheckInput() { System.out.print("Баланс составляет: ");}
    @Override
    public void textCheckInputWithdraw() { System.out.println("Введите сумму для снятия");}
    @Override
    public void textCheckInputAddMoney() { System.out.println("Внесите сумму для пополнения");}
    @Override
    public void textCheckInputLimits() {
        System.out.println("1 Лимит на снятие");
        System.out.println("2 Лимит на перевод");
        System.out.println("Выберите операцию");
    }
    @Override
    public void textContinuationInput() {
        System.out.println("Продолжить работу?");
        System.out.println("1 Да");
        System.out.println("2 Нет");}
    @Override
    public void textContinuationInputCompletion() { System.out.println("Работа завершена");}
    @Override
    public void registrationAccountNumber() { System.out.println("Введите номер аккаунта/Enter your account number: ");}
    @Override
    public void registrationAccountPin() { System.out.println("Введите Ваш пин-код/Enter your PIN: ");}
    @Override
    public void registrationAccountMail() { System.out.println("Введите Вашу почту/Enter your mail");}
    @Override
    public void registrationAccountCreated() { System.out.println("Аккаунт успешно создан/Account created successfully");}

    @Override
    public void withdrawMoneyCompletion() {
        System.out.println("Операция прошла успешно");
    }

    @Override
    public void withdrawMoneyLimit() {
        System.out.println("Превышен лимит");
    }

    @Override
    public void withdrawMoneyNotEnough() {
        System.out.println("Недостаточно средств");
    }

    @Override
    public void addMoneyCreated() {
        System.out.println("Операция выполнена успешно");
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
        System.out.print("Тип операции: ");
    }

    @Override
    public void textPrintTransactionsSum() {
        System.out.print(" ******* " + "Сумма: " );
    }

    @Override
    public void textPrintTransactionsTime() {
        System.out.print(" BYN " + "*******" + " Время совершения операции: ");
    }

    @Override
    public void textGenerateAndSavePin() {
        System.out.print("Ваш новый пин-код: ");
    }

    @Override
    public void textYourTransferLimit() {
        System.out.print("Ваш лимит на перевод: ") ;
    }

    @Override
    public void textYourWithdrawalLimit() {
        System.out.print("Ваш лимит на снятие: ");
    }

    @Override
    public void textLimitMenu() {
        System.out.println("1 Изменить лимит");
        System.out.println("2 Удалить лимит");
        System.out.println("3 Выйти в главное меню");
    }


    @Override
    public void textInputLimit() {
        System.out.println("Введите сумму для изменения лимита");
    }

    @Override
    public void textLimitChanged() {
        System.out.print("Ваш лимит изменен: ");
    }

    @Override
    public void textLimitDelete() {
        System.out.println("Ваш лимит удалён");
    }

    @Override
    public void textProfileData() {
        System.out.println("**** Личные данные *** ");
    }

    @Override
    public void textProfileEmail() {
        System.out.print("Почта: ");
    }

    @Override
    public void textProfileLogin() {
        System.out.print("Логин: ");
    }

    @Override
    public void textProfileChangeData() {
        System.out.println("1 Изменить почту");
        System.out.println("2 Изменить логин");
    }

    @Override
    public void textProfileNewEmail() {
        System.out.print("Введите новую почту: ");
    }

    @Override
    public void textProfileNewLogin() {
        System.out.print("Введите новый логин: ");
    }

    @Override
    public void textProfileChangeEmail() {
        System.out.println("Почта успешно изменена!");
    }

    @Override
    public void textProfileChangeLogin() {
        System.out.println("Логин успешно изменен!");
    }

    @Override
    public void textProfileIncorrect() {
        System.out.println("Некорректный ввод!");
    }

    @Override
    public void textTransferNumberAccount() {
        System.out.println("Введите номер аккаунта для перевода");
    }

    @Override
    public void textTransferSum() {
        System.out.println("Введите сумму перевода");
    }

    @Override
    public void textTransferLimit() {
        System.out.println("Превышен лимит перевода");
    }

    @Override
    public void textTransferIncorrect() {
        System.out.println("Некорректная сумма для перевода");
    }


}
