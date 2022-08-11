import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class homework2 {

    public static void main(String[] args) {

        // входные/выходные  данные к задаче 1
        int [] mass = new int [] {50, 25, 0, 35, -2005, 125, -125};
        int posStart = 0;
        int posEnd = mass.length - 1;
        System.out.println(Arrays.toString (SortMass(mass, posStart, posEnd)));

        // входные/выходные  данные к задаче 2
        List<List<Integer>> ans = new ArrayList<>();
        combine(4, 2, ans);
        System.out.println(ans);

    }


    // Методы к задаче 1 сортировка массива слиянием

    private static int [] SortMass(int[] a, int posStart, int posEnd) {

        if (posEnd <= posStart)
           return a;
        int posMid = posStart + (posEnd - posStart) / 2;
        SortMass(a, posStart, posMid);
        SortMass(a, posMid + 1, posEnd);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = posStart; k <= posEnd; k++)
            buf[k] = a[k];

        int i = posStart, j = posMid + 1;
        for (int k = posStart; k <= posEnd; k++) {

            if (i > posMid) {
                a[k] = buf[j];
                j++;
            } else if (j > posEnd) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
       return a;
    }

// Методы к задаче 2: комбинация цифр от 1 до n по m
    public static List<List<Integer>> combine(int n, int k, List<List<Integer>> ans) {
        genComb(n, k, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void genComb(int n, int k, int prevEl, List<Integer> curComb, List<List<Integer>> ans) {
        if (curComb.size() == k) {
            ans.add(new ArrayList<>(curComb));
        }
        for (int i = prevEl + 1; i <= n; i++) {
            curComb.add(i);
            genComb(n, k, i, curComb, ans);
            curComb.remove(curComb.size() - 1);
        }
    }
}
