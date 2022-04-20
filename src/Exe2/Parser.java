package Exe2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
//Задание2

public class Parser {

    final static String regex = "^[Сс]трада(.*)";

    public ArrayList<String> parse(File file) {

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(file).useDelimiter("[^а-яА-Я]+")) {

            String line = "";

            while (scanner.hasNextLine()) {
                lines.add(line);
                line = scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            words.addAll(Arrays.asList(line.split("[^а-яА-Я]+")));
        }

        Pattern pattern = Pattern.compile(regex);

        for (String word : words) {
            if (pattern.matcher(word).find()) {
                Main.sufferingWords.offer(word);
            }
        }
        return lines;
    }
}

