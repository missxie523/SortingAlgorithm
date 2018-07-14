import java.util.Arrays;
//Time = O(nlogn) ~ O(n^2), Space = O(logn) ~ O(n)
public class QuickSort {
    public int[] quickSort(int[] array){
        if(array == null){
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }
    public void quickSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }
    private int partition(int[] array, int left, int right){
        int pivotIndex = pivotIde(left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while(leftBound <= rightBound){
            if(array[leftBound] < pivot){
                leftBound++;
            }else if(array[rightBound] >= pivot){
                rightBound--;
            }else{
                swap(array, leftBound, rightBound);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }
    private int pivotIde(int left, int right){
        int pivotIndex = (int) (left + Math.random()*(int)(left - right + 1));
        return pivotIndex;
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        int[] array = {5, 3, -7, -1};
        QuickSort sol = new QuickSort();
        sol.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
