package spring.mvc.basic_ict05.ch02;

public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("<< 디폴트 생성자 >>");
	};

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
		System.out.println("LgTV - volumeUp()");
	}

	@Override
	public void volumDown() {
		System.out.println("LgTV - volumDown()");
	}

}
