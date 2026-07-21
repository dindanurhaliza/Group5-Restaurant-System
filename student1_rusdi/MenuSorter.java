package student1_rusdi;

import shared.MenuItem;

public class MenuSorter {

    public static void insertionSortByPrice(MenuItem[] arr, int size) {
        for (int i = 1; i < size; i++) {
            MenuItem key = arr[i];
            int j = i - 1;
             while (j >= 0 && arr[j].price > key.price) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
        
    }

}
public static void insertionSortBycategory(MenuItem[] arr, int size) {
    for (int i = 1; i < size; i++) {
        MenuItem key = arr [i];
        int j = i - 1;
        while (j >= 0 && arr[j].type.compareTo(key.type) > 0 ) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}

public static void mergeByPrice(MenuItem[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    MenuItem[] leftArr = new MenuItem[n1];
    MenuItem[] rightArr = new MenuItem[n2];
    for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
    for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i].price <= rightArr[j].price) {
            arr[k] = leftArr[i];
            i++;
        } else {
            arr[k] = rightArr[j];
            j++;
        }
        k++;

    }
    while (i < n1) { arr[k] = leftArr[i]; i++; k++;}
    while (j < n2) { arr[k] = rightArr[j]; j++; k++;}


}

public static void mergeSortByCategory(MenuItem[] arr, int size) {
    mergeSortByCategory(arr, 0, size - 1);
}

private static void mergeSortByCategory(MenuItem[] arr, int left, int right) {
if (left < right) {
    int mid = (left + right) / 2;
    mergeSortByCategory(arr, left, mid);
    mergeSortByCategory(arr, mid + 1, right);
    mergeByCategory(arr, left, mid, right);

}

}

private static void mergeByCategory(MenuItem[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    MenuItem[] leftArr = new MenuItem[n1];
    MenuItem[] rightArr = new MenuItem[n2];
    for (int i = 0; i < n1; i++) leftArr[i] = arr[left + 1];
    for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i].type.compareTo(rightArr[j].type) <= 0) {
            arr[k] = leftArr[i];
        i++;
        }else{ 
    arr[k] = rightArr[j];
    j++;
        }
k++;
    }

while (i < n1) { arr[k] = leftArr[i]; i++; k++; }
    while (j < n2) { arr[k] = rightArr[j]; j++; k++; }

}
}