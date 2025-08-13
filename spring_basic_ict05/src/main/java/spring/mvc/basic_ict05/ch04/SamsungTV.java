package spring.mvc.basic_ict05.ch04;

public class SamsungTV implements TV{
	
	// 멤버변수
	private SonySpeaker sony;	// sony 주소값
	private String brand;		// 브랜드 : 삼성
	private int price;			// 가격 : 1200000
	
	// DI(Dependency Injection) : 의존성 주입이며, 클래스 간의 의존관계를 Bean 설정에 기반해 컨테이너가 자동으로 연결해주는 방식이다.
	// 1) 생성자 Injection 2) Setter Injection이 있다.
   
	// 1) 생성자 Injection   => 매개변수 생성자
	
	// 매개변수 생성자
	public SamsungTV(SonySpeaker sony, String brand, int price) {
		this.sony = sony;
		this.brand = brand;
		this.price = price;
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
	
	public void printInfo() {
		System.out.println("sony 주소 : " + sony);
		System.out.println("브랜드 : " + brand);
		System.out.println("price : " + price);
	}

}
