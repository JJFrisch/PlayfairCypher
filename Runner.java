
public class Runner {

	public static void main(String[] args) {
		String val = "ioenxxxqropr..o02f,34lf.l"; //used to encript
		PlayFairCypherRunner x = new PlayFairCypherRunner(val); //create a new cypher
		String Em = x.encrypt("xanthinars guide is worderous!"); //encripting the string
		String message = x.decrypt(Em); //decripting the resulting string (used the encripting string at the top.)
		
        System.out.println("This string is encripted: xanthinars guide is worderous!");
		System.out.println("Turns into this: " + Em);
		System.out.println("decripted back into the original with no spaces: " + message);
		

	}

}
