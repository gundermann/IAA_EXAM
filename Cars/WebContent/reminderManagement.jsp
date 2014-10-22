<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>btn.reminderManagement</h3>
<s:form>
	<s:actionerror/>
	
	<%-- Menü --%>
	<s:submit key="btn.masterDataManagement" action="OpenMasterDataManagement"/>
	<s:submit key="btn.inventoryManagement" action="OpenInventoryManagement"/>
	<s:submit key="btn.search" action="OpenSearch"/>
	<s:submit key="btn.rental" action="OpenRental"/>
	<s:submit key="btn.reminderManagement" action="OpenReminderManagement"/>
</s:form>