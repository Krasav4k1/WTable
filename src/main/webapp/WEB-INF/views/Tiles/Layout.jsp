<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--<title><tiles:getAsString name="title"></tiles:getAsString></title>--%>
</head>
<!-- This is template, "parent" web page  -->
<body>
<div>
    <tiles:insertAttribute name="header"/>
</div>
<div>
    <tiles:insertAttribute name="uvidomlenia"/>
</div>
<div>
    <tiles:insertAttribute name="body"/>
</div>
<div>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>