package member.model.vo;

import java.io.Serializable;

public class Member implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String phone;
	private String profile;//이미지 파일명
	
	public Member() {
		
	}

	public Member(String name, String phone, String profile) {
		this.name = name;
		this.phone = phone;
		this.profile = profile;
	}

	@Override
	public String toString() {
		return name + "," + phone + "," + profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
