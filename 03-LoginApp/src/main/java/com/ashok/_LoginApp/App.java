package com.ashok._LoginApp;

import com.ashok.sequrity.service.PasswordService;

public class App {
  public static void main(String[] args) {	
    PasswordService service = new PasswordService();
    String encrypt = service.encrypt("adimurthy@123.com");
    System.out.println("Encryted:: "+encrypt);
    
    String decrypt = service.decrypt(encrypt);
    System.out.println("Decrypted:: "+decrypt);
  }
}
