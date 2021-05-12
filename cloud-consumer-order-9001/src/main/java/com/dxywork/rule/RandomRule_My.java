package com.dxywork.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.List;

public class RandomRule_My extends AbstractLoadBalancerRule {
    private int total = 0;//总共被调用次数
    private int currentIndex = 0;//当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> uplist = lb.getReachableServers();//健康的微服务
            List<Server> alllist = lb.getAllServers();//所有微服务
            int serverCount = alllist.size();//微服务数量
            if (serverCount == 0) {
                return null;
            }
            if (total < 5) {
                server = uplist.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= uplist.size()) {
                    currentIndex = 0;
                }
            }
            /*int size = uplist.size();
            if (total % 5 == 0 && total > 0) {
                int i = 0;
                System.out.println("进入了");
                while (i < 5) {
                    server = uplist.get(currentIndex);
                    currentIndex++;
                    if (currentIndex >= size) {
                        currentIndex = 0;
                    }
                    i++;
                }
            } else {
                System.out.println("进入了第二个");
                server = uplist.get(currentIndex);
                total++;
                currentIndex++;
                if (currentIndex >= size) {
                    currentIndex = 0;
                }
            }
            System.out.println(total);*/
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return this.choose(this.getLoadBalancer(), o);
    }
}
