import java.util.Arrays;
//Time = O(n), Space = O(1)
//abcccabbacaa --> aaaaa bbbbb ccccc
public class RainbowSort {
    public int[] rainbowSort(int[] array){
        if(array == null){
            return array;
        }
        int i = 0, j = 0, k = array.length - 1;
        while(j <= k){
            if(array[j] == -1){
                swap(array, i, j);
                i++;
                j++;
            }else if(array[j] == 0){
                j++;
            }else{
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        int[] array = {1, 0, 0, -1, -1, 1, 0, 0};
        RainbowSort sol = new RainbowSort();
        sol.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }
}
