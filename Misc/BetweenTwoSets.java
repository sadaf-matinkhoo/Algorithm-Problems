package Misc;

import java.util.*;

public class BetweenTwoSets {
	
	public static void main(String[] args) {
		// read input and create arrays
		Scanner in = new Scanner(System.in);
		String[] sizes = in.nextLine().split(" ");
		int sizeA = Integer.parseInt(sizes[0]);
		int sizeB = Integer.parseInt(sizes[1]);
		int[] A = createArray(in.nextLine().split(" "), sizeA);
		int[] B = createArray(in.nextLine().split(" "), sizeB);
		in.close();

		int lcm = findLCM(A);
		int gcf = findGCF(B);
		System.out.println(countMultiplesLessThan(lcm, gcf));
	}
	
	// create an in array from a String array
	private static int[] createArray(String[] nums, int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(nums[i]);
		}
		return arr;
	}
	
	// find the least common multiple of the numbers in an int array
	private static int findLCM(int[] arr) {
		int result = 1;
		
		int max = findMaxElement(arr);
		ArrayList<Integer> primes = findAllPrimesLessThan(max);
		
		
		HashMap<Integer, Integer> allPrimeFactors = new HashMap<Integer, Integer>();
		for (int num : arr) {
			HashMap<Integer, Integer> primeFactors = getPrimeFactors(num, primes);
			mergeFactorsLCM(allPrimeFactors, primeFactors);
		}
		for (int key : allPrimeFactors.keySet()) {
			result *= Math.pow(key, allPrimeFactors.get(key));
		}
		return result;
	}
	
	
	// find all the prime numbers less than n
	private static ArrayList<Integer> findAllPrimesLessThan(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if (n <= 1) return primes;
		primes.add(2);
		for (int i = 3; i <= n; i++) {
			boolean isPrime = true;
			for (int factor : primes) {
				if (i % factor == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) primes.add(i);
		}
		return primes;
	}

	// find the maximum element in an int array
	private static int findMaxElement(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int num : arr) {
			max = Math.max(max, num);
		}
		return max;
	}

	private static void mergeFactorsLCM(HashMap<Integer, Integer> allPrimeFactors, HashMap<Integer, Integer> primeFactors) {
		for (Integer key : primeFactors.keySet()) {
			if (!allPrimeFactors.containsKey(key)) {
				allPrimeFactors.put(key, primeFactors.get(key));
			} else {
				allPrimeFactors.put(key, Math.max(allPrimeFactors.get(key), primeFactors.get(key)));
			} 
		}
	}

	// given a list of prime numbers, find all prime factors of num and
	// their powers from the list.
	private static HashMap<Integer, Integer> getPrimeFactors(int num, ArrayList<Integer> primes) {
		HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
		for (int factor : primes) {
			int power = 0;
			while (num % factor == 0 && num > 1) {
				num /= factor;
				power++;
			}
			if (power > 0) primeFactors.put(factor, power);
		}
		return primeFactors;
	}

	// find the greatest common factor between numbers of an int array
	private static int findGCF(int[] arr) {
		int result = 1;
		
		int min = findMinElement(arr);
		ArrayList<Integer> primes = findAllPrimesLessThan(min);
		
		HashMap<Integer, Integer> allPrimeFactors = new HashMap<Integer, Integer>();
		// add the prime factors of the first number
		HashMap<Integer, Integer> primeFactors = getPrimeFactors(arr[0], primes);
		for (Integer key : primeFactors.keySet()) {
			allPrimeFactors.put(key, primeFactors.get(key));
		}
		
		for (int num : arr) {
			primeFactors = getPrimeFactors(num, primes);
			mergeFactorsGCF(allPrimeFactors, primeFactors);
		}
		for (int key : allPrimeFactors.keySet()) {
			result *= Math.pow(key, allPrimeFactors.get(key));
		}
		
		return result;
	}
	
	private static void mergeFactorsGCF(HashMap<Integer, Integer> allPrimeFactors, HashMap<Integer, Integer> primeFactors) {
		for (Integer factor : allPrimeFactors.keySet()) {
			if (!primeFactors.containsKey(factor)) {
				allPrimeFactors.remove(factor);
			} else {
				allPrimeFactors.put(factor, Math.min(allPrimeFactors.get(factor), primeFactors.get(factor)));
			}
		}
	}

	// find the minimum element of an int array
	private static int findMinElement(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int num : arr) {
			min = Math.min(min, num);
		}
		return min;
	}

	// find the number of multiples of a that are less than b
	private static int countMultiplesLessThan(int a, int b) {
		int count = 0, multiplier = 1;
		while (multiplier * a <= b) {
			if ((b % (multiplier * a)) == 0) count++;
			multiplier++;
		}
		return count;
	}
	
	
}
