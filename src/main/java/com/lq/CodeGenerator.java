package com.lq;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * 代码生成器，控制台输入模块表名回车自动生成对应项目目录中
 */
public class CodeGenerator {

    /**
     * 读取控制台内容
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        builder.append("请输入"+ tip+": ");
        System.out.println(builder.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "! ");
    }


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator auto = new AutoGenerator();

        //region 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setActiveRecord(true);  // 是否执行AR模式
        gc.setAuthor("liangq8");
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");  // 生成路径
        gc.setFileOverride(true);  // 文件覆盖
        gc.setIdType(IdType.AUTO);   // 主键策略
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);  // 生成基本的resultMap
        gc.setBaseColumnList(true);  // 生成基本的SQL片段
        gc.setOpen(false);
        //endregion

        //region 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);  // 设置数据库类型
        dsc.setUrl("jdbc:mysql://localhost:3306/devops?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("spdb1234");
        //endregion

        //region 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);  // 全局大写命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);  // 表名指定采用驼峰式
        strategy.setNaming(NamingStrategy.underline_to_camel);  // 数据库表映射到实体类指定采用驼峰式
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名"));
        //endregion

        //region 包配置
        PackageConfig pc = new PackageConfig();
        String moduleNameGenerate = scanner("是否生成模块：Y/N");
        if ("Y".equals(moduleNameGenerate)) {
            pc.setModuleName(scanner("模块名"));
        }
        pc.setParent("com.lq");
        pc.setMapper("dao");  // dao
        pc.setService("service");
        pc.setController("web");
        pc.setEntity("model");
        pc.setXml("mapper");
        //endregion

        //region 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        //endregion


        //region 统一配合
        auto.setGlobalConfig(gc);
        auto.setDataSource(dsc);
        auto.setStrategy(strategy);
        auto.setPackageInfo(pc);
        auto.setCfg(injectionConfig);
        //endregion

        // 执行
        auto.execute();
    }
}
