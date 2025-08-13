package spring.mvc.basic_ict05.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("[방법1. 자바에서 인스턴스 생성]");
		
		// 실행방법 => Main 클래스 우클릭 > Run As > Java Application
		
		// 방법1. new 연산자를 이용해서 객체 생성
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumDown();
		System.out.println();
		
//		<< 디폴트 생성자 >>
//		SamsungTV - powerOn()
//		SamsungTV - powerOff()
//		SamsungTV - volumeUp()
//		SamsungTV - volumDown()
		
		System.out.println("[방법2. xml에서 인스턴스 생성후 IoC 컨테이너를 이용해서 로딩]");
		
		/* 1. IoC(Inversion of Control) 컨테이너를 구동한다.
		 * 1-1. Main 클래스가 스프링설정파일(appContext_01.xml)을 로딩하여 IoC 컨테이너를 구동
		 * 1-2. 스프링 설정파일에 <bean>으로 등록된 SamsungTV 객체를 생성
		 * 1-3. xml 생성 : src/main/resources 우클릭 > New > Spring Bean Configuration file 선택
		 */
		
		// GenericXmlApplicationContext => 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("appContext_01.xml");
		
		/*
		 * 2. IoC 컨테이너로부터 getBean() 메서드로 "samsungTV" 객체를 요청(lookup)
		 * getBean(id) => id 속성은 컨테이너로부터 <bean> 객체를 요청할 때 사용하므로, 반드시 스프링 컨테이너가 생성한 객체들 사이에서 유일해야 한다.
		 */
		SamsungTV tv2 = (SamsungTV)context.getBean("tv");	// Object 타입으로 리턴
		
		// 3. 실행 : Main 클래스 우클릭 > Run As > Java Application
		tv2.powerOn();
		tv2.powerOff();
		tv2.volumeUp();
		tv2.volumDown();
		
//		<< 디폴트 생성자 >>	=> getBean() 할 때 호출
//		SamsungTV - powerOn()
//		SamsungTV - powerOff()
//		SamsungTV - volumeUp()
//		SamsungTV - volumDown()
		
		context.close();
		
	}
	
}
