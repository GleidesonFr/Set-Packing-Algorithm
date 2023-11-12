package app;

import java.util.ArrayList;
import java.util.Arrays;

import promptInterface.Printer;

public class SetPacking {

    private static boolean[] combinations; //array que armazena as combinações da solução

    private static boolean verifyDisjuctionWithArray(ArrayList<User> cumulative, User user){ //função que verifica se um conjunto comum e outro empacotado são disjuntos
        if(cumulative.isEmpty()){ //verifica se o array cumulativo está vazio
            return true; //caso esteja, ele é disjunto
        }else{
            for (User userCumulative : cumulative) {
                int[] userC = userCumulative.getLanguages(); //armazena os idiomas do usuário que está no array cumulativo
                int[] userU = user.getLanguages(); //armazena os idiomas do usuário comum
                for (int i = 0; i < userU.length; i++) {
                    if(userC[i] == 1 && userU[i] == 1){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static boolean verifyDisjuction(User userMaster, User userCommon){ //função que verifica se dois conjuntos são disjuntos
        int[] array = userCommon.getLanguages(); //armazena os idiomas do usuário comum
        int i = 0;

        for(int language : userMaster.getLanguages()){
            if(language == 1 && array[i] == 1){ //se os dois usuários falam uma mesma lingua, eles não são disjuntos (return false)
                return false;
            }
            i++;
        }

        return true;
    }

    private static void insertToArray(ArrayList<User> Cumulative){ //insere valores da variável cumulativa na de combinações
        Arrays.fill(combinations, false);
        for (User user : Cumulative) {
            combinations[user.getId() - 1] = true; //adiciona true ao array caso exista um elemento nessa posição (combinations é um array que usa referência booleana)
        }
    }

    private static boolean isCombinationsEmpty(){ //verifica se o array de combinação está vazio
        for (int index = 0; index < combinations.length; index++) {
            if(combinations[index] == true){
                return false;
            }
        }

        return true;
    }

    private static boolean verifyMax(ArrayList<User> Cumulative){
        int countCombinations = 0; //variável usada para contar quantos elementos estão no array de combinações
        for(int i = 0; i < combinations.length; i++){
            if(combinations[i] == true){
                countCombinations++; //caso seja verdadeiro, adicione mais uma unidade
            }
        }

        if(countCombinations < Cumulative.size()){ //verifica qual array tem maior quantidade de elementos
            return true;
        }else{
            return false;
        }
    }

    private static boolean storeCombinations(ArrayList<User> Cumulative){ //função de controle que armazena a melhor combinação
        if(!isCombinationsEmpty()){ //verifica se o array de combinações não está vazio
            if(verifyMax(Cumulative)){ //se não estiver, verifica qual é a solução com mais elementos possíveis
                insertToArray(Cumulative); //se o maior vier do array cumulativo, adicione seus elementos nele
                return true;
            }else{
                return false;
            }
        }else{
            insertToArray(Cumulative); //caso o array de combinações esteja vazio, insira os elementos nele
            return true;
        }
    }

    private static void recursiveSetPacking(ArrayList<User> users, ArrayList<User> Cumulative){ //resolve de maneira recursiva o problema do empacotamento usando o array maximal
        boolean verification; //variável de retorno usada para verificar se existe ou não disjunção entre os elementos

        for (int i = 0; i < users.size(); i++) {
            verification = verifyDisjuctionWithArray(Cumulative, users.get(i)); //função verifica se o conjunto é disjunto ou não
            if(verification){
                Cumulative.add(users.get(i)); //caso seja disjunto, adiciona ao array cumulativo
                recursiveSetPacking(users, Cumulative); //chama a função recursivamente
            }
        }
            storeCombinations(Cumulative); // função que armazena a melhor combinação encontrada até agora
    }
    
    public static void SetPackingAlgorithm(ArrayList<User> users){ //função de força bruta para o empacotamento de conjuntos
        ArrayList<User> storeUsers = new ArrayList<User>(); //variável que armazena a sequência maximizada de usuários em relação a um deles
        ArrayList<User> cumulative = new ArrayList<User>(); //variável que armazena os idiomas que os usuários falam de maneira acumulada
        combinations = new boolean[users.size()]; //inicializa a váriável onde será armazenada a melhor solução
        boolean verification; //variável de retorno caso um conjunto seja disjunto ou não

        for(int i = 0; i < users.size(); i++){
            storeUsers.add(users.get(i)); //usuário base é armazenado para se realizar comparações em relação a ele próprio.
            for(int j = 0; j < users.size(); j++){
                if(i != j){
                    verification = verifyDisjuction(users.get(i), users.get(j)); //verifica a disjunção entre elementos e retorna true/false
                    if(verification){
                        storeUsers.add(users.get(j)); //caso seja disjunto, armazena o valor na váriável
                    }
                }
            }
            recursiveSetPacking(storeUsers, cumulative); //faz o processo de empacotamento de maneira recursiva.
            storeUsers.clear(); //limpa o array com a primeira sequência máxima.
        }

        Printer.printSolution(combinations); //imprime o resultado no prompt
    }
}
