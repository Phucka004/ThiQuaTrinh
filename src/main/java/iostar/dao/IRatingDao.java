package iostar.dao;

import iostar.model.Rating;

public interface IRatingDao {

	void insert(Rating rating) throws ClassNotFoundException;

}
