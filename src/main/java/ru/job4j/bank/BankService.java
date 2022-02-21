package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает простейшую работу банка
 * @author Ivan Martinov
 * @version 0.1
 */
public class BankService {

    /**
     * Хранинение пользователей происходит в коллекции HashMap ключем у которой является данные пользователь, а картой
     * его аккаунт.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления нового пользователя. Если такого еще нету.
     * @param user данные пользователя.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод создает аккаунт пользователю.
     * @param passport паспорт по которому производится пойск клиента ,пойск
     *             производится в методе{@link BankService#findByPassport(String)}
     *
     * @param account данные аккаунта которые хотим привизать к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет клиента по паспорту.
     * @param passport данные паспорта
     * @return возращает клиента или null если он не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     *  Метод ищет аккаунт клиента по его реквизитам.
     * @param passport паспорт клиента для пойска пользователя {@link BankService#findByPassport(String)}
     * @param requisite реквизиты по которым будем искать клиента.
     * @return если аккаунт не найден вернется null.
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перевода средст с одного счета клиента на другой счет другого клиента.
     * @param srcPassport  паспорт клиента с которые переводит средства
     * @param srcRequisite реквизиты счета с которого будет произведен перевод
     * @param destPassport паспорт получателя
     * @param destRequisite счет получателя
     * @param amount сумма перевода
     * @return возращает true если все прошло положительно, иначе false
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount)  {
        boolean rsl = false;
        Account srcUser = findByRequisite(srcPassport, srcRequisite);
        Account destUser = findByRequisite(destPassport, destRequisite);
        if (srcUser != null && destUser != null && srcUser.getBalance() >= amount) {
            srcUser.setBalance(srcUser.getBalance() - amount);
            destUser.setBalance(destUser.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}