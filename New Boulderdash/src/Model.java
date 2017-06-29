public class Model {
    public static final int CAVE_SIZE = 10; //Définition de la taille de la carte.
    private Cell[][] cave;  //Définition du tableau contenant le niveau actuel.
    private int diamondsCount; //Instanciation d'un attribut pour stocker le comptage des diamants au total.
    private int diamondsFound; //Instanciation d'un attribut pour stocker le comptage des diamants qui va rester.
    private int playerX; //Instanciation d'un attribut pour stocker la position sur l'axe horizontale du joueur, sur le tableau.
    private int playerY; //Instanciation d'un attribut pour stocker la position sur l'axe verticale du joueur, sur le tableau.
    private boolean gameOver; //Instanciation d'un attribut pour déterminer plus tard un Game Over.
    private boolean levelCompleted; //Instanciation d'un attribut pour déterminer plus tard un niveau réussi.

    public Model(int[][] intCaveArray) {
        diamondsCount = 0;
        diamondsFound = 0;
        gameOver = false;
        levelCompleted = false;
        cave = new Cell[CAVE_SIZE][CAVE_SIZE]; // Récupération du tableau contenant le niveau actuel,
        // pour le mettre dans un tableau ou sera déterminer, les positions de chaque éléments.

        for(int y = 0; y < CAVE_SIZE; y++) {
            for(int x = 0; x < CAVE_SIZE; x++) {
                if(intCaveArray[x][y] == 0) {
                    cave[y][x] = new Void();
                } else if(intCaveArray[x][y] == 1) {
                    cave[y][x] = new Wall();
                } else if(intCaveArray[x][y] == 2) {
                    cave[y][x] = new Player();
                    playerX = y;
                    playerY = x;
                } else if(intCaveArray[x][y] == 3) {
                    cave[y][x] = new Mud();
                } else if(intCaveArray[x][y] == 8) {
                    cave[y][x] = new Monster();
                } else if(intCaveArray[x][y] == 4) {
                    cave[y][x] = new Diamond();
                    diamondsCount++;
                }else if(intCaveArray[x][y] == 5) {
                    cave[y][x] = new Boulder();
                } else if(intCaveArray[x][y] == 6) {
                    cave[y][x] = new ExitLocked();
                } else if(intCaveArray[x][y] == 7) {
                    cave[y][x] = new ExitOpen();
                }
            }
        }
    }

    //Méthode permettant d'indiquer au joueur d'aller vers le haut.

    public void moveUp() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof Wall) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof Boulder) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof Diamond) {
            diamondsFound++;
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new Void();
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX][playerY-1] instanceof Void) {
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new Void();
            return;
        }
        if(cave[playerX][playerY-1] instanceof Mud) {
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new Void();
            return;
        }
        if(cave[playerX][playerY-1] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX][playerY-1] instanceof ExitOpen) {
            cave[playerX][playerY-1] = cave[playerX][playerY];
            playerY--;
            cave[playerX][playerY+1] = new Void();
            levelCompleted = true;
            return;
        }
    }

    //Méthode permettant d'indiquer au joueur d'aller vers le bas.
    public void moveDown() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof Wall) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof Boulder) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof Diamond) {
            diamondsFound++;
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new Void();
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX][playerY+1] instanceof Void) {
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new Void();
            return;
        }
        if(cave[playerX][playerY+1] instanceof Mud) {
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new Void();
            return;
        }
        if(cave[playerX][playerY+1] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX][playerY+1] instanceof ExitOpen) {
            cave[playerX][playerY+1] = cave[playerX][playerY];
            playerY++;
            cave[playerX][playerY-1] = new Void();
            levelCompleted = true;
            return;
        }
    }

    //Méthode permettant d'indiquer au joueur d'aller vers la gauche.
    public void moveLeft() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(cave[playerX-1][playerY] instanceof Wall) {
            return;
        }
        if(cave[playerX-1][playerY] instanceof Boulder) {
            if(cave[playerX-2][playerY] instanceof Void) {
                cave[playerX-2][playerY] = cave[playerX-1][playerY];
                cave[playerX-1][playerY] = cave[playerX][playerY];
                cave[playerX][playerY] = new Void();
                playerX--;
            }
            return;
        }
        if(cave[playerX-1][playerY] instanceof Diamond) {
            diamondsFound++;
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new Void();
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX-1][playerY] instanceof Void) {
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new Void();
            return;
        }
        if(cave[playerX-1][playerY] instanceof Mud) {
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new Void();
            return;
        }
        if(cave[playerX-1][playerY] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX-1][playerY] instanceof ExitOpen) {
            cave[playerX-1][playerY] = cave[playerX][playerY];
            playerX--;
            cave[playerX+1][playerY] = new Void();
            levelCompleted = true;
            return;
        }
    }

    //Méthode permettant d'indiquer au joueur d'aller à droite.
    public void moveRight() {
        if(gameOver || levelCompleted) {
            return;
        }
        if(cave[playerX+1][playerY] instanceof Wall) {
            return;
        }
        if(cave[playerX+1][playerY] instanceof Boulder) {
            if(cave[playerX+2][playerY] instanceof Void) {
                cave[playerX+2][playerY] = cave[playerX+1][playerY];
                cave[playerX+1][playerY] = cave[playerX][playerY];
                cave[playerX][playerY] = new Void();
                playerX++;
            }
            return;
        }
        if(cave[playerX+1][playerY] instanceof Diamond) {
            diamondsFound++;
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new Void();
            if(diamondsFound == diamondsCount) {
                openDoor();
            }
            return;
        }
        if(cave[playerX+1][playerY] instanceof Void) {
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new Void();
            return;
        }
        if(cave[playerX+1][playerY] instanceof Mud) {
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new Void();
            return;
        }
        if(cave[playerX-1][playerY] instanceof ExitLocked) {
            return;
        }
        if(cave[playerX+1][playerY] instanceof ExitOpen) {
            cave[playerX+1][playerY] = cave[playerX][playerY];
            playerX++;
            cave[playerX-1][playerY] = new Void();
            levelCompleted = true;
            return;
        }
    }

    public boolean getGameOver() { //Récupérer le Game Over.
        return gameOver;
    }

    public boolean getLevelCompleted() { //Récupérer le Level Completed.
        return levelCompleted;
    }

    public String getDiamonds() { // Récupérer le nb de diamants totals, détectés sur la carte, et le nb de diamants collectés.
        return diamondsFound+" out of "+diamondsCount+" diamonds collected.";
    }

    public void openDoor() { //Méthode pour interchanger une porte fermée en porte ouverte.
        for(int y = 0; y < CAVE_SIZE; y++) {
            for(int x = 0; x < CAVE_SIZE; x++) {
                if(cave[x][y] instanceof ExitLocked) {
                    cave[x][y] = new ExitOpen();
                }
            }
        }
    }

    //Méthode pour déterminer les mouvements des boulders, des diamants.
    public void tick() {
        if(gameOver || levelCompleted) {
            return;
        }
        for(int y = CAVE_SIZE-1; y >= 0; y--) {
            for(int x = CAVE_SIZE-1; x >= 0; x--) {

                //Méthodes pour "tuer" le joueur.
                if (cave[x][y] instanceof Boulder) {
                    if (cave[x][y + 1] instanceof Player && ((Boulder) cave[x][y]).getFalling()) {
                        cave[x][y + 1] = cave[x][y];
                        cave[x][y] = new Void();
                        gameOver = true;
                    }
                }
                if (cave[x][y] instanceof Boulder) {
                    if (cave[x][y + 1] instanceof Monster && ((Boulder) cave[x][y]).getFalling()) {
                        cave[x][y + 1] = cave[x][y];
                        cave[x][y] = new Void();
                    }
                }
                if (cave[x][y] instanceof Diamond) {
                    if (cave[x][y + 1] instanceof Monster && ((Diamond) cave[x][y]).getFalling()) {
                        cave[x][y + 1] = cave[x][y];
                        cave[x][y] = new Void();
                    }
                }
                if(cave[x][y] instanceof Diamond) {
                    if(cave[x][y+1] instanceof Player && ((Diamond)cave[x][y]).getFalling()) {
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new Void();
                        gameOver = true;
                    }
                }

                //Méthode pour faire chuter le boulder et le diamant
                if(cave[x][y] instanceof Boulder) {
                    if(cave[x][y+1] instanceof Void) {
                        ((Boulder)cave[x][y]).setFalling(true);
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new Void();
                    } else {
                        ((Boulder)cave[x][y]).setFalling(false);
                    }
                }
                if(cave[x][y] instanceof Diamond) {
                    if(cave[x][y+1] instanceof Void) {
                        ((Diamond)cave[x][y]).setFalling(true);
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new Void();
                    } else {
                        ((Diamond)cave[x][y]).setFalling(false);
                    }
                }

                //Méthode pour que le boulder et le diamant décalent lorsqu'ils sont sur un de ces éléments.
                if(cave[x][y] instanceof Boulder) {
                    if(cave[x][y+1] instanceof Boulder || cave[x][y+1] instanceof Diamond) {
                        if(cave[x-1][y] instanceof Void && cave[x-1][y+1] instanceof Void) {
                            cave[x-1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Boulder)cave[x-1][y+1]).setFalling(true);
                        } else if(cave[x+1][y] instanceof Void && cave[x+1][y+1] instanceof Void) {
                            cave[x+1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Boulder)cave[x+1][y+1]).setFalling(true);
                        } else if(cave[x-1][y] instanceof Void && cave[x-1][y+1] instanceof Player) {
                            cave[x-1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Boulder)cave[x-1][y+1]).setFalling(true);
                            gameOver = true;
                        } else if(cave[x+1][y] instanceof Void && cave[x+1][y+1] instanceof Player) {
                            cave[x+1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Boulder)cave[x+1][y+1]).setFalling(true);
                            gameOver = true;
                        } else {
                            ((Boulder)cave[x][y]).setFalling(false);
                        }
                    }
                }
                if(cave[x][y] instanceof Diamond) {
                    if(cave[x][y+1] instanceof Boulder || cave[x][y+1] instanceof Diamond) {
                        if(cave[x-1][y] instanceof Void && cave[x-1][y+1] instanceof Void) {
                            cave[x-1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Diamond)cave[x-1][y+1]).setFalling(true);
                        } else if(cave[x+1][y] instanceof Void && cave[x+1][y+1] instanceof Void) {
                            cave[x+1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Diamond)cave[x+1][y+1]).setFalling(true);
                        } else if(cave[x-1][y] instanceof Void && cave[x-1][y+1] instanceof Player) {
                            cave[x-1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Diamond)cave[x-1][y+1]).setFalling(true);
                            gameOver = true;
                        } else if(cave[x+1][y] instanceof Void && cave[x+1][y+1] instanceof Player) {
                            cave[x+1][y+1] = cave[x][y];
                            cave[x][y] = new Void();
                            ((Diamond)cave[x+1][y+1]).setFalling(true);
                            gameOver = true;
                        } else {
                            ((Diamond)cave[x][y]).setFalling(false);
                        }
                    }
                }
            }
        }
    }

    public void tick2() {
        if (gameOver || levelCompleted) {
            return;
        }
        for (int y = CAVE_SIZE - 1; y >= 0; y--) {
            for (int x = CAVE_SIZE - 1; x >= 0; x--) {

                //Méthode pour bouger le monstre à droite.
                if (cave[x][y] instanceof Monster) {
                    if (cave[x+1][y] instanceof Void) {
                        ((Monster) cave[x][y]).setMove(true);
                        cave[x+1][y] = cave[x][y];
                        cave[x][y] = new Void();
                    }
                }
                //Méthode pour bouger le monstre à gauche.
                if (cave[x][y] instanceof Monster) {
                    if (cave[x - 1][y] instanceof Void) {
                        ((Monster) cave[x][y]).setMove(true);
                        cave[x - 1][y] = cave[x][y];
                        cave[x][y] = new Void();
                        return;
                    }
                }

                //Méthode pour tuer le perso
                if(cave[x][y] instanceof Monster) {
                    if (cave[x - 1][y] instanceof Player && ((Monster) cave[x][y]).getMove()) {
                        cave[x - 1][y] = cave[x][y];
                        cave[x][y] = new Void();
                        gameOver = true;
                    }
                }
                if(cave[x][y] instanceof Monster) {
                    if (cave[x + 1][y] instanceof Player && ((Monster) cave[x][y]).getMove()) {
                        cave[x + 1][y] = cave[x][y];
                        cave[x][y] = new Void();
                        gameOver = true;
                    }
                }
                if(cave[x][y] instanceof Monster) {
                    if (cave[x][y - 1] instanceof Player && ((Monster) cave[x][y]).getMove()) {
                        cave[x][y - 1] = cave[x][y];
                        cave[x][y] = new Void();
                        gameOver = true;
                    }
                }
                if(cave[x][y] instanceof Monster) {
                    if(cave[x+1][y+1] instanceof Player && ((Monster)cave[x][y]).getMove()) {
                        cave[x][y+1] = cave[x][y];
                        cave[x][y] = new Void();
                        gameOver = true;
                    }
                }
            }
        }
    }

    //Tableau convertissant en numérique, les images.
    public int[][] getCaveArray() {
        int[][] myArray = new int[CAVE_SIZE][CAVE_SIZE];
        for(int y = 0; y < CAVE_SIZE; y++) {
            for(int x = 0; x < CAVE_SIZE; x++) {
                if(cave[x][y] instanceof Void) {
                    myArray[x][y] = 0;
                } else if(cave[x][y] instanceof Wall) {
                    myArray[x][y] = 1;
                } else if(cave[x][y] instanceof Player) {
                    myArray[x][y] = 2;
                } else if(cave[x][y] instanceof Mud) {
                    myArray[x][y] = 3;
                } else if(cave[x][y] instanceof Monster) {
                    myArray[x][y] = 8;
                } else if(cave[x][y] instanceof Diamond) {
                    myArray[x][y] = 4;
                } else if(cave[x][y] instanceof Boulder) {
                    myArray[x][y] = 5;
                } else if(cave[x][y] instanceof ExitLocked) {
                    myArray[x][y] = 6;
                } else if(cave[x][y] instanceof ExitOpen) {
                    myArray[x][y] = 7;
                }
            }
        }
        return myArray;
    }
}