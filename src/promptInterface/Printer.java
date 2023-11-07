package promptInterface;

public class Printer {
    
    public static void printArray(int[][] Matrix, int valueI, int valueJ){
        for(int i = 0; i < valueI; i++){
            System.out.printf("User " + (i+1) + ": ");
            for(int j = 0; j < valueJ; j++){
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
