package SystemDesign;


import java.util.Scanner;

// Main class
public class TicTacToeLLD {
    public static void main(String[] args) {
        Player p1 = new Player("Alice", CellValue.X);
        Player p2 = new Player("Bob", CellValue.O);

        Game game = new Game(3, p1, p2);
        game.play();
    }
}

// Enums
enum GameStatus {
    IN_PROGRESS, DRAW, WIN;
}

enum CellValue {
    EMPTY, X, O;
}

// Player class
class Player {
    private String name;
    private CellValue symbol;

    public Player(String name, CellValue symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public CellValue getSymbol() {
        return symbol;
    }
}

// Cell class
class Cell {
    private int row;
    private int col;
    private CellValue value;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = CellValue.EMPTY;
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

// Board class
class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].getValue() == CellValue.EMPTY) return false;
            }
        }
        return true;
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col].getValue() == CellValue.EMPTY;
    }

    public void makeMove(int row, int col, CellValue symbol) {
        grid[row][col].setValue(symbol);
    }

    public Cell[][] getGrid(){
        return grid;
    }

    public boolean checkWin(int row, int col, CellValue symbol) {
        boolean winRow = true, winCol = true, winDiag = true, winAntiDiag = true;

        for (int i = 0; i < size; i++) {
            if (grid[row][i].getValue() != symbol) winRow = false;
            if (grid[i][col].getValue() != symbol) winCol = false;
            if (grid[i][i].getValue() != symbol) winDiag = false;
            if (grid[i][size - i - 1].getValue() != symbol) winAntiDiag = false;
        }

        return winRow || winCol || winDiag || winAntiDiag;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getValue() + "\t");
            }
            System.out.println();
        }
    }
}

// Game class
class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private GameStatus status;

    public Game(int boardSize, Player p1, Player p2) {
        board = new Board(boardSize);
        players = new Player[]{p1, p2};
        currentPlayerIndex = 0;
        status = GameStatus.IN_PROGRESS;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (status == GameStatus.IN_PROGRESS) {
            board.printBoard();
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row and column (0-indexed): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= board.getGrid().length || col < 0 || col >= board.getGrid().length || !board.isCellEmpty(row, col)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board.makeMove(row, col, currentPlayer.getSymbol());

            if (board.checkWin(row, col, currentPlayer.getSymbol())) {
                status = GameStatus.WIN;
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                return;
            }

            if (board.isFull()) {
                status = GameStatus.DRAW;
                board.printBoard();
                System.out.println("Game is a draw!");
                return;
            }

            currentPlayerIndex = 1 - currentPlayerIndex;
        }
    }
}


