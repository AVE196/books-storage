package ave.bookStorage;

import ave.bookStorage.storage.Storage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final String menu = """
                1. Вывести каталог.
                2. Добавить объект.
                3. Выдать объект.
                4. Вернуть объект.
                5. Выйти из приложения.
                """;

        final String errorMessage = "Некорректный ввод";

        boolean isNotExit = true;

        Scanner scan = new Scanner(System.in);

        Storage storage = new Storage();

        while (isNotExit) {
            System.out.println(menu);
            int choise = Integer.parseInt(scan.nextLine());

            switch (choise) {
                case 1:
                    storage.printBooks();
                    break;
                case 2:
                    System.out.println("введите информацию по книге (автор - название - количество)");
                    String author = scan.nextLine();
                    String title = scan.nextLine();
                    int availableCopies = Integer.parseInt(scan.nextLine());
                    storage.addBook(author, title, availableCopies);
                    break;
                case 3:
                    // выдать
                    break;
                case 4:
                    // вернуть
                    break;
                case 5:
                    isNotExit = false;
                    break;
                default:
                    System.out.println(errorMessage);
                    break;
            }
        }
    }
}
