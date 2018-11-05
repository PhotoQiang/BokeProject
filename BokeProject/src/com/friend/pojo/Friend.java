package com.friend.pojo;

public class Friend {
   private int friendId;
   private String friendName;
   private int userId;
   
   public Friend(){
	   
   }
   
   public Friend(int friendId) {
	  super();
	  this.friendId = friendId;
   }
   
   public Friend(String friendName, int userId) {
	   	  super();
		  this.friendName = friendName;
		  this.userId = userId;
	   }  
   
   public Friend(int friendId, String friendName, int userId) {
   	  super();
	  this.friendId = friendId;
	  this.friendName = friendName;
	  this.userId = userId;
   }

   public int getFriendId() {
	  return this.friendId;
   }

   public void setFriendId(int friendId) {
	  this.friendId = friendId;
   }

   public String getFriendName() {
	  return this.friendName;
   }

   public void setFriendName(String friendName) {
	  this.friendName = friendName;
   }

   public int getUserId() {
	  return this.userId;
   }

   public void setUserId(int userId) {
	  this.userId = userId;
   }
      
}
