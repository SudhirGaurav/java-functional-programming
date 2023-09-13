package com.example.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// Link : https://www.youtube.com/watch?v=tklkyVa7KZo&t=712s&ab_channel=Telusko
/*
 *  Ques: Whyvdo we use stream?
 *  Ans : to avoid data change in main list , set.. etc . it ll avoid data leakage 
 *  
 *  IMP : IF stream is already used or consumed , u ll get : Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
 */
public class StreamApiFromTelusko {

	public static void main(String[] args) {

		//int[] arr = {4,5,2,3,7,2};
		List<Integer> list = Arrays.asList(1,2,3,4,5,9,6,3);
		//understandConsuledStream(list);
		//understandConsuledStreamConcept(list);
		//printOddNumber(list);
		sumOfArrayVal(list);
		
		
	}

	private static void sumOfArrayVal(List<Integer> list) {

		Stream<Integer> data=list.stream();
		/*
		Stream<Integer> limitData=data.limit(2);
		limitData.forEach(k -> System.out.println(k));
		*/
		
		Optional<Integer> sumData=data.reduce((c,e)-> c+e);   /// How to read , C -> carry . e -> new element . just add which we learn in childhood
		System.out.println(sumData.get());
		
	}

	private static void printOddNumber(List<Integer> list) {
		
		Stream<Integer> data=list.stream();
		System.out.println("Odd no is ");
		Stream<Integer> filteredData=data.filter(k -> k%2 !=0);
		filteredData.forEach(d -> System.out.println(d));
		
	}

	//If stream is already consumed u can not use . See .class file parameter "linkedOrConsumed"
	private static void understandConsuledStreamConcept(List<Integer> list) {

		Stream<Integer> sData=	list.stream();
		
		Stream<Integer> sortedData=sData.sorted();
		
		//sData.forEach(k -> System.out.println(k)); // u can nit use this stream becaise it is already consumed  "stream has already been operated upon or closed"
		sortedData.forEach(k -> System.out.println(k)); // it ll work because it has fresh stream
	}

	private static void understandConsuledStream(List<Integer> list) {
		Stream<Integer> streamData = list.stream();
		long count = streamData.count();
		System.out.println("Count is : " + count);
		streamData.forEach(k -> System.out.println(k)); // Exception in thread "main" java.lang.IllegalStateException:
														// stream has already been operated upon or closed
	}

}
