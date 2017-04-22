import java.util.Arrays;

/**
 * Basic hash table implementation
 * 0 is used to indicate an empty slot
 * Adjust hash functions hash1() and hash2() as desired
 */
public class DoubleHashTable {
	private int[] table;
	private int size;
	private int collisions;
	private int load;
	int rehashCount;
	private final double MAX_LOAD = 0.5;
	
	public DoubleHashTable(int size) {
		this.size = size;
		collisions = 0;
		rehashCount = 0;
		load = 0;
		table = new int[size];
	}
	
	public void insert(int num) {

		if(table[hash1(num)] == 0) {
			table[hash1(num)] = num;
		}
		else {
			do {collisions++; }
			while(table[hash1(hash1(num)+collisions*hash2(num))] != 0);
			table[hash1(hash1(num)+collisions*hash2(num))] = num;		// INSERT
		}
		load++;

		
		if((double) load / size >= MAX_LOAD) rehash();
	}
	
	public String toString() {
		return Arrays.toString(table);
	}
	
	private int hash1(int x) {
		return x % 10;
	}
	
	private int hash2(int x) {
		return 7 - x % 7;
	}
	
	private void rehash() {
		int[] temp = table;
		size = nextPrime(size*2-1);
		table = new int[size];
		load = 0;
		for(int num : temp) {
			if(num != 0) insert(num);
		}
		rehashCount++;
	}
	
	/*
	 * gives the next prime number after initial value that is at least twice the table size
	 */
	private int nextPrime(int start) {
		for(int i = start+1; true ;i++) {
			boolean isPrime = true;
			for(int j = 2; j < i/2; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) return i;
		}
	}
}
