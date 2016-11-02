package circus.tower;

import java.util.*;

public class CircusTowerProblem {
	public static void main(String[] args) {
		// read input and create an array of Person objects
		Scanner in = new Scanner(System.in);
		int numPeople = Integer.parseInt(in.nextLine());
		Person[] people = new Person[numPeople];
		for (int i = 0; i < numPeople; i++) {
			String[] currentPerson = in.nextLine().split(" ");
			people[i] = new Person(Integer.parseInt(currentPerson[0]), Integer.parseInt(currentPerson[1]));
		}
		in.close();
		CircusTower ct = new CircusTower(people);
		System.out.println(ct.getHighestTowerHeight());
	}
}
