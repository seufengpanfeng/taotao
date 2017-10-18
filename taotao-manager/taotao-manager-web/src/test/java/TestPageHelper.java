import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by feng on 2017/10/17.
 */

public class TestPageHelper {

@Test
    public void testPageHelper(){
        //创建一个spring容器
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("" +
            "classpath:spring/applicationContext-*.xml");
        //从spring容器中获得Mapper的代理对象
    TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        //执行查询。并分页
    TbItemExample example = new TbItemExample();
    //分页处理
    PageHelper.startPage(1,10);//第一页，10条
    List<TbItem> list = tbItemMapper.selectByExample(example);
    //取商品列表
    for(TbItem tbItem:list){
        System.out.println(tbItem.getTitle());
    }
    //取分页信息
    PageInfo<TbItem> pageInfo =new PageInfo<TbItem>(list);
    long total = pageInfo.getTotal();
    System.out.println("共有商品"+total);
//分页插件对逆向工程生成的代码支持不好，不能对有条件的查询分页，会异常。



    }
}
