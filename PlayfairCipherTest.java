//for eclipse
// used to test if the cypher worked at each stage
/*
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class PlayfairCipherTest {
	PlayFairCypherRunner c1;

	@Before
	public void setUp() throws Exception {
		c1 = new PlayFairCypherRunner("The Lost numbers are: 4, 8, 15, 16, 23, and 42.");
	}

	@Test
	public void testGetValToRight() {
		assertEquals("m", c1.getValToRight(1, 1));
		assertEquals("3", c1.getValToRight(3, 5));
	}

	@Test
	public void testGetValBelow() {
		assertEquals("m", c1.getValBelow(0, 2));
		assertEquals("o", c1.getValBelow(5, 4));
	}

	@Test
	public void testGetPairs() {
		ArrayList<StringPair> pairs = PlayFairCypherRunner.getPairs("hello");
		assertEquals(new StringPair("h", "e"), pairs.get(0));
		assertEquals(new StringPair("l", "x"), pairs.get(1));
		assertEquals(new StringPair("l", "o"), pairs.get(2));
		ArrayList<StringPair> pairs2 = PlayFairCypherRunner.getPairs("abcde");
		assertEquals(new StringPair("a", "b"), pairs2.get(0));
		assertEquals(new StringPair("c", "d"), pairs2.get(1));
		assertEquals(new StringPair("e", "x"), pairs2.get(2));
		ArrayList<StringPair> pairs3 = PlayFairCypherRunner.getPairs("xxylophone");
		assertEquals(new StringPair("x", "q"), pairs3.get(0));
		assertEquals(new StringPair("x", "y"), pairs3.get(1));
		assertEquals(new StringPair("l", "o"), pairs3.get(2));
		assertEquals(new StringPair("p", "h"), pairs3.get(3));
		assertEquals(new StringPair("o", "n"), pairs3.get(4));
		assertEquals(new StringPair("e", "x"), pairs3.get(5));
	}

	

	@Test
	public void testGetEncryptedPairs() {
		ArrayList<StringPair> pairs = PlayFairCypherRunner.getPairs("hello");
		ArrayList<StringPair> ep1 = c1.getEncryptedPairs(pairs);
		assertEquals(new StringPair("e", "l"), ep1.get(0));
		assertEquals(new StringPair("b", "l"), ep1.get(1));
		assertEquals(new StringPair("o", "s"), ep1.get(2));
		ArrayList<StringPair> pairs2 = PlayFairCypherRunner.getPairs("abcde");
		ArrayList<StringPair> ep2 = c1.getEncryptedPairs(pairs2);
		assertEquals(new StringPair("n", "r"), ep2.get(0));
		assertEquals(new StringPair("3", "0"), ep2.get(1));
		assertEquals(new StringPair("l", "w"), ep2.get(2));
		ArrayList<StringPair> pairs3 = PlayFairCypherRunner.getPairs("xxylophone");
		ArrayList<StringPair> ep3 = c1.getEncryptedPairs(pairs3);
		assertEquals(new StringPair("y", "v"), ep3.get(0));
		assertEquals(new StringPair("y", "z"), ep3.get(1));
		assertEquals(new StringPair("o", "s"), ep3.get(2));
		assertEquals(new StringPair("g", "s"), ep3.get(3));
		assertEquals(new StringPair("t", "r"), ep3.get(4));
		assertEquals(new StringPair("l", "w"), ep3.get(5));
	}

	@Test
	public void testGetRow() {
		assertEquals(0, c1.getRow("t"));
		assertEquals(0, c1.getRow("h"));
		assertEquals(0, c1.getRow("e"));
		assertEquals(0, c1.getRow("l"));
		assertEquals(0, c1.getRow("o"));
		assertEquals(0, c1.getRow("s"));
		assertEquals(1, c1.getRow("n"));
		assertEquals(1, c1.getRow("u"));
		assertEquals(1, c1.getRow("m"));
		assertEquals(1, c1.getRow("b"));
		assertEquals(1, c1.getRow("r"));
		assertEquals(1, c1.getRow("a"));
		assertEquals(2, c1.getRow("4"));
		assertEquals(2, c1.getRow("8"));
		assertEquals(2, c1.getRow("1"));
		assertEquals(2, c1.getRow("5"));
		assertEquals(2, c1.getRow("6"));
		assertEquals(2, c1.getRow("2"));
		assertEquals(3, c1.getRow("3"));
		assertEquals(3, c1.getRow("d"));
		assertEquals(3, c1.getRow("0"));
		assertEquals(3, c1.getRow("7"));
		assertEquals(3, c1.getRow("9"));
		assertEquals(3, c1.getRow("c"));
		assertEquals(4, c1.getRow("f"));
		assertEquals(4, c1.getRow("g"));
		assertEquals(4, c1.getRow("i"));
		assertEquals(4, c1.getRow("j"));
		assertEquals(4, c1.getRow("k"));
		assertEquals(4, c1.getRow("p"));
		assertEquals(5, c1.getRow("q"));
		assertEquals(5, c1.getRow("v"));
		assertEquals(5, c1.getRow("w"));
		assertEquals(5, c1.getRow("x"));
		assertEquals(5, c1.getRow("y"));
		assertEquals(5, c1.getRow("z"));
	}

	@Test
	public void testGetColumn() {
		assertEquals(0, c1.getColumn("t"));
		assertEquals(0, c1.getColumn("n"));
		assertEquals(0, c1.getColumn("4"));
		assertEquals(0, c1.getColumn("3"));
		assertEquals(0, c1.getColumn("f"));
		assertEquals(0, c1.getColumn("q"));
		assertEquals(1, c1.getColumn("h"));
		assertEquals(1, c1.getColumn("u"));
		assertEquals(1, c1.getColumn("8"));
		assertEquals(1, c1.getColumn("d"));
		assertEquals(1, c1.getColumn("g"));
		assertEquals(1, c1.getColumn("v"));
		assertEquals(2, c1.getColumn("e"));
		assertEquals(2, c1.getColumn("m"));
		assertEquals(2, c1.getColumn("1"));
		assertEquals(2, c1.getColumn("0"));
		assertEquals(2, c1.getColumn("i"));
		assertEquals(2, c1.getColumn("w"));
		assertEquals(3, c1.getColumn("l"));
		assertEquals(3, c1.getColumn("b"));
		assertEquals(3, c1.getColumn("5"));
		assertEquals(3, c1.getColumn("7"));
		assertEquals(3, c1.getColumn("j"));
		assertEquals(3, c1.getColumn("x"));
		assertEquals(4, c1.getColumn("o"));
		assertEquals(4, c1.getColumn("r"));
		assertEquals(4, c1.getColumn("6"));
		assertEquals(4, c1.getColumn("9"));
		assertEquals(4, c1.getColumn("k"));
		assertEquals(4, c1.getColumn("y"));
		assertEquals(5, c1.getColumn("s"));
		assertEquals(5, c1.getColumn("a"));
		assertEquals(5, c1.getColumn("2"));
		assertEquals(5, c1.getColumn("c"));
		assertEquals(5, c1.getColumn("p"));
		assertEquals(5, c1.getColumn("z"));
	}

	@Test
	public void testToWordAndDigit() {
		assertEquals("TheLostnumbersare48151623and42",
				PlayFairCypherRunner.toWordAndDigit("The Lost numbers are: 4, 8, 15, 16, 23, and 42."));
		assertEquals("1234567890abcdefghijklm",
				PlayFairCypherRunner.toWordAndDigit("    1!2@3#4$5%6^7&8*9(0)-_=+a[b]cd;e'f,g.h/i:jk<l>m?"));
	}

	@Test
	public void testToLowerCase() {
		assertEquals("thelostnumbersare48151623and42", PlayFairCypherRunner.toLowerCase("TheLostnumbersare48151623and42"));
	}

	@Test
	public void testRemoveDuplicates() {
		assertEquals("thelosnumbra4815623d", PlayFairCypherRunner.removeRepeatedCharacters("thelostnumbersare48151623and42"));
	}

	@Test
	public void testGetGrid() {
		String[][] grid = PlayFairCypherRunner.getGrid("thelosnumbra4815623d");
		assertEquals("t", grid[0][0]);
		assertEquals("h", grid[0][1]);
		assertEquals("e", grid[0][2]);
		assertEquals("l", grid[0][3]);
		assertEquals("o", grid[0][4]);
		assertEquals("s", grid[0][5]);
		assertEquals("n", grid[1][0]);
		assertEquals("u", grid[1][1]);
		assertEquals("m", grid[1][2]);
		assertEquals("b", grid[1][3]);
		assertEquals("r", grid[1][4]);
		assertEquals("a", grid[1][5]);
		assertEquals("4", grid[2][0]);
		assertEquals("8", grid[2][1]);
		assertEquals("1", grid[2][2]);
		assertEquals("5", grid[2][3]);
		assertEquals("6", grid[2][4]);
		assertEquals("2", grid[2][5]);
		assertEquals("3", grid[3][0]);
		assertEquals("d", grid[3][1]);
		assertEquals("0", grid[3][2]);
		assertEquals("7", grid[3][3]);
		assertEquals("9", grid[3][4]);
		assertEquals("c", grid[3][5]);
		assertEquals("f", grid[4][0]);
		assertEquals("g", grid[4][1]);
		assertEquals("i", grid[4][2]);
		assertEquals("j", grid[4][3]);
		assertEquals("k", grid[4][4]);
		assertEquals("p", grid[4][5]);
		assertEquals("q", grid[5][0]);
		assertEquals("v", grid[5][1]);
		assertEquals("w", grid[5][2]);
		assertEquals("x", grid[5][3]);
		assertEquals("y", grid[5][4]);
		assertEquals("z", grid[5][5]);
	}

}
*/