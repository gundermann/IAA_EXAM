<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>
	<s:text name="txt.masterDataManagement.lender"/>
</h3>
<s:form>
<s:actionerror/>
	<%-- Form fields for the lender's attributes --%>
	<s:hidden name="lender.lenderId"/>
	<s:textfield name="lender.matriculationNumber" key="lender.matriculationNumber" requiredLabel="true"/>
	<s:textfield name="lender.firstName" key="lender.firstname" requiredLabel="true"/>
	<s:textfield name="lender.lastName" key="lender.lastname" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveLender" align="left"/>
	<s:submit key="btn.cancel" action="CancelLender" align="left"/>
</s:form>
