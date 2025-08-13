package spring.mvc.basic_ict05.ch01;

public class SamsungTV implements TV{
	
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
		System.out.println("SamsungTV - volumeUp()");
	}

	@Override
	public void volumDown() {
		System.out.println("SamsungTV - volumDown()");
	}

}
