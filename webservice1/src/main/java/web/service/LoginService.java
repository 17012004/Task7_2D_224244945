package web.service;

public class LoginService {

    private static final String VALID_USERNAME = "ahsan";
    private static final String VALID_PASSWORD = "ahsan_pass";
    private static final String VALID_DOB = "01-01-2000"; // dd-MM-yyyy

    /**
     * Checks if all inputs are valid for login.
     * @param username user's username
     * @param password user's password
     * @param dob user's date of birth in dd-MM-yyyy
     * @return true if all match expected values
     */
    public static boolean login(String username, String password, String dob) {
        if (isNullOrEmpty(username) || isNullOrEmpty(password) || isNullOrEmpty(dob)) {
            return false;
        }

        return username.equals(VALID_USERNAME)
                && password.equals(VALID_PASSWORD)
                && dob.equals(VALID_DOB);
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
