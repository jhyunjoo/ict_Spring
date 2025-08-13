package com.spring.aop_ict05.basic;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("aopContext_01.xml");
		
		Member member = (Member)context.getBean("member");

		// 핵심관심 Member 정보 출력
		member.getMemberInfo();
		
		context.close();
		
		// Main.java 우클릭 > Run As > Java Application
		
//		[핵심관심]
//		-- 디폴트 생성자 호출 --
//		<<< 핵심관심(비즈니스 로직) : 멤버정보 출력 >>>
//		id : hyunj
//		pwd : 1101
//		name : 현주
//		hobby : 다꾸
	}
}