package com.ashok.sequrity.service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class PasswordService {
	
	public String encrypt(String text) {
		Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(text.getBytes());
		return encodedString;
	}
	
	public String decrypt(String encryptedtext) {
		Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode(encryptedtext);
		return new String(decode);
	}
}
