# Connect4Game

This repository contains the Connect 4 game implemented in both Java and Python.

## About the Game

Connect 4 is a two-player strategy game in which players take turns dropping colored discs into a vertical grid. The objective of the game is to connect four of one's own discs of the same color next to each other vertically, horizontally, or diagonally before the other player.

## Java Implementation

The Java implementation of the game is in the `java` directory. It consists of a single file `Connect4.java` that contains the entire game logic. To run the game, simply compile the `Connect4.java` file using the `javac` command and then run the `Connect4` class using the `java` command:

```
javac Connect4.java
java Connect4
```

## Python Implementation

The Python implementation of the game is in the `python` directory.

- `Connect4Game.py`: contains the game logic


To run the game, simply run the `Connect4Game.py` file using the `python` command:

```
python Connect4Game.py
```

## How to Play

1. Choose a column to drop a disc in by typing a number from 1 to 7 (inclusive).
2. The disc will drop to the lowest empty cell in the chosen column.
3. The game continues until one player connects four discs of the same color vertically, horizontally, or diagonally or the board is full (a tie game).

Enjoy the game!
