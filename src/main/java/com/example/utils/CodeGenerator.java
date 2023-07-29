package com.example.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    /*？？？？？？？？？？*/
    private static final String[] TABLE_NAMES = new String[]{"sys_org"};
    /*项目文件路径（到com文件夹的上一层也就是java文件夹截止，java后面没有斜杠）*/
    public static final String PROJECT_PATH = "/Users/wanghongyu/IdeaProjects/GeneratorTest/src/main/java";
    /*项目名*/
    public static final String PROJECT_NAME = "meeting";
    /*模块名称*/
    public static final String MODULE_NAME ="";

    //此时已经锁定到了模块内部
    public static void main(String[] args) {
        //创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //设置数据源
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        autoGenerator.setDataSource(dataSource);
        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(PROJECT_PATH);
        globalConfig.setOpen(true);//生成完毕后是否打开目录
        globalConfig.setAuthor("wahoyu");//作者
        globalConfig.setFileOverride(false);//是否覆盖
        globalConfig.setMapperName("%sMapper");//设置数据层接口名，%s表示占位符，代指模块名称
//        globalConfig.setIdType(IdType.ASSIGN_ID);//设置Id生成策略
        autoGenerator.setGlobalConfig(globalConfig);
        //设置包名相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example");//想要将mapper等文件夹生成在哪个文件夹中
        packageConfig.setEntity("entity");//设置实体类的包名
        packageConfig.setMapper("mapper");//设置数据层的包名
        autoGenerator.setPackageInfo(packageConfig);
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //strategyConfig.setInclude()//设置当前参与生成的表名，参数为可变参数
        strategyConfig.setTablePrefix("");//去掉生成的前缀
        strategyConfig.setRestControllerStyle(true);//设置是否启动Rest风格
        strategyConfig.setVersionFieldName("version");//设置乐观锁字段名
        strategyConfig.setEntityLombokModel(true);//设置是否启用lombok
        strategyConfig.setCapitalMode(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //下划线转驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //需要生成的的表名，多个表名传数组
        String[] tableList = new String[] {"student"};
        strategyConfig.setInclude(tableList);
        autoGenerator.setStrategy(strategyConfig);
        //执行代码生成器
        autoGenerator.execute();
    }


    /**
     * @MethodName: getStrategyConfigInfo
     * @Description: 策略配置
     * @Return: StrategyConfig
     **/
    public static StrategyConfig getStrategyConfigInfo(String... tableNames) {
        StrategyConfig strategyConfigInfo = new StrategyConfig();
        strategyConfigInfo.setCapitalMode(true);
        strategyConfigInfo.setNaming(NamingStrategy.underline_to_camel);
        //下划线转驼峰命名
        strategyConfigInfo.setColumnNaming(NamingStrategy.underline_to_camel);
        //需要生成的的表名，多个表名传数组
        strategyConfigInfo.setInclude(tableNames);
        //设置逻辑删除字段
        strategyConfigInfo.setLogicDeleteFieldName("deleted");
        //使用lombok
        strategyConfigInfo.setEntityLombokModel(true);
        //设置表格前缀
        strategyConfigInfo.setTablePrefix("");
        //rest风格
        strategyConfigInfo.setRestControllerStyle(true);
        return strategyConfigInfo;
    }
}