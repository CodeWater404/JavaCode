package codewater.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-22:43
 * @Function Description ：添加两个依赖后，直接从官方复制下来这段代码就可以根据数据库表生成代码
 */
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatisplus? characterEncoding=utf-8&userSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("codewater") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://JavaCode//MybatisPlus//generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("codewater") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E://JavaCode//MybatisPlus//generator"));// 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
