package br.com.ale.Import.V2;

import java.io.IOException;

public class TestFileMover {

	
	public static void main(String[] args) throws IOException {

	
		new FileMover().moveToNew(FolderName.IN, FolderName.ERROR, ConfigurationReader.getCsvName());;
		
		new FileMover().moveToNew(FolderName.IN, FolderName.PROCESSING, ConfigurationReader.getCsvName());;

		
//		System.out.println(FolderName.IN.getFolder());
	
	}
}
