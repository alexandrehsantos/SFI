package br.com.ale.Import.V2;

import java.io.Reader;

public class Mostra {

	public static void main(String[] args) {
	
		String s = "abcdef";
		
		s = s.replace("e", "xxxx");
		
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("abcdef");

		sb.replace(1, 3, "x");
		
		System.out.println(sb);
	}
	
}
