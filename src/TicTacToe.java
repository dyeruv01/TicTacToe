import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static void main(String[] args) {

        //printing the gameboard

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};


        printGameBoard(gameBoard);

        while (true)
        {
            String result = checkWinner();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9)");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos)|| cpuPositions.contains(playerPos))
            {
                System.out.println("Position taken!");
                playerPos= scan.nextInt();
            }
            placePiece(gameBoard,playerPos,"player");
            if (result.length()>0)
            {
                System.out.println(result);
                break;
            }


            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            while (playerPositions.contains(cpuPos)|| cpuPositions.contains(playerPos))
            {
                System.out.println("Position taken!");
                cpuPos= scan.nextInt();
            }
            placePiece(gameBoard,cpuPos,"cpu");

            printGameBoard(gameBoard);

            if (result.length()>0)
            {
                System.out.println(result);
                break;
            }

        }
    }

        public static void printGameBoard(char[][] gameBoard)
        {
            for(char[] row : gameBoard)
            {
                for (char c: row)
                {
                    System.out.print(c);

                }
                System.out.println();
            }
        }


        public static void placePiece(char[][] gameBoard, int pos, String user)
        {

            char symbol='X';

            if (user.equals("Player"))
            {
                symbol = 'X';
                playerPositions.add(pos);
            } else if (user.equals("cpu")) {
                symbol ='0';
                cpuPositions.add(pos);
            }
            switch(pos)
            {
                case 1 :
                    gameBoard[0][0] = symbol;break;
                case 2 :
                    gameBoard[0][2] = symbol;break;
                case 3 :
                    gameBoard[0][4] = symbol;break;
                case 4:
                    gameBoard[2][0] = symbol;break;
                case 5 :
                    gameBoard[2][2] = symbol;break;
                case 6 :
                    gameBoard[2][4] = symbol;break;
                case 7 :
                    gameBoard[4][0] = symbol;break;
                case 8:
                    gameBoard[4][2] = symbol;break;
                case 9:
                    gameBoard[4][4] = symbol;break;
                default: return;
            }
        }

        public static String checkWinner()
        {
            List topRow = Arrays.asList(1,2,3);
            List midRow = Arrays.asList(4,5,6);
            List botRow = Arrays.asList(7,8,9);

            List leftCol = Arrays.asList(1,4,7);
            List midCol = Arrays.asList(2,5,8);
            List rightCol = Arrays.asList(3,6,9);

            List firstD = Arrays.asList(1,5,9);
            List secondD = Arrays.asList(3,5,7);

            List<List> winningConditions = new ArrayList<List>();
            winningConditions.add(topRow);
            winningConditions.add(midRow);
            winningConditions.add(botRow);
            winningConditions.add(leftCol);
            winningConditions.add(midCol);
            winningConditions.add(rightCol);
            winningConditions.add(firstD);
            winningConditions.add(secondD);


            for (List l: winningConditions)
            {
                if (playerPositions.containsAll(l))
                {
                    return "Congratz";
                }
                else if (cpuPositions.containsAll(l)) {
                    return "CPU Wins";
                }
                else if (playerPositions.size()+cpuPositions.size()==9)
                {
                    return "Aiyoo tie";
                }
            }
            return "";
        }
}