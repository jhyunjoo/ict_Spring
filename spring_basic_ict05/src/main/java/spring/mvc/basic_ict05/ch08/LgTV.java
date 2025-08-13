package spring.mvc.basic_ict05.ch08;

import javax.inject.Inject;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lgtv")
public class LgTV implements TV{
	
	// @Autowired
	@Inject
	AppleSpeaker apple;		// null -> @Autowired / @Inject : 주소값이 전달된다.(100)
	
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
		apple.volumeUp();
	}

	@Override
	public void volumDown() {
		// apple = new AppleSpeaker();
		apple.volumDown();
	}

}
