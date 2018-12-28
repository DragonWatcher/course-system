<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>学生选课管理系统</title>
  <link rel="stylesheet" href="/css/login.css">
  <link rel="stylesheet" href="/font-awesome/css/font-awesome.min.css">
   
</head>
<body>
<div class="logo_box">
  <h1>学生选课管理系统</h1>
  <form action="login" method="post" autocomplete="off">
    <div class="input_outer">
      <i class="fa fa-user-o u_user"></i>
      <input required="required" name="username" class="text" placeholder="输入账号" type="text">
    </div>
    <div class="input_outer">
      <i class="fa fa-eye u_user"></i>
      <input required="required" placeholder="请输入密码" name="password" class="text" type="password">
  		
    </div>
    <div class="checkbox my_checkbox">
   		 <label><input name='role' type="radio" checked="checked" value="student" />学生</label>
		 <label><input name='role' type="radio"  value="teacher" />教师</label>
		 <label><input name='role' type="radio"  value="admin"/>管理员</label>
    </div>
    <div class="mb2">
      <button class="act-but submit" style="color: #FFFFFF">登录</button>
      <!--<div class="actions"><a href="/reg">注册</a></div>-->
    </div>
  <#if error??>
    <div style="text-align:center;padding: 10px;">${error}</div>
  </#if>

  </form>
</div>
</body>
</html>