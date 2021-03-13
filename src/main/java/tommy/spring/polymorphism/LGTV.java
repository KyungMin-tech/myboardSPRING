package tommy.spring.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")//�긦 ������ ����ϴµ� ���̵� tv�� ����ض�
public class LGTV implements TV{
	
	//@Autowired//�ڵ����� speakerŸ���� ���
	//@Qualifier("apple")
	//@Resource(name="sony")
	@Autowired
	private Speaker speaker;
	public LGTV() {
		System.out.println("LGTV ��ü ����");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV ������ �Ҵ�");
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV ������ ����");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();// lgTV���� ����Ŀ�� �̿��ؼ� ���� ����
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
