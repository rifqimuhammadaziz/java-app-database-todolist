package rifqimuhammadaziz.todolist.util;

import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String input(String text) {
        System.out.print(text + " : ");
        String data = scanner.nextLine();
        return data;
    }
}
