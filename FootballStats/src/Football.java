import java.util.Arrays;
import java.util.Random;

public class Football {
    public static void main(String[] args) {
        int[][] aparitii = generateStats(30);


        System.out.println("Aparitiile jucatorilor: " + Arrays.toString(aparitii[0]));
        System.out.println("Golurile jucatorilor: " + Arrays.toString(aparitii[1]));
        System.out.println("Cel mai utilizat jucator este cel aflat la pozitia: " + getMostUsedPlayer(aparitii[0]));
        System.out.println("Goalgeterul echipei este jucatorul aflat la pozitia: " + getGoalgeter(aparitii[1]));
        System.out.println("Cel mai eficient jucator este cel  aflat la pozitia: "+efficiencyCalculator(aparitii[0], aparitii[1]));

    }


    public static int[][] generateStats(int numberOfPlayers) {
        int[][] numberOfAppearances = new int[2][numberOfPlayers];
        int maxNumberOfAppearances = 6;
        int maxNumberOfGoals = 20;
        Random r = new Random();
        for (int i = 0; i < numberOfAppearances[0].length; i++) {
            numberOfAppearances[0][i] = r.nextInt(maxNumberOfAppearances);
            numberOfAppearances[1][i] = r.nextInt(maxNumberOfGoals);
        }

        return numberOfAppearances;

    }

    public static int getMostUsedPlayer(int[] appearances) {
        int mostUsedPlayerIndex = 0;
        for (int i = 0; i < appearances.length; i++) {
            if (appearances[i] > appearances[mostUsedPlayerIndex]) {
                mostUsedPlayerIndex = i;
            }
        }
        return mostUsedPlayerIndex;

    }

    public static int getGoalgeter(int[] playerGoals) {
        int highestScorerIndex = 0;
        for (int i = 0; i < playerGoals.length; i++) {
            if (playerGoals[i] > playerGoals[highestScorerIndex]) {
                highestScorerIndex = i;
            }
        }
        return highestScorerIndex;

    }

    public static double efficiencyCalculator(int[] nrAparitii, int[] nrGoluri) {
        double eficienta;
        int mostEfficientPlayer=0;


        for (int i = 0; i < nrAparitii.length; i++) {
            eficienta = nrAparitii[i] / (double) nrGoluri[i];
            if (eficienta>0){
                mostEfficientPlayer=i;
            }

        }


        return mostEfficientPlayer;
    }

}

