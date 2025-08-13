package spring.mvc.basic_ict05.ch10;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker - volumeUp()");
	}

	@Override
	public void volumDown() {
		System.out.println("SonySpeaker - volumDown()");
	}

}
