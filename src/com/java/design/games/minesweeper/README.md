# **Minesweeper Game Design**

Minesweeper is a single-mineSweeperPlayer puzzle game. The objective of the game is to clear a rectangular board containing 
hidden "mines" or bombs without detonating any of them, with help from clues about the number of neighboring mines in 
each field. The game originates from the 1960s, and it has been written for many computing platforms in use today. 
It has many variations and offshoots.

Minesweeper will set up the board by never placing a mine on the first square revealed.

### **Steps to play the game:**

1. A mineSweeperPlayer chooses the difficulty level.
2. A mineSweeperPlayer chooses to click on a square of his choice on the board one at a time.
3. The clicked square reveals if it is either one of the following options
   
    -> Unrevealed Mine ('M')
   
    -> Blank ('B')
   
    -> Digit ('1' - '8')
   
    -> Revealed Mine ('X') 
   
4. If a mine ('M') is revealed, then the game is over since the mineSweeperPlayer clicked on 'X'.
5. If an empty square ('E') with no adjacent mines is revealed, then a blank ('B') revealed and all of its adjacent 
   unrevealed squares will be revealed.
6. If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') 
   representing the number of adjacent mines.
7. A mineSweeperPlayer is declared as winner when no more squares can be revealed.    
   