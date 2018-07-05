package com.ztwu.demo.javaapi;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * Created with Intellij IDEA.
 * User: ztwu2
 * Date: 2018/7/5
 * Time: 14:17
 * Description
 */

public class ClientFactory {

    @SuppressWarnings({"resource", "unchecked"})
    public static Client transportClient() {
        //创建client
        TransportClient transportClient = null;
        try {
            //设置集群名称(配置信息)
            Settings settings = Settings.builder()
                    .put("cluster.name", "ztwu_cluster")
                    .build();
            //创建client(添加连接地址)
            transportClient = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.101"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.102"), 9300));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportClient;
    }
}
