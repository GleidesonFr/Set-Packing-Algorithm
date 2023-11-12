package app;

import java.util.ArrayList;
import java.util.Arrays;

import promptInterface.Printer;

public class SetPacking {

    private static boolean[] combinations;

    private static boolean verifyDisjuctionWithArray(ArrayList<User> cumulative, User user){
        if(cumulative.isEmpty()){
            return true;
        }else{
            for (User userCumulative : cumulative) {
                int[] userC = userCumulative.getLanguages();
                int[] userU = user.getLanguages();
                for (int i = 0; i < userU.length; i++) {
                    if(userC[i] == 1 && userU[i] == 1){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static boolean verifyDisjuction(User userMaster, User userCommon){
        int[] array = userCommon.getLanguages();
        int i = 0;

        for(int language : userMaster.getLanguages()){
            if(language == 1 && array[i] == 1){
                return false;
            }
            i++;
        }

        return true;
    }

    private static void insertToArray(ArrayList<User> Cumulative){
        Arrays.fill(combinations, false);
        for (User user : Cumulative) {
            combinations[user.getId() - 1] = true;
        }
    }

    private static boolean isCombinationsEmpty(){
        for (int index = 0; index < combinations.length; index++) {
            if(combinations[index] == true){
                return false;
            }
        }

        return true;
    }

    private static boolean verifyMax(ArrayList<User> Cumulative){
        int countCombinations = 0;
        for(int i = 0; i < combinations.length; i++){
            if(combinations[i] == true){
                countCombinations++;
            }
        }

        if(countCombinations < Cumulative.size()){
            return true;
        }else{
            return false;
        }
    }

    private static boolean storeCombinations(ArrayList<User> Cumulative){
        if(!isCombinationsEmpty()){
            if(verifyMax(Cumulative)){
                insertToArray(Cumulative);
                return true;
            }else{
                return false;
            }
        }else{
            insertToArray(Cumulative);
            return true;
        }
    }

    private static void recursiveSetPacking(ArrayList<User> users, ArrayList<User> Cumulative){
        boolean verification;

        for (int i = 0; i < users.size(); i++) {
            verification = verifyDisjuctionWithArray(Cumulative, users.get(i));
            if(verification){
                Cumulative.add(users.get(i));
                recursiveSetPacking(users, Cumulative);
            }
        }
            storeCombinations(Cumulative);
    }
    
    public static void SetPackingAlgorithm(ArrayList<User> users){
        ArrayList<User> storeUsers = new ArrayList<User>();
        ArrayList<User> cumulative = new ArrayList<User>();
        combinations = new boolean[users.size()];
        boolean verification;

        for(int i = 0; i < users.size(); i++){
            storeUsers.add(users.get(i));
            for(int j = 0; j < users.size(); j++){
                if(i != j){
                    verification = verifyDisjuction(users.get(i), users.get(j));
                    if(verification){
                        storeUsers.add(users.get(j));
                    }
                }
            }
            recursiveSetPacking(storeUsers, cumulative);
        }

        Printer.printSolution(combinations);
    }
}
