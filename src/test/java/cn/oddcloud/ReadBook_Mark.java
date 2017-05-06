package cn.oddcloud;


/**
 *读spring文档笔记知识要点
 *
 * 以面的链接是spring文档
 * http://www.oddcloud.cn/spring-%E5%AE%98%E6%96%B9%E6%96%87%E6%A1%A3.html
 */

/**
 一，概述
 使用 Spring 框架的好处
 Spring 可以使开发人员使用 POJOs 开发企业级的应用程序
 Spring 在一个单元模式中是有组织的。
 Spring 不会让你白费力气坐重复工作，它真正的利用了一些现有的技术，像几个 ORM 框架、日志框架、J
 EE、Quartz 和 JDK 计时器，其他视图技术。
 测试一个用 Spring 编写的应用程序很容易
 Spring 的 web 框架是一个设计良好的 web MVC 框架
 轻量级的 IOC 容器往往是轻量级的
 Spring 提供了一个一致的事务管理界面

 */

/**
 第一章，依赖注入

 Spring 最认同的技术是控制反转的依赖注入（DI）模式。控制反转（IoC）是一个通用的概念，它可以用许多不
 同的方式去表达，依赖注入仅仅是控制反转的一个具体的例子。

 在 OOP 中模块化的关键单元是类，而在 AOP 中模块化的关键单元是方面。AOP 帮助你将横切关注点从它们所
 影响的对象中分离出来，然而依赖注入帮助你将你的应用程序对象从彼此中分离出来。
 */

/**
 体系结构

 <p>核心容器</p>

 核心容器由核心，Bean，上下文和表达式语言模块组成，它们的细节如下：

 核心模块提供了框架的基本组成部分，包括 IoC 和依赖注入功能。
 •          Bean 模块提供 BeanFactory，它是一个工厂模式的复杂实现。
 •          上下文模块建立在由核心和 Bean 模块提供的坚实基础上，它是访问定义和配置的任何对象的媒介。Applica-
 tionContext 接口是上下文模块的重点。
 •           表达式语言模块在运行时提供了查询和操作一个对象图的强大的表达式语言。

 <h1> 数据访问/集成</h1>


 数据访问/集成层包括 JDBC，ORM，OXM，JMS 和事务处理模块，它们的细节如下：
 • JDBC 模块提供了删除冗余的 JDBC 相关编码的 JDBC 抽象层。
 • ORM 模块为流行的对象关系映射 API，包括 JPA，JDO，Hibernate 和 iBatis，提供了集成层。
 • OXM 模块提供了抽象层，它支持对 JAXB，Castor，XMLBeans，JiBX 和 XStream 的对象/XML 映射
 实现。
 • Java 消息服务 JMS 模块包含生产和消费的信息的功能。
 • 事务模块为实现特殊接口的类及所有的 POJO 支持编程式和声明式事务管理。


 <h1>Web</h1>

 Web 层由 Web，Web-MVC，Web-Socket 和 Web-Portlet 组成，它们的细节如下：
 • Web 模块提供了基本的面向 web 的集成功能，例如多个文件上传的功能和使用 servlet 监听器和面向 web
 应用程序的上下文来初始化 IoC 容器。
 • Web-MVC 模块包含 Spring 的模型-视图-控制器（MVC），实现了 web 应用程序。
 • Web-Socket 模块为 WebSocket-based 提供了支持，而且在 web 应用程序中提供了客户端和服务器端
 之间通信的两种方式。
 • Web-Portlet 模块提供了在 portlet 环境中实现 MVC，并且反映了 Web-Servlet 模块的功能。


 还有其他一些重要的模块，像 AOP，Aspects，Instrumentation，Web 和测试模块，它们的细节如下：

 • AOP 模块提供了面向方面的编程实现，允许你定义方法拦截器和切入点对代码进行干净地解耦，它实现了应
 该分离的功能。
 • Aspects 模块提供了与 AspectJ 的集成，这是一个功能强大且成熟的面向切面编程（AOP）框架。
 • Instrumentation 模块在一定的应用服务器中提供了类 instrumentation 的支持和类加载器的实现。
 • Messaging 模块为 STOMP 提供了支持作为在应用程序中 WebSocket 子协议的使用。它也支持一个注解
 编程模型，它是为了选路和处理来自 WebSocket 客户端的 STOMP 信息。
 • 测试模块支持对具有 JUnit 或 TestNG 框架的 Spring 组件的测试

 */

/**
 * IOC容器
 *
 */
/**
 *
 Spring 容器是 Spring 框架的核心。容器将创建对象，把它们连接在一起，配置它们，并管理他们的整个生命周
 期从创建到销毁。Spring 容器使用依赖注入（DI）来管理组成一个应用程序的组件。这些对象被称为 Spring Beans


 <p>Sping 的 BeanFactory 容器</p>

 它主要的功能是为依赖注入 （DI） 提供支持，这个容器接口在 org.springframewor
 k.beans.factory.BeanFactor 中被定义。 BeanFactory 和相关的接口，比如，BeanFactoryAware、 Dispo
 sableBean、InitializingBean，仍旧保留在 Spring 中，主要目的是向后兼容已经存在的和那些 Spring 整合在
 一起的第三方框架。


 最常被使用的是 XmlBeanFactory 类。这个容器从
 一个 XML 文件中读取配置元数据，由这些元数据来生成一个被配置化的系统或者应用。

 eg:
 XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));



 <p>Spring ApplicationContext 容器</p>

 Application Context 是 spring 中较高级的容器。和 BeanFactory 类似，它可以加载配置文件中定义的 bea
 n，将所有的 bean 集中在一起，当有请求的时候分配 bean。

 ApplicationContext 包含 BeanFactory 所有的功能，一般情况下，相对于 BeanFactory，ApplicationConte
 xt 会被推荐使用。BeanFactory 仍然可以在轻量级应用中使用，比如移动设备或者基于 applet 的应用程序。


 最常被使用的 ApplicationContext 接口实现：

 • FileSystemXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供
 给构造器 XML 文件的完整路径
 eg:
 ApplicationContext context = new FileSystemXmlApplicationContext
 ("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");


 • ClassPathXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提
 供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中
 搜索 bean 配置文件。

 • WebXmlApplicationContext：该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 be
 an。
 */


/**
 * Bean
 */

/**
 *
 bean 是一个被实例化，组装，并通过 Spring IoC 容器所管理的对象

 属性有class id name scope constructor-arg properties autowiring mode

 lazy-initialization mode  initialization 方法 destruction 方法


 <p>Spring 配置元数据</p>

 • 基于 XML 的配置文件。
 • 基于注解的配置
 • 基于 Java 的配置


 <p>作用域</p>

 eg;  scope="singleton"

 singleton  该作用域将 bean 的定义的限制在每一个 Spring IoC 容器中的一个单一实例(默认)。

 prototype  该作用域将单一 bean 的定义限制在任意数量的对象实例。

 request    该作用域将 bean 的定义限制为 HTTP 请求。

 session    该作用域将 bean 的定义限制为 HTTP 会话。

 global-session 该作用域将 bean 的定义限制为全局 HTTP 会话。

<p>Bean 的生命周期</p>


 为了定义安装和拆卸一个 bean，我们只要声明带有 init-method 和/或 destroy-method 参数的 。init-metho
 d 属性指定一个方法，在实例化 bean 时，立即调用该方法。同样，destroy-method 指定一个方法，只有从容
 器中移除 bean 之后，才能调用该方法。


 初始化回调

 1
 public class ExampleBean implements InitializingBean {
 public void afterPropertiesSet() {
 // do some initialization work
 }
 }

 2

 <bean id="exampleBean"
 class="examples.ExampleBean" init-method="init"/>

 销毁回调

 1

 public class ExampleBean implements DisposableBean {
 public void destroy() {
 // do some destruction work
 }
 }

 2

 <bean id="exampleBean"
 class="examples.ExampleBean" destroy-method="destroy"/>

 建议你不要使用 InitializingBean 或者 DisposableBean 的回调方法，因为 XML 配置在命名方法上提供了极大
 的灵活性。


 默认的初始化和销毁方法
 如果你有太多具有相同名称的初始化或者销毁方法的 Bean，那么你不需要在每一个 bean 上声明初始化方法和
 销毁方法。框架使用 元素中的 default-init-method 和 default-destroy-method 属性提供了灵活地配置这种
 情况

 <p>Spring——Bean 后置处理器</p>


 BeanPostProcessor 接口定义回调方法，你可以实现该方法来提供自己的实例化逻辑，依赖解析逻辑等。你也
 可以在 Spring 容器通过插入一个或多个 BeanPostProcessor 的实现来完成实例化，配置和初始化一个bean
 之后实现一些自定义逻辑回调方法。

 你可以配置多个 BeanPostProcessor接口，通过设置 BeanPostProcessor 实现的 Ordered 接口提供的 ord
 er 属性来控制这些 BeanPostProcessor 接口的执行顺序。

 BeanPostProcessor 可以对 bean（或对象）实例进行操作，这意味着 Spring IoC 容器实例化一个 bean 实
 例，然后 BeanPostProcessor 接口进行它们的工作。

 ApplicationContext 会自动检测由 BeanPostProcessor 接口的实现定义的 bean，注册这些 bean 为后置处
 理器，然后通过在容器中创建 bean，在适当的时候调用它。

 <p>Bean 定义继承</p>

 <bean id="helloWorld" class="com.tutorialspoint.HelloWorld">
 <property name="message1" value="Hello World!"/>
 <property name="message2" value="Hello Second World!"/>
 </bean>
 <bean id="helloIndia" class="com.tutorialspoint.HelloIndia" parent="helloWorld">
 <property name="message1" value="Hello India!"/>
 <property name="message3" value="Namaste India!"/>


 */


/**
 *
 * 依赖注入
 *
 */

/**
 *
 方法：
     类构造函数


 (使用 index 属性来显式的指定构造函数参数的索引 eg <constructor-arg index="0" value="2001"/>)
 eg
 <bean id="textEditor" class="com.tutorialspoint.TextEditor">
 <constructor-arg ref="spellChecker"/>
 </bean>
 <!-- Definition for spellChecker bean -->
 <bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
 </bean>

 Setter 方法

 <bean id="textEditor" class="com.tutorialspoint.TextEditor">
 <property name="spellChecker" ref="spellChecker"/>
 </bean>
 <!-- Definition for spellChecker bean -->
 <bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
 </bean>
       使用 p-namespace 实现 XML 配置
            <bean id="john-classic" class="com.example.Person"
            p:name="John Doe"
            p:spouse-ref="jane"/>
            </bean>

 */

/**
 * 注入内部 Beans
 */

/**
 <bean id="outerBean" class="...">
 <property name="target">
 <bean id="innerBean" class="..."/>
 </property>
 </bean>
 */

/**
 *
 * 注入集合
 */

/**
 现在如果你想传递多个值，如 Java Collection 类型 List、Set、Map 和 Properties

 <property name="addressList">
 <list>
 <value>INDIA</value>
 <value>Pakistan</value>
 <value>USA</value>
 <value>USA</value>
 </list>
 </property>
 <!-- results in a setAddressSet(java.util.Set) call -->
 <property name="addressSet">
 <set>
 <value>INDIA</value>
 <value>Pakistan</value>
 <value>USA</value>
 <value>USA</value>
 </set>
 </property>
 <!-- results in a setAddressMap(java.util.Map) call -->
 <property name="addressMap">
 <map>
 <entry key="1" value="INDIA"/>
 <entry key="2" value="Pakistan"/>
 <entry key="3" value="USA"/>
 <entry key="4" value="USA"/>
 </map>
 </property>
 <!-- results in a setAddressProp(java.util.Properties) call -->
 <property name="addressProp">
 <props>
 <prop key="one">INDIA</prop>
 <prop key="two">Pakistan</prop>
 <prop key="three">USA</prop>
 <prop key="four">USA</prop>
 </props>
 </property>

<p>注入 Bean 引用</p>
 <list>
 <ref bean="address1"/>
 <ref bean="address2"/>
 <value>Pakistan</value>2
 </list>

<p>要传递一个空字符串作为值</p>

 <property name="email" value=""/>

 <p>要传递一个 NULL 值</p>
 <property name="email"><null/></property>

 */


/**
 * Beans 自动装配
 *
 */

/**
 <p>自动装配模式</p>

使用 元素的 autowire
 属性为一个 bean 定义指定自动装配模式

 <bean id="textEditor" class="com.tutorialspoint.TextEditor"
 autowire="byName">

 <bean id="textEditor" class="com.tutorialspoint.TextEditor"
 autowire="byType">

 <bean id="textEditor" class="com.tutorialspoint.TextEditor"
 autowire="constructor">
 */

/**
 *
 *基于注解的配置
 */

/**

 在这前要在xml加入<context:annotation-config/>


 @Required 注解应用于 bean 属性的 setter 方法。
 它表明受影响的 bean 属性在配置时必须放在 XML 配置文
 件中，否则容器就会抛出一个 BeanInitializationException 异常。下


 @Autowired 注解可以应用到 bean 属性的 setter 方法，非 setter 方法，构造函数
 和属性。
 Setter 方法中的 @Autowired
 你可以在 XML 文件中的 setter 方法中使用 @Autowired 注释来除去 元素。当 Spring遇到一个在 setter 方法
 中使用的 @Autowired 注释，它会在方法中视图执行 byType 自动连接。

 @Autowired 的（required=false）选项
 默认情况下，@Autowired 注释意味着依赖是必须的，它类似于 @Required 注释，然而，你可以使用 @Auto
 wired 的 （required=false） 选项关闭默认行为。




 @Qualifier
 可能会有这样一种情况，当你创建多个具有相同类型的 bean 时，并且想要用一个属性只为它们其中的一个进行
 装配，在这种情况下，你可以使用 @Qualifier 注释和 @Autowired 注释通过指定哪一个真正的 bean 将会被装
 配来消除混乱


 Spring JSR-250 注释
 Spring 支持 JSR-250 的基础的注解，其中包括了 @Resource，@PostConstru
 ct 和 @PreDestroy 注解。

 @PostConstruct 和 @PreDestroy 注释：
 为了定义一个 bean 的安装和卸载，我们使用 init-method 和/或 destroy-method 参数简单的声明一下 。initmethod
 属性指定了一个方法，该方法在 bean 的实例化阶段会立即被调用。同样地，destroy-method 指定了
 一个方法，该方法只在一个 bean 从容器中删除之前被调用。
 你可以使用 @PostConstruct 注释作为初始化回调函数的一个替代，@PreDestroy 注释作为销毁回调函数的
 一个替代

 @Resource

 你可以在字段中或者 setter 方法中使用 @Resource 注释，它和在 Java EE 5 中的运作是一样的。@Resour
 ce 注释使用一个 ‘name’ 属性，该属性以一个 bean 名称的形式被注入。你可以说，它遵循 by-name 自动
 连接语义

 */


/**
 * 基于 Java 的配置
 */

/**

<p> @Configuration 和 @Bean 注解</p>

 @Configuration
 public class HelloWorldConfig {
 @Bean
 public HelloWorld helloWorld(){
 return new HelloWorld();
 }
 }
 上面的代码将等同于下面的 XML 配置：
 <beans>
 <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
 </beans>

 public static void main(String[] args) {
 ApplicationContext ctx =
 new AnnotationConfigApplicationContext(HelloWorldConfig.class);
 HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
 helloWorld.setMessage("Hello World!");
 helloWorld.getMessage();
 }

<p> @Import 注解</p>
 @import 注解允许从另一个配置类中加载 @Bean 定义

 @Configuration
 @Import(ConfigA.class)
 public class ConfigB {
 @Bean
 public B a() {
 return new A();
 }
 }

<p>生命周期回调</p>
 @Bean(initMethod = "init", destroyMethod = "cleanup" )
 @Scope("prototype")

 */


/**
 * Spring 中的事件处理
 */

/**
 通过 ApplicationEvent 类和 ApplicationListener 接口来提供在 ApplicationContext 中处理事件。
 如果一个 bean 实现 ApplicationListener，那么每次 ApplicationEvent 被发布到 ApplicationContext 上，那个 bean 会
 被通知。

 */

/**
 * Spring 框架的 AOP
 *
 */

/**
 Spring 框架的一个关键组件是面向方面的编程(AOP)框架。面向方面的编程需要把程序逻辑分解成不同的部分称
 为所谓的关注点。跨一个应用程序的多个点的功能被称为横切关注点，这些横切关注点在概念上独立于应用程序
 的业务逻辑。有各种各样的常见的很好的方面的例子，如日志记录、审计、声明式事务、安全性和缓存等。
 在 OOP 中，关键单元模块度是类，而在 AOP 中单元模块度是方面。依赖注入帮助你对应用程序对象相互解耦
 和 AOP 可以帮助你从它们所影响的对象中对横切关注点解耦。AOP 是像编程语言的触发物，如 Perl，.NE
 T，Java 或者其他。
 Spring AOP 模块提供拦截器来拦截一个应用程序，例如，当执行一个方法时，你可以在方法执行之前或之后添
 加额外的功能。


 AOP 术语

 Aspect     一个模块具有一组提供横切需求的 APIs。例如，一个日志模块为了记录日志将被 AOP 方面调用。应用程序可以拥有任意数量的方面，这取决于需求。

 Join point  在你的应用程序中它代表一个点，你可以在插件 AOP 方面。你也能说，它是在实际的应用程序中，其中一个操作将使用 Spring AOP 框架。

 Advice     这是实际行动之前或之后执行的方法。这是在程序执行期间通过 Spring AOP 框架实际被调用的代码。

 Pointcut       这是一组一个或多个连接点，通知应该被执行。你可以使用表达式或模式指定切入点正如我们将在 AOP 的例子中看到的。

 Introduction       引用允许你添加新方法或属性到现有的类中。

 Target object      被一个或者多个方面所通知的对象，这个对象永远是一个被代理对象。也称为被通知对象。

 Weaving Weaving        把方面连接到其它的应用程序类型或者对象上，并创建一个被通知的对象。这些可以在编译时，类加载时和运行时完成。


 通知的类型

 前置通知           在一个方法执行之前，执行通知。

 后置通知            在一个方法执行之后，不考虑其结果，执行通知。

 返回后通知          在一个方法执行之后，只有在方法成功完成时，才能执行通知。

 抛出异常后通知        在一个方法执行之后，只有在方法退出抛出异常时，才能执行通知。

 环绕通知               在建议方法调用之前和之后，执行通知。


 声明一个 aspect

 <aop:config>
 <aop:aspect id="myAspect" ref="aBean">
 ...
 </aop:aspect>
 </aop:config>
 <bean id="aBean" class="...">
 ...
 </bean>


 声明一个切入点
 <aop:config>
 <aop:aspect id="myAspect" ref="aBean">
 <aop:pointcut id="businessService" expression="execution(* com.xyz.myapp.service.*.*(..))"/>
 </aop:aspect>
 </aop:config>
 <bean id="aBean" class="...">
 ...
 </bean>

 声明建议

 <aop:config>
 <aop:aspect id="myAspect" ref="aBean">
 <aop:pointcut id="businessService" expression="execution(* com.xyz.myapp.service.*.*(..))"/>

 <aop:before pointcut-ref="businessService" method="doRequiredTask"/>

 <aop:after pointcut-ref="businessService" method="doRequiredTask"/>

 <aop:after-returning pointcut-ref="businessService" returning="retVal" method="doRequiredTask"/>
 <aop:after-throwing pointcut-ref="businessService" throwing="ex" method="doRequiredTask"/>

 <aop:around pointcut-ref="businessService" method="doRequiredTask"/>

 </aop:aspect>
 </aop:config>
 <bean id="aBean" class="...">
 ...
 </bean>


 <p>Spring 中基于 AOP 的 @AspectJ</p>

 <p>声明一个 aspect</p>
 @Aspect
 public class AspectModule {
 }

 <p>声明一个切入点</p>
 @Pointcut("execution(* com.xyz.myapp.service.*.*(..))") // expression
 private void businessService() {} // signature

 <p>声明建议</p>
 @Before("businessService()")
 public void doBeforeTask(){
 ...
 }
 @After("businessService()")
 public void doAfterTask(){
 ...
 }
 @AfterReturning(pointcut = "businessService()", returning="retVal")
 public void doAfterReturnningTask(Object retVal){
 // you can intercept retVal here.
 ...
 }
 @AfterThrowing(pointcut = "businessService()", throwing="ex")
 public void doAfterThrowingTask(Exception ex){
 // you can intercept thrown exception here.
 ...
 }

 */

/**
 * MVC 框架教程
 */

/**
 • 模型封装了应用程序数据，并且通常它们由 POJO 组成。
 • 视图主要用于呈现模型数据，并且通常它生成客户端的浏览器可以解释的 HTML 输出。
 • 控制器主要用于处理用户请求，并且构建合适的模型并将其传递到视图呈现。


 <p>DispatcherServlet</p>
 Spring Web 模型-视图-控制（MVC）框架是围绕 DispatcherServlet 设计的，DispatcherServlet 用来处理
 所有的 HTTP 请求和响应。

 下面是对应于 DispatcherServlet 传入 HTTP 请求的事件序列：
 • 收到一个 HTTP 请求后，DispatcherServlet 根据 HandlerMapping 来选择并且调用适当的控制器。
 • 控制器接受请求，并基于使用的 GET 或 POST 方法来调用适当的 service 方法。Service 方法将设置基于
 定义的业务逻辑的模型数据，并返回视图名称到 DispatcherServlet 中。
 • DispatcherServlet 会从 ViewResolver 获取帮助，为请求检取定义视图。
 • 一旦确定视图，DispatcherServlet 将把模型数据传递给视图，最后呈现在浏览器中。

 <p>需求的配置</p>

 <web-app id="WebApp_ID" version="2.4"
 xmlns="http://java.sun.com/xml/ns/j2ee"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
 http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
 <display-name>Spring MVC Application</display-name>

 <servlet>
 <servlet-name>HelloWeb</servlet-name>
 <servlet-class>
 org.springframework.web.servlet.DispatcherServlet
 </servlet-class>
 <load-on-startup>1</load-on-startup>
 </servlet>

 <servlet-mapping>
 <servlet-name>HelloWeb</servlet-name>
 <url-pattern>*.jsp</url-pattern>
 </servlet-mapping>
 </web-app>


 <p>定义控制器</p>

 DispatcherServlet 发送请求到控制器中执行特定的功能。@Controller 注释表明一个特定类是一个控制器的作
 用。@RequestMapping 注释用于映射 URL 到整个类或一个特定的处理方法。
 @RequestMapping(method = RequestMethod.GET)


 */

