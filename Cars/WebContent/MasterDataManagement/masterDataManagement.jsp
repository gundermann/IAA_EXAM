<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:submit key="btn.publicationType" action="ShowPublicationTypeList"/>
	<s:submit key="btn.keywords" action="ShowKeywordList"/>
	<s:submit key="btn.lender" action="ShowLenderList"/>
	<s:submit key="btn.author" action="ShowAuthorList"/>
</s:form>