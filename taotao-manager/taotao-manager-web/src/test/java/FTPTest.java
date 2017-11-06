import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by feng on 2017/10/29.
 */
public class FTPTest {

    public void testFtpClient() throws  Exception{
        //创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        //创建ftp连接，
        ftpClient.connect("106.15.199.235",21);
        //登录ftp服务器，使用用户名和密码
        ftpClient.login("ftpuser2","182971");
        //上传文件，
        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("F:\\CSDN图片\\0.jpg"));
        //设置上传的路径
        ftpClient.changeWorkingDirectory("/home/ftpuser2/www/images");
        //修改上传文件的格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数，服务器文档名
        //第二个参数，上传文档的inputStream
        ftpClient.storeFile("hello1.jpg",inputStream);
        //关闭连接
        ftpClient.logout();
    }
    @Test
    public  void testFtpUtil()throws  Exception{
        FileInputStream inputStream = new FileInputStream(new File("F:\\CSDN图片\\0.jpg"));
        //新建时间文件夹，按照时间存放文件
        FtpUtil.uploadFile("106.15.199.235", 21, "ftpuser2", "182971", "/home/ftpuser2/www/images","/2017/10/28", "hell02.jpg", inputStream);

    }
}
