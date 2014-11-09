<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>
	<s:text name="txt.masterDataManagement.publisher"/>
</h3>
<s:form>
<s:actionerror/>
	<%-- Form fields for the publisher's attributes --%>
	<s:hidden name="publisher.publisherId"/>
	<s:textfield name="publisher.publisherName" key="publisher.name" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublisher" align="left"/>
	<s:submit key="btn.cancel" action="CancelPublisher" align="left"/>
</s:form>
