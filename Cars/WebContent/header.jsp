<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<h1>
	<s:text name="txt.welcome" />
</h1>
<%-- Menü --%>
<s:form>
	<s:submit align="left" key="btn.masterDataManagement"
		action="OpenMasterDataManagement" />
	<s:submit align="left" key="btn.inventoryManagement"
		action="OpenInventoryManagement" />
	<s:submit align="left" key="btn.search" action="OpenSearch" />
	<s:submit align="left" key="btn.rental" action="OpenRental" />
	<s:submit align="left" key="btn.reminderManagement"
		action="OpenReminderManagement" />
</s:form>
