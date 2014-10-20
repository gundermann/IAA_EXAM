<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>btn.masterDataManagement</h3>
<s:form>
	<s:submit key="btn.kindOfPublication" action="KindOfPublicationList"/>
	<s:submit key="btn.keyword" action="KeywordList"/>
	<s:submit key="btn.borrower" action="BorrowerList"/>
</s:form>