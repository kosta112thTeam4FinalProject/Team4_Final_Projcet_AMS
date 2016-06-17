package kr.co.AMS.Util;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.util.FileCopyUtils;

public class FileUtils {
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	public String uploadFile(String originalName, byte[] fileData) throws Exception{
		
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "-" + originalName;
		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
}
