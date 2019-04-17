package com.tian.springboot.mapper;

import java.util.List;

import com.tian.springboot.domain.User;

//@Mapper  如果这里不加注解 那么要在Springboot的启动文件文件加@MapperScan("com.sxt.springboot.mapper")
public interface UserMapper {
	//@Delete("delete from user where user_id=#{value}")
	int deleteByPrimaryKey(Integer userId);

	//@Insert("insert into user(user_name,user_address) values(#{userName},#{userAddress})")
	int insert(User record);

	// @Select("select user_id as userId, user_name as userName,user_address as  userAddress from user where user_id=#{value}")
//	@Select("select * from user where user_id=#{value}")
//	@Results(value = { @Result(property = "userId", column = "user_id"),
//			@Result(property = "userName", column = "user_name"),
//			@Result(property = "userAddress", column = "user_address") })
	User selectByPrimaryKey(Integer userId);
	
//	@Update("update user set user_name=#{userName},user_address=#{userAddress} where user_id=#{userId}")
	int updateByPrimaryKey(User record);
	
//	@Select("select * from user")
//	@Results(value = { @Result(property = "userId", column = "user_id"),
//			@Result(property = "userName", column = "user_name"),
//			@Result(property = "userAddress", column = "user_address") })
	public List<User> queryAllUser();
}