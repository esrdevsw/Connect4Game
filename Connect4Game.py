import numpy as np

# create the board
ROWS = 6
COLS = 7
board = np.zeros((ROWS, COLS), dtype=int)

# function to print the board
def print_board():
    print(np.flip(board, axis=0))

# function to check if a column is full
def is_column_full(col):
    return board[ROWS-1][col] != 0

# function to drop a disc into a column
def drop_disc(col, player):
    for row in range(ROWS):
        if board[row][col] == 0:
            board[row][col] = player
            break

# function to check if a player has won
def has_player_won(player):
    # check horizontal
    for row in range(ROWS):
        for col in range(COLS-3):
            if board[row][col] == player and board[row][col+1] == player and board[row][col+2] == player and board[row][col+3] == player:
                return True

    # check vertical
    for row in range(ROWS-3):
        for col in range(COLS):
            if board[row][col] == player and board[row+1][col] == player and board[row+2][col] == player and board[row+3][col] == player:
                return True

    # check diagonal (down-right)
    for row in range(ROWS-3):
        for col in range(COLS-3):
            if board[row][col] == player and board[row+1][col+1] == player and board[row+2][col+2] == player and board[row+3][col+3] == player:
                return True

    # check diagonal (down-left)
    for row in range(ROWS-3):
        for col in range(3, COLS):
            if board[row][col] == player and board[row+1][col-1] == player and board[row+2][col-2] == player and board[row+3][col-3] == player:
                return True

    return False

# main game loop
player = 1
game_over = False
while not game_over:
    # get player input
    print_board()
    col = int(input("Player {}'s turn. Choose a column (1-7): ".format(player)))

    # validate input
    col -= 1
    if col < 0 or col >= COLS or is_column_full(col):
        print("Invalid move. Please try again.")
        continue

    # drop disc and check for win
    drop_disc(col, player)
    if has_player_won(player):
        print_board()
        print("Congratulations, Player {} wins!".format(player))
        game_over = True
        break

    # check for tie game
    if np.count_nonzero(board) == ROWS * COLS:
        print_board()
        print("It's a tie game!")
        game_over = True
        break

    # switch player
    player = 2 if player == 1 else 1

