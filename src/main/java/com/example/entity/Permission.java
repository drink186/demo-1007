package com.example.entity;

import java.util.Set;

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
@Table(name="t_permission")
public class Permission {
	@Id
    @GeneratedValue
    @Column(name="p_id")
    private Integer id;        //自增长主键
	@Column(name="p_name",length=20)
	private String name;        //名称
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="t_role_permission",joinColumns= {@JoinColumn(name="p_id")}
	           ,inverseJoinColumns= {@JoinColumn(name="r_id")})
	private Set<Role> roleList; //权限角色集合
	public Set<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
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
