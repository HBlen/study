1. 安装IntelliJ IDEA开发环境
1.下载IntelliJ IDEA
下载网站：https://www.jetbrains.com/idea/download
下载符合操作系统的Ultimate 最终版本。
2.在 hosts 文件里面添加如下配置
0.0.0.0 account.jetbrains.com
注：采用命令修改或图形界面修改hosts文件，后者修改失败可以将文件拷贝到桌面修改后替换原hosts文件。
3.打开 idea，输入注册码 网址 http://idea.lanyus.com/
注：不要使用破解jar包，不要使用破解jar包，不要使用破解jar包


2. maven安装
下载网址：http://maven.apache.org/download.cgi 解压下载的安装包到某一目录，比如：/Users/xxx/Documents/maven 配置环境变量： 打开terminel输入以下命令： vim ~/.bash_profile 打开.bash_profile文件，在次文件中添加设置环境变量的命令 export M2_HOME=/Users/xxx/Documents/maven/apache-maven-3.5.0 export PATH=$PATH:$M2_HOME/bin 添加之后保存并推出，执行以下命令使配置生效： source ~/.bash_profile 输入：mvn -v命令 查看是否安装成功
配置文件：~/Documents/apache-maven-3.6.0/conf/settings.xml 替换settings.xml文件
下载地址 http://phabricator.huobidev.com/file/download/xurcvrchmaf7mdb7pepy/PHID-FILE-yo67bxy2ls7j45gzzawn/settings.xml
在idea上配置maven file-->other settings-->preferences for new projects参考图片所示配置 


3.
安装homebree ：https://www.jianshu.com/p/bca8fc1ff3f0
安装Java JDK ：https://www.kancloud.cn/kancloud/ocds-guide-to-setting-up-mac/71035


