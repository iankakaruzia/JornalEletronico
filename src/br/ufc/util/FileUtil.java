package br.ufc.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void saveFile(String path, MultipartFile file){
		File saveFile = new File(path);
		try {
			FileUtils.writeByteArrayToFile(saveFile, file.getBytes());
			System.out.println("Arquivo salvo em: " + saveFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
