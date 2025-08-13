package spring.mvc.basic_ict05.ch03;

public class SonySpeaker {
	
	// 디폴트 생성자
	public SonySpeaker() {
		System.out.println("<<< SonySpeaker - 디폴트 생성자 >>>");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeaker - volumeUp()");
	}

	public void volumDown() {
		System.out.println("SonySpeaker - volumDown()");
	}

}
