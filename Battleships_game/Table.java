import java.util.Scanner;
import java.lang.Math;

abstract class Table {
    private char[][] gameTable = new char[10][10];
    private int chosenRowToFill;
    private int chosenColumnToFill;
    private int amountOfShips;
    public void setChosenRowToFill(int chosenRowToFill) {
        this.chosenRowToFill = chosenRowToFill; 
    }
    public void setChosenColumnToFill(int chosenColumnToFill) {
        this.chosenColumnToFill = chosenColumnToFill;
    }
    public int getChosenRowToFill() {
        return chosenRowToFill;
    }
    public int getChosenColumnToFill() {
        return chosenColumnToFill;
    }
    public int getAmountOfShips() {
        return amountOfShips;
    }
    public void setAmountOfShips(int amountOfShips) {
        this.amountOfShips = amountOfShips;
    }
    public void initializeTable() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                gameTable[j][i] = '0';
            }
        }
    }
    public void setTableField(int gameTableRow, int gameTableColumn, char gameTableField) {
        gameTable[gameTableRow][gameTableColumn] = gameTableField;
    }
    public void setShotTableField(int gameTableRow, int gameTableColumn, char gameTableField) {
        gameTable[gameTableRow][gameTableColumn] = gameTableField;
    }
    public char getTableField(int gameTableRow, int gameTableColumn) {
        return gameTable[gameTableRow][gameTableColumn];
    }
    public char[][] getGameTable(){
        return gameTable;
    }
    public void fillWithShips() {};
}
class UserTable extends Table {
    public void fillWithShips(int fillRow, int fillColumn) {
        setChosenRowToFill(fillRow);
        setChosenColumnToFill(fillColumn);
        setTableField(getChosenRowToFill(), getChosenColumnToFill(), '1');
    }
}
class EnemyTable extends Table {
    public void fillWithShips() {
        setChosenRowToFill((int)(Math.random() * 9));
        setChosenColumnToFill((int)(Math.random() * 9));
        while(getTableField(getChosenRowToFill(), getChosenColumnToFill()) == '1'){
            setChosenRowToFill((int)(Math.random() * 9));
            setChosenColumnToFill((int)(Math.random() * 9));
        }
        setTableField(getChosenRowToFill(), getChosenColumnToFill(), '1');
    }
}