package com.edu.util;
//加密解密的算法
public class SimplyCipher {
	public static byte[] getSecretKey(int length) {
		byte[] secretKey = new byte[length];
		
		for (int i = 0; i < length; i++) {
			secretKey[i] = (byte) (Math.random() * 256);
		}
		
		return secretKey;
	}
	
	public static byte encrypt(byte text, byte key) {
		return (byte) (text ^ key);
	}
	
	public static byte[] encrypt(byte[] text, byte[] key) {
		int keyIndex = 0;
		int keyLen = key.length;
		
		for (int i = 0; i < text.length; i++) {
			text[i] = encrypt(text[i], key[keyIndex]);
			keyIndex = (keyIndex + 1) % keyLen;
		}
		
		return text;
	}
	
}
