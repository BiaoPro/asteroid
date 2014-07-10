package com.asteroid.model;

import java.sql.Date;


/**用户信息表,关联users表
 * @author 吴泽标
 *
 */
public class User {
  
  
  private int user_id;
  private String username;
  private String password;
  private int level;
  private Date b_date;
  
 //用户信息
  private String name;
  private String sex;
  private String email;
  private String favourite;
  private String image;  

  
  public User(){}
  public User(String username,String password){
    this.username=username;
    this.password=password;
  }
  public User(String name,String username,String password){
    this.name=name;
    this.username=username;
    this.password=password;
    this.image="images/user/no-image.jpg";
  }
 
  
  public String toString() {
    return "[user_id:"+user_id+",username:"+username+",password;"+password+",level:"+level+",b_date:"+b_date+",name;"+name+",sex:"+sex+",email:"+email+",favourite"+favourite+",image:"+image+"]";
  }

  
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getLevel() {
    return level;
  }
  public void setLevel(int level) {
    this.level = level;
  }
  public Date getB_date() {
    return b_date;
  }
  public void setB_date(Date b_date) {
    this.b_date = b_date;
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
