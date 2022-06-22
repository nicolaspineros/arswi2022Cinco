package co.escuelaing.edu;

import java.util.ArrayList;
import java.util.Arrays;

public class GameService {
    private ArrayList<String> solution = new ArrayList<>(Arrays.asList("9","8","7","6"));
    int attempts = 6;
    int famas,picas;

    String result;
    private ArrayList<String> input;
    public GameService(){
    }

    public String tryNum(String inputN){
        famas=0;
        picas=0;
        input = new ArrayList<String>(Arrays.asList(inputN.split("")));
        attempts--;
        if (succesNumber()){
            return "Este es el numero correcto!";
        } else if (attempts > 0){
            return checkPicasandFamas();
        }
            return "Game Over";

    }

    private String checkPicasandFamas() {
        for (int i = 0; i < solution.size(); i++) {
            if (solution.contains(input.get(i))) {
                if (input.get(i).equals(solution.get(i))) {
                    famas++;
                } else { picas ++; }
            }
        }
        return picas + "Picas " + famas + "Famas";
    }

    public boolean succesNumber() {
        System.out.println("Solution: "+solution);
        System.out.println("Input: "+input);
        System.out.println(input.equals(solution));
        System.out.println(attempts);
        if (input.equals(solution) || famas == 4){
            return true;
        }
        return false;
    }
}
