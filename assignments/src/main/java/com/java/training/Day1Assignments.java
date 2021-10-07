package com.java.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author spartan 
 *
 */
@FunctionalInterface
interface Excersice1 {
	public int multiply(int a, int b);
}

@FunctionalInterface
interface Excersice2 {
	public String addSpace(String str);
}

@FunctionalInterface
interface Excersice3 {
	public boolean isValidUser(String userName,String password);
}


public class Day1Assignments {

	public static void main(String... args) throws NumberFormatException, ParseException {
		/**
		 * Write a lambda expression which accepts x and y numbers and return xy .
		 */
		Excersice1 ex = (x, y) -> x * y;
		System.out.println("Output Excersice1 = "+ex.multiply(4,5));
		
		/**
		 * Exercise 2: Write a method that uses lambda expression to format a given string, 
		 * where a space is inserted between each character of string. 
		 * For ex., if input is “CG”, then expected output is “C G”.
		 */
		Excersice2 ex2 = (s)->{
			StringBuilder strbr = new StringBuilder(s.length()*2);
			for(char c : s.toCharArray()) {
				if(strbr.length()==0) 
					strbr.append(c);
				else 
					strbr.append(" ").append(c);
			}	
			return strbr.toString();
		};
		System.out.println("Output Excersice2 = "+ex2.addSpace("ROHIT"));
		
		/**
		 * Exercise 3: Write a method that uses lambda expression to 
		 * accept username and password and return true or false. 
		 * (Hint: Use any custom values for username and password for authentication)
		 */
		Excersice3 ex3 = (usrNm,pass)->{
			//If the combination is available in list consider valid user
			String[] details = {usrNm,pass};
			return Stream.of("rohit","rohitpass","mahesh","maheshpass").collect(Collectors.toList()).containsAll(Arrays.asList((details)));			
		};
		System.out.println("Output Excersice3 = " +ex3.isValidUser("rohit", "rohitpass"));
		
		/**
		 * Exercise 4: Write a class with main method to demonstrate instance creation using method reference. 
		 * (Hint: Create any simple class with attributes and getters and setters)
		 */
		//Using method reference to print the values using printValues method in Day1Program1
		System.out.print("Output Excercise4 = ");
		Stream.of("a","b","c","d").forEach(new Day1Assignments()::printValues);
		
		System.out.println("");
		
		/**
		 * 	Exercise 5: Write a method to calculate factorial of a number. Test this method using method reference feature.
		 */
		System.out.println("Output Excercise5 = Printing factorials of given number");
		Stream.of(5).map(new Day1Assignments():: factorial).forEach(System.out::print);
		System.out.println("");
		/**
		 * 	Exercise 6: In this requirement, you need to sort the list of players based on number of matches played, runs scored or powerRating.
		 */
		//players array
		System.out.println("Output Excercise6 = ");
		List<Player> playersList = new ArrayList<Player>();
		
		playersList.add(Player.createPlayer("MS Dhoni,07-07-1981,Batsman,159,3561,0,India,4.4"));
		playersList.add(Player.createPlayer("Virat Kohli,05-11-1988,Batsman,149,4418,4,India,4.7"));
		playersList.add(Player.createPlayer("Ab de Villiers,7-02-1984,Batsman,129,3473,0,S Africa,4.6"));
		playersList.add(Player.createPlayer("Mitchell Starc,30-01-1990,Bowler,27,96,34,Australia,4"));
		playersList.add(Player.createPlayer("Bhuvneshwar,05-02-1990,Bowler,90,158,111,India,4.1"));
		
		//TODO:- In-case if wanna see the list before sorting
		//playersList.forEach(x->System.out.println(x.toString()));
		
		//TODO:- Need to sort based on user input
		//Collections.sort(playersList, new PlayerNumberOfMatchesComparator());
		//Collections.sort(playersList, new PlayerPowerRatingComparator());
		Collections.sort(playersList, new PlayerRunScoredComparator());		
		
		playersList.forEach(System.out::println);		
		
	}
	
	private void printValues(String str) {
		System.out.print(str+" ");
	}
	
	private int factorial(int i) {
		if(i==0) return 1;
		return i*factorial(i-1);
	}
}

/*
 * Create a Class Player with the following attributes: 
 * Mark all the attributes as private, Create / Generate appropriate Getters & Setters, Add a default constructor and a
 * parameterized constructor to take in all attributes in the given order: Player(String name, java.util.Date dateOfBirth, 
 * String skill, Integer numberOfMatches,Integer runs, Integer wickets, String nationality, Double powerRating)
 */
class Player{
	
	private String name;
	private Date dateOfBirth;
	private String skill;
	private Integer numberOfMatches;
	private Integer runs;
	private Integer wickets;
	private String nationality;
	private Double powerRating;
	
	public Player() {}
	
	public Player(String name, Date dateOfBirth, String skill, Integer numberOfMatches, Integer runs, Integer wickets,
			String nationality, Double powerRating) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.skill = skill;
		this.numberOfMatches = numberOfMatches;
		this.runs = runs;
		this.wickets = wickets;
		this.nationality = nationality;
		this.powerRating = powerRating;
	}
	
	public static Player createPlayer(String detail) throws NumberFormatException, ParseException {
		String[] details = detail.split(",");
		return new Player(details[0], new SimpleDateFormat("dd-MM-yyyy").parse(details[1]), details[2], Integer.valueOf(details[3]), Integer.valueOf(details[4]), Integer.valueOf(details[5]),details[6], Double.valueOf(details[7]));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getNumberOfMatches() {
		return numberOfMatches;
	}
	public void setNumberOfMatches(Integer numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}
	public Integer getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Double getPowerRating() {
		return powerRating;
	}
	public void setPowerRating(Double powerRating) {
		this.powerRating = powerRating;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", dateOfBirth=" + dateOfBirth + ", skill=" + skill + ", numberOfMatches="
				+ numberOfMatches + ", runs=" + runs + ", wickets=" + wickets + ", nationality=" + nationality
				+ ", powerRating=" + powerRating + "]";
	}

}

class PlayerNumberOfMatchesComparator implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return a.getNumberOfMatches().compareTo(b.getNumberOfMatches());
    }
}

class PlayerRunScoredComparator implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return a.getRuns().compareTo(b.getRuns());
    }
}

class PlayerPowerRatingComparator implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return a.getPowerRating().compareTo(b.getPowerRating());
    }
}




