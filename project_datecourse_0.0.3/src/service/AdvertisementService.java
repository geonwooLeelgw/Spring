package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.AdvertisementBean;
import dao.DAO;

public class AdvertisementService {

	public AdvertisementBean returningToAction(int advertisement_num) {
		
		DAO adDAO = DAO.getInstance();
		Connection con = getConnection();
		adDAO.setConnection(con);
		
		AdvertisementBean adResult = adDAO.adInfo(advertisement_num);
		
		close(con);
		
		return adResult;
	}
}



