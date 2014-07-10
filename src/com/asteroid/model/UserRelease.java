/**
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.model;

import java.sql.Timestamp;

/**
 * @author 吴泽标
 *
 */
public class UserRelease {
     private int release_id;
     private int user_id;
     private int tag_id;
     private String title;
     private String content;
     private String image;
     private String music;
     private String video; 
     private Timestamp pub_time; 
     
     public UserRelease(){
       
     }
    
     public UserRelease(int user_id, int tag_id, String title, String content) {
       this.user_id = user_id;
       this.tag_id = tag_id;
       this.title = title;
       this.content = content;
   
    }
     
     
     public UserRelease(int user_id, int tag_id, String title, String content, String image) {
        this.user_id = user_id;
        this.tag_id = tag_id;
        this.title = title;
        this.content = content;
        this.image = image;
    
     }
     
     
     
     public String toString() {
       return "[release_id:"+release_id+",user_id:"+user_id+",tag_id;"+tag_id+"\n content:"+content+"\n image:"+image+"\n music;"+music+"\n video:"+video+"]";
     }

    public int getRelease_id() {
      return release_id;
    }

    public void setRelease_id(int release_id) {
      this.release_id = release_id;
    }

    public int getUser_id() {
      return user_id;
    }

    public void setUser_id(int user_id) {
      this.user_id = user_id;
    }

    public int getTag_id() {
      return tag_id;
    }

    public void setTag_id(int tag_id) {
      this.tag_id = tag_id;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getMusic() {
      return music;
    }

    public void setMusic(String music) {
      this.music = music;
    }

    public String getVideo() {
      return video;
    }

    public void setVideo(String video) {
      this.video = video;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public Timestamp getPub_time() {
      return pub_time;
    }

    public void setPub_time(Timestamp pub_time) {
      this.pub_time = pub_time;
    }
     
     
 
}
