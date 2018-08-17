package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public class Paths {
	/*
	 * paths useage
	 */
	public static void main(String[] args) throws Exception {
		
		Path path=java.nio.file.Paths.get("E:\\clipse-workspace\\test\\src\\files\\Paths.java");
		Path absolutePath = path.toAbsolutePath();
		System.out.println(path);
		System.out.println(absolutePath);
		
		
		
		Files.copy(absolutePath,new FileOutputStream("a.txt"));//如果文件不存在，则自动创建一个此文件，且会覆盖原来的内容
		//绝对路径
		File file=new File("b.txt");

		//相对路径
		File file2=new File("c.txt");
	/*	try {
		file.createNewFile();
		file2.createNewFile();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}*/
		System.out.println(file2);
		file.createNewFile();
		
		//一次性读取所有行
		List<String> lines=Files.readAllLines(java.nio.file.Paths.get("E:\\clipse-workspace\\test\\b.txt"), Charset.forName("gbk"));
		System.out.println(lines);
		//将多个字符串写入指定文件               会覆盖原来文件内容   文件不存在的话自动创建
		Files.write(java.nio.file.Paths.get("E:\\clipse-workspace\\test\\c.txt"), lines, Charset.forName("gbk"));
		//读取文件内容
		Files.lines(java.nio.file.Paths.get("E:\\clipse-workspace\\test\\c.txt")).forEach(pa->System.out.println("文件内容"+pa));
		//列出当前目录下所有文件及其子目录
		Files.list(java.nio.file.Paths.get(".")).forEach(pa->System.out.println(pa));
		

		System.out.println("path include the number of root----"+path.getNameCount());

	}
	
}
