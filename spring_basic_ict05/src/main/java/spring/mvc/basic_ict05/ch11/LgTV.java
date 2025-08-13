package spring.mvc.basic_ict05.ch11;

import javax.annotation.Resource;	// pom.xml에 javax.annotation-api 추가하면 에러안남

import org.springframework.stereotype.Component;

@Component("lgtv")
public class LgTV implements TV{
	
	/* 
	 * 방법1. @AutoWired + @Qualifier("sony")
    *  방법2. @Resource(name="sony") => 객체의 이름을 이용하여 의존성 주입 처리
    *  
    */
	
	@Resource(name="sony")		// import 에러 -> https://mvnrepository.com/ -> javax Annotation API 검색 -> 1.3.2버전 -> pom.xml에 추가
	private Speaker speaker;	// Speaker 자식 객체가 여러개이므로 에러 => expected single matching bean but found 2: [apple, sony]
	
	public LgTV() {
		System.out.println("<<< LgTV 디폴트 생성자 >>>");
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV - powerOn()");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - powerOff()");
	}

	@Override
	public void volumeUp() {
		// apple = new AppleSpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumDown() {
		// apple = new AppleSpeaker();
		speaker.volumDown();
	}

}
