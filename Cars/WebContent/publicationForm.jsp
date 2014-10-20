<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the car's attributes --%>
	<s:hidden name="publication.id"/>
	<s:textfield name="publication.title" key="lbl.brand" size="40" maxlength="100" requiredLabel="true"/>
	<s:textfield name="publication.athors" key="lbl.color" size="10" maxlength="50" requiredLabel="true"/>
	<s:textfield name="publication.publishingDate" key="lbl.wheelCount" size="1" maxlength="1" requiredLabel="true"/>
	<s:textfield name="publication.verlag" key="lbl.yearOfProduction" size="4" maxlength="4"/>
	<s:checkbox name="publication.kindOfPublication" key="lbl.isDieselEngine"/>

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SavePublication"/>
	<s:submit key="btn.cancel" action="CancelPublication"/>
</s:form>
