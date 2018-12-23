# devops

### 1.代码规约
> 参照~/files/JAVA开发规范.docx

### 2.git规范
> Commit message格式

    <type>: <subject>  注意：冒号后面有空格
>> type

* feat：新功能（feature）
* fix：修补bug
* docs：文档（documentation）
* style：格式（不影响代码运行的变动）
* refactor：重构
* test：增加测试
* chore：构建过程或辅助工具的变动

>> subject

subject是commit的简短描述，不超过50个字符，且结尾不加句号(.)。

### 3.git使用说明
> 常用命令：
  
    git config --list  查看git配置
    git config --global user.name "com"
    git config --global user.email "com@com.com.cn"
    ssh-keygen -t rsa -C "com@com.com.cn"  将生成的~/.ssh/id_rsa.pub中的公钥复制到github/gitlab/gitblit上
    git remote add origin url
    git push -u origin master  指定origin为默认主机
        
> 其他git命令

    git init  初始化git仓库
    git clone url 远程拷贝仓库到本地
    git status  查看当前仓库的状态
    git diff  查看当前状态与最新commit之间的差异
    git diff v1 v2  版本1与版本2的差异
    git add .  添加新建文件
    git checkout -- .  撤回所有修改
    git commit -m "message"  提交信息
    git log  查看commit日志
    git reset --hard commitID  回退指定版本号的版本
    git branch  查看分支
   
### 4.数据库
> 填写~/files/mysql.xlsx
> 运行~/scripts/table_auto.py，即cmd下运行python table_auto.py

------------------------------

