package app;

import java.util.Scanner;

import promptInterface.Menu;

public class App {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection, valueI = 0, valueJ = 0, Matrix[][];

        while (true) {
            Menu.logo();
            Menu.choicesToProcess();
            Menu.selection();
            selection = sc.nextInt();

            while(selection < 1 && selection > 6){
                Menu.errorInTyping();
                selection = sc.nextInt();
            }

            switch (selection) {
                case 1:
                    Menu.logo();
                    Menu.firstQuestion();
                    valueI = sc.nextInt();
                    Menu.secondQuestion();
                    valueJ = sc.nextInt();
                    Matrix = RandomMatrixValue.initRandomMatrixValues(valueI, valueJ);
                break;
                case 2:
                    Menu.comingSoonMessage();
                break;
                case 3:
                    Menu.comingSoonMessage();
                break;
                case 4:
                    Menu.comingSoonMessage();
                break;
                case 5:
                    Menu.comingSoonMessage();
                break;
                case 6:
                    sc.close();
                    System.exit(0);
                break;
            }
        }
    }
}
