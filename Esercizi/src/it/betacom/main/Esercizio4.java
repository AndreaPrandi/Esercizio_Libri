package it.betacom.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import it.betacom.model.User;

public class Esercizio4 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> moltipli=list.stream().map((s)->s*3).collect(Collectors.toList());
		for (Integer elemento : moltipli) {
            System.out.println(elemento);
        }

	}
	
}
