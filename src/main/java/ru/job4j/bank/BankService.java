package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод ищет клиента по паспорту.
     * @param passport данные паспорта
     * @return возращает клиента или null если он не найден
     */
    public Optional<User> findByPassport(String passport) {
     return users.keySet()
             .stream()
             .filter(user -> user.getPassport().equals(passport))
             .findFirst();
    }

    /**
     *  Метод ищет аккаунт клиента по его реквизитам.
     * @param passport паспорт клиента для пойска пользователя {@link BankService#findByPassport(String)}
     * @param requisite реквизиты по которым будем искать клиента.
     * @return если аккаунт не найден вернется null.
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(req -> req.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> srcUser = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destUser = findByRequisite(destPassport, destRequisite);
        if (srcUser.isPresent() && destUser.isPresent() && srcUser.get().getBalance() >= amount) {
            srcUser.get().setBalance(srcUser.get().getBalance() - amount);
            destUser.get().setBalance(destUser.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}