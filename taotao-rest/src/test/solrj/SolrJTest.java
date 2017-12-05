package solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Created by feng on 2017/11/30.
 */
public class SolrJTest {
    @Test
    public void addDocument() throws Exception{
        //创建一个连接
        SolrServer solrServer = new HttpSolrServer("http://106.15.199.235:8080/solr");
        //创建一个文本对象
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id","test001");
        document.addField("item_title","测试商品1");
        document.addField("item_price",54321);
        //把文档写入索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }
}
