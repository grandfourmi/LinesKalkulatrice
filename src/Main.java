import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Калькулятор строк готов к работе.\nВведите вашу строку (не более 10 символов) в кавычках" +
                "\nзатем +,-,/,* и следом еще одну строку или число от 1 до 10.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] data;
        String operation = null;
        sc.close();

        if (input.contains(" + ")) {
            data = input.split(" \\+ ");
            operation = "+";
        } else if (input.contains(" - ")) {
            data = input.split(" - ");
            operation = "-";
        } else if (input.contains(" * ")) {
            data = input.split(" \\* ");
            operation = "*";
        } else if (input.contains(" / ")) {
            data = input.split(" / ");
            operation = "/";
        } else {
            throw new Exception("Некорректный знак действия");
        }
        String premier = data[0];
        String deuxieme = data[1];

        Boolean isNumeric = true;
        int index = premier.indexOf(deuxieme);
        isNumeric = premier.matches("-?\\d+(\\.\\d+)?");
        if (isNumeric) {
            throw new Exception("Число не может быть первым");
        }

        if (premier.length() > 12 | deuxieme.length() > 12) {
            throw new Exception("Строка слишком длинная");
        }
        isNumeric = deuxieme.matches("-?\\d+(\\.\\d+)?");
        if (isNumeric) {
            int leChiffre = Integer.parseInt(deuxieme);
            if (leChiffre < 1 | leChiffre > 10) {
                throw new Exception("Возможно использовать число только от 1 до 10");
            }
        }
        switch (operation) {
            case "+":
                if (isNumeric) {
                    throw new Exception("Нельзя складывать строку и число");
                } else {
                    sortieConsole("\"" + premier + deuxieme + "\"");
                }
                break;
            case "*":
                if (isNumeric != true) {
                    throw new Exception("Умножать можно только на число");
                } else {
                    int multiplicateur = Integer.valueOf(deuxieme);
                    String repondre = "";

                    for (int i = 0; i < multiplicateur; i++) {
                        repondre += premier;
                    }
                    sortieConsole(repondre);
                }
                break;
            case "/":
                if (isNumeric != true) {
                    throw new Exception("Для деления необходимо число");
                } else {
                    int d = Integer.valueOf(deuxieme);
                    int longer = premier.length() / d;
                    sortieConsole("\"" + premier.substring(0, longer) + "\"");
                }
                break;
            case "-":
                char a = data[1].charAt(1);
                int indexA = data[0].indexOf(a);

                if (indexA==-1){
                    System.out.println(data[0]);

                } else {
                    System.out.println(data[0].substring(0,indexA));
                }

                }
        }
           static void sortieConsole (String repondre){
        System.out.println((repondre.length() < 40) ? "\"" + repondre.replace("\"", "") + "\"" :
                "\"" + repondre.replace("\"", "").substring(0, 40) + "..." + "\"");
    }
}

