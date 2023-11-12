package promptInterface;

public class Menu {
    
    public static void choicesToProcess(){
        System.out.println();
        System.out.println("1 - Generate Matrix");
        System.out.println("2 - Set Packing (Brute Force)");
        System.out.println("3 - Generate Time Process Algorithm (Brute Force)");
        System.out.println("4 - Set Packing (Heuristic)");
        System.out.println("5 - Generate Time Process Algorithm (Heuristic)");
        System.out.println("6 - Exit");
        System.out.println();
    }

    public static void logo(){
        System.out.println();
        System.out.println("<---------- LingoChat ---------->");
        System.out.println();
    }

    public static void comingSoonMessage(){
        System.out.println();
        System.out.println("This part is creation. It's open in soon! :)");
        System.out.println();
    }

    public static void selection(){
        System.out.println();
        System.out.printf("Type: ");
    }

    public static void firstQuestion(){
        System.out.println();
        System.out.printf("How many users you want in a chat?: ");
    }

    public static void secondQuestion(){
        System.out.println();
        System.out.printf("How many languages you want to limit the array?: ");
    }

    public static void errorInTyping(){
        System.out.println();
        System.out.printf("Sorry, but this value not is valid. Please, try again: ");
    }

    public static void seeYouLaterMessage(){
        System.out.println();
        System.out.println("See you later, dev! :)");
    }
}
