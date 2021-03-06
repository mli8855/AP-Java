public class ArrayMain {

	public static void main(String[] args) {
		//This is how you time how quickly a computer processes information;
		//long startTime = System.currentTimeMillis();

		//ArrayTests.printIntArray(ArrayTests.populateArray50());
		//ArrayTests.printIntArray(ArrayTests.populateArrayRandom(50, 100));
		//ArrayTests.printIntArray(ArrayTests.makeDieArray());
		//ArrayTests.printIntArray(ArrayTests.populateResultArray(ArrayTests.makeDieArray(1000)));
		//ArrayTests.printStringArray(ArrayTests.cardGen());

		//int [] arr = {0,2,4,3,5,8,9};
		//System.out.println(""+longestConsecutiveSequence(arr));
		//int [] subArr = getSubArray(arr,12,16);
		//contains(arr,subArr);
		
		
		//long endTime = System.currentTimeMillis();
		//System.out.println("Completed time in " + (endTime-startTime) + " milliseconds");
		
	}

	private static void passByValueDemonstration(){
		String[] someStrings = new String[100];
		populateArray(someStrings);

		//In this method, we pass the ELEMENT
		//(a variable) not the array so no change will be made
		// to escape -> use / 
		System.out.println("Before \"changeString\"" + someStrings[99]);
		changeString(someStrings[99]);
		System.out.println("After " + someStrings[99]);

		System.out.println("Before \"changeArray\"" + someStrings[99]);
		changeArray(someStrings);
		System.out.println("After " + someStrings[99]);

		System.out.println("Before \"changeArrayElements\" " + someStrings[99]);
		changeArrayElements(someStrings,99);
		System.out.println(someStrings[99]);

	}

	private static void changeArrayElements(String[] someStrings, int i){
		someStrings[i]="new item" + (i+1);
	}

	private static void changeArray(String[] someStrings){
		someStrings= new String[100];
		for (int i=0;i<someStrings.length;i++){
			someStrings[i]= "new item " + (i+1);
		}
	}
	private static void changeString(String s){
		s = "This string has been changed";
	}

	private static void printArray(String[] str) {
		for(String a: str){
			System.out.println(a);
		}
	}


	private static void populateArray(String[] str) {
		for (int index = 0; index < str.length; index++){
			str[index]="value" + (index+1);
		}
	}


	public static void arrayIntroMethod(){
		//construct 2 integer arrays
		//those two methods do the same thing
		//primitive type arrays fill with ZEROES: 0,0.0,false;
		int[] zeros1= {0,0,0};
		int[] zeros2 = new int[3];
		//example
		boolean[] booleans = new boolean[3];
		//iterate (2 ways)
		// FIRST METHOD : FOR LOOP
		//	the index of the data is important to reference
		//	you need to customize how you iterate
		//		increase by 2, go backwards etc	
		for(int index = 0; index< booleans.length;index++){
			System.out.println(index+" )" + booleans[index]);
		}
		for(boolean b: booleans){
			System.out.println(""+b);
		}

		//these two constructors are different
		String[] strings1={"","",""};
		String[] strings2=new String[3];



		//SECOND METHOD : FOR EACH
		//always goes in order, does not keep track of index
		//easier to type
		for(String s: strings1){
			System.out.println(s);
		}
		for(String s: strings2){
			System.out.println(s);
		}
	}

	/**
	 * returns number of elements less than d
	 * @param arr
	 * @param num
	 */
	public static int countUnderBound(double[] arr, double d){
		int count=0;
		for(int i= 0; i<arr.length; i++){
			if (arr[i]<d){
				count++;
			}
		}
		return count;
	}

	public static int[] getSubArray(int[] arr, int startIndex, int endIndex){
		int[] subArray = new int[endIndex-startIndex+1];
		for (int i =0; i<subArray.length; i++){
			subArray[i] = arr[startIndex+i];
		}
		return subArray;
	}

	/**
	 * 
	 * @param arr
	 * @param subArray
	 * @return
	 */
	public static boolean contains(int[] arr,int[] subArray){

		for (int i = 0; i<arr.length; i++){
			int j = 0;
			while (j < arr.length){
				if(arr[j] == subArray[i + j] && j == subArray.length-1){
					return true;
				}else if (subArray[j] != arr[i+j]){
					break;
				}
				j++;
			}
		}
		return false;
	}
	
	public static int longestConsecutiveSequence(int[] array1){
        /**This method counts the longest consequtive sequence in an array.
         * It does not matter where the sequence begins
         * If there are no consecutive numbers, the method should return '1'
         * 
         * Examples:
         * longestSequence({1,2,3,4,5,8,9}) returns '5', since the sequence '1,2,3,4,5' is 5 integers long 
         * longestSequence({0,9,10,11,4,3,8,9}) returns '3', since '9,10,11' is 3 integers long
         * longestSequence({0,9,8,11,4,3,7,9}) returns '1', since there are no consecutive integers
         * */
       
        int longestConsec =1;
        int newConsec =1;
        		
        for (int i = 0; i<array1.length-1; i++){
        	if(array1[i]+1==array1[i+1]){
        		newConsec++;
        	}else if (newConsec > longestConsec){
        		longestConsec = newConsec;
        		newConsec=1;
        	}
        }
        return longestConsec;
    }
}
