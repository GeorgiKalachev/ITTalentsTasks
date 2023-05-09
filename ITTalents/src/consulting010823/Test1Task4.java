package consulting010823;

public class Test1Task4 {

    public static void main(String[] args) {

        /*
        Write a method that by given map of a parking lot and the coordinates of the
        entrance of the parking lot, finds the smallest amount of steps you need to park your
        car. You can drive on squares marked with ' ' (space). A free parking spot is marked
        with 'F'. Spots that are already taken are marked with 'T'. You cannot pass through
        taken parking spots. The method must return an integer value equal to the smallest
        amount of moves that are needed to park the car or -1 if there is no available parking
        spot.
        If you consider this hard, try to return whether you can park your car or not, no matter
        the steps. (-5%)
         */

        char[][] parking = {
                {' ',' ','T',' ','T',' ',' ',' ','T',' ',' ',},
                {'T','T','T',' ','T','T','T','T','T',' ','T',},
                {' ',' ','T',' ','T',' ',' ',' ',' ',' ',' ',},
                {' ',' ','T',' ','T',' ','F',' ',' ',' ',' ',},
                {'T',' ',' ',' ','T',' ',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ','F',' ',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',}
        };
        System.out.println(tryToPark(parking, 0, 3, 0));
    }

    static int tryToPark(char[][] parking, int myI, int myJ, int steps){
        if(myI < 0 || myI >= parking.length || myJ < 0 || myJ >= parking[0].length || parking[myI][myJ] == 'T'){
            return -1;
        }
        steps++;
        if(parking[myI][myJ] == 'F'){
            return steps;
        }
        parking[myI][myJ] = 'T';
        int rightSteps =    tryToPark(parking, myI, myJ+1, steps);
        int leftSteps =     tryToPark(parking, myI, myJ-1, steps);
        int bottomSteps =   tryToPark(parking, myI+1, myJ, steps);
        int topSteps =      tryToPark(parking, myI-1, myJ, steps);
        //return min from those 4 variables that is > 0 or -1 if all are -1
        int[] stepsArr = {leftSteps, rightSteps, topSteps, bottomSteps};
        //-1 3 -1 2
        if(leftSteps == -1 && rightSteps == -1 && topSteps == -1 && bottomSteps == -1 ){
            return -1;
        }
        else {
            int min = -1;
            for (int i = 0; i < stepsArr.length; i++) {
                if(stepsArr[i] > 0){
                    if(min == -1 || stepsArr[i] < min) {
                        min = stepsArr[i];
                    }
                }
            }
            return min;
        }
    }
}
