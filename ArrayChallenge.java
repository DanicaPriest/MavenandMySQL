public class ArrayChallenge{

public static void main(String[] args ){
	int[] arr = {7, 9, 79, 97, 779, 997 };
	int x;
	for (int i = 0; i < arr.length/2; i++){
	x = arr[i];
	arr[i] = arr[(arr.length -1)- i];
	arr[(arr.length -1)-i] = x;}

	for (int i= 0; i < arr.length; i++){
		System.out.print(arr[i] + ", ");
	}
}


}
