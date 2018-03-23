package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/***
 * Entity for Company table
 * @author Oria
 *
 */
@NoArgsConstructor
@Entity
public class Company {

	// Object's members
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Getter
	@Setter
	@Column
	private String companyName;

	@Getter
	@Setter
	@Column
	private String password;

	@Getter
	@Setter
	@Column
	private String email;

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Coupon> coupons = new ArrayList<>();

	

	/***
	 * CTR with no id value
	 * 
	 * @param companyName
	 * @param password
	 * @param email
	 */
	public Company(String companyName, String password, String email) {
		super();
		this.companyName = companyName;
		this.password = password;
		this.email = email;
	}

	/***
	 * ToString
	 */
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", password=" + password + ", email=" + email
				+ "]";
	}
}