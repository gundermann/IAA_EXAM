<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title><tiles:insertAttribute name="title" /></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<s:head />
</head>
<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />
	<!-- MasterDataManagementHeader -->
	<tiles:insertAttribute name="masterDataManagementHeader" />
	<hr />
	<!-- Content -->
	<tiles:insertAttribute name="content" />
</body>
</html>

