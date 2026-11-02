class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> seen = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];

                if (value == '.')
                    continue;

                if (!seen.add(value)) {
                    return false;
                }
            }

            seen.clear();
        }

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                char value = board[row][col];

                if (value == '.')
                    continue;

                if (!seen.add(value)) {
                    return false;
                }
            }

            seen.clear();
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> boxCheck = new HashSet<>();

                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {
                        char value = board[i][j];

                        if (value == '.')
                            continue;

                        if (!boxCheck.add(value)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
