package data;

public enum LoginData {

    Correct("chris@tof.com", "1478963"),
    WrongPassword("chris@tof.com", "789456"),
    WrongEmail("kriis@tof.com", "1478963"),
    Empty(null, null);


    public final String email;
    public final String password;

    LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
