package circus.tower;

import java.util.Arrays;
import java.util.Comparator;

public class CircusTower {
	private Person[] people;
	private int highestTowerHeight = 1;
	private int[] memo;
	
	CircusTower(Person[] people) {
		this.people = people;
		
		// initialize the memo array
		memo = new int[people.length];
		Arrays.fill(memo, -1);
		// the shortest person, if standing at the base,
		// can only create a tower of height 1 regardless of their weight.
		memo[people.length - 1] = 1;
		
		buildTower();
	}
	
	private void buildTower() {
		// sort people based on their height in descending order
		Arrays.sort(people, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				if (p1.getHeight() < p2.getHeight()) {
					return 1;
				} else if (p1.getHeight() > p2.getHeight()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		// for each person, calculate the highest achievable tower
		// if that person stands at the base and update the global maximum.
		for (int i = 0; i < people.length; i++) {
			highestTowerHeight = Math.max(highestTowerHeight, buildHighestTower(i));
		}
	}
	
	private int buildHighestTower(int index) {
		if (index < 0) return 0;
		if (memo[index] != -1) return memo[index];
		
		// the tower is at least one person high.
		int maxHeight = 1;
		for (int i = index + 1; i < people.length; i++) {
			// find all the next persons with less weight and
			// calculate the tower height if that person stands
			// on top of the current person.
			if (people[i].getWeight() < people[index].getWeight()) {
				maxHeight = Math.max(maxHeight, 1 + buildHighestTower(i));
			}
		}
		memo[index] = maxHeight;
		return  maxHeight;
	}

	public int getHighestTowerHeight() {
		return highestTowerHeight;
	}
	
}
