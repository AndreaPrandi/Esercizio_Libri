package it.betacom.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.betacom.model.User;

public class Esercizio2 {
	public static void main(String[] args) {
		User user1= new User("Mario","admin");
		User user2= new User("FRANCO","admin");
		User user3= new User("LUCA","member");
		User user4= new User("Mario","member");
		User user5= new User("Mario","member");
		List <User> lista = new ArrayList<>();
		List <User> members = new ArrayList<>();
		List <User> admin = new ArrayList<>();
		lista.add(user1);
		lista.add(user2);
		lista.add(user3);
		lista.add(user4);
		lista.add(user5);
		Predicate <User> p = ((s)->s.getRuolo().equals("admin"));
		Predicate <User> z = ((s)->s.getRuolo().equals("member"));
		members= lista.stream().filter(z).collect(Collectors.toList());
		admin = lista.stream().filter(p).collect(Collectors.toList());
		for (User elemento : admin) {
            System.out.println(elemento.toString());
        }
		System.out.println("----------------------------------------------------------------");
		for (User elemento : members) {
            System.out.println(elemento.toString());
        }
		
		
	}

}
