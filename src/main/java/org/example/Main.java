package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

    public static String calc(String input) throws Exception{

        String[] numbers = input.trim().split("\\s+");

        if (numbers.length != 3) {
            throw new Exception("Неверный формат выражения");
        }

        int a;
        int b;

        try {
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Введенное выражение не является числом");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Неверный ввод чисел. Числа должны быть от 1 до 10 включительно");
        }

        String operator = numbers[1];

        int result;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Неподдерживаемый операнд. Поддерживаются только +, -, *, /");
        }
        return String.valueOf(result);
    }
}