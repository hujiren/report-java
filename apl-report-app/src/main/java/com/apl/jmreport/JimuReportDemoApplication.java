package com.apl.jmreport;

import org.jeecg.modules.jmreport.common.util.oConvertUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@MapperScan(value={"org.jeecg.modules.**.mapper*"})
@SpringBootApplication(scanBasePackages = {
        "org.jeecg.modules.jmreport",
        "com.apl.jmreport",
        "com.apl.lib", //APL基本工具类
        "com.apl.tenant", //多租户
        "com.apl.db.adb", // adb数据库操作助手
        "com.apl.cache", // redis代理
        },
        exclude= {DataSourceAutoConfiguration.class})
public class JimuReportDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(JimuReportDemoApplication.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String path = oConvertUtils.getString(env.getProperty("server.servlet.context-path"));
        System.out.print("\n----------------------------------------------------------\n\t" +
                "Application JimuReport Demo is running! Access URL:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/jmreport/list\n\t" +
                "----------------------------------------------------------");

    }

}
