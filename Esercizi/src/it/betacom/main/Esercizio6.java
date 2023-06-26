package it.betacom.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Esercizio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		int somma=list.stream().reduce(0,(som,num)->som+num);
		System.out.println(somma);
	}

}
