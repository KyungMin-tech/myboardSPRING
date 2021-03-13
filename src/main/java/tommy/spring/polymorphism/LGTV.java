package tommy.spring.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")//얘를 빈으로 등록하는데 아이디를 tv로 등록해라
public class LGTV implements TV{
	
	//@Autowired//자동으로 speaker타입을 등록
	//@Qualifier("apple")
	//@Resource(name="sony")
	@Autowired
	private Speaker speaker;
	public LGTV() {
		System.out.println("LGTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV 전원을 켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV 전원을 끈다");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();// lgTV에서 스피커를 이용해서 볼륨 조절
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
