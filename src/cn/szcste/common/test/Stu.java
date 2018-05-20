package cn.szcste.common.test;

public class Stu {
	private int id;
	private String name;
	private int roomid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", roomid=" + roomid + "]";
	}
	
	
}
