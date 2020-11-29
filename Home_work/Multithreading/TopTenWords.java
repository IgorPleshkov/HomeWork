package Home_work.Multithreading;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopTenWords {
    /*
    Основной поток читает из файла текст, разбивает его на несколько частей
      Каждый поток получает свою часть, считает количество слов, переносит результат в общую мапу
      Основной поток выводит результат: топ N слов

      количество потоков = Runtime.getRuntime().availableProcessors();
     */
    public static void main(String[] args) {
        String fileFromText = "";
        Map<String, Integer> topTenWords = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("someFile.txt"));
            String str;
            while ((str = reader.readLine()) != null) {
                fileFromText += str + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> listFromText = new ArrayList<>(Arrays.asList(fileFromText.split(" ")));

        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];
        int tmp = listFromText.size() / threads.length + (listFromText.size() % threads.length);
        for (int i = 0; i < threads.length; i++) {
            int start = i * tmp;
            int stop = start + tmp;
            // System.out.println(start + "/" + stop);
            threads[i] = new Thread(() -> {
                for (int x = start; x < stop; x++) {
                    if (x >= listFromText.size()) { return; }
                    String str = listFromText.get(x);
                    synchronized (topTenWords) {
                        topTenWords.put(str, topTenWords.getOrDefault(str, 0) + 1);
                        // System.out.println(Thread.currentThread().getName());
                    }
                }
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int maxValue = (Collections.max(topTenWords.values()));
        int count = 1;
        for (int i = maxValue; i > 0; i--) {
            for (Map.Entry<String, Integer> pair : topTenWords.entrySet()) {
                if (count > 10) break;
                if (pair.getValue() == i) {
                    System.out.println("" + count + ". Слово - \"" + pair.getKey() + "\" встречается " + pair.getValue() + " раз(а).");
                    count++;
                }
            }
        }


    }
}
