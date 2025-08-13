package spring.mvc.basic_ict05.ch10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		// GenericXmlApplicationContext => 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("appContext_10.xml");
		
		LgTV tv = (LgTV)context.getBean("lgtv");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumDown();
		
//		<<< LgTV 디폴트 생성자 >>>
//		LgTV - powerOn()
//		LgTV - powerOff()
//		AppleSpeaker - volumeUp()
//		AppleSpeaker - volumDown()
		
		context.close();
	}

}
