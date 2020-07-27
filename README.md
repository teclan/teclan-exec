## 调用CMD命令行的简单封装

```
cmd /c dir 是执行完dir命令后关闭命令窗口。 
cmd /k dir 是执行完dir命令后不关闭命令窗口。 
cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。 
cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭。

连续执行命令时，需要 && 连接

```

## 作为依赖

- 克隆本项目

- 在项目目录下执行

``` 
mvn install -Dmaven.test.skip=true
```

- 在需要引用的项目下添加如下依赖

```xml
 <dependency>
     <groupId>teclan.exec</groupId>
     <artifactId>teclan-exec</artifactId>
     <version>0.0.1-SNAPSHOT</version>
  </dependency>
```