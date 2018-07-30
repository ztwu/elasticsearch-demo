package com.ztwu.demo.javaapi;

import org.elasticsearch.client.Client;

/**
 * Created with Intellij IDEA.
 * User: ztwu2
 * Date: 2018/7/4
 * Time: 14:58
 * Description 使用java api操作elasticsearch
 */

public class JavaApiElasticsearchTest {

    public static void main(String[] args) {
        Client client =  ClientFactory.transportClient();
        ElasticsearchCURD elasticsearchCURD = new ElasticsearchCURD(client);

//        elasticsearchCURD.createIndex("test_java_api");
//        elasticsearchCURD.addMapping("test_java_api","test_type");
//        elasticsearchCURD.createDoc("test_java_api","test_type","1");
//        elasticsearchCURD.createDoc2("test_java_api","test_type");
//        elasticsearchCURD.updateDoc("test_java_api","test_type","1");
        System.out.println(elasticsearchCURD.get("edmp_bigdata_exam_subject_report","dm_standard_report_union_exam_subject","KgSX2WQBJaVaXotg_aJw"));
//        elasticsearchCURD.min("test_java_api","test_type");

    }
}
