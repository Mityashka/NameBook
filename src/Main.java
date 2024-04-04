import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите через пробел:");
            System.out.println("Фамилия, Имя, Отчество, Дата рождения dd.mm.yyyy, телефон, пол(m/f):");

            String userDataInput = scanner.nextLine();
            String[] userDataArray = userDataInput.split(" ");
            if (userDataArray.length != 6) {
                throw new InvalidDataFormatException("Пропущены одно или несколько полей");
            }

            UserData userData = new UserData(userDataArray[0], userDataArray[1], userDataArray[2], userDataArray[3], Long.parseLong(userDataArray[4]), userDataArray[5]);

            String fileName = userData.getLastName() + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(userDataInput + "\n");
            fileWriter.close();
            System.out.println("Данные упешно сохранены в: " + fileName);

            scanner.close();
        } catch (InvalidDataFormatException | IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}