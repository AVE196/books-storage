package ave.bookStorage;

import ave.bookStorage.model.Book;
import ave.bookStorage.storage.Storage;

import java.util.InputMismatchException;
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
                    try {
                        storage.addBook(createBook(scan));
                        // TODO конкретные исключения?
                    } catch (Exception e) {
                        System.out.println(errorMessage + ". " + e.getMessage());
                    }
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

    private static int readInt(Scanner scan) {
        try {
            //TODO проверка количества?
            return Integer.parseInt(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Поле \"Количество копий\" не может быть не числом");
        }
    }

    private static Book createBook(Scanner scan) {
        System.out.println("введите информацию по книге (автор - название - количество)");
        String author = scan.nextLine().trim();
        if (author.isEmpty()) throw new InputMismatchException("Поле \"Автор\" не может быть пустым");
        String title = scan.nextLine().trim();
        if (title.isEmpty()) throw new InputMismatchException("Поле \"Название\" не может быть пустым");
        int availableCopies = readInt(scan);
        return new Book(author, title, availableCopies);
    }
}
