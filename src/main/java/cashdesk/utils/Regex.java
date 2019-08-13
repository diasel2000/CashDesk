package cashdesk.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *verify Login, Password, Number, Code Regex
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class Regex {
    private static final Logger LOGGER = LogManager.getLogger(Regex.class.getName());

    private static final String LOGIN_REGEX = "^[a-zA-Z\\\\s]+";
    private static final String PASSWORD_REGEX = "^(?=\\S+$).{5,}$";
    private static final String NUMBER_REGEX = "[\\d]+";
    private static final String CODE_REGEX = "[0-9]";

    public static boolean isNumberCorrect(String numberString) {
        if (numberString == null) {
            return false;
        }
        LOGGER.debug("number.matches "+numberString + numberString.matches(NUMBER_REGEX));
        return numberString.matches(NUMBER_REGEX);
    }
    public static boolean isCodeCorrect(String numberString) {
        if (numberString == null) {
            return false;
        }
        LOGGER.debug("number.matches "+numberString + numberString.matches(CODE_REGEX));
        return numberString.matches(CODE_REGEX);
    }

    public static boolean isRoleCorrect(String role) {
        switch (role){
        case("caisher"):return role.matches(LOGIN_REGEX);
        case("seniorCaisher"):return role.matches(LOGIN_REGEX);
        case("supervisor"):return role.matches(LOGIN_REGEX);
        default: return false;
        }

    }


    public static boolean isLoginCorrect(String login) {
        if (login == null) {
            return false;
        }
        LOGGER.debug("login.matches");
        return login.matches(LOGIN_REGEX);
    }

    public static boolean isPasswordCorrect(String password) {
        LOGGER.debug("password.matches");
        if (password == null || password.isEmpty()) {
            return false;
        }
        return password.matches(PASSWORD_REGEX);
    }
}
