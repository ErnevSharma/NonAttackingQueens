public class NonattackingQueen {

    int[] queens;   
    
    final int NUM_QUEENS = 8;
 
    public NonattackingQueen()
    {
        queens = new int[NUM_QUEENS];
    }

  
    boolean canPlace(int queenNumber, int column)
    {
        for (int row = 0; row < queenNumber; row++) // check all rows above queenNumber row
        {

            if (queens[row] == column) // in the same column
                return false;
            if (Math.abs(queens[row] - column) == Math.abs(row - queenNumber)) // same diagonal
                return false;
        }
        return true;
    }
    
   
    public void solve(int queenNumber)
    {
        for (int column = 0; column < NUM_QUEENS; column++)  // iterate through all columns
        {
            if (canPlace(queenNumber, column)) // queen can be placed in current column
            {
                queens[queenNumber] = column;  // place queen in current column
                

                if (queenNumber + 1 >= NUM_QUEENS) // solved
                    printSolution();
                else    // keep looking
                    solve(queenNumber + 1);
            }
        }
    }

   
    public void showSolutions()
    {
        solve(0);  // start with the first row
    }
    
  
    private void printSolution()
    {
        int column;
        for (int row=0; row<NUM_QUEENS; row++)
        {
            for (column = 0; column<NUM_QUEENS; column++)
                if (queens[row] == column)
                    System.out.print(" X");
                else 
                    System.out.print(" 0");
            System.out.print("\n");
        }
        System.out.println("\n-----------------------");

    }
    
    public static void main (String args[]) {
        new NonattackingQueen().showSolutions();
    }
}
