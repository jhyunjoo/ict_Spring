package spring.mvc.basic_ict05.ch09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	
	// 멤버변수
	@Autowired
	private SonySpeaker sony;	// sony 주소값
	
	// 디폴트 생성자
	public SamsungTV() {
		System.out.println("<<< SamsungTV - 디폴트 생성자 >>>");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - powerOn()");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV - powerOff()");
	}

	@Override
	public void volumeUp() {
		sony.volumeUp();
	}

	@Override
	public void volumDown() {
		sony.volumDown();
	}

}
