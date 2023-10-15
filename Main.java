import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to our shop!");

        Map<Integer, Integer> ram = new HashMap<>();
        Map<Integer, Integer> ssd = new HashMap<>();
        Map<Integer, String> os = new HashMap<>();
        Map<Integer, String> color = new HashMap<>();

        Notebook.fillRam(ram);
        Notebook.fillSsd(ssd);
        Notebook.fillOs(os);
        Notebook.fillColor(color);

        Set<Notebook> allNotebooks = new HashSet<>();
        for (int i = 1; i <= 15; i++) {
            Notebook element = Notebook.generateNotebook(ram, ssd, os, color);
            allNotebooks.add(element);
        }

        int minRam = 1;
        int minSsd = 1;
        String userOs = "0";
        String userColor = "0";

        int d = 0;
        while (d == 0) {
            System.out.println("Выберите параметры: ");
            System.out.println("1 - Количество оперативки");
            System.out.println("2 - Размер жёсткого диска");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("Для поиска по заданным параметрам нажмите '5'");

            Scanner scanner = new Scanner(System.in);
            int point = 0;
            try {
                point = Integer.parseInt(scanner.nextLine());
                switch (point) {
                    case 1:
                        System.out.println("Выберите объём оперативки: ");
                        System.out.println("1 - 8Гб");
                        System.out.println("2 - 16Гб");
                        System.out.println("3 - 32Гб");
                        System.out.println("4 - 64Гб");
                        String userMemory = scanner.nextLine();
                        try {
                            minRam = Integer.parseInt(userMemory);
                            if (minRam < 1 || minRam > 4) {
                                minRam = 1;
                                System.out.println("Неверное значение!");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Введите число!");
                        }
                        break;

                    case 2:
                        System.out.println("Выберите объём жесткого диска: ");
                        System.out.println("1 - 256Гб");
                        System.out.println("2 - 512Гб");
                        System.out.println("3 - 1Тб");
                        String userHdd = scanner.nextLine();
                        try {
                            minSsd = Integer.parseInt(userHdd);
                            if (minSsd < 1 || minSsd > 3) {
                                minSsd = 1;
                                System.out.println("Неверное значение!");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Введите число!");
                        }
                        break;

                    case 3:
                        System.out.println("Выберите ОС: ");
                        System.out.println("1 - FreeDOS");
                        System.out.println("2 - Windows");
                        System.out.println("3 - MacOS");
                        String indexOs = scanner.nextLine();
                        try {
                            int choiceOs = Integer.parseInt(indexOs);
                            if (choiceOs < 1 || choiceOs > 3) {
                                choiceOs = 1;
                                System.out.println("Неверное значение!");
                            } else
                                userOs = os.get(choiceOs);
                        } catch (NumberFormatException ex) {
                            System.out.println("Введите число!");
                        }
                        break;

                    case 4:
                        System.out.println("Выберите цвет");
                        System.out.println("1 - Белый");
                        System.out.println("2 - Чёрный");
                        System.out.println("3 - Металлик");
                        String indexColour = scanner.nextLine();
                        try {
                            int choiceColour = Integer.parseInt(indexColour);
                            if (choiceColour < 1 || choiceColour > 3) {
                                choiceColour = 1;
                                System.out.println("Неверное значение!");
                            } else
                                userColor = color.get(choiceColour);
                        } catch (NumberFormatException ex) {
                            System.out.println("Введите число!");
                        }
                        break;

                    case 5:
                        d = 1;
                        scanner.close();
                        break;

                    default:
                        System.out.println("Неверное значение. Попробуй ещё раз!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Вы ввели не число.");
            }
        }


        for (Notebook book : allNotebooks) {
            if (ram.get(minRam) <= book.ram && ssd.get(minSsd) <= book.ssd
                    && (userOs.equals("0") || book.os.equals(userOs))
                    && (userColor.equals("0") || book.color.equals(userColor))) {
                d = 2;
                System.out.println(book);
            }
        }
        if (d != 2) {
            System.out.println("Ничего не найдено! Попробуйте изменить критерии поиска.");
        }
    }
}