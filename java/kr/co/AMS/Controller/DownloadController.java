package kr.co.AMS.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.AMS.Model.DAO.DownloadDao;
@Controller
@RequestMapping("/download")
public class DownloadController {

	@Autowired
	private SqlSession SqlSession;
	
	@RequestMapping("/downloadFile.ams")
	public void downloadFile(String idx, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		DownloadDao downloadDao = SqlSession.getMapper(DownloadDao.class);
		
		Map<String, Object> map = downloadDao.selectFileInfo(idx);
		
		String storedFileName = (String)map.get("STORED_FILE_NAME");
	    String originalFileName = (String)map.get("ORIGINAL_FILE_NAME");
	    
	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\file\\"+storedFileName));
	    
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();

		
	}
}