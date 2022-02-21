package ru.job4j.bank;

import java.util.Objects;

/**
 * Клаас поисывает пользователя.
 * @author Ivan Martinov
 * @version 0.1
 */
public class User {

    /**
     * Поля:
     * Паспорт клиента
     * Имя пользователя
     */
    private String passport;
    private String username;

    /**
     * Конструктор
     * @param passport паспорт
     * @param username имя пользователя
     */
    public User(String passport, String username)  {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для получения поспорта.
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для замены поспорта
     * @param passport паспорт на которые нужно заменит
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для получения имя пользователя
     * @return Имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для замены имени пользователя
     * @param username имя на которое нужно заменить
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод для сранения пользователей
     * @param o с кем сравниваем
     * @return true если пользователь один и тот же, false - если пользователи разные
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Получение хэщкода клиента
     * @return хэкод.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}