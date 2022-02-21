package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает аккаунт клиента в банке
 * @author Ivan Martinov
 * @version 0.1
 */
public class Account {
    /**
     * Поля - реквизиты и баланс клиента
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор
     * @param requisite присвоение реквизитов при создании аккаутнта
     * @param balance баланс счета на момент создания
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для получения реквизтов
     * @return возращает реквизиты клиента
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для замены рекзитов
     * @param requisite заменят действующие реквизиты клиента
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер для получения баланса счета.
     * @return возращает баланс по счету.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер для назначения баланса при его изменении
     * @param balance заменяет текущий баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *  Переопределенный метод equals.
     * @param o с чем сранивать.
     * @return взращает true или false в зависимости от один и тот же ли это аккаунт.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод для получения хэшкода аккаунта.
     * @return хешкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}