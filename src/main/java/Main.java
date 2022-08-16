import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader readCSV = new BufferedReader(new FileReader("UserInfo.csv"));
        Gson gson = new Gson();

        while (true) {
            String line = readCSV.readLine(); // Получаем строку
            if (line == null) {
                break;
            }
            String[] lineSep = line.split(","); // Делим слова через запятые (4 слова)

            Account account = new Account(lineSep[0], lineSep[1], lineSep[2], lineSep[3]);
            String json = gson.toJson(account);
            System.out.println(json);
        }
    }
}

class Account {
    private String login;
    private String name;
    private String age;
    private String numberPoints;

    public Account(String login, String name, String age, String numberPoints) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.numberPoints = numberPoints;
    }

    @Override
    public String toString() {
        return "Account{" + "login='" + login + '\'' + ", name='" + name + '\'' + ", age=" + age + ", numberPoints=" + numberPoints + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return age == account.age && numberPoints == account.numberPoints && Objects.equals(login, account.login) && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, numberPoints);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumberPoints() {
        return numberPoints;
    }

    public void setNumberPoints(String numberPoints) {
        this.numberPoints = numberPoints;
    }
}
