package cn.oddcloud;
/*
以下内容是我通过平时老师课上用的ppt进行的总结



        提问1：谈谈你对软件体系结构的理解

            软件体系结构（Software Architecture）：是软件编程风格范畴的一个通俗概念，比如说用C++、Java等来进行软件设计是面向对象的编程语言体系结构，
                而Basic、C的软件体系结构特点是面向过程的编程语言。每一种软件体系结构均有自己的组织原则和基本成份，从而决定了风格的形成。

            软件架构（Software Framework）:整个软件系统的各个模块之间的结构设计，是软件工程范畴的概念，就象设计一栋房子的户型图。

            软件体系结构强调方法论，体现的是学术范畴的。

            软件架构更强调开发实践，体现的是工程范畴的。

        问题2：有哪些类型的应用

            体系结构风格

            管道/过滤器体系结构风格

            数据抽象和面向对象体系结构风格

            事件驱动体系结构风格

            分层体系结构风格

            数据共享体系结构风格

            C/S结构（客户机/服务器体系结构风格）

            三层C/S结构（面向网络应用）

            B/S结构（浏览器/服务器体系结构风格



        典型应用

            服务器端程序（Java Web、PHP、.NET，淘宝php-java，滴滴打车php/mysql）

            移动客户端（Android手机，iPhone手机，各种平板，饿了吗app、暴风、爱奇艺）

            浏览器客户端（新浪、微博等订阅关注系统，推拉模式）

            专用客户端（QQ程序、微信，实时处理）

            HTTP协议，完成浏览器类客户端与服务器端的交互

            TCP/UDP，完成专用客户端与服务器端的交互



        提问3：什么是企业级应用？

            为商业组织、大型企业而创建的解决方案及应用程序。具有用户数多、数据量大、事务密集等特点，能够满足未来业务需要的变化，
                易于升级和维护。

            好的企业级应用体系结构设计，需要考虑体系结构的合理性、安全性、灵活性、健壮性，既能满足企业级应用的复杂需求，
                也能为系统的调整和升级留有余地。从而延长整个应用的生命周期，增强用户的适应性，减少了系统维护的开销和难度
                ，给用户带来最大的利益。



        什么是架构？

            架构是一系列相关的抽象模式，用于指导大型软件系统各方面的设计。

            架构则描述了一个软件系统从整体到部分的最高层次的抽象划分。直接认为架构就是系统的设计规划图也不为过。

            根据关注的角度不同，架构大概有三种：

            逻辑架构：主要描述软件系统中元件之间的关系，例如用户界面，数据库，业务逻辑元件等等

            物理架构：主要描述软件元件是如何安装到硬件上的。

            系统架构：主要描述系统的非功能性特征，如可扩展性、可靠性、强壮性、灵活性、性能等。

        如何架构一个软件系统，通常就会用到分层技术。

            软件开发主要任务，是要保证软件的高效运转和功能的正常实现。分层技术通过对软件内部结构进行解析，
                赋予不同层次结构的不同功能，从而提高软件功能的丰富程度和使用性能。

            分层技术为软件的不同层次结构分配不同的解决过程，各个层次结构间组成一个严密的封闭系统。
                不同层面结构彼此平等。分层技术最主要的应用领域是软件架构开发。

            分层技术是将软件按照一定逻辑关系分解成多个层面，每个层面都有各自的功能，组合起来则形成完整的软件。
                各分层之间具有一定独立性，需要完善软件功能或者对软件进行升级改造时，只需   要对涉及到的分层进行完善修改，
        、       对其它层面几乎没有影响，使软件升级和改造工作变得更加简单，提高工作效率。

            分层技术通过分层模式来定义各个功能层次的接口。按照这种设计方式，软件复用性得以大幅提高，对于软件开发、设计十分有利。
                开发之后的各个层面能够充分利用标准接口，有效实现自动对接。

            目标:

                降低耦合，降低层与层之间的依赖。有利于应对需求变更，有利于排错，有利于后期的维护。

                简化问题复杂度，各层分工明确。例如OSI七层模型和简化的tcpip协议的四层模型。把一个复杂问题分解，
                    达到化繁为简的效果。但是，一般针对系统大小而言的，如果一个小的系统，也可能会把简单问题复杂化。

        Spring概述

            Spring用于管理组件，组件的管理需要进行配置

            Spring为组件提供服务，服务的使用也需要配置

            Spring是一个轻量级的框架，提供管理组件和提供服务的实现类。

        Spring框架的作用

            软件架构中利用Spring框架管理系统的各个组件(Action、Service、DAO)，使用Spring的IOC和AOP机制实现应用程序中的Bean组件等的关联，
                从而实现了低耦合调用，增强系统可维护性和扩展性。

            Spring通过控制反转（IoC）技术实现低耦合。

        1.Spring框架体系结构

            1.1 Spring框架

                Spring是分层的javaEE应用一站式轻量级开源框架，由Rod Johnson创建；Spring是为简了化企业级系统开发而诞生的；
                    使用Spring，可以用简单的JavaBeans来实现那些EJB的功能。

                如果一个系统不需要分布式计算或声明式事务支持，EJB并不是最好的选择；Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。

                Spring的核心是控制反转（IoC）和面向切面编程（AOP）。提供了展现层SpringMVC、持久层SpringJDBC以及业务层是否管理等
                    众多企业级应用技术。Spring IoC和AOP能让代码很好的分层和解耦，从而提高可维护性和可扩展性，便于测试。

            1.2 Spring体系结构

                Spring 是一个分层架构，由 7 个定义良好的模块组成，有1400多个类。Spring模块构建在核心容器之上，核心容器定义了创建、配置和管理 bean 的方式。

                Spring的精妙之处在于，组成Spring框架的每个模块（或组件）都可以单独存在，或者与其他一个或多个模块联合实现。针对某个领域问题，Spring往往支持多种实现方案。

            1.3 Spring模块

                1核心容器（Spring Core）

                    核心容器提供 Spring 框架的基本功能(Spring Core)。

                    核心容器的主要组件是 BeanFactory，它是工厂模式的实现，作为IoC容器管理Bean。

                    BeanFactory 使用控制反转（IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开，将类和类之间的依赖从代码中脱离出来，用配置的方式进行依赖关系描述，
                        由IoC容器负责依赖类之间的创建、拼接、管理、获取等工作。 BeanFactory接口是Spring框架的核心接口，实现了容器的许多核心功能。

                    spring-core.jar，spring-beans.jar
                2上下文（Spring Context）
                    Spring上下文是一个配置文件，向 Spring框架提供上下文信息。

                    Context模块构建与核心模块之上，扩展额BeanFactory的功能，提供了许多企业服务，
                        例如JNDI、EJB、电子邮件、国际化、校验和调度功能。ApplicationContext是Context模块的核心接口。

                     spring-context.jar
                3 面向切面编程（Aspect Oriented Programming）
                    AOP是OOP的一个补充， OOP的基本是类Class，AOP的基本则是切面Aspect。

                    切面Aspect：Aspect是对我们关注的一类行为进行建模。如：在所有数据库操作前我们需要开启事务，
                        在操作之后我们需要提交或回滚事务。这里“开启事务”和“提交/回滚事务”可以看做“开启事务----数据库操作-
                        ---提交/回滚事务”这种执行流程的两个行为切面。

                    如果我们把一类重复的行为提取出来，形成一个切面，植入到所有需要的地方，既有利于代码重用，又可以让原逻辑更加清晰。
                        如果这种植入可以配置化，如在调试阶段植入，在发布之后不植入，或者说植入不同的行为等，将是非常有用的。

                    通过配置管理特性，Spring AOP 模块直接将面向切面的编程功能集成到了 Spring 框架中。所以，
                        可以很容易地使 Spring 框架管理的任何对象支持AOP。

                    Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，
                        不用依赖 EJB 组件，就可以将声明性事务管理集成到应用程序中。

                    spring-aop.jar, spring-aspects.jar

                4数据访问对象（Spring DAO）
                    JDBC DAO抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。

                    异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。

                    Spring DAO 面向 JDBC 的异常遵从通用的 DAO 异常层次结构。

                    Spring通过模板化技术对各种数据访问计数进行了封装，将模式化代码隐藏起来，是数访问程序大幅简化，
                        建立起数据形式及访问技术无关的统一DAO层，借助AOP技术，Spring提供了声明式事务功能。

                    spring-jdbc.jar

                5对象关系映射（Spring ORM）
                    Spring 框架插入了若干个ORM框架，从而提供了 ORM 的对象关系工具，其中包括JDO、Hibernate和iBatis。

                    所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。

                    spring-tx.jar，spring-jdbc.jar，spring-orm.jar

                6Spring Web（web及远程操作）
                    Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。
                        所以，Spring框架支持与 Jakarta Struts 、webwork等的集成。

                    Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。

                    Web模块还提供了多项面向web的功能，如透明化文件上传，对Freemarker、Velocity、XSLT的支持。

                    spring-web.jar,

            Spring IoC容器
                Spring在使用前，必须在Spring IoC容器中装配好Bean，并建立Bean和Bean之间的关联关系。

                Bean工厂（BeanFactory）是Spring框架最核心接口，BeanFactory使得管理不同类型的Java对象成为可能，
                    应用上下文（ApplicationContext）建立在BeanFactory基础上，提供了更多面向应用的功能。
                    一般称BeanFactory为IoC容器，称ApplicationContext为应用上下文（有时也称为Spring容器）。

                从用途上划分，BeanFactory是Spring框架的基础设施，面向Spring本身，ApplicationContext面向使用Spring框架的开发者，
                    几乎所有的应用场合都直接使用ApplicationContext而不是BeanFactory。

            ApplicationContext介绍

            BeanFactory在初始化时，必须提供一种日志框架，一般使用Log4J,即在类路径下提供Log4J配置文件，
                这样启动Spring容器才不会报错。

            BeanFactory是心脏，则ApplicationContext就是完整身躯。ApplicationContext由BeanFactory派生而来，
                提供了更多面向实际应用的功能。

        Spring容器的启动（实例化）
            创建ApplicationContext对象，代表一个Spring控制反转容器启动。

        ApplicationContext的几种常用实现：
            ClassPathXmlApplicationContext：从类路径下的一个或多个XML文件中加载上下文定义，即加载Bean定义的信息。
                把应用上下文的定义文件作为类资源。

            FileSystemXmlApplicationContext：从文件系统中的一个或多个XMl文件中加载上下文定义，即Bean定义的信息。

            XmlWebApplicationContext：从Web应用下的一个或多个XML文件中载入Bean定义信息。

            AnnotationConfigApplicationContext:从一个或多个基于Java的配置类中加载Spring应用上下文。

            AnnotationConfigWebApplicationContext:从一个或多个基于Java的配置类中加载Spring Web应用上下文。


        基于XML的Spring配置
            Spring通过一个XML配置文件描述了Bean及Bean之间的依赖关系，利用Java语言的反射功能实例化Bean并建立Bean之间的依赖关系。
            Spring管理的Java对象称为“beans”。
            Spring的Ioc容器在完成这些底层工作的基础上，还提供了Bean实例缓存、生命周期管理、Bean实例代理、事件发布、资源装载等高级服务。

        依赖注入的两种方式

            XML中声明依赖注入的两种方法：构造器注入和属性注入
            属性注入：通过SetXxx（）方法和xml文件配置实现注入。
            构造器注入：通过构造器和xml文件配置实现注入。Xml文件的两种配置方案：
            <constrctor-arg>元素
            使用Spring3.0所引入的c-命名空间
            元素方式比命名空间更加冗长，难以读懂，但有些配置元素方式可以实现，但命名空间无法实现。



        Spring与分层

            Spring主要用于管理组件，而组件通常是Java类，并且是在服务器端运行的这些Java类；
            Spring不管理JSP、专用客户端、浏览器客户端、移动客户端；
            Spring不管理数据库，数据库由数据库管理系统来管理；
            Spring管理的组件包括：
            控制器层：通常写成 XXXAction.java
            业务层（或者服务层）：通常写成 XXXService.java
            DAO层（数据库访问层）：Data Access Object的缩写，通常写成 XXXDAO.java



        Spring中如何管理组件

            Spring负责组件生命周期的管理
            但是需要告诉Spring需要管理哪些组件
            通过配置文件配置
            通过注解声明

            通过注解的方式
            <bean id=“userAction" class=“action.UserAction"></bean>
             action.UserAction是组件类，userAction是对象名字
            控制层组件
            @Controller
            public class UserAction
            u业务层组件
            @Service
            public class UserService
            uDAO控件
            @Repository
            public class UserDAO



    Web应用分析

        请求/应答模式：因为采用请求/应答模式，只能从视图向模型发送请求，不能让模型去请求视图

            客户端通过浏览器发送一次请求，是一个路径（地址），服务器应答一次
            服务器不会主动给客户端发送信息。服务器端的控制器接收请求，控制器根据路径表示的含义调用模型部分。
            模型完成处理之后，把结果在返回给控制器。
            控制器根据执行的结果，选择一个视图（输出界面，通常是html代码）给用户响应。浏览器接收到返回的html代码（或者字符串），解析生成网页。
            开发人员需要考虑的是如何接收请求，以及如何应答

            服务器的主要工作
                接收请求，也就是解析那个地址，这个地址可能是JSP文件，也可能是Servlet（此时需要在Web.xml中配置请求路径与Servlet的对应关系）；
                得到请求信息，例如注册信息，通过request对象（在Servlet中是doGet或者doPost的参数HttpServletRequest request）得到各种请求信息；
                调用JavaBean完成处理，会得到处理结果；
                响应用户，返回一个html文档，该文档是根据我们编写的JSP文件生成的，有时候需要给JSP文件传输数据。



    如何映射请求路径

    四种方式配置请求路径：
        简单URL的映射处理器：SimpleUrlHandlerMapping
        根据Bean名：BeanNameUrlHandlerMapping
        根据类名：ControllerClassNameHandlerMapping
        注解方式： @Controller、@RequestMapping(value="/userList")



    如何映射控制器返回的字符串

            使用Model对象
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("customers", customers);
        ModelAndView modelAndView = new ModelAndView("/customerList",model);
        return modelAndView;

        中心控制器把返回的字符串解析成一个响应界面文件。如：在/WEB-INF/views下面找到XXX.jsp，
        系统把数据填充到XXX.jsp中，形成html文档。
        <bean
            class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/" />
        <property name="suffix" value=".jsp" />
        </bean>

    控制器如何得到界面输入的值


         @RequestMapping(value="/add")
         protected ModelAndView add(String id,String name,String age){
             List<Customer> customers = new ArrayList<Customer>();
             Customer c1 = new Customer();
             c1.setCustId(Integer.parseInt(id));
             c1.setName(name);
             c1.setAge(Integer.parseInt(age));
             customers.add(c1);
             Map<String,Object> model = new HashMap<String,Object>();
             model.put("customers", customers);
             ModelAndView modelAndView = new ModelAndView("/customerList",model);
             return modelAndView;
         }

    如何把控制器查询的结果传给视图（JSP文件)

        Action控制器

              Map<String,Object> model = new HashMap<String,Object>();
              model.put("customers", customers);
              ModelAndView modelAndView = new ModelAndView("/customerList",model);

        JSP页面

                  <table border="1">
              <tr>
                  <th>编号</th>
                  <th>姓名</th>
                  <th>年龄</th>
              </tr>
              <c:forEach items="${customers}" var="customer">
                  <tr>
                      <td>${customer.custId}</td>
                      <td>${customer.name}</td>
                      <td>${customer.age}</td>
                  </tr>
              </c:forEach>
          </table>




*/


