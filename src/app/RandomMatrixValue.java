package app;

import java.util.ArrayList;
import java.util.Random;

import promptInterface.Printer;

public class RandomMatrixValue {


    public static ArrayList<User> initRandomMatrixValues(int lenU, int lenL){
        ArrayList<User> users = new ArrayList<User>();
        int languages[] = new int[lenL], id = 1;
        Random random = new Random();

        for(int i = 0; i < lenU; i++){
            for(int j = 0; j < lenL; j++){
                languages[j] = random.nextInt(2);
            }

            users.add(new User(languages, id));
            languages = new int[lenL];
            id++;
        }
        
        Printer.printArray(users, lenL);

        return users;
    }
}
