package com.example.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.shiro.Encripty;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShiroDao {
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	@Test
	public void addPermission() {
		Permission pm=new Permission();
		pm.setName("删除商品");
		pm.setUrl("/goods/delete.html");
		permissionDao.save(pm);
	}
	@Test
	public void addRole() {
		Role role=new Role();
		role.setRole("采购");
		role.setDescription("商品的入库、库存查询");
		roleDao.save(role);
	}
	@Test
	public void testPassword() {
		System.out.println(Encripty.enctiptyPassword("123456"));
	}
	@Test
	public void findByAccount() {
		User user=userDao.findByAccount("admin");
		System.out.println(user.getUserName());
		for(Role role:user.getRoleList()) {
			System.out.println(role.getRole());
			for(Permission p:role.getPermissionList()) {
				System.out.println("=="+p.getName());
			}
		}
	}
}
