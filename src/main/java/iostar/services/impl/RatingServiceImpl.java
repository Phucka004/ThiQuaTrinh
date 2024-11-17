package iostar.services.impl;

import iostar.dao.IRatingDao;
import iostar.dao.impl.RatingDao;
import iostar.model.Rating;
import iostar.services.IRatingService;

public class RatingServiceImpl implements IRatingService{
	private IRatingDao ratingDao = new RatingDao();
	@Override
	public void insert(Rating rating) {
		try {
			ratingDao.insert(rating);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
