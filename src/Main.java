import java.io.*;
import java.util.*;

import Lab3Classes.*;
import Lab3Classes.Date;

public class Main {


    public static ArrayList<Date> readDateFile() {
        String fileName;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть назву файла з датами:");
        fileName = scanner.next();

        // Object defenition
        ArrayList<Date> list = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                // Getting line
                String line = fileScanner.nextLine();

                // Time or date type check
                String delimiter = "/";
                String[] numbers = line.split(delimiter);

                // Wrong file format exception
                if (numbers.length != 3) {
                    throw new RuntimeException("File is formatted incorrectly!");
                }


                int[] num = {0, 0, 0};
                for (int i = 0; i < 3; i++) {
                    num[i] = Integer.parseInt(numbers[i]);
                }

                list.add(new Date(num[0], num[1], num[2]));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }
    public static ArrayList<Time> readTimeFile() {
        String fileName;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть назву файла з годинами:");
        fileName = scanner.next();

        // Object defenition
        ArrayList<Time> list = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                // Getting line
                String line = fileScanner.nextLine();

                // Time or date type check
                String delimiter = ":";
                String[] numbers = line.split(delimiter);

                // Wrong file format exception
                if (numbers.length != 3) {
                    throw new RuntimeException("File is formatted incorrectly!");
                }


                int[] num = {0, 0, 0};
                for (int i = 0; i < 3; i++) {
                    num[i] = Integer.parseInt(numbers[i]);
                }

                list.add(new Time(num[0], num[1], num[2]));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }


    public static void saveDatesToFile(ArrayList<Date> dates, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Date date : dates) {
                writer.write(date.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveTimesToFile(ArrayList<Time> times, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Time time : times) {
                writer.write(time.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void task1() throws IOException {
        Scanner cin = new Scanner(System.in);
        ArrayList<Time> time = readTimeFile();
        ArrayList<Date> date = readDateFile();


        System.out.println("Loaded:");
        System.out.println("Time:");
        for(int i = 0; i < time.size(); i++) {
            System.out.println("[" + i + "] " + time.get(i).toString());
        }

        System.out.println("\n\nDate:");
        for(int i = 0; i < date.size(); i++) {
            System.out.println("[" + i + "] " + date.get(i).toString());
        }

        // x == y   0
        // x <  y   -1
        // x >  y   1

        //System.out.println(time.get(0).compareTo(time.get(1)));
        //System.out.println(time.get(0).compareTo(time.get(2)));
        //System.out.println(time.get(0).compareTo(time.get(3)));


        Collections.sort(time);
        Collections.sort(date);
        System.out.println("Sorted:");
        System.out.println("Time:");
        for(int i = 0; i < time.size(); i++) {
            System.out.println("[" + i + "] " + time.get(i).toString());
        }

        System.out.println("\n\nDate:");
        for(int i = 0; i < date.size(); i++) {
            System.out.println("[" + i + "] " + date.get(i).toString());
        }

        System.out.println("Уведіть 1 час за форматом '5 30 20', що буде виглядати як '15:30:20'");
        time.add(new Time(cin.nextInt(), cin.nextInt(), cin.nextInt()));

        System.out.println("Уведіть 1 дату за форматом '01 05 2023', що буде виглядати як '01/05/2023'");
        date.add(new Date(cin.nextInt(), cin.nextInt(), cin.nextInt()));
        cin.nextLine();

        Collections.sort(time);
        Collections.sort(date);
        System.out.println("Sorted:");
        System.out.println("Time:");
        for(int i = 0; i < time.size(); i++) {
            System.out.println("[" + i + "] " + time.get(i).toString());
        }

        System.out.println("\n\nDate:");
        for(int i = 0; i < date.size(); i++) {
            System.out.println("[" + i + "] " + date.get(i).toString());
        }


        System.out.println("Уведіть назву файлу, у який будуть збережені години:");
        saveTimesToFile(time, cin.nextLine());


        System.out.println("Уведіть назву файлу, у який будуть збережені дати:");
        saveDatesToFile(date, cin.nextLine());

    }



    public static void rearrange(List<Integer> list) {
        int first = 0;
        int last = list.size() - 1;

        while (first < last) {
            int current = list.get(first);

            if (current < 0) {
                list.remove(first);
                list.add(current);
                last--;
            } else {
                first++;
            }
        }
    }
    public static void task2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, -2, 9, -4, 0, 3, -1));

        System.out.println("Original list: " + list);
        rearrange(list);
        System.out.println("Rearranged list: " + list);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(" Java lab 5");

        Scanner cin = new Scanner(System.in);
        String choice = "";

        while (!Objects.equals(choice, "3")) {
            System.out.println("Enter task number (1-2) (3) to exit");
            choice = cin.nextLine();

            if(Objects.equals(choice, "1")) {
                task1();
            }
            if(Objects.equals(choice, "2")) {
                task2();
            }
        }
    }
}
