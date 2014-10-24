<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the keyword's attributes --%>
	<s:textfield name="lender.matrikelnummer" key="lender.matrikelnummer" requiredLabel="true"/>
	<s:textfield name="lender.firstname" key="lender.firstname" requiredLabel="true"/>
	<s:textfield name="lender.lasstname" key="lender.lastname" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveKeyword"/>
	<s:submit key="btn.cancel" action="CancelKeyword"/>
</s:form>
