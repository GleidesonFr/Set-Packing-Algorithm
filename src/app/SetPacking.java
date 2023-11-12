package app;

import java.util.ArrayList;

public class SetPacking {

    private static boolean[] combinations;

    public static boolean verifyDisjuctionWithArray(ArrayList<User> cumulative, User user){
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

    public static boolean verifyDisjuction(User userMaster, User userCommon){
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

    public static int[] insertToArray(User user){
        int[] array = new int[user.getLanguages().length];
        int i = 0;

        for (int language : user.getLanguages()) {
            array[i] = language;
        }

        return array;
    }

    public static boolean verifyMax(ArrayList<User> Cumulative){
        return true; //is comming
    }

    public static boolean storeCombinations(ArrayList<User> Cumulative){
        return true; //is comming
    }

    public static void recursiveSetPacking(ArrayList<User> users, ArrayList<User> Cumulative){
        boolean verification;

        for (int i = 0; i < users.size(); i++) {
            verification = verifyDisjuctionWithArray(Cumulative, users.get(i));
            if(verification){
                Cumulative.add(users.get(i));
                recursiveSetPacking(users, Cumulative);
            }
        }
            //... is comming ...

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
    }
}
