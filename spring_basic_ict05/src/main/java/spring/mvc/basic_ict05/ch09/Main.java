package spring.mvc.basic_ict05.ch09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// GenericXmlApplicationContext => 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("appContext_09.xml");
		
		SamsungTV tv = (SamsungTV)context.getBean("tv");	// Object 타입으로 리턴
		
		// 3. 실행 : Main 클래스 우클릭 > Run As > Java Application
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumDown();
		
		context.close();
		
	}
	
}
