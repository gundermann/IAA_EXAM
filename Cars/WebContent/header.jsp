<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<h1>
	<s:text name="txt.welcome" />
</h1>
<%-- Menü --%>
<s:form>
	<s:submit align="left" key="btn.masterDataManagement"
		action="ShowMasterDataManagement" />
	<s:submit align="left" key="btn.inventoryManagement"
		action="ShowInventoryManagement" />
	<s:submit align="left" key="btn.rental" action="ShowRental" />
	<s:submit align="left" key="btn.reminderManagement"
		action="ShowAdmonitionManagement" />
</s:form>
