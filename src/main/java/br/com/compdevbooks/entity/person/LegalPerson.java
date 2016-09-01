package br.com.compdevbooks.entity.person;

public class LegalPerson extends Person {

    private String stateRegistrationCode; //inscricao estadual
    private String tradingName;

    public String getStateRegistrationCode() {
        return stateRegistrationCode;
    }

    public void setStateRegistrationCode(String stateRegistrationCode) {
        this.stateRegistrationCode = stateRegistrationCode;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }
}
