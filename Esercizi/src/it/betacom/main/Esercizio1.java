package it.betacom.main;

import java.util.function.Predicate;

public class Esercizio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome ="Andrea";
		Predicate <String> containsA = ((s)-> s.contains("A"));
		Predicate <String> TenChar = ((s)-> s.length()>10);
		System.out.println(containsA.test(nome));
		System.out.println(TenChar.test(nome));
	}

}
