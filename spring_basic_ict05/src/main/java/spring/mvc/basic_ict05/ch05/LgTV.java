package spring.mvc.basic_ict05.ch05;

public class LgTV implements TV{
	
	private AppleSpeaker apple;		// 주소값
	private String brand;			// brand
	private int price;				// price
	private int bonusPoint;			// bonusPoint
	
	public LgTV(AppleSpeaker apple, String brand, int price, int bonusPoint) {
		this.apple = apple;
		this.brand = brand;
		this.price = price;
		this.bonusPoint = bonusPoint;
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
		apple.volumeUp();
	}

	@Override
	public void volumDown() {
		apple.volumDown();
	}
	
	public void printInfo() {
		System.out.println("apple 주소 : " + apple);
		System.out.println("brand : " + brand);
		System.out.println("price : " + price);
		System.out.println("bonusPoint : " + bonusPoint);
	}

}
