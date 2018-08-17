package classLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import test.this_1;
/**
 * 
 * 实现自定义类加载器需要继承ClassLoader或者URLClassLoader，继承ClassLoader则需要自己重写findClass()方法并编写加载逻辑，继承URLClassLoader则可以省去编写findClass()方法以及class文件加载转换成字节码流的代码。那么编写自定义类加载器的意义何在呢？

当class文件不在ClassPath路径下，默认系统类加载器无法找到该class文件，在这种情况下我们需要实现一个自定义的ClassLoader来加载特定路径下的class文件生成class对象。

当一个class文件是通过网络传输并且可能会进行相应的加密操作时，需要先对class文件进行相应的解密后再加载到JVM内存中，这种情况下也需要编写自定义的ClassLoader并实现相应的逻辑。

当需要实现热部署功能时(一个class文件通过不同的类加载器产生不同class对象从而实现热部署功能)，需要实现自定义ClassLoader的逻辑。
 * @author huangyuan
 * @date 2018年8月7日下午4:42:21
 * @Description
 */
public class MyClassLoader extends ClassLoader{

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		String filename=name.substring(name.lastIndexOf(".")+1)+".class";
		InputStream inputStream=MyClassLoader.class.getResourceAsStream(filename);
			if (inputStream==null) {
				super.loadClass(name);
			}
			try {
				byte[] buff=new byte[inputStream.available()];
				inputStream.read(buff);
				//���ܽ�class����������ת����Class����
				return defineClass(buff, 0, buff.length);
			} catch (IOException e) {
				throw new ClassNotFoundException();
			}
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> class1 = new MyClassLoader().loadClass("classLoader.MyClassLoader");
		Class<? extends String> class2 = "classLoader.MyClassLoader".getClass();
		System.out.println(class1.equals(class2));
	}

}
