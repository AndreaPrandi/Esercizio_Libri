package it.betacom.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> pari=list.stream().filter((s)->s%2==0).collect(Collectors.toList());
		for(Integer i:pari) {
			System.out.println(i);
		}
	}

}
