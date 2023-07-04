// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook
// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле
// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.*;

public class homeworkSeminar6 {
    public static void main(String[] args) {
        Map<String, String> crete_map; 
        System.out.println();
        Notebook notebook1 = new Notebook("Asus", 8, 512, "Windows 7", "белый");
        Notebook notebook2 = new Notebook("Acer", 6, 256, "Windows 10", "черный");
        Notebook notebook3 = new Notebook("Huawei", 8, 256, "Windows 8", "синий");
        Notebook notebook4 = new Notebook("Lenovo", 4, 128, "Windows 11", "красный");
        Notebook notebook5 = new Notebook("MacBook", 16, 1024, "MacOS", "серый");
        ArrayList<Notebook> spisok = new ArrayList<>();
        spisok.add(notebook1);
        spisok.add(notebook2);
        spisok.add(notebook3);
        spisok.add(notebook4);
        spisok.add(notebook5);
        System.out.println("Здравствуйте, в наличии имеются следующие ноутбуки: ");
        for (var item : spisok) {
            System.out.println(item);
        }
        System.out.println();
        crete_map = Filter();
        FindList(crete_map, spisok);

    }

    static void FindList(Map<String, String> crete_map, ArrayList<Notebook> n_list) {
        ArrayList<Notebook> finalRes = new ArrayList<>();
        System.out.println();
        for (var notebook : n_list) {
            if ((crete_map.containsKey("Ram")) && (notebook.getRam() < Integer.parseInt(crete_map.get("Ram")))) {
                notebook.setName("");
            }
            if ((crete_map.containsKey("SD")) && (notebook.getSd() < Integer.parseInt(crete_map.get("SD")))) {
                notebook.setName("");
            }

            if ((crete_map.containsKey("OS")) && (!notebook.getOs().equals(crete_map.get("OS")))) {
                notebook.setName("");
            }
            if ((crete_map.containsKey("Цвет")) && (!notebook.getColor().equals(crete_map.get("Цвет")))) {
                notebook.setName("");
            }
        }
        for (var i : n_list) {
            if (!i.getName().equals("")) {
                finalRes.add(i);
            }
            System.out.println();
        }
        if (finalRes.size() > 0) {
            System.out.println();
            System.out.println("Cоответствуют: ");

            for (var item : finalRes) {
                System.out.println(item);
            }
            System.out.println();
        } else {
            System.out.println("Соответствий не найдено");
        }

    }

    static Map<String, String> Filter() {
        String os = "";
        String color = "";
        Map<String, String> fin = new HashMap<>();
        Boolean getOut = false;
        while (!getOut) {
            System.out.println();
            System.out.println("Введите данные для фильтра: ");
            System.out.println("1 - Выбрать ОЗУ: ");
            System.out.println("2 - Выбрать объем памяти: ");
            System.out.println("3 - Операционная система: ");
            System.out.println("4 - Выбор цвета: ");
            Scanner sc = new Scanner(System.in);
            String op = sc.nextLine();
            switch (op) {
                case "1": {
                    System.out.println("4, 6, 8 или 16? ");
                    fin.put("Ram", sc.nextLine());
                    break;
                }
                case "2": {
                    System.out.println("128, 256, 512 или 1024? ");
                    fin.put("SD", sc.nextLine());
                    break;
                }
                case "3": {
                    System.out.println("1 - Windows7, 2 - Windows8, 3 - Windows10, 4 - Windows11 или 5 - MacOS ");
                    String oper = sc.nextLine();
                    switch (oper) {
                        case "1": {
                            os = "Windows 7";
                            break;
                        }
                        case "2": {
                            os = "Windows 8";
                            break;
                        }
                        case "3": {
                            os = "Windows 10";
                            break;
                        }
                        case "4": {
                            os = "Windows 11";
                            break;
                        }
                        case "5": {
                            os = "MacOS";
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    fin.put("OS", os);
                    break;
                }
                case "4": {
                    System.out.println("1 - белый, 2 - черный, 3 - синий, 4 - красный или 5 - серый? ");
                    String oper = sc.nextLine();
                    switch (oper) {
                        case "1": {
                            color = "белый";
                            break;
                        }
                        case "2": {
                            color = "черный";
                            break;
                        }
                        case "3": {
                            color = "синий";
                            break;
                        }
                        case "4": {
                            color = "красный";
                            break;
                        }
                        case "5": {
                            color = "серый";
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    fin.put("Цвет", color);
                    break;
                }
                case "": {
                    getOut = true;
                    break;
                }
                default: {
                    break;
                }
            }
            for (Entry<String, String> item : fin.entrySet()) {
                String key = item.getKey();
                String value = item.getValue();
                System.out.print(key + ":" + value + " ");
            }
        }
        return fin;

    }
}