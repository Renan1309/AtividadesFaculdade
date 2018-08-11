package Cripografia;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

public class TesteEncrypt {

	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, IOException {
		// TODO Auto-generated method stub
		AESfuncao aes = new AESfuncao();
		String senha = JOptionPane.showInputDialog("Digite a sua senha");
		String titulo = "123456";
		//aes.thekey =senha;
		aes.geraition(senha);
		String Encrypted =aes.encrypt(titulo);
		System.out.println(Encrypted);
		String Decrypted = aes.decrypt(Encrypted);
		System.out.println(Decrypted);
	}
	//5v3sBgZkeyqgpIlPXmCTjg==

}
