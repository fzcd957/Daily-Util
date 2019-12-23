package com.edu.util;
//String转16进制以及16进制转String
public class ByteAndDigit {
	
	public static String byte2Hex(byte value) {
		StringBuffer res = new StringBuffer();
		
		res.append("0123456789ABCDEF".charAt((value >> 4) & 0x0F))
			.append("0123456789ABCDEF".charAt(value & 0x0F));
		
		return res.toString(); 
	}
	
	public static String byte2Hex(byte[] value) {
		StringBuffer res = new StringBuffer();
		
		for (int i = 0; i < value.length; i++) {
			res.append(byte2Hex(value[i]));
		}
		
		return res.toString();
	}
}
