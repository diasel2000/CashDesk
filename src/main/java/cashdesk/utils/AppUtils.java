package cashdesk.utils;

import cashdesk.model.entity.Users;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
    private static  int REDIRECT_ID = 0;

    // Сохранить информацию пользователя в Session.
    public static void storeLoginedUser(HttpSession session, Users loginedUser) {
        // На JSP можно получить доступ через ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    // Получить информацию пользователя, сохраненную в Session.
    public static Users getLoginedUser(HttpSession session) {
        Users loginedUser = (Users) session.getAttribute("loginedUser");
        return loginedUser;
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = uri_id_map.get(requestUri);

        if (id == null) {
            id = REDIRECT_ID++;

            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);
            return id;
        }

        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = id_uri_map.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }
}
