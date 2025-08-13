package spring.mvc.basic_ict05.ch03;

public class SamsungTV implements TV{
	
	SonySpeaker sony = null;
	
	public SamsungTV () {
		System.out.println("<< 디폴트 생성자 >>");
	};

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
		// System.out.println("SamsungTV - volumeUp()");
		sony = new SonySpeaker();
		sony.volumeUp();
	}

	@Override
	public void volumDown() {
		// System.out.println("SamsungTV - volumDown()");
		sony = new SonySpeaker();
		sony.volumDown();
	}

}
