package spring.mvc.basic_ict05.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("[방법1. 자바에서 인스턴스 생성]");
		
		// 방법1. new 연산자를 이용해서 객체 생성
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumDown();
		
		System.out.println("[방법2. xml에서 인스턴스 생성후 IoC 컨테이너를 이용해서 로딩]");
		/*
		 * 2. IoC 컨테이너로부터 getBean() 메서드로 "samsungTV" 객체를 요청(lookup)
		 * getBean(id) => id 속성은 컨테이너로부터 <bean> 객체를 요청할 때 사용하므로, 반드시 스프링 컨테이너가 생성한 객체들 사이에서 유일해야 한다.
		 */
		
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("appContext_02.xml");
		
		LgTV tv2 = (LgTV)context.getBean("tv");
		tv2.powerOn();
		tv2.powerOff();
		tv2.volumeUp();
		tv2.volumDown();
	}

}
