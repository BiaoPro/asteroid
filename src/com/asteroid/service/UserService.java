package com.asteroid.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.asteroid.controller.user.UserDao;
import com.asteroid.model.Attention;
import com.asteroid.model.User;
import com.asteroid.util.Constant;


/**
 * 验证用户正确性
 * 
 * 注释人： 吴泽标
 * @since 1.0
 */
	
public class UserService
{

  
  
    private User user=new User();
    
	public UserService()
	{
	}

	private UserDao dao=new UserDao();
	
	/**
	 * 验证帐号和密码的正确性
	 * @param username
	 * @param password
	 * @return
	 */
	public int authenticate(String username, String password)
	{
	 
          UserDao dao = new UserDao();
          if (dao.check(username)) {
            int id=dao.check(username, password);
            if (id>0){
              setUserInfo(id);
              return Constant.USER_LOGON_SUCCESS;//1:登录成功
            }
            else
              return Constant.PASSWORD_VERIFY_ERROR;//-4:密码错误
      
          } else
            return Constant.USER_NOT_EXIST;//-2帐号不存在
	}
	
	/**
	 * 验证用户名的正确性
	 * @param username
	 * @return int值
	 *  0表示不合法，1表示合法并存在数据库中
	 */
	public int checkName(String username)
	{
		if (username == null || "".equals(username))
			return 0;
        return dao.check(username) ? 1 : 0;
	}

	public int checkEmail(String email)
	{
		if (email == null || "".equals(email))
			return 0;
//		UserInfoDao userDao = new UserInfoDaoImpl();
//		UserAccountInfo user = userDao.findByEmail(email);
//		return user == null ? 1 : 0;
		return 1;
	}
	
  public int register(String username, String pwd1) {
    
          return register(username, pwd1, pwd1);
    
  }
  
  public int register(String name,String username, String pwd1) {
    
    return register(name,username, pwd1, pwd1);

}

  public int register(String name,String username, String pwd1,String pwd2) {
    
   if(!pwd1.equals(pwd2)) return Constant.PASSWORD_VERIFY_ERROR;//-4:密码不一致！
    
    UserDao dao = new UserDao();
    if (dao.check(username)) {
        return Constant.USERNAME_VERIFY_ERROR;//-3:用户已注册
    } else{
      User vo=new User(name,username,pwd1);
      dao.save(vo);
      return Constant.USER_REGISTER_SUCCESS;//-2帐号不存在
    }
  }
  
  public boolean changePassword(String newPassword,int user_id){
    
    return dao.updatePassword(newPassword, user_id);
    
  }
  
  public User setUserInfo(int id) {
    this.user=dao.findById(id);
    return user;

}

  public User getUserInfo() {
    return this.user;
  }
  
  
  /**
   * 获取搜索key获取用户信息列表
   * @param user_id
   * @return
   */
  public List<User> getUserListByKey(String key) {return dao.findByKey(key);}



	

}
