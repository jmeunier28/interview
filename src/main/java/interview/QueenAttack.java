package interview;

public class QueenAttack {
    public static void main(final String[] args) {
        int[][] arr = new int[3][2];
        arr[0][0] = 5;
        arr[0][1] = 5;
        arr[1][0] = 4;
        arr[1][1] = 2;
        arr[2][0] = 2;
        arr[2][1] = 3;
        System.out.println(queensAttack(5, 3, 4, 3, arr));
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[][] board = new int[n][n];
        int moves = 0;
        if (n == 1) {
            return 0;
        }
        // k is num of obstacles
        // objstacles is a 2d array
        // use following formula to count queens possible moves:
        // 1. top = queen[][y] - 1      5. upRight = min(top, right);
        // 2. bottom = n - queen[][y]   6. upLeft = min(top, left);
        // 3. right = n - queen[x][]    7. lowRight = min(bottom, right);
        // 4. left = queen[x][] - 1     8. lowLeft = min(bottom, left);
        int top = (c_q - 1);
        int bottom = (n - c_q);
        int right = (n - r_q);
        int left = (r_q - 1);
        int topRight = Math.min(top, right);
        int topLeft = Math.min(top, left);
        int bottomRight = Math.min(bottom, right);
        int bottomLeft = Math.min(bottom, left);

        // save obstacles
        int topObs = 0;
        int bottomObs = 0;
        int leftObs = 0;
        int rightObs = 0;
        int upperRightObs = 0;
        int lowerRightObs = 0;
        int upperLeftObs = 0;
        int lowerLeftObs = 0;
        if (k == 0) {
            // no obstacles so just count the possible squares
            moves += top + bottom + right + left + topRight + topLeft + bottomRight + bottomLeft;
        }
        // for doing this with obstacles
        // 1. attackAbove = obs[][y] - queen[][y] - 1   5. attackUpRight == attackAbove
        // 2. attackBelow = queen[][y] - obs[][y] - 1   6. attackLowRight == attackBelow
        // 3. attackRight = obs[x][]- queen[x][] - 1    7. attackUpLeft == attackAbove
        // 4. attackLeft = queen[x][] - obs[x][] - 1    8. attackLowLeft == attackBelow
        else {
            // else fall into this loop and do eval with obstacles
            for (int i = 0; i < k; i++) {
                int obsX = obstacles[i][0];
                int obsY = obstacles[i][1];
                //  int above = obsY - c_q - 1;
                //  int below = c_q - obsY - 1;
                //  int right = obsX - r_q - 1;
                //  int left = r_q - obsX - 1;
                if (obsX == r_q) {
                    // vertical check
                    if (obsY > c_q) {
                        // attack above
                        topObs =  obsX - c_q - 1;
                    } else {
                        // attack below
                        bottomObs = c_q - obsX - 1;
                    }
                } else if (obsY == c_q) {
                    if (obsX > r_q) {
                        // attack right
                        topObs =  obsY - c_q - 1;

//                        rightObs =  obsX - r_q - 1;
                    } else {
                        bottomObs = c_q - obsY - 1;

//                        leftObs =  r_q - obsX - 1;
                    }
                } else if (Math.abs(obsY - c_q) == Math.abs(obsX - r_q)) {
                    // they are a diagnol threat
                    // below and above diagnols are counted same way
                    if (obsY > c_q) {
                        // above
                        if (obsX > r_q) {
                            // right
                            upperRightObs =  obsX - r_q - 1;
                        } else {
                            // left
                            upperLeftObs = r_q - obsX - 1;
                        }
                    }
                    if (obsY < c_q) {
                        // below
                        if (obsX > r_q) {
                            // right
                            lowerRightObs = c_q - obsY - 1;
                        } else {
                            // left
                            lowerLeftObs = c_q - obsY - 1;
                        }
                    }

                }
            }

            // up down left right
            moves+= topObs == 0 ? top : topObs;
            moves+= bottomObs == 0 ? bottom : bottomObs;
            moves+= rightObs == 0 ? right : rightObs;
            moves+= leftObs == 0 ? left : leftObs;

            // diagnal
            moves+= upperRightObs == 0 ? topRight : upperRightObs;
            moves+= upperLeftObs == 0 ? topLeft : upperLeftObs;
            moves+= lowerLeftObs == 0 ? bottomLeft : lowerLeftObs;
            moves+= lowerRightObs == 0 ? bottomRight : lowerRightObs;
        }


        return moves;
    }
}
