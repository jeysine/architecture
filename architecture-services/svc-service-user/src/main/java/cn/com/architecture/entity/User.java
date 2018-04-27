package cn.com.architecture.entity;

import cn.com.architecture.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends Base implements Serializable {
	private static final long serialVersionUID = 6669554082209059078L;
	private Long id;

	private String name;

    private Integer gender;

    private String phoneNumber;

    private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", gender=" + gender +
				", phoneNumber='" + phoneNumber + '\'' +
				", age=" + age + '}';
	}



}
