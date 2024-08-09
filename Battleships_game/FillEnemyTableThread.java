class FillEnemyTableThread implements Runnable{
    EnemyTable enemyGameTable;
    int amountOfShipsToInsert;
    public FillEnemyTableThread(EnemyTable enemyGameTable, int amountOfShipsToInsert) {
        this.enemyGameTable = enemyGameTable;
        this.amountOfShipsToInsert = amountOfShipsToInsert;
    }
    public void run() {
        for(int i=0; i<amountOfShipsToInsert;i++) {
            enemyGameTable.fillWithShips();
        }
    }
}