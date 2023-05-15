package com.skyworth.oltu.oauth2;

public enum AccountType {

    //skyworth
    SKYWORTH("skyworth"),
    //amazon
    AMAZON("amazon"),
    //google
    GOOGLE("google");

    private final String accountType;

    private AccountType(String accountType) {
        this.accountType = accountType;
    }


    public String getAccountType() {
        return accountType;
    }

    public static AccountType getInstance(String accountType) {
        switch (accountType) {
            case "amazon":
                return AMAZON;
            case "skyworth":
                return SKYWORTH;
            case "google":
                return GOOGLE;
            default:
        }
        return null;
    }
}
