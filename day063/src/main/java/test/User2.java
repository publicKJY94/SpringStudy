package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class User2 { // Client(브라우저)

	public static void main(String[] args) {
		// 팩토리를 통해 look up: 객체를 호출
		// 호출된 객체를 사용
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 스프링에서 기본제공하는 팩토리
		// 스프링 컨테이너 역할 : POJO객체를 생성해주는 역할
		// 설정파일(.xml)이 필요함
		
		// 아이폰에 애플워치 setter로 주입 
		Phone phone = (Phone)factory.getBean("apple");
		
		phone.powerOn();
		phone.call();
		phone.powerOff();
		
		// 갤럭시에 갤럭시워치 생성자 주입
		phone = (Phone) factory.getBean("galaxy");
		
		phone.powerOn();
		phone.call();
		phone.powerOff();
		factory.close();
	}

}
