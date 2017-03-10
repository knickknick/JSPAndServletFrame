package Test;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import entity.User;

public class test {

	public static void main(String[] args) {
		
		ClassPathResource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		User user = (User) factory.getBean("user");
		System.out.println("�û���Ϊ��"+user.getUsername());
		System.out.println("����Ϊ��"+user.getPassword());
		System.out.println("����Ϊ��"+user.getEmail());
		System.out.println("�绰����Ϊ��"+user.getPhonenumber());
	}

}
