public class dataArray {
    // Initialize an empty array with size 10
    int[] emptyArray = new int[10];

    // Add values to the empty array
    public void addData(int value, int index){
        emptyArray[index] = value;
    }

    // Delete values in an array by replacing the value with -1
    public void delete(int removeIndex){
        // Check if there is a value in the array that can be deleted
        if (emptyArray[removeIndex] != 0) {
            emptyArray[removeIndex] = -1;
            System.out.println("Deleting Value at index " + removeIndex);
        }
        else {
            System.out.println("Cannot delete in an empty index");
        }
    }

    // Print the values in the array
    public void printArray() {
        System.out.println("Laman ng myArray:");

        // Only print the values in the array that are not empty values
        for (int i = 0; i <= emptyArray.length - 1; i++) {
            if (emptyArray[i] != 0) {
                System.out.println(i + "- " + emptyArray[i]);
            } else {
                System.out.println(i);
            }
        }
        System.out.println();
    }

    public static void main (String[] args){
        dataArray myArray = new dataArray();

        myArray.addData(1,1);
        myArray.addData(2,2);
        myArray.addData(5,5);
        myArray.printArray();
        myArray.delete(5);
        myArray.printArray();
        myArray.delete(6);
    }
}
