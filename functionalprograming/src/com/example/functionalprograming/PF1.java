package com.example.functionalprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PF1 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(5);
		list.add(11);
		list.add(4);
		list.add(1);
		list.add(3);
		
		List<String> cources =List.of("Java","microservie","docker","kubernetes","feign","Spring" , "Spring boot","rest");
		//printNumberFP(list);
		//printNumberSecondTypeFP(list);
		//printEvenNumberFP(list);
		//printSquareOfEvenNumberFP(list);
		
		//printCourseWhishHaveSpring(cources);
		printNumberOfCharacteInEachCourse(cources);
		

	}

	private static void printNumberOfCharacteInEachCourse(List<String> cources) {

		cources.stream().map(course -> course+" -> "+ course.length()).forEach(System.out::println);
	}

	private static void printSquareOfEvenNumberFP(List<Integer> list) {

		list.stream().filter(num -> num%2==0).map(a-> a*a).forEach(System.out::println);
	}

	private static void printing(Integer number) {
		System.out.println(number);
	}
	private static void printNumberSecondTypeFP(List<Integer> list) {
		list.stream().forEach(PF1::printing);
	}

	private static void printCourseWhishHaveSpring(List<String> cources) {
		cources.stream().filter(course -> course.toUpperCase().contains("SPRING")).forEach(System.out::println);
	}

	private static void printEvenNumberFP(List<Integer> list) {
		System.out.println("Printing even number is ");
		list.stream().filter(a -> a % 2 == 0).forEach(System.out::println);
	}

	private static void printNumberFP(List<Integer> list) {
		list.stream().forEach(System.out::println); // :: is called method reference
	}

}
