### 销售管理系统的实现

#### 环境配置
1. 开发工具idea2018，数据库mysql5.6
2. 数据库的配置在resources文件夹中jdbc.properties外置文件中
```
    jdbc.driver=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://127.0.0.1:3306/sakila
    jdbc.username=root
    jdbc.password=123456
```
#### 数据格式 
        接口返回的数据为json格式，其格式为{code:"",msg:"",map:""}
        1.code:返回值，如果code = 100 ,则为ture. code = 200,则为false.
        2.msg:成功或失败的信息。
        3.map:返回前段的数据 
    
#### 实现的功能
##### 1. 拒绝未登录用户进入系统功能
    对于未登录的用户，直接访问`success.html`页面是不允许的，如果强行访问则会被跳转回登录界面，进行登录操作。
##### 2. 登录功能
    用户名为customer表的first_name字段，密码为customer表的last_name字段。利用正则校验用户名和密码，用户名和密码不能为中文和数字，且字母个数范围都在[1,16]之间。
    不允许用户名和密码为空提交。
##### 3. 对customer的新增、编辑、删除、批量删除功能
    1.新增：使用正则检验。firstName、lastNmae不能为中文或数字，eamil必须符合:(字母数字).(字母数字)@(字母数字).com  例如: Aa1.aA1@qq.com 。firstName、lastNmae、email不能为空提交。
    2.编辑：使用正则检验。firstName、lastNmae不能为中文或数字，eamil必须符合:(字母数字).(字母数字)@(字母数字).com  例如: Aa1.aA1@qq.com 。firstName、lastNmae、email不能为空提交。
    3.删除：点击删除按钮会弹出提示框是否要删除firstNname 的该条信息。
    4.批量删除;选择多条数据进行删除，弹出警示框会提示将要删除的多个firstName。如果没有选择要删的数据时进行提示必须选择要删除的数据。
##### 4. 分页功能
    1.分页信息：显示当前第几页，一共有几页，总共的记录有多少条
    2.分页导航条：首页、“<<”代表上一页、“>>”代表下一页、末页。当前页为首页时，“<<”失效不可选，反之亦然。点击跳转按钮跳转到相应的页数。当前页是高亮的状态。
##### 5. 退出系统功能
    页面的右上角人头图标为退出系统功能，并且提示要确认退出？如果确认，则清除session并且退出系统后会返回到登录界面，此时需要重新登录才能访问主界面。
       