# Configuration-Center
数据配置中心

MySQL+Docker+Zookeeper+Druid+SpringBoot+Gradle+Quartz

1.MySQL用于持久化配置数据

2.Server在配置数据时会同时分发至ZK-Node/MySQL，ZK在Client会注册Watcher，一旦通知更新，则刷新Client端KV缓存

3.Clinet根据领域模型中TTL会定时使用Quartz 轮询数据库更新数据

4.Druid用作监控整体数据库访问与Web

5.Docker虚拟化环境-------备选

