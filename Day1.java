import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {


    private static List<String> values = new ArrayList<>();


    public static int addFromText(){
        int total = 0;


        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("resources/day1.1 text"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while(scanner.hasNextLine()){
            String value = scanner.useDelimiter("\r\n").next();
            values.add(value);
        }

        for(String s: values){






            s = s.replace("nine", "nine9nine");
            s = s.replace("eight", "eight8eight");
            s = s.replace("two", "two2two");
            s = s.replace("one", "one1one");
            s = s.replace("three", "three3three");
            s = s.replace("four", "four4four");
            s = s.replace("five", "five5five");
            s = s.replace("six", "six6six");
            s = s.replace("seven", "seven7seven");



            StringBuilder sb = new StringBuilder();
            StringBuilder nums = new StringBuilder();
            sb.append(s).reverse();
            String reversed = sb.toString();


            String[] spilt = s.split("");
            String[] reverseSplit = reversed.split("");

            for( String number : spilt){
                if(number.equals("1") || number.equals("2") || number.equals("3") ||
                        number.equals("4") || number.equals("5") || number.equals("6") ||
                        number.equals("7") || number.equals("8") || number.equals("9") ){

                    nums.append(number);
                    break;
                }
            }

            for( String numberReversed : reverseSplit){
                if(numberReversed.equals("1") || numberReversed.equals("2") || numberReversed.equals("3") ||
                        numberReversed.equals("4") || numberReversed.equals("5") || numberReversed.equals("6") ||
                        numberReversed.equals("7") || numberReversed.equals("8") || numberReversed.equals("9") ){

                    nums.append(numberReversed);
                    break;
                }
            }

            String number = nums.toString();
            int fin = Integer.parseInt(number);

            total+= fin;

        }

        return total;
    }
}
