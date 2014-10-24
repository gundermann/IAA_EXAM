<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the lender's attributes --%>
	<s:textfield name="lender.matrikelnumber" key="lender.matrikelnumber" requiredLabel="true"/>
	<s:textfield name="lender.firstName" key="lender.firstname" requiredLabel="true"/>
	<s:textfield name="lender.lastName" key="lender.lastname" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveLender"/>
	<s:submit key="btn.cancel" action="CancelLender"/>
</s:form>
