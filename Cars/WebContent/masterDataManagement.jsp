<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="btn.masterDataManagement"/></h3>
<s:form>
	<s:submit key="btn.publicationType" action="ShowPublicationTypeList"/>
	<s:submit key="btn.keywords" action="ShowKeywordList"/>
	<s:submit key="btn.lender" action="ShowLenderList"/>
</s:form>