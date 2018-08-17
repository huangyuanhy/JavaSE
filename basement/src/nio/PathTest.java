package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        //�ڴ�ͳjava.io�У� �ļ���Ŀ¼���������File���� �� File file = new File(".");
        //NIO.2��������ӿ�Path������ƽ̨�޹ص�·�����ļ���Ŀ¼����Path�����ʾ
        //ͨ��·��������Paths����һ��·������Path
        Path path = Paths.get(".");
        System.out.println("path�������·��������" + path.getNameCount());
        System.out.println("path�ĸ�·���� "+path.getRoot());
        //path�ľ���·��
        //�Աȴ�ͳjava.io, ȡ����·�� file.getAbsoluteFile()
        Path absolutePath = path.toAbsolutePath();
        System.out.println("path�ľ���·����");
        System.out.println(absolutePath);
        System.out.println("absolutePath�ĸ�·���� "+absolutePath.getRoot());
        System.out.println("absolutePath�������·��������" + absolutePath.getNameCount());
        System.out.println(absolutePath.getName(1));
        //�Զ��String������path
        Path path2 = Paths.get("e:", "publish" , "codes");
        System.out.println(path2);
        

        
    }
}