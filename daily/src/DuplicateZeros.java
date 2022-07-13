/**
 * 1089. 复写零
 * https://leetcode.cn/problems/duplicate-zeros/
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};

    }

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int left = -1;
        int top = 0;
        int right = n - 1;
        while (top < n) {
            left++;
            if (arr[left] == 0) {
                top += 2;
            } else {
                top++;
            }
        }

        if (top == n + 1) {
            arr[right] = 0;
            right--;
            left--;
        }
        while (right >= 0) {
            arr[right] = arr[left];
            right--;
            if (arr[left] == 0) {
                arr[right] = arr[left];
                right--;
            }
            left--;
        }
    }
}
