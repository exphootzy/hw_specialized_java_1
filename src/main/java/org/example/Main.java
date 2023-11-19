package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue lotera = new PriorityQueue<>(new ToyComparator(SortType.Descending));
        Scanner scanner = new Scanner(System.in);

        Toy toy1 = new Toy("Плюшевый мишка");
        Toy toy2 = new Toy("Барби");
        Toy toy3 = new Toy("Машинка");
        Toy toy4 = new Toy("Халк");
        Toy toy5 = new Toy("Фотоаппарат");
        Toy toy6 = new Toy("Коляска для куклы");
        System.out.println("Введите наименование через клавшу ENTER трёх игрушек для участия в лотереи");
        Toy toy7 = new Toy(scanner.nextLine());
        Toy toy8 = new Toy(scanner.nextLine());
        Toy toy9 = new Toy(scanner.nextLine());

        lotera.add(toy1);
        lotera.add(toy2);
        lotera.add(toy3);
        lotera.add(toy4);
        lotera.add(toy5);
        lotera.add(toy6);
        lotera.add(toy7);
        lotera.add(toy8);
        lotera.add(toy9);


        System.out.println("Запускаем лотерею: \n***************************************");

        try (FileWriter writer = new FileWriter("Results.txt")) {
            for (int i = lotera.size(); i > 0; i--) {
                Toy priz = (Toy) lotera.remove();
                System.out.println("Вам выпало: \n" + priz + "\n_________________________");
                writer.write(priz.toString() + "\n");
            }
            System.out.println("Успешно.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }






    }
}