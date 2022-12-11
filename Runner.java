
public class Runner {

	public static void main(String[] args) {
		String key_val = "ioenxxxqropr..o02f,34lf.l"; //used to encript
		String message = "xanthinars guide is worderous!"; //text to encript
		PlayFairCypherRunner x = new PlayFairCypherRunner(key_val); //create a new cypher
		String encripted_message = x.encrypt(message); //encripting the string
		String decripted_message = x.decrypt(encripted_message); //decripting the resulting string (used the encripting string at the top.)
		
        System.out.println("This string is encripted: " + message);
		System.out.println("Turns into this: " + encripted_message);
		System.out.println("Decripted back into the original with no spaces: " + decripted_message);
		

	}

}
