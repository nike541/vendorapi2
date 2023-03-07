package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
 private Long id;
 public Vendor(Long id, String name, String code, String address, String city, String state, String pincode,
		String phone, String email) {

	this.id = id;
	this.name = name;
	this.code = code;
	this.address = address;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.phone = phone;
	this.email = email;
}

private String name;
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
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

private String code;
 public Vendor() {
	
}

private String address;
 public Vendor(String name, String code, String address, String city, String state, String pincode, String phone,
		String email) {
	super();
	this.name = name;
	this.code = code;
	this.address = address;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.phone = phone;
	this.email = email;
}

private String city;
 private String state;
 private String pincode;
 private String phone;
 private String email;
	    
}
