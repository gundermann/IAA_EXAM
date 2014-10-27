<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- The application's main template --%>
<html>
<head>
<title><tiles:insertAttribute name="title" /></title>
<style>
/* for hiding the page banner */
.pagebanner 
{
        display: none;
}
/* for customizing page links */
.pagelinks 
{
        color: maroon;
        margin: 20px 0px 20px 50px;
}
/* for shifting all the Export options*/
.exportlinks 
{
        margin: 20px 0px 20px 30px;
}
/* For changing the spaces between export link */
.export 
{
        margin-left: 30px;
}
/* For odd and even row decoration */
tr.odd 
{
        background-color: #fff
}
tr.tableRowEven,tr.even 
{
        background-color: #CCCCCC
}
/* Css for table elements */
th,td 
{
        padding: 2px 4px 2px 4px;
        text-align: left;
        vertical-align: top;
}
thead tr 
{
        background-color: #999999;
}
/* For changing the background colour while sorting */
th.sorted 
{
        background-color: #CCCCCC;
}
th.sorted a
{
        background-position: right;
        display: block;
        width: 100%;
}
th.sortable a {
	background-image: url(img/arrow_off.png);
    background-repeat: no-repeat;
    background-position: right;
        display: block;
        width: 100%;
}

th.order1 a {
	background-image: url(img/arrow_down.png);
    background-repeat: no-repeat;
}

th.order2 a {
	background-image: url(img/arrow_up.png);
    background-repeat: no-repeat;
}
th a:hover 
{
        text-decoration: underline;
        color: black;
}
th a,th a:visited 
{
        color: black;
}
</style>
<s:head />
</head>
<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />
	<hr/>
	<!-- Content -->
	<tiles:insertAttribute name="content" />

</body>
</html>
