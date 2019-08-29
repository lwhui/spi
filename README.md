 SPI 全称为 Service Provider Interface，是一种服务发现机制。
    
    SPI 的本质是将接口实现类的全限定名配置在文件中，并由服务加载器读取配置文件，加载实现类。
        这样可以在运行时，动态为接口替换实现类。正因此特性，我们可以很容易的通过 SPI 机制为我们的程序提供拓展功能。
        
 核心思想其实就是解耦，是“基于接口的编程＋策略模式＋配置文件”组合实现的动态加载机制。
        
    使用场景
        A、数据库驱动加载接口实现类的加载
        B、JDBC加载不同类型数据库的驱动
            JDBC4.0之前通常使用Class.forName("com.mysql.jdbc.Driver")加载数据库驱动
            JDBC4.0之后就不需要Class.forName(...)加载了，直接获取连接（DriverManager.getConnection(...)）就可以，
            这种方式就是使用Java的SPI扩展机制来实现，具体看DriverManager（静态代码开始）源码。
            具体厂商或者框架开发者实现。厂商或者框架开发者开发具体的实现：
                1、在META-INF/services目录下定义一个名字为接口全限定名的文件，比如java.sql.Driver文件，
                   文件内容是具体的实现名字，比如lwh.study.sql.MyDriver。
                2、写具体的实现lwh.study.sql.MyDriver，都是对接口Driver的实现。

        C、日志门面接口实现类的加载
            SLF4J加载不同提供商的日志实现类
        D、Spring
            Spring中大量使用了SPI，比如：servlet3.0规范对ServletContainerInitializer的实现、自动
            类型转换Type Conversion SPI（Converter SPI、Formater SPI）等
        E、Dubbo
            SPI 机制在第三方框架中也有所应用，比如 Dubbo 就是通过 SPI 机制加载所有的组件。不过，
            Dubbo 并未使用 Java 原生的 SPI 机制，而是对其进行了增强，允许用户扩展实现Filter接口。
            在 Dubbo 中，SPI 是一个非常重要的模块。基于 SPI，我们可以很容易的对 Dubbo 进行拓展。        
