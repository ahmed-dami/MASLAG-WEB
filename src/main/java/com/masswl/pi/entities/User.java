package com.masswl.pi.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(	name = "users", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email") 
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	private String confirmPasswordUser ;
	private boolean stateUser ;
	private String phoneNumberUser ;
	private String adressUser ;
	@Temporal (TemporalType.DATE)
	private Date birthDateUser ;
	private String emailUser ;
	@Enumerated (EnumType.STRING)
	private SexeType sexeUser ;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	
	@JsonIgnore 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private List<Post> posts;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private List <Comment> comments;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private List <Liking> likings;
	
	
	
	public User() {
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String confirmPasswordUser, boolean stateUser,
			String phoneNumberUser, String adressUser, Date birthDateUser, String emailUser, SexeType sexeUser,
			Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.sexeUser = sexeUser;
		this.roles = roles;
	}
	public String getConfirmPasswordUser() {
		return confirmPasswordUser;
	}
	public void setConfirmPasswordUser(String confirmPasswordUser) {
		this.confirmPasswordUser = confirmPasswordUser;
	}
	public boolean isStateUser() {
		return stateUser;
	}
	public void setStateUser(boolean stateUser) {
		this.stateUser = stateUser;
	}
	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}
	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}
	public String getAdressUser() {
		return adressUser;
	}
	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}
	public Date getBirthDateUser() {
		return birthDateUser;
	}
	public void setBirthDateUser(Date birthDateUser) {
		this.birthDateUser = birthDateUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public SexeType getSexeUser() {
		return sexeUser;
	}
	public void setSexeUser(SexeType sexeUser) {
		this.sexeUser = sexeUser;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmPasswordUser=" + confirmPasswordUser + ", stateUser=" + stateUser + ", phoneNumberUser="
				+ phoneNumberUser + ", adressUser=" + adressUser + ", birthDateUser=" + birthDateUser + ", emailUser="
				+ emailUser + ", sexeUser=" + sexeUser + ", roles=" + roles + "]";
	}
	
	
}
