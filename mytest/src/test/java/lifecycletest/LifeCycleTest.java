package lifecycletest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lifeCycle.xml");
		LifecycleBean lifeCycleBean = applicationContext.getBean("lifeCycleBean", LifecycleBean.class);
		System.out.println("12. bean创建完成 name： " + lifeCycleBean.getName());
		((ClassPathXmlApplicationContext) applicationContext).destroy();
	}
}
