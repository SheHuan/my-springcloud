package com.sh.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 Ribbon 访问某个服务时的配置
 * <p>
 * RibbonConfig 类必须是 @Configuration 类，但请注意它不在主应用程序上下文的 @ComponentScan 中。
 * 否则，它由所有@RibbonClients 共享。如果您使用@ComponentScan（或@SpringBootApplication），
 * 则需要采取措施避免将其包含在内（例如，您可以将其放在一个单独的、不重叠的包中或在@ComponentScan 中明确指定要扫描的包）
 * <p>
 * 简单的说就不是不要被主程序的 @ComponentScan（或@SpringBootApplication） 扫描到
 */
@Configuration
public class RibbonConfig {

    /**
     * Ribbon 默认使用轮询策略实现负载均衡，这里改为随机策略
     * 注意 OrderApplication80 中配置的服务名，还有调用时地址的服务名必须大写
     * @return
     */
    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
