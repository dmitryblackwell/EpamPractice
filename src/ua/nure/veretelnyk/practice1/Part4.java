package ua.nure.veretelnyk.practice1;
/*
    Практическое задание №1
    _______________________

    Задание 4
    -------------------------------------------------------
    Название класса: ua.nure.your_last_name.Practice1.ua.nure.veretelnyk.practice3.Part4
    -------------------------------------------------------

    Написать класс, который реализует функциональность определения наибольшего общего делителя двух целых положительных чисел, переданных в приложение как параметры командной строки.

    Пример:
    -------------------------------------------------------
    Параметры командной строки: 25 15
    Консольный вывод: 5
    -------------------------------------------------------
*/

public class Part4 {
    public static void main(String[] args) {
        int a =Integer.parseInt(args[0]);
        int b =Integer.parseInt(args[1]);

        while (a != b){
            if (a>b)
                a -= b;
            else
                b -= a;
        }

        System.out.println(a);
    }
}
