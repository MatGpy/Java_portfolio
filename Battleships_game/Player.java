import java.util.HashSet;
import java.util.Scanner;
import java.lang.Math;
import java.util.Set;
import javax.swing.JOptionPane;

abstract class Player {
    private int amountOfShotShips;
    public int chosenRowToShoot;
    public int chosenColumnToShoot;
    public void setChosenRowToShoot(int chosenRowToShoot) {
        this.chosenRowToShoot = chosenRowToShoot; 
    }
    public void setChosenColumnToShoot(int chosenColumnToShoot) {
        this.chosenColumnToShoot = chosenColumnToShoot;
    }
    public int getChosenRowToShoot() {
        return chosenRowToShoot;
    }
    public int getChosenColumnToShoot() {
        return chosenColumnToShoot;
    }
    public void setAmountOfShotShips(int amountOfShotShips) {
        this.amountOfShotShips = amountOfShotShips;
    }
    public int getAmountOfShotShips() {
        return amountOfShotShips;
    }
    public void shoot() {};
}
class User extends Player {
    public void shoot(EnemyTable enemyGameTable, UserTable userDisplayedTable, int shootRow, int shootColumn) {
        setChosenRowToShoot(shootRow);
        setChosenColumnToShoot(shootColumn);
        if(enemyGameTable.getTableField(getChosenRowToShoot(), getChosenColumnToShoot()) == '1') {
            setAmountOfShotShips(getAmountOfShotShips()+1);
            JOptionPane.showMessageDialog(null, "Zestrzelono jeden z wrogich statków", "Informacja", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
class Enemy extends Player {
    public void shoot(UserTable userGameTable) {
        setChosenRowToShoot((int)(Math.random() * 9));
        setChosenColumnToShoot((int)(Math.random() * 9));
        while(userGameTable.getTableField(getChosenRowToShoot(), getChosenColumnToShoot()) == 'X'){
            setChosenRowToShoot((int)(Math.random() * 9));
            setChosenColumnToShoot((int)(Math.random() * 9));
        }
        if(userGameTable.getTableField(getChosenRowToShoot(), getChosenColumnToShoot()) == '1') {
            setAmountOfShotShips(getAmountOfShotShips()+1);
            JOptionPane.showMessageDialog(null, "Jeden z twoich statków został zestrzelony", "Informacja", JOptionPane.PLAIN_MESSAGE);
        }
        userGameTable.setShotTableField(getChosenRowToShoot(),getChosenColumnToShoot(),'X');
    }
}