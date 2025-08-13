package spring.mvc.basic_ict05.ch08;

import org.springframework.stereotype.Component;

@Component("apple")		// AppleSpeaker apple = new AppleSpeaker();
						// "apple" 생략가능 -> getBean() 안하므로
public class AppleSpeaker {

	public void volumeUp() {
		System.out.println("AppleSpeaker - volumeUp()");
	}

	public void volumDown() {
		System.out.println("AppleSpeaker - volumDown()");
	}
	
}
