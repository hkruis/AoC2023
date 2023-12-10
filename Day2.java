import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    private static List<String> values = new ArrayList<>();

    public static int reaedGames() {
        int total = 0;
        int mid = 0;

        int total2 = 0;
        int gameNum = 1;

        int red = 12;
        int green = 13;
        int blue = 14;




        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("resources/day2 text"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while (scanner.hasNextLine()) {
            String value = scanner.useDelimiter("\r\n").next();
            values.add(value);
        }

        for (String game : values) {
            boolean redCondition = true;
            boolean greenCondition = true;
            boolean blueCondition = true;

            int red2 = 0;
            int green2 = 0;
            int blue2 =0;

            String replacement = "Game " + gameNum + ":";
            game = game.replace(replacement, "");

            Scanner scanner1 = new Scanner("game");
            String[] guesses = game.split(";");
            for (String color : guesses) {
                String[] diff = color.split(",");

                for (String fin : diff) {
                    if (fin.contains("blue")) {
                        fin = fin.replace("blue", "").trim();
                        int blueComp = Integer.parseInt(fin);
                        if(blueComp > blue2) blue2 = blueComp;
                        if (blueComp > blue) {
                            blueCondition = false;
                        }
                    } else if (fin.contains("red")) {
                        fin = fin.replace("red", "").trim();
                        int redComp = Integer.parseInt(fin);
                        if(redComp > red2) red2 = redComp;
                        if (redComp > red) {
                            redCondition = false;
                        }
                    } else {
                        fin = fin.replace("green", "").trim();
                        int greenComp = Integer.parseInt(fin);
                        if(greenComp > green2) green2 = greenComp;
                        if (greenComp > green) {
                            greenCondition = false;
                        }
                    }

                }

            }
            mid = blue2* red2* green2;
            if (redCondition && greenCondition && blueCondition) {
                total += gameNum;
            }
            gameNum++;
            total2+=mid;
        }
        return total;

    }
}
