# 面试 Web基础

## Java Web

### 1. Session的生命周期？如何管理？



### 2. ServletContext、HttpSession、HttpServletRequest的异同？作用范围？

**ServletContext**
ServletContext是Servlet上下文，web服务器在启动阶段会解析web.xml配置文件，为运行的web应用创建一个全局唯一的ServletContext对象，应用内所有的servelet都共享这个上下文对象，当应用停止时，该对象才销毁。其有两个功能：存储数据和读取资源。
① **存储数据**：由于其全局特性，可以在Servlet之间传递数据，通常用于存放全局配置参数，通过`setAttribute(String name, Object value)`、`getAttribute(String name)`和`removeAttribute(String name)`方法可以存放、获取以及消除数据。
② **读取资源**：此外，还可以通过`getRealPath(String path)`根据相对路径获取resource目录下的绝对路径；也可以使用`getResourceAsStream(String path)`以字节流的方式读取resource目录下的文件。



**HttpSession**
Java Web中使用HttpSession维护一个浏览器到服务器的会话，其中保存了用户当前的信息。在会话范围内，可以使用HttpSession存储数据，例如保存用户登陆状态(username和password)和其他基本信息。可以通过`request.getSession()`方法获取当前的会话，其中request是`HttpServletRequest`的实例。

HttpSession也可以用于**数据共享**，在会话范围内，通过`setAttribute(String name, Object value)`和`getAttribute(String name)`可以设置和获取数据。由于Session记录了当前的会话，因此统计session即可统计当前系统的在线人数和活跃度等信息。
使用SessionListener可以对Session的状态进行监听，重写`sessionCreated()`、`sessionDestroyed()`可以监听Session的创建和销毁，`attributeAdded()`、``attributeReplaced()`、`attributeRemoved()`可以监听session数据的添加、修改和销毁操作。

**HttpServletRequest**
HttpServletRequest是web服务的请求，每一次HTTP请求都会生成一个新的HttpServletRequest对象。其可以在一个请求的范围内跨Servlet传递数据。

**相同点**：三者都可以用于传递数据，都有着相同的存取数据的方法。
**不同点**：三者作用范围不同，ServletContext作用域为应用全局；HttpSession作用域为一次会话；HttpServletRequest作用域为一次HTTP请求。



### 3. Servlet是什么？有什么作用？



### 4. JDBC是什么？连接池是什么？



### 5. 使用IO多路复用的方式实现JDBC？







## 框架

### 1. Spring的两大特性？IOC和AOP？



### 2. Spring如何处理Bean之间的相互依赖？Spring的三级缓存？



### 2. SpringMVC的特性？DispatcherServlet运行机制？



### 3. 为什么Springboot开箱即用？



### 4. Springboot的启动流程？

SpringBoot的基本启动流程如下：
① 从main中找到run()方法，创建一个`SpringApplication`对象，再调用其run()方法。
② 创建应用监听器`SpringApplicationRunListeners`开始监听创建Context时的各个事件。
③ 加载SpringBoot配置环境`ConfigurableEnvironment`，并将其加入监听对象中。
④ 加载应用上下文`ConfigurableApplicationContext`并将其返回。
⑤ 创建Spring容器，开始自动化配置并实例化Bean。



### 6. 常用依赖注入注解的区别？(@Bean、@Component、@Atowired、@Resource、@Qualifier)



### 7. @Controller和@RestController注解的区别？



### 8. 对MyBatis的理解？如何实现分页？



### 9. 幂等问题如何解决？

#### 幂等问题
考虑订单提交业务，当同一笔订单多次提交，扣款金额和预期不一致，则说明操作不幂等。幂等性是要求相同的逻辑操作无论执行多少次其结果都是统一的。

#### 解决幂等问题的方法

**数据库防重**
利用数据表唯一索引的特性，操作后生成一个唯一索引存放至数据库中，通过数据库的唯一性去重，重复的操作会导致相同的索引出现。当相同索引出现后数据库抛出异常，后台程序捕获异常并进行处理即可保证系统幂等。Java程序需要捕获DuplicateKeyException异常，Spring应用捕获：MySQLIntegrityConstraintViolationException异常。唯一索引可以使用uuid，也可以使用name、timestamp等字段组合生成。
注：UUID(Universally Unique Identifier)通用唯一识别码，由32个16进制数组成，理论包含$2^{128}$个不同ID，通常用于分布式系统中指定元素的唯一辨识信息。

**布隆过滤器**
布隆过滤器是由Bitmap和映射函数构成的检索工具，用于判断一个元素是否存在于一个集合(Bitmap)中。对操作构建一个唯一的key(MD5编码时间戳)，使用映射函数判断集合中是否存在该元素，若不存在则将其加入集合(Bitmap对应位置为1)，若存在则拒绝操作。以此保证操作的幂等性。

**分布式锁**
使用Redis或Zookeeper分布式锁，将订单编号作为唯一业务字段，setnx的方式实现加锁，并配置过期时间。若加锁成功则说明第一次请求可以操作数据，否则拒绝数据操作。
这种方式只能实现key过期时间范围内的幂等操作。

**Token**
对每一个操作前都先从后台获取一个临时生成的token，后台返回token的同时将这个token放入token池。当请求接口时附上token，后台接收请求后验证token池中是否存在对应的token，若存在则删除池中的token，并执行操作；若不存在则说明操作已经执行，拒绝操作。
通常使用Redis的方式实现token池。



### 10. 什么是跨域问题？如何解决？



### 11. SSO是什么？如何实现？



### 12. Shiro如何实现权限验证？JWT是什么？



### 13. Druid是什么？自动聚合性能问题？









## Web服务器

### 1. Tomcat是什么？



### 2. Tomcat默认的线程数量？



### 3. Nginx为什么可靠性高？



### 4. Netty如何实现NIO？BIO、NIO、AIO的区别？



### 5. RSTP是什么？如何实现？









## 中间件

### 1. Kafka、RabbitMQ、RocketMQ的异同？



### 2. Zookeeper是什么？





 