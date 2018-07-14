import java.util.Arrays;

//Time = O(n^2), Space = O(1)
public class SelectionSort {
    public int[] selectionSort(int[] a){
        if(a == null || a.length == 0){
            return null;
        }
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            int global = i;
            for(int j = i + 1; j < n; j++){
                if(a[j] < a[global]){
                    global = j;
                }
            }
            swap(a, i, global);
        }
        return a;
    }
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args){
        int[] array = {5, 3, -7, -1};
        SelectionSort sol = new SelectionSort();
        sol.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
