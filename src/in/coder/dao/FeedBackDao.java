package in.coder.dao;

import java.util.List;

import in.coder.pojo.Food;

public interface FeedBackDao {

	boolean addfeedback(String username,String email,String type,String question);

	
}
