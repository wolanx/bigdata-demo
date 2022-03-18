## port

- Hadoop默认端口说明 https://blog.csdn.net/zzhongcy/article/details/19912577

- hdfs
  - NameNode
    - 8020: api rpc
- yarn
  - ResourceManager
    - 8088: web

## install

- dockerfile https://github.com/HariSekhon/Dockerfiles/blob/master/hadoop/Dockerfile

```shell
docker pull harisekhon/hadoop:2.9

docker run -it -d --name hadoop -p 8088:8088 -p 8020:8020 harisekhon/hadoop:2.9
```

## hdfs cmd

- HDFS常用Shell命令 https://github.com/heibaiying/BigData-Notes/blob/master/notes/HDFS常用Shell命令.md

```shell
# 加进去文件
hadoop fs -put test.log /
hadoop fs -ls /
```
