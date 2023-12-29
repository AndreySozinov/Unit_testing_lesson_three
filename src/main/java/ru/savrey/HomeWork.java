package ru.savrey;

/**
 * HW 3.1. Нужно покрыть тестами метод evenOddNumber на 100%
 * Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
 *
 * HW 3.2. Нужно написать метод numberInInterval который проверяет, попадает ли переданное число
 * в интервал (25;100) и возвращает true, если попадает и false - если нет,
 *покрыть тестами метод на 100%
 *
 * Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей,
 * кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством,
 * указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию.
 */

public class HomeWork {
    final static int MIN = 25;
    final static int MAX = 100;

    public boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    public boolean numberInInterval(int n) {
        return n > MIN && n < MAX;
    }
}
