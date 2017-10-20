package merge_sort;

class Solution{
    public static void main(String[]args){
        int[] arr = {3,2,1,6,5};
        mergeSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int s, int e){
        if(s < e){
            int m = (s + e) / 2;
            mergeSort(arr, s, m);
            mergeSort(arr, m + 1, e);
            merge(arr, s, m, e);
        }
    }

    public static void merge(int[] arr, int s, int m, int e){
        int[] newArr = new int[arr.length];
        int indx = 0;
        int i = s;
        int j = m + 1;

        while(i <= m && j <= e){
            if(arr[i] <= arr[j]){
                newArr[indx] = arr[i];
                indx++; i++;
            }else{
                newArr[indx] = arr[j];
                indx++; j++;
            }
        }

        if(i <=  m){
            while(i <= m){
                newArr[indx++] = arr[i++];
            }
        }else{
            while(j <= e){
                newArr[indx++] = arr[j++];
            }
        }

        for(int r = 0; r < indx; r++){
            arr[s++] = newArr[r];
        }
    }
}