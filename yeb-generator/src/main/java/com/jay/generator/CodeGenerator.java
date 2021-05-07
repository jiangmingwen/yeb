package com.jay.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    /**
     * 读取控制台内容
     *
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }

        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/yeb-generator/src/main/java");

        //作者
        gc.setAuthor("Jay");

        //打开输出目录
        gc.setOpen(false);

        //xml开启BaseColumnList
        gc.setBaseColumnList(true);

        //实体属性Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/yeb?useUnicode=true&character=UTF-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("jay123");
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();

        pc.setParent("com.jay.server")
                .setEntity("pojo")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {

            @Override
            public void initMap() {
                //to do nothing
            }
        };

        //如果模板引擎是freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        //自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/yeb-generator/src/main/resources/mapper/" +
                        tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.no_change);

        //lombok
        strategyConfig.setEntityLombokModel(true);
        //生成@ResetController控制器
        String[] s = scanner("表名，多个英文逗号分割").split(",");
        strategyConfig.setInclude(s);
        strategyConfig.setControllerMappingHyphenStyle(true);

        //表前缀
        strategyConfig.setTablePrefix("t_");
        mpg.setStrategy(strategyConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();


    }
}
