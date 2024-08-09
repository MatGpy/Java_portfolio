import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window {
    private JFrame window;
    private JPanel wholePanel;
    private JPanel userTablePanel;
    private JPanel enemyTablePanel;
    private JPanel grid;
    private JPanel buttonGrid;
    private JButton[][] gridFields;
    public JButton[][] gridButtons;
    private JTextField rowField;
    private JTextField columnField;
    public JButton confirmFieldButton;
    private JPanel fieldChoicePanel;
    private JPanel tableLabels;
    private JTextArea rowNumberText = new JTextArea("Wstaw numer rzędu:");
    private JTextArea columnNumberText = new JTextArea("Wstaw numer kolumny:");
    private JTextArea userTableText = new JTextArea("Plansza Gracza");
    private JTextArea enemyTableText = new JTextArea("Plansza Przeciwnika");
    public Window() {
        window = new JFrame("Gra w statki");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.WHITE);
        window.setSize(1000,600);       
        wholePanel = new JPanel();
        wholePanel.setLayout(new GridLayout(1,2));
        grid = new JPanel(new GridLayout(10,10));
        gridFields = new JButton[9][9];
        grid.add(new JTextArea(" "));
        for(int k=0; k<9; k++) {
            grid.add(new JTextArea(""+(k+1)));
        }
        for(int i=0; i<9; i++){
            grid.add(new JTextArea(""+(i+1)));
            for(int j=0; j<9; j++){
                gridFields[i][j] = new JButton();     
                grid.add(gridFields[i][j]);     
            }
        }
        userTablePanel = new JPanel();
        userTablePanel.setLayout(new BorderLayout());
        userTablePanel.add(grid, BorderLayout.CENTER);
        userTablePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonGrid = new JPanel(new GridLayout(10,10));
        gridButtons = new JButton[9][9];
        buttonGrid.add(new JTextArea(" "));
        for(int k=0; k<9; k++) {
            buttonGrid.add(new JTextArea(""+(k+1)));
        }
        for(int i=0; i<9; i++){
            buttonGrid.add(new JTextArea(""+(i+1)));
            for(int j=0; j<9; j++){
                gridButtons[i][j] = new JButton();    
                buttonGrid.add(gridButtons[i][j]);     
            }
        }
        enemyTablePanel = new JPanel();
        enemyTablePanel.setLayout(new BorderLayout());
        enemyTablePanel.add(buttonGrid, BorderLayout.CENTER);
        enemyTablePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldChoicePanel = new JPanel();
        tableLabels = new JPanel(new GridLayout(1,2));
        rowNumberText.setEditable(false);
        columnNumberText.setEditable(false);
        userTableText.setEditable(false);
        enemyTableText.setEditable(false);
        fieldChoicePanel.add(rowNumberText, BorderLayout.NORTH);
        rowField = new JTextField(5);
        fieldChoicePanel.add(rowField, BorderLayout.NORTH);
        fieldChoicePanel.add(columnNumberText, BorderLayout.NORTH);
        columnField = new JTextField(5);
        fieldChoicePanel.add(columnField, BorderLayout.NORTH);
        confirmFieldButton = new JButton("Umieść statek");
        fieldChoicePanel.add(confirmFieldButton, BorderLayout.NORTH);
        tableLabels.add(userTableText);
        tableLabels.add(enemyTableText);
        wholePanel.add(userTablePanel);
        wholePanel.add(enemyTablePanel);
        window.add(tableLabels,BorderLayout.SOUTH);
        window.add(fieldChoicePanel,BorderLayout.NORTH);
        window.add(wholePanel,BorderLayout.CENTER);
        window.setVisible(true);
    }
    public String getRow() {
        return rowField.getText();
    }
    public String getColumn() {
        return columnField.getText();
    }
    public JButton[][] getGridButtons(){
        return gridButtons;
    }
    public void enemyTableListener (ActionListener pressedEnemyButton){
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                gridButtons[i][j].addActionListener(pressedEnemyButton);
            }
        }
    }
    public void confirmFieldButtonListener (ActionListener pressedConfirmFieldButton){
        confirmFieldButton.addActionListener(pressedConfirmFieldButton);
    }
    public void refreshTable(char[][] currentTable){
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                gridFields[i][j].setText(String.valueOf(currentTable[i][j]));
    }
    }
}
}
