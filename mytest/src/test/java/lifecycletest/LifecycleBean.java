/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lifecycletest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Simple test of BeanFactory initialization and lifecycle callbacks.
 *
 * @author Rod Johnson
 * @author Colin Sampaleanu
 * @author Chris Beams
 * @since 12.03.2003
 */
public class LifecycleBean implements BeanNameAware,
		BeanFactoryAware,
		ApplicationContextAware,
		InitializingBean,
		DisposableBean{
	private BeanFactory beanFactory;

	private ApplicationContext applicationContext;

	private String name;

	public LifecycleBean(String name) {
		System.out.println("2. 构造方法被调用，name：" + name);
		this.name = name;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("5. BeanNameAware被调用, 获取到的beanName：" + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("6. BeanFactoryAware被调用，获取到beanFactory：" + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("7. ApplicationContextAware被调用，获取到ApplicationContextAware：" + applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("9. afterPropertiesSet被调用");
	}

	public void myInit() {
		System.out.println("10. myInit自定义初始化方法被调用，name：" + getName());
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("13. DisposableBean被调用");
	}

	public void myDestroy() {
		System.out.println("14. destroy-method自定义销毁方法被调用");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
