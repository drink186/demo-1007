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
@Table(name="t_role")
public class Role {
	@Id
	@GeneratedValue
	@Column(name="r_id")
	private Integer id;         //自增长主键
	@Column(name="r_name",length=20)
	private String name;        //角色
	@ManyToMany
	@JoinTable(name="t_user_role",joinColumns= {@JoinColumn(name="r_id")}
	           ,inverseJoinColumns= {@JoinColumn(name="u_id")})
	private Set<User> userList; //角色用户集合
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="t_role_permission",joinColumns= {@JoinColumn(name="r_id")}
	           ,inverseJoinColumns= {@JoinColumn(name="p_id")})
	private Set<Permission> permissionList;//角色权限集合


	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
	public Set<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(Set<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
