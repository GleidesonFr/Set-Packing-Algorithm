package promptInterface;

import java.util.ArrayList;

import app.User;

public class Printer {
    
    public static void printArray(ArrayList<User> users, int lenL){
        int i = 0;
        for(User user : users){
            System.out.printf("User " + (i + 1) + ": ");
            for(int language : user.getLanguages()){
                System.out.print(language + " ");
            }
            System.out.println();
            i++;
        }
    }

    public static void printSolution(boolean[] combinations){
        System.out.printf("Solution: Users ");
        for(int i = 0; i < combinations.length; i++){
            if(combinations[i] == true){
                System.out.print((i + 1) + " ");
            }
        }

        System.out.printf("form a good combination :)");
    }
}
