<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.lendingManagement" />
</h3>

<s:form>
	<s:actionerror />
	<s:hidden name="lendingId" value="0" />

	<%-- The table of publications--%>
	<display:table id="publicationTable" name="publicationList"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="basic.msg.empty_list" value="Es können keine Publikationen mehr ausgeliehen werden - bitte Abbrechen" />
		<display:column>
			<input type="radio" name="publicationId"
				value="${publicationTable.publicationId}" />
		</display:column>
		<display:column title="Nak-ID" property="nakId"
			sortable="true" />
		<display:column title="Titel" property="title"
			sortable="true" />
		<display:column title="Datum der Veröffentlichung"
			property="dateOfPublication" sortable="true" />
		<display:column title="Verlag"
			property="publisher.publisherName" sortable="true" />
		<display:column title="Publikationsart"
			property="publicationType.name" sortable="true" />
		<display:column title="ISBN" property="isbn"
			sortable="true" />
	</display:table>

	<%-- The table of lender--%>
	<display:table id="lenderTable" name="lenderList" cellpadding="5px;"
		cellspacing="5px;" style="margin-left:50px;margin-top:20px;"
		requestURI="#">
		<display:setProperty name="basic.msg.empty_list" value="Keine Ausleiher vorhanden" />
		<display:column>
			<input type="radio" name="lenderId" value="${lenderTable.lenderId}" />
		</display:column>
		<display:column title="Matrikulationsnummer"
			property="matriculationNumber" sortable="true" />
		<display:column title="Vorname" property="firstName"
			sortable="true" />
		<display:column title="Nachname" property="lastName"
			sortable="true" />
	</display:table>

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveLending" />
	<s:submit key="btn.cancel" action="CancelLending" />
</s:form>
