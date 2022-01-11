# SPRING CORE

## 1. IOC (Inversion of Control)
- Combine with `Dependency Injection`

- **IOC Container**: manage beans - create object, write them together, config and manage their life cycle till destruction.
		configuration metadata: XML, Java annotations, Java code.
	+ BeanFactory (use for lightweight application): provide config framework and basic function
	Ex: `XmlBeanFactory`
	+ ApplicationContext (recommend): extends from BeanFactory with more enterprise-specific functionality: resolve textual messages from a properties file, publish application events to interested event listeners.
	Common implementation: 
		`FileSystemXmlApplicationContext`
		`ClassPathXmlApplicationContext`
		`WebXmlApplicationContext`
- **MainApp**:
	+ ApplicationContext: 
		- using `ClassPathXmlApplicationContext()`: load beans configuration file and take care of creating and initializing all objects (beans mentioned in config file)
		- using `AnnotationConfigApplicationContext()`: load to read config file
	+ use `getBean()` - use bean ID to return generic object, then cast to actual object.

- **Bean Configuration File**: `Beans.xml`
```
<beans>
	<bean></bean> //object
	<bean></bean>
</beans>
```
- Benefits: 
	+ minimize the amount of code
	+ make application easy to test (doesn't require any singletons in unit test cases.)
	+ IOC container support eager instantiation and lazy loading of services.

## 2. Dependency Injection (DI)
- Not create objects but describe how they should be created
- Not directly connect to components and services but describe which services are needed by which components in config file. 
IOC container is then responsible for hooking it all up.
- 2 types:
	+ `Constructor-based DI`: container invokes a class constructor with arguments, each representing a dependency on other class.
	+ `Setter-based DI`: container call setter methods after invoking no-argument constructor or no-argument static factory method to instantiate bean.


## 3. Bean Scope
- Initiate bean:
```
<bean> id="name" class="link to class" scope="">
	<property name="var name" value="passed value" />
</bean>
```

- Using Annotation: initialize a bean
@Bean: use only inside `@Configuration`

- Scope: `singleton` | `prototype` | `request` | `session` | `application` | `websocket`

- How to: 
<br/>`@Component`
<br/>`@Scope(value="scope_name")`
	+ request, session, application, websocket: use for ApplicationContext impl ( `XMLWebApplicationContext` and `AnnotationConfigWebApplicationContext`)
	+ singleton: default scope, create only one instance each bean everytime a request has called.
	+ prototype: can create new instance everytime has new request.

## 4. Autowiring
- `@Autowired`: auto match value in container and inject
4 autowired mode: no, byType, byName, constructor
- Use via class filed, via a setter, via constructor(easy test)
- In Bean configuration, use `<context:annotation-config>` to turn on annotation wiring

## 5. Annotations
- `@Component`, `@Repository`(persistence layer), `@Service` (business layer), `@Controller` (presentation layer): all is a BEAN
- `@Configuration`: use for config files.
- `@ComponentScan`: scan bean
- `@Import`: for loading `@Bean`
- LifeCycle Callback: `@Bean(initMethod="method_name", destroyMethod="method_name")`
- `@Scope("scope_name")`: default is singleton, can change to prototype, session, ... 

## 6. Dependencies
```
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
</dependency>
```
- Servlet Library: 
`http://mvnrepository.com/artifact/javax.servlet/javax.servlet-api`
- Spring dependencies: 
```
http://mvnrepository.com/artifact/org.springframework/spring-core
http://mvnrepository.com/artifact/org.springframework/spring-web
http://mvnrepository.com/artifact/org.springframework/spring-webmvc
https://mvnrepository.com/artifact/org.springframework/spring-jdbc
https://mvnrepository.com/artifact/mysql/mysql-connector-java
```

## 7. Event Handling 
- Provided through `ApplicatonListener<event_name>` interface, using `ConfigurableApplicationContext`
- Listen through method `onApplicationEvent()`
- Built-in Events:
	+ ContextRefreshedEvent: `refresh()`
	+ ContextStartedEvent: `start()`
	+ ContextStoppedEvent: `stop()`
	+ ContextClosedEvent: `close()`
	+ RequestHandledEvent: web-specific for HTTP request

## 8. AOP 
`Aspect-oriented programming`
- **Cross-cutting concern**: the functions that span multiple points of an application.
- A technique allow modularizing crosscutting concerns, or behavior that cut across the typical divisions of responsibility (logging, transaction managent)
- Core construct: aspect - encapsulates behaviors affecting multiple classes into reusable modules.

## 9. JDBC Framework
- Open connection, execute SQL statement, process exceptions, handle transactions, close connection
- Execute SQL statement
	+ `queryForInt()`
	+ `queryForLong()`
	+ `queryForObject()`
- Execute DDL statement: `execute(SQL)`
- DataSource class: `org.springframework.jdbc.datasource.DriverManagerDataSource`
- Query Basic:
```
SELECT * FROM table;
INSERT INTO table (var1,var2) VALUES (?,?);
UPDATE table SET var1=?, var2=? WHERE var3=?;
DELETE FROM table WHERE var=?;
```

## 10. Transaction Management
- An abstract layer on top of different underlying transaction management APIs.
- Defined by `PlatformTransactionManager` interface:
	+ `TransactionStatus getTransaction(TransactionDefinition definition)`
	+ `commit(TransactionStatus status)`
	+ `rollback(TransactionStatus status)`
- Local transaction specific to a single transactional resource
- Global transaction is required in a distributed computing environment where all the resources are distributed across multiple system.
- 2 types: 
	+ Programmatic: manage transaction with the help of program
	+ Declarative: separate transaction from business code

## 11. Web MVC Framework 
`Model - View - Controller`
- After receiving HTTP request, DispatcherServlet consults HandlerMapping to call Controller
- Controller take request and call service methods to return view name to DispatcherServlet
- DispatcherServlet will take help from ViewResolver to find the defined view for request
- Finally, DispatcherServlet pass model data to the view.

- Required Config: map request in `web.xml`
```
<servlet></servlet>
<servlet-mapping><servlet-mapping>
```

## 12. Customize a bean
- Initialization method
`@PostConstruct`
- Destroy method
`@PreDestroy`


## 13. Bean LifeCycle
- controlled using `init()` method or using `InitializingBean`/`DisposableBean` interfaces
```
org.springframework.beans.factory.InitializingBean
org.springframework.beans.factory.DisposableBean
```

## 14. Log4J


**RERFERENCE**:
```
https://www.tutorialspoint.com/spring/index.htm
https://groupe-sii.github.io/cheat-sheets/spring/spring-core/index.html
```