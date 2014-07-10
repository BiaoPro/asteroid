/**
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.model;

/**用户基本信息，不关联数据库
 * @author 吴泽标
 *
 */
public class UserInfo {
  
  private int user_id;
  private String username;
  private String name;
  private String sex;
  private String email;
  private String favourite;
  private String image;  
  
  
  public String toString() {
    return "[user_id:"+user_id+",username:"+username+",name;"+name+",sex:"+sex+",email:"+email+",favourite"+favourite+",image:"+image+"]";
  }
  
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getFavourite() {
    return favourite;
  }
  public void setFavourite(String favourite) {
    this.favourite = favourite;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  
  
  

}
