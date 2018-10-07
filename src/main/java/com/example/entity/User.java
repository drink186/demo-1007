package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="u_id")
	private Long id;            //自增长主键
	@Column(name="u_account",length=20)
	private String account;     //登录的账号
	@Column(name="u_username",length=20)
	private String userName;    //注册的昵称
	@Column(name="u_password",length=32)
	private String password;    //密码
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="t_user_role",joinColumns= {@JoinColumn(name="u_id")}
	           ,inverseJoinColumns= {@JoinColumn(name="r_id")})
	private Set<Role> roleList; //用户角色集合

	public Set<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
