package com.junlyz.controller;

import com.junlyz.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @Date: 2019/5/7 0007 20:42
 * @Description:
 */
@RestController
public class LearnController {

    /**
     * 生成静态html模板
     * @param msg
     * @throws IOException
     */
    @GetMapping("/thymeleaf/{msg}")
    public void learn(@PathVariable String msg) throws IOException {
        //创建模版加载器
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");  //模板文件的所在目录
        resolver.setSuffix(".html");       //模板文件后缀
        //创建模板引擎
        TemplateEngine templateEngine = new TemplateEngine();
        //将加载器放入模板引擎
        templateEngine.setTemplateResolver(resolver);
        //创建字符输出流并且自定义输出文件的位置和文件名
        FileWriter writer = new FileWriter("D:/learn/index.html");
        //创建Context对象(存放Model)
        Context context = new Context();
        //创建Context对象(存放Model)
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(19);
        User user = new User();
        user.setName("李四");
        user.setAge(20);

        users.add(user1);
        users.add(user);
        context.setVariable("users", users);
        context.setVariable("names", list);
        //放入数据
        context.setVariable("hello",msg);

        //创建静态文件,"text"是模板html名字
        templateEngine.process("hello",context,writer);
    }

    public static void main(String[] args) throws IOException{
        String msg = "世界你好奥！";

        //创建模版加载器
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");  //模板文件的所在目录
        resolver.setSuffix(".html");       //模板文件后缀
        //创建模板引擎
        TemplateEngine templateEngine = new TemplateEngine();
        //将加载器放入模板引擎
        templateEngine.setTemplateResolver(resolver);
        File file = new File("D:/learn/index.html");

        boolean exists = file.exists();
        System.out.println(exists);
        //创建字符输出流并且自定义输出文件的位置和文件名
        FileWriter writer = new FileWriter(file);
        //创建Context对象(存放Model)
        Context context = new Context();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setName("张三");
        user1.setAge(19);
        User user = new User();
        user.setName("李四");
        user.setAge(20);

        users.add(user1);
        users.add(user);
        context.setVariable("users", users);
        context.setVariable("names", list);
        //放入数据
        context.setVariable("hello",msg);
        //创建静态文件,"text"是模板html名字
        templateEngine.process("hello",context,writer);
    }

}
