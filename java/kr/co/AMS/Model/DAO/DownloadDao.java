package kr.co.AMS.Model.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DownloadDao {

	public Map<String, Object> selectFileInfo(String idx) throws ClassNotFoundException, SQLException;

}
