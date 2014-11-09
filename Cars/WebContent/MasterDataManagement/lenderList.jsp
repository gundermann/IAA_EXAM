<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.masterDataManagement.lender" />
</h3>

<s:form>
	<s:actionerror />
	<%-- list of lenders --%>
	<display:table id="lenderTable" name="lenderList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list"
			value="Keine Ausleiher vorhanden" />
		<display:column>
			<input type="radio" name="lenderId" value="${lenderTable.lenderId}" />
		</display:column>
		<display:column title="Matrikulation-Nummer"
			property="matriculationNumber" sortable="true" />
		<display:column title="Vorname" property="firstName" sortable="true" />
		<display:column title="Nachname" property="lastName" sortable="true" />
	</display:table>

	<%-- The buttons --%>
	<s:submit key="btn.add" action="AddLender" align="left" />
	<s:submit key="btn.delete" action="DeleteLender" align="left" />
	<s:submit key="btn.edit" action="EditLender" align="left" />
</s:form>