package br.com.webservice.test;

import java.text.SimpleDateFormat;

public class TestaData {
	
	public static void main(String[] args) {
//		Calendar instance = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss"); //"dd/MM/yyyy HH:mm:ss"
		long currentTimeMillis = Long.valueOf("1429239600000");
		
		
		String teste = date.format(currentTimeMillis);
		System.out.println(teste);

	}

}
