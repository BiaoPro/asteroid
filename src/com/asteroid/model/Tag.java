/**
 *
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.model;

/**标签表
 * @author 吴泽标
 *
 */
public class Tag {
  
  private int tag_id;
  private String tag_name;
  private String tag_img;
  
  public Tag(){}
  public Tag(String tag_name,String tag_img){
    this.tag_name=tag_name;
    this.tag_img=tag_img;
  }
  public Tag(int tag_id,String tag_name,String tag_img){
    this.tag_id=tag_id;
    this.tag_name=tag_name;
    this.tag_img=tag_img;
  }
  
  public String toString() {
    return "[tag_id:"+tag_id+",tag_name:"+tag_name+",tag_img;"+tag_img+"]";
  }
  
  public int getTag_id() {
    return tag_id;
  }
  public void setTag_id(int tag_id) {
    this.tag_id = tag_id;
  }
  public String getTag_name() {
    return tag_name;
  }
  public void setTag_name(String tag_name) {
    this.tag_name = tag_name;
  }
  public String getTag_img() {
    return tag_img;
  }
  public void setTag_img(String tag_img) {
    this.tag_img = tag_img;
  }
 


}
