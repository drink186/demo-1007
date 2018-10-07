package com.example.componet;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.shiro.ShiroChain;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestComponet {
	
	@Autowired
	private ShiroChain shiroChain;

	
	
	@Test
	public void test1() {
        Map<String,String> map=shiroChain.getFilterChainDefinitionMap();
		for (String key : map.keySet()) {
			System.out.println(key + ":" +map.get(key) );
		}

	}

}
