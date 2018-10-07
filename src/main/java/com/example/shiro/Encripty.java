package com.example.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Encripty {
	public static String enctiptyPassword(String password) {
		String salt = "test";// 盐
		int times = 1024;// 加密迭代次数
		// 1024次加盐加密
		Object md5Password = new SimpleHash("MD5", password, ByteSource.Util.bytes(salt), times);
		return md5Password.toString();
	}
}
