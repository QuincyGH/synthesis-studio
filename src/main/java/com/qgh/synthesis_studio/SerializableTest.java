package com.qgh.synthesis_studio;

import java.io.*;

public class SerializableTest implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int yes = 1;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new SerializableTest().getFile("yes 的练级攻略.txt");
        try {
            /*
            将对象序列化存储到文件中
             */
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(new SerializableTest());
            out.close();

            // 序列化后修改类值为3
            SerializableTest.yes = 3;

            /*
            将文件中的数据反序列化为对象
             */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            SerializableTest serializableTest = (SerializableTest) in.readObject();
            in.close();

            // 打印反序列化对象中的静态变量值
            System.out.println(serializableTest.yes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取路径
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public File getFile(String fileName) throws FileNotFoundException {
        File file = new File(this.getClass().getResource("").getPath() + File.separator + fileName);
        System.out.println(file.getAbsolutePath());
        if (file == null) {
            throw new FileNotFoundException("此路径不存在");
        }
        return file;
    }
}
