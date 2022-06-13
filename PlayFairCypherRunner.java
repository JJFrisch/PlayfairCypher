import java.util.ArrayList;

public class PlayFairCypherRunner {
	private static final int ROW_SIZE = 6;
	private static final int COL_SIZE = 6;
	private static String[][] grid;

	public PlayFairCypherRunner(String phrase) {
		String allWordAndDigit = toWordAndDigit(phrase);
		String lc = toLowerCase(allWordAndDigit);
		String noRepeatedChars = removeRepeatedCharacters(lc);
		grid = getGrid(noRepeatedChars);
	}
	
	/**
	 * Returns a String that contains all of the alphabetic and
	 * numeric characters in s without changing their order.
	 * Example: given the parameter "Hello, world! 4*2", the
	 * returned String will be "Helloworld42".
	 */
	public static String toWordAndDigit(String s) {
		String toReturn = "";
		String acceptable = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int k=0;k<s.length();k++){
			for(int w=0;w<acceptable.length();w++){
				if(s.substring(k, k+1).equals(acceptable.substring(w, w+1))){
					toReturn+=s.substring(k, k+1);
					w=acceptable.length();
				}
			}
		}
		return toReturn;

	}

	/**
	 * Returns a String that contains the characters from s in 
	 * lower case. Any non-alphabetic character will be unchanged.
	 * Example: given the parameter "ZUZU42", the returned String
	 * will be "zuzu42".
	 */
	public static String toLowerCase(String s) {
		String toReturn = "";
		toReturn = s.toLowerCase();
		return toReturn;
	}

	/**
	 * Returns a String that contains the characters from s without
	 * repetition.
	 * Example: given the parameter "zuzu4242taz", the returned String
	 * will be "zu42ta".
	 */
	public static String removeRepeatedCharacters(String s) {
		String used = "";
		String toReturn = "";
		for(int k=0;k<s.length();k++){
			if(used.contains(s.substring(k,k+1))==false){
				toReturn+=s.substring(k,k+1);
				used+=s.substring(k,k+1);
			}
		}
		return toReturn;
	}
	
	/**
	 * Returns the PlayfairCipher grid. 
	 * 1) The preprocessed key phrase, which will contain 
	 * alphanumeric characters (lowercase) without 
	 * repeated characters, is added to the grid (traveling through
	 * the grid in row-major order).
	 * 2) If empty cells remain in the grid, they are filled (again, 
	 * in row-major order) with digits 0-9 (without repetition), then
	 * letters a-z (without repetition).
	 */
	public static String[][] getGrid(String s) {
		String acceptable = "0123456789abcdefghijklmnopqrstuvwxyz";
		String script = removeRepeatedCharacters(s+acceptable);
		String[][] toReturn = new String[6][6];
		int pos = 0;
		for(int k=0;k<toReturn.length;k++){
			for(int w=0;w<toReturn[k].length;w++){
				toReturn[k][w] = script.substring(pos, pos+1);
				pos++;
			}
		}
		return toReturn;
	}	
	
	/**
	 * s is a phrase that will be encrypted.
	 * getPairs will pre-process s so that getPairs is working with
	 * a String containing alphanumeric characters (lowercase) with 
	 * no repeated characters.
	 * Then, the preprocessed String is traversed, creating a list of 
	 * Pairs as discussed in class.
	 * 
	 */
	public static ArrayList<StringPair> getPairs(String s) {
		ArrayList<StringPair> toReturn = new ArrayList<StringPair>();
		for(int k=0;k<s.length();k+=2){
			String f = s.substring(k,k+1);
			String d = "";
			if(s.length() == k+1) {
				d = "x";
			}else {
				d = s.substring(k+1,k+2);
			}
			if(f.equals(d)){
				if(f.equals("x")){
					toReturn.add(new StringPair(f,"q"));
				}
				else{
					toReturn.add(new StringPair(f,"x"));
				}
				k--;
			} else{
				toReturn.add(new StringPair(f,d));
			}
			
		}
		return toReturn;
	}
	
	public String encrypt(String message) {
		String allWordAndDigit = toWordAndDigit(message);
		String lc = toLowerCase(allWordAndDigit);
//		String noRepeatedChars = removeRepeatedCharacters(lc);
		ArrayList<StringPair> np = getPairs(lc);
		ArrayList<StringPair> p = getEncryptedPairs(np);
		String toReturn = "";
		for(int k=0;k<p.size();k++) {
			toReturn += p.get(k).getFirst();
			toReturn += p.get(k).getSecond();
		}
		return toReturn;
	}
	
	public String decrypt(String EM) {
		String message = "";
		ArrayList<StringPair> np = getPairs(EM);
		ArrayList<StringPair> p = getDecryptedPairs(np);
		for(int k=0;k<p.size();k++) {
			message += p.get(k).getFirst();
			message += p.get(k).getSecond();
		}
//		check for (letter x letter) and get rid of x
		for(int k=0;k<message.length()-3;k++) {
			if(message.substring(k,k+1).equals(message.substring(k+2,k+3)) 
					&& message.substring(k+1,k+2).equals("x")) {
				message = message.substring(0,k+1) + message.substring(k+2);
			}
		}
		return message;
	}


	public ArrayList<StringPair> getEncryptedPairs(ArrayList<StringPair> p) {
		ArrayList<StringPair> toReturn = new ArrayList<StringPair>();
		for(int k=0;k<p.size();k++) {
			int r1 = getRow(p.get(k).getFirst());
			int c1 = getColumn(p.get(k).getFirst());
			int r2 = getRow(p.get(k).getSecond());
			int c2 = getColumn(p.get(k).getSecond());
			if(r1==r2) {
				toReturn.add(new StringPair(getValToRight(r1,c1), getValToRight(r2,c2)));
			}else if (c1 == c2) {
				toReturn.add(new StringPair(getValBelow(r1,c1), getValBelow(r2,c2)));
			}else {
				String top = grid[r1][c2];
				String bot = grid[r2][c1];
				toReturn.add(new StringPair(top, bot));
			}
		}
		return toReturn;
	}

	public ArrayList<StringPair> getDecryptedPairs(ArrayList<StringPair> p){
		ArrayList<StringPair> toReturn = new ArrayList<StringPair>();
		for(int k=0;k<p.size();k++) {
			int r1 = getRow(p.get(k).getFirst());
			int c1 = getColumn(p.get(k).getFirst());
			int r2 = getRow(p.get(k).getSecond());
			int c2 = getColumn(p.get(k).getSecond());
			if(r1==r2) {
				toReturn.add(new StringPair(getValToLeft(r1,c1), getValToLeft(r2,c2)));
			}else if (c1 == c2) {
				toReturn.add(new StringPair(getValAbove(r1,c1), getValAbove(r2,c2)));
			}else {
				String top = grid[r1][c2];
				String bot = grid[r2][c1];
				toReturn.add(new StringPair(top, bot));
			}
		}
		return toReturn;
	}
	
	public int getRow(String s) {
		for(int k=0;k<grid.length;k++){
			for(int w=0;w<grid[k].length;w++){
				if(grid[k][w].equals(s)) {
					return k;
				}
			}
		}
		return -1;
	}

	public int getColumn(String s) {
		for(int k=0;k<grid.length;k++){
			for(int w=0;w<grid[k].length;w++){
				if(grid[k][w].equals(s)) {
					return w;
				}
			}
		}
		return -1;
	}

	public String getValToRight(int r, int c) {
		if(c==grid[0].length-1) {
			return grid[r][0];
		}else {
			return grid[r][c+1];	
		}
	}
	
	public String getValToLeft(int r, int c) {
		if(c==0) {
			return grid[r][grid[r].length-1];
		}else {
			return grid[r][c-1];	
		}
	}

	public String getValBelow(int r, int c) {
		if(r==grid[0].length-1) {
			return grid[0][c];
		}else {
			return grid[r+1][c];	
		}
	}
	
	public String getValAbove(int r, int c) {
		if(r==0) {
			return grid[grid.length-1][c];
		}else {
			return grid[r-1][c];	
		}
	}
}
