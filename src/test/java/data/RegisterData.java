package data;

public enum RegisterData {

    Correct("Krystof", "Testor", "qrys@taf.com", "023456789", "1478963", "1478963"),
    Empty(null, null, null, null, null, null);

    public final String firstname;
    public final String lastname;
    public final String email;
    public final String telephone;
    public final String password;
    public final String passwordConfirm;

    RegisterData(String firstname, String lastname, String email, String telephone, String password, String passwordConfirm) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

}
