package spring.mvc.basic_ict05.ch09;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker {
	
	public void volumeUp() {
		System.out.println("SonySpeaker - volumeUp()");
	}

	public void volumDown() {
		System.out.println("SonySpeaker - volumDown()");
	}

}
