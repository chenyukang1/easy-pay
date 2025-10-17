package com.cyk.easy.pay.gateway.domain.rule.service;

import com.cyk.easy.pay.common.valobj.Money;
import com.cyk.easy.pay.routing.domain.channel.model.valobj.TransactionContext;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.Currency;

class DroolsRuleEngineServiceTest {

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("route.drl"));

        // 3. 构建 KieBuilder
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();

        if (kieBuilder.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            throw new RuntimeException("规则文件编译出错: " + kieBuilder.getResults().toString());
        }
        // 4. 获取 KieContainer
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());

        // 5. 创建 KieSession（这里用配置文件里的名字，也可以直接 newKieSession()）
        KieSession kieSession = kieContainer.newKieSession();

        TransactionContext ctx = new TransactionContext();
        ctx.setTransactionId("tx123");
        ctx.setMoney(Money.of(100000, Currency.getInstance("CNY")));
        kieSession.insert(ctx);
        kieSession.fireAllRules();

        System.out.println(ctx.getOrderId());

        kieSession.dispose();
    }

}