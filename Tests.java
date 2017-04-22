public class Tests {
	public static void main(String args[]) {
		
		DoubleHashTable hashed = new DoubleHashTable(10);

		hashed.insert(4371);
		hashed.insert(1323);
		hashed.insert(6173);
		hashed.insert(4199);
		hashed.insert(4344);
		hashed.insert(9679);
		hashed.insert(1989);
		
		System.out.println(hashed.toString());
		System.out.println("rehashed: " + hashed.rehashCount);

	}
	

}

