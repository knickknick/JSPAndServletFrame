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
		System.out.println("用户名为："+user.getUsername());
		System.out.println("密码为："+user.getPassword());
		System.out.println("邮箱为："+user.getEmail());
		System.out.println("电话号码为："+user.getPhonenumber());
	}

}
