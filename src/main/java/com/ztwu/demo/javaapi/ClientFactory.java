package com.ztwu.demo.javaapi;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
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
                    .put("cluster.name", "edmp_bigdata_cluster")
                    //忽视连接集群时名字验证
                    .put("client.transport.ignore_cluster_name", true)
                    //ping 一个节点时等待时间 默认5秒
                    .put("client.transport.ping_timeout", "5s")
                    //多久采样 ping / 节点列表和连接
                    .put("client.transport.nodes_sampler_interval", "5s")
                    .build();

            //创建client(添加连接地址)
            transportClient = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("172.31.17.2"), 9300));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportClient;
    }
}
