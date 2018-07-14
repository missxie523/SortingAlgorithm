import java.util.Arrays;

//Time = O(nlogn), Space = O(n)
public class MergeSort {
    public int[] mergeSort(int[] array){
        if(array == null){
            return array;
        }
        mergeSort(array, 0, array.length - 1);
        return array;
    }
    private void mergeSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    private void merge(int[] array, int left, int mid, int right){
        //copy the content to helper array and we will merge from the helper array.
        int[] helper = new int[array.length];
        for(int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= right){
            if(helper[leftIndex] <= helper[rightIndex]){
                array[left++] = helper[leftIndex++];
            }else{
                array[left++] = helper[rightIndex++];
            }
        }
        //If we still have some elements at left side, we need to copy them
        while(leftIndex <= mid){
            array[left++] = helper[leftIndex++];
        }
        //If there are some elements at right side, we do not need to copy them since they are already in their position.
    }
    public static void main(String[] args){
        int[] array = {5, 3, -7, -1};
        MergeSort sol = new MergeSort();
        sol.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
