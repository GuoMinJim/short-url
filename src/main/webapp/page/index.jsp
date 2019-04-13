<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
</head>
<script type="application/javascript" src="../public/jquery.min.js"></script>
<body>
    Hello World! 当前访问量为：${views}
    <hr>
    <form method="POST" action="../convert/long2short">
        请输入长链接：<input type="text" name="longUrl" id="longUrl" value=""><br/>
        长度: <input type="text" name= "length" id = "length"></input><br/>
        <select name="diyUrl" id="diyUrl">
        <c:forEach items="${diys}" var="line" varStatus="stat">
            <option value="${line}">${line}</option>
        </c:forEach>
        </select> 
        <!-- <c:forEach items="${diys}" var="line" varStatus="stat">
            <input type="radio" name="diyUrl" id="diyUrl" value="${line}">${line}<br>
        </c:forEach> -->
    </form>
    <div id="shortUrl" name="shortUrl"></div>
    <input type="submit" id="btn" class="btn" value="压缩">
    <hr>
    请输入短链接：<input type="text" name="shortUrll" id="shortUrll" value="">
    <div id="longUrll" name="longUrll"></div>
    <input type="submit" id="btn1" class="btn1" value="还原">
</body>
<script type="application/javascript">
    $("#btn").click(function (e) {
        $.ajax({
            type : "POST",
        url : "./convert/long2short",
        data: {
          diyUrl : document.getElementById("diyUrl").value,
          longUrl : document.getElementById("longUrl").value,
          length : document.getElementById("length").value
        }, 
        success :function(data) {
            console.log(data);
            $("#shortUrl").html(data);
        }
        })
    })

    $("#btn1").click(function (e) {
        $.ajax({
            type : "GET",
        url : "./convert/short2long",
        data: {
            shortUrl : document.getElementById("shortUrll").value
        }, 
        success :function(data) {
            console.log(data);
            $("#longUrll").html(data);
        }
        })
    })
</script>
</html>