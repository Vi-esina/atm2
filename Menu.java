package atm;
import java.util.Currency;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Menu {
private static Scanner scanner;
    public static ForeignCurrency foreignCurrency;
    public static Language language;
    public Menu() {
        this.language = language;
        scanner = new Scanner(System.in);
    }
    protected static int choose() {
        return scanner.nextInt();
    }


    public static void loginMenu(){
        language =new RussianMenu();
language.textLoginMenu();
        switch (choose()) {
            case 1:
                Service.registrationAccount(language);
                break;
            case 2:
               language.textLanguage();
               language();
               break;
            default:
                language.textLoginDefault();
                loginMenu();
        }
    }


    public static void language() {
        if (choose() == 1) {
            language =new RussianMenu();
            DataBase.checkUser();
        } else {
language=new EnglishMenu();
            DataBase.checkUser();
            }

        }


    public static void start() {
        checkInput(choose());
        continuationInput();
    }

    public static void currencyInput(){
        System.out.println("Выберите тип валюты (1 - BYN, 2 - USD, 3 - EUR, 4 - RUB ):");
        int currencyChoice = scanner.nextInt();

        switch (currencyChoice) {
            case 1:
                foreignCurrency = ForeignCurrency.BYN;
                break;
            case 2:
                foreignCurrency=ForeignCurrency.USD;
                break;
            case 3:
                foreignCurrency=ForeignCurrency.EUR;
                break;
            case 4:
                foreignCurrency=ForeignCurrency.RUB;
                break;
            default:
                System.out.println("Неправильный выбор валюты.");
                currencyInput();
                break;
        }

    }
        public static void checkInput(int num1) {
            switch (num1) {
                case 1:
                    currencyInput();
                    language.textCheckInput();
                    double convertedBalance = foreignCurrency.convertToCurrency(Service.getActualAccount().getBalance());
                    System.out.println("Баланс: " + convertedBalance + " " + foreignCurrency);
                    if (Service.getActualAccount().getBalance() <= 0) {
                        language.textCriticalBalance();
                    }
                    break;
                case 2:
                    currencyInput();
                    language.textCheckInputWithdraw();
                    Service.withdrawMoney(language);

                    break;
                case 3:
                    currencyInput();
                    language.textCheckInputAddMoney();
                    Service.addMoney(language);

                    break;
                case 4:
                    Service.setActualAccount(null);

                    break;
                case 5:
                    Service.generateAndSavePin(language);
                    break;
                case 6:
                    language.textCheckInputLimits();
                    Service.limit(language, choose());
                    break;
                case 7:
                    Service.printTransactions(language);
                    break;
                case 8:
                    currencyInput();
Service.transferMoney(language);
break;
                case 9:
                    Service.profile();
            }
        }

        public static void continuationInput() {
            language.textContinuationInput();
            if (choose() == 1) {
                language.textStart();
                start();
            } else {
                language.textContinuationInputCompletion();
            }
        }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}



//44 6378
