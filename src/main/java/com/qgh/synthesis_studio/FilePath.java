package com.qgh.synthesis_studio;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FilePath {
    public static void main(String[] args) {
        new FilePath().getPath();
    }

    public void getPath() {
        // 一、获取项目编译路径
        // 1、使用 getResource().getPath() 获取编译路径
        // 1.1、传递 "/" 作为参数，返回类的 classpath 根路径
        File f11 = new File(Objects.requireNonNull(this.getClass().getResource("/")).getPath());
        // D:\AppStuData\IdeaProjects\synthesis-studio\target\classes
        System.out.println(f11);

        // 1.2、传递以 "/" 开头作为参数，返回类的以 classpath 根路径开头的路径
        File f12 = new File(Objects.requireNonNull(this.getClass().getResource("/com/qgh")).getPath());
        // D:\AppStuData\IdeaProjects\synthesis-studio\target\classes\com\qgh
        System.out.println(f12);

        // 1.3、传递 "" 作为参数，返回类所在包的路径
        File f13 = new File(Objects.requireNonNull(this.getClass().getResource("")).getPath());
        // D:\AppStuData\IdeaProjects\synthesis-studio\target\classes\com\qgh\synthesis_studio
        System.out.println(f13);

        // 1.4、传递以 "" 开头作为参数，返回以类所在包开头的路径
        File f14 = new File(Objects.requireNonNull(this.getClass().getResource("temp")).getPath());
        // D:\AppStuData\IdeaProjects\synthesis-studio\target\classes\com\qgh\synthesis_studio\temp
        System.out.println(f14);

        // 2、使用类加载器 getClassLoader() 获取编译路径，始终从 classpath 根路径开始，参数不能以 "/" 开头
        // 2.1、传递 "" 作为参数，返回类的 classpath 根路径
        File f21 = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath());
        // D:\AppStuData\IdeaProjects\synthesis-studio\target\classes
        System.out.println(f21);

        // 2.2、传递以 "" 开头作为参数，返回以 classpath 根路径开头的路径
        File f22 = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource("com")).getPath());
        // D:\AppStuData\IdeaProjects\synthesis-studio\target\classes\com
        System.out.println(f22);

        // 二、获取项目工作目录路径
        /*
        2、使用 System.getProperty() 获取项目路径
        System.getProperty() 函数可以获取各种系统属性。"user.dir" 属性会返回当前工作目录的路径，通常是项目的根目录。
         */
        String projectPath = System.getProperty("user.dir");
        // D:\AppStuData\IdeaProjects\synthesis-studio
        System.out.println(projectPath);

        /*
        3、使用 File 对象获取工程路径
        创建一个 File 对象，不传递任何参数给它的构造函数，然后调用 getCanonicalPath() 方法来获取当前工程的路径。这种方法不依赖于类加载器，因此它适用于获取项目的根目录。
         */
        File directory = new File("");
        String courseFile;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // D:\AppStuData\IdeaProjects\synthesis-studio
        System.out.println(courseFile);
    }
}
