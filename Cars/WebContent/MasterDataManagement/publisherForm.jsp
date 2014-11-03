<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the publisher's attributes --%>
	<s:hidden name="publisher.publisherId"/>
	<s:textfield name="publisher.publisherName" key="publisher.name" requiredLabel="true"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublisher"/>
	<s:submit key="btn.cancel" action="CancelPublisher"/>
</s:form>
