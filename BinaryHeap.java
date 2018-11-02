public class BinaryHeap {


        int[] arr = new int[10];
        int size = 0;

        void swap(int[] arr, int a, int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        void growArray(){
            int[] temp = this.arr;
            arr = new int[size * 2];
            for (int i = 0; i < size; i++){
                arr[i] = temp[i];
            }
        }

        private void shiftdown(int parent){
            int child = parent * 2 + 1;

            if ( child >= size){
                return;
            }
            if (arr[child + 1] < arr[child]){
                child++;
            }
            if(arr[parent] > arr[child]){
                swap(arr, child, parent);
                shiftdown(child);
            }
        }

        int remove(){
            int pri = arr[0];
            arr[0] = arr[size-1];
            size--;
            shiftdown(0);
            return  pri;
        }

        void add(int pri){
            if (size >= arr.length){
                growArray();
            }
            arr[size] = pri;
            size++;
            int index = size-1;
            int parent = (index -1)/2;
            while (index > 0 && arr[index] < arr[parent]){
                swap(arr, index, parent);
                index = parent;
                parent = (index-1)/2;
            }
        }
    }


