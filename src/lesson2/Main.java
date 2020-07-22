package lesson2;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1:");
        invertArray();
        System.out.println("\n\nTask 2:");
        fillArray();
        System.out.println("\n\nTask 3:");
        changeArray();
        System.out.println("\n\nTask 4:");
        filDiagonal();
        System.out.println("\n\nTask 5:");
        findArray();
        System.out.println("\n\nTask 6:");
        System.out.println(arrBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(arrBalance(new int[]{2, 1, 1, 2, 1}));
        System.out.println(arrBalance(new int[]{10, 10}));
        System.out.println("\nTask 7:");
        modArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, -2);
        System.out.println("\nTask 7.1:");
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, -2);
    }

    //    Задание1.
    static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("before:\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.println("\nafter: ");
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

    //    Задание2.
    static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
            System.out.println(arr[i] + " ");
        }
    }

    //    Задание 3.
    static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("before:\n");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\nafter:\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }
    }

    //    Задание 4.
    static void filDiagonal() {
        int counter = 1;
        int[][] table = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i == j) || (i == 6 - 1 - j))
                    table[i][j] = counter;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(table[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }

    //    Задание 5*.
    static void findArray() {
        int[] a = {1, 6, 2, 4, 15, 8, 5, 2, 4, 7, 1, 6, -15};
        int min = a[0];
        int max = a[0];
        System.out.print(" in array:\n");
        for (int i : a) {
            System.out.println(i + " ");
        }
        for (int i = 0; i < a.length; i++) {
            min = (min < a[i]) ? min : a[i];
            max = (max > a[i]) ? max : a[i];
        }
        System.out.print("\nmin: " + min + "\nmax: " + max);
    }

    //    Задание 6.
    static boolean arrBalance(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j <= i; j++) {
                sumLeft += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    //    Задание 7.
    static void modArray(int[] inArray, int n) {
        System.out.print("before: ");
        for (int i : inArray) {
            System.out.print(i + " ");
        }
        System.out.print("(n = " + n + ")");
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                // Right
                int tmp = inArray[inArray.length - 1];
                for (int j = inArray.length - 1; j > 0; j--) {
                    inArray[j] = inArray[j - 1];
                }
                inArray[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                // Left
                int tmp = inArray[0];
                for (int j = 0; j < inArray.length - 1; j++) {
                    inArray[j] = inArray[j + 1];
                }
                inArray[inArray.length - 1] = tmp;
            }
        }
        System.out.print("\naftet:  ");
        for (int i : inArray) {
            System.out.print(i + " ");
        }
    }

    //    Задание 7.1.
    public static int[] shiftArray(int[] inArray, int shift) {
        System.out.print("before: ");
        for (int i : inArray) {
            System.out.print(i + " ");
        }
        System.out.print("(n = " + shift + ")");
        if (shift != 0) {      //через деление по модулю
            int finalShift;
            if (shift > inArray.length) {
                shift = Math.abs(shift % inArray.length);
            } else {
                finalShift = shift;
            }
            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
                    int buffer = inArray[0];
//                    int[] myArray = new int[0];
                    inArray[0] = inArray[inArray.length - 1];
                    for (int j = 1; j < inArray.length; j++) {
                        inArray[inArray.length - j] = inArray[inArray.length - j - 1];
                    }
                    inArray[1] = buffer;
                }
            } else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
                    int buffer = inArray[inArray.length - 1];
                    inArray[inArray.length - 1] = inArray[0];
                    for (int j = 1; j < inArray.length - 1; j++) {
                        inArray[j-1] = inArray[j];
                    }
                    inArray[inArray.length - 2] = buffer;
                }
            }
            System.out.print("\naftet:  ");
            for (int j : inArray) {
                System.out.print(j + " ");
            }

        }
        return inArray;
    }
}