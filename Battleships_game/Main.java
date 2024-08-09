import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window();
                GameRulesWindow gameRulesWindow = new GameRulesWindow();
                User user = new User();
                Enemy enemy = new Enemy();
                UserTable userGameTable = new UserTable();
                EnemyTable enemyGameTable = new EnemyTable();
                userGameTable.setAmountOfShips(15);
                enemyGameTable.setAmountOfShips(15);
                user.setAmountOfShotShips(0);
                enemy.setAmountOfShotShips(0);
                userGameTable.initializeTable();
                enemyGameTable.initializeTable();
                for(int m = 0; m<9; m++){
                    for(int n = 0; n<9; n++){
                        window.gridButtons[m][n].setEnabled(false);
                    }
                }
                window.refreshTable(userGameTable.getGameTable());
                new Thread(new FillEnemyTableThread(enemyGameTable,3)).start();
                new Thread(new FillEnemyTableThread(enemyGameTable,3)).start();
                new Thread(new FillEnemyTableThread(enemyGameTable,3)).start();
                new Thread(new FillEnemyTableThread(enemyGameTable,3)).start();
                new Thread(new FillEnemyTableThread(enemyGameTable,3)).start();
                JPanel panel = new JPanel(new BorderLayout());
                panel.setPreferredSize(new Dimension(250,250));
                JPanel panel2 = new JPanel(new BorderLayout());
                panel2.setPreferredSize(new Dimension(250,250));
                panel.add(new JLabel("<html><body style='width: 100%'>"+
                "Etap 1: umieść wszystkie swoje statki na swojej planszy "+"(aby umieścić statek na planszy, musisz wpisać w przeznaczone do tego pola tekstowe numer rzędu"+
                " i numer kolumny pola, do którego chcesz wstawić swój statek, a potem wcisnąć przycisk 'Umieść statek')."
                +"</body></html>"), BorderLayout.CENTER);
                JOptionPane.showMessageDialog(null, panel, "Informacja", JOptionPane.PLAIN_MESSAGE);
                window.confirmFieldButtonListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                    try{
                        int row = Integer.parseInt(window.getRow());
                        int column = Integer.parseInt(window.getColumn());
                        row = row -1;
                        column = column -1;
                        if (row < 0 || row > 8 || column < 0 || column > 8) {
                            JOptionPane.showMessageDialog(null, "Użytkownik wybrał nieprawidłowe pole planszy do wypełnienia.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (userGameTable.getTableField(row, column) == '1'){
                            JOptionPane.showMessageDialog(null, "Użytkownik wybrał do wypełnienia pole planszy, które zostało już wypełnione.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        else{
                            userGameTable.fillWithShips(row,column);
                            window.refreshTable(userGameTable.getGameTable());
                            userGameTable.setAmountOfShips(userGameTable.getAmountOfShips()-1);
                            if(userGameTable.getAmountOfShips()==0){
                                panel2.add(new JLabel("<html><body style='width: 100%'>"+
                                "<p>Użytkownik ustawił już na planszy wszystkie swoje statki.</p>" +
                                " Etap 2: strzelaj w pola na planszy przeciwnika tak, aby zestrzelić wszystkie jego statki. "+"(aby strzelić w pole na planszy przeciwnika,"+
                                " musisz wcisnąć wybrany przycisk na jego planszy."
                                +"</body></html>"));
                                JOptionPane.showMessageDialog(null,panel2, "Informacja", JOptionPane.INFORMATION_MESSAGE);
                                window.confirmFieldButton.setEnabled(false);
                                for(int m = 0; m<9; m++){
                                    for(int n = 0; n<9; n++){
                                        window.gridButtons[m][n].setEnabled(true);
                                    }
                                }
                            }
                        }
                    } catch(NumberFormatException numberformatexception){
                        JOptionPane.showMessageDialog(null, "Użytkownik wybrał nieprawidłowe pole planszy do wypełnienia.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    {
                    }
                    }
                });
                window.enemyTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event){
                        JButton pressedButton = (JButton) event.getSource();
                        for(int i=0; i<9; i++){
                            for (int j=0; j<9; j++){
                                if(window.getGridButtons()[i][j] == pressedButton){
                                    user.shoot(enemyGameTable,userGameTable,i, j);
                                    window.getGridButtons()[i][j].setEnabled(false);
                                    enemy.shoot(userGameTable);
                                    window.refreshTable(userGameTable.getGameTable());
                                    window.confirmFieldButton.setEnabled(false);
                                if(enemy.getAmountOfShotShips() == enemyGameTable.getAmountOfShips()) {
                                    JOptionPane.showMessageDialog(null, "Porażka - przeciwnik zestrzelił wszystkie twoje statki.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                                    for(int m = 0; m<9; m++){
                                        for(int n = 0; n<9; n++){
                                            window.gridButtons[m][n].setEnabled(false);
                                        }
                                    }   
                                } 
                                else if(user.getAmountOfShotShips() == enemyGameTable.getAmountOfShips()){
                                    JOptionPane.showMessageDialog(null, "Zwycięstwo - udało ci się zestrzelić wszystkie statki przeciwnika.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                                    for(int m = 0; m<9; m++){
                                        for(int n = 0; n<9; n++){
                                            window.gridButtons[m][n].setEnabled(false);
                                        }
                                    }
                                }
                            }
                            }
                        }
                    }
                });
            }
        });
    
    }
}