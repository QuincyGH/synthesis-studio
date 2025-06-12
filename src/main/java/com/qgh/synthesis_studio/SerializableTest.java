package com.qgh.synthesis_studio;

import java.io.*;
import java.nio.file.Files;

public class SerializableTest implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int yes = 1;

    public static void main(String[] args) {
        File file = new SerializableTest().getFile("yes 的练级攻略.txt");
        try {
            /*
            将对象序列化存储到文件中
             */
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            out.writeObject(new SerializableTest());
            out.close();

            // 序列化后修改类值为3
            SerializableTest.yes = 3;

            /*
            将文件中的数据反序列化为对象
             */
            ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file.toPath()));
            SerializableTest serializableTest = (SerializableTest) in.readObject();
            in.close();

            // 打印反序列化对象中的静态变量值
            System.out.println(serializableTest.yes);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取路径
     *
     * @param fileName
     * @return
     */
    public File getFile(String fileName) {
        File file = new File(this.getClass().getResource("").getPath() + File.separator + fileName);
        System.out.println(file.getAbsolutePath());
        return file;
    }
}
