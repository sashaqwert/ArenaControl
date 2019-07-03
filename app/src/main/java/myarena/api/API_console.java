package myarena.api;

/**
 * Ответ MyArena.ru API на запрос о консоли сервера (Неофициальный метод - getconsole)
 */
public class API_console extends  API_ответ {

    public String console_log;

    @Override
    public String toString() {
        if (успех()) {
            return console_log;
        }
        else {
            return message;
        }
    }
}
