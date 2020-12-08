import java.util.*;

public class Main {
    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] move = {1,5,3,5,1,2,1,4};
        Solution sol = new Solution();
        sol.Solution(board, move);
    }
}

// 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
// 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return
class Solution_krane {
    public int Solution_krane(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            for (int i=0; i<board[move-1].length; i++) {
                int value = board[i][move-1];
                if (value == 0)
                    continue;

                if (stack.empty()) {
                    // 없는 경우 추가하고 끝
                    stack.push(value);
                    board[i][move-1] = 0;
                    break;
                }

                // 겹치는 경우 터트림(삭제)
                if (board[i][move-1] == stack.peek()) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(value);
                }
                board[i][move-1] = 0;
                break;
            }
        }

        return answer;
    }
}