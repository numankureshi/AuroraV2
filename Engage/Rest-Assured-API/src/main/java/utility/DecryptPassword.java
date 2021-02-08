package utility;



public class DecryptPassword {
	public String decryptUserPassword(String encryptString) {
		StringBuilder sBuilder = new StringBuilder(encryptString);
		sBuilder.reverse();
		StringBuilder encryptedStringBuilder = new StringBuilder();
		
		for(int i = 0; i < sBuilder.length(); i++) {
			encryptedStringBuilder.append((char)((int)sBuilder.charAt(i) - 10));
		}
		return encryptedStringBuilder.toString();
	}
}
