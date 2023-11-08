package atm.src;

public enum ForeignCurrency {
    USD("USD", 0.31),
    EUR("EUR", 0.28),
    RUB("RUB", 29.67),
    BYN("BYN", 1.0);

    private String code;
    private double rate;

    ForeignCurrency(String code, double rate) {
        this.code = code;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public double getRate() {
        return rate;
    }
    public double convertToCurrency(double amount) {
        return amount * rate;
    }

}

