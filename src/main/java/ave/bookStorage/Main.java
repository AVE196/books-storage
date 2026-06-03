package ave.bookStorage;

import ave.bookStorage.exceptions.ItemNotFoundException;
import ave.bookStorage.exceptions.NotAvailableCopiesException;
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

        final String errorMessage = "Некорректный ввод. ";

        boolean isNotExit = true;

        Scanner scan = new Scanner(System.in);

        Storage storage = new Storage();

        while (isNotExit) {
            try {
                System.out.println(menu);
                int choice = readInt(scan);
                switch (choice) {
                    case 1:
                        storage.printBooks();
                        break;
                    case 2:
                        storage.addBook(createBook(scan));
                        System.out.println("Книга добавлена");
                        break;
                    case 3:
                        System.out.print("Введите название книги, которую хотите взять: ");
                        storage.takeBook(readNotEmptyString(scan));
                        System.out.println("Книга выдана");
                        break;
                    case 4:
                        System.out.print("Введите название книги, которую хотите вернуть: ");
                        storage.returnBook(readNotEmptyString(scan));
                        System.out.println("Книга возвращена");
                        break;
                    case 5:
                        isNotExit = false;
                        System.out.println("До новых встреч!");
                        break;
                    default:
                        throw new InputMismatchException("Введите номер опции из списка");
                }
            } catch (NotAvailableCopiesException e) {
                System.out.println("В данный момент в хранилище нет свободных копий книги: " + e.getMessage());
            } catch (ItemNotFoundException e) {
                System.out.println("В хранилище не удалось найти книгу с названием: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage + "Вы ввели: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(errorMessage + e.getMessage());
            }
        }
    }

    private static int readInt(Scanner scan) {
        String input = null;
        try {
            input = scan.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(input);
        }
    }

    private static Book createBook(Scanner scan) {
        System.out.println("Введите информацию по добавляемой книге.");
        System.out.print("Введите автора книги: ");
        String author = readNotEmptyString(scan);
        System.out.print("Введите название книги: ");
        String title = readNotEmptyString(scan);
        System.out.print("Введите количество добавляемых экземпляров книги: ");
        int availableCopies = readInt(scan);
        if (availableCopies <= 0)
            throw new InputMismatchException("Поле \"Количество внесенных копий\" должно быть больше 0");
        return new Book(author, title, availableCopies);
    }

    private static String readNotEmptyString(Scanner scan) {
        String s = scan.nextLine().trim();
        if (s.isEmpty()) throw new InputMismatchException("Поле не может быть пустым");
        else return s;
    }
}
