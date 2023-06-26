package it.betacom.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import it.betacom.model.User;

public class Esercizio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Predicate <Integer> p = ((s)->(s<10&&s>5));
		
		list.stream().filter(p).forEach(System.out::println);
	}

}
