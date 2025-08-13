package spring.mvc.basic_ict05.ch10;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;	// 주의
import org.springframework.stereotype.Component;

@Component("lgtv")
public class LgTV implements TV{
	
	/*  @Qualifier("sony") : 자격부여 의미
    * 객체가 여러개 일때(인터페이스 의미) 어떤 객체를 할당할지를 기술하며, 특정객체의 이름을 이용해서 의존성주입한다.
    * 
    * Quilifier 생략시 에러메시지 => expected single matching bean but found 2: apple,sony
    *  Speaker speaker = new SonySpeaker();
    *  Speaker speaker = new AppleSpeaker();
    *  
    */
	
	@Inject
	@Qualifier("apple")	// : 자격 부여 의무
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
