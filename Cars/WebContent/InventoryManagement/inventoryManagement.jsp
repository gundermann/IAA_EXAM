<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.inventoryManagement" />
</h3>

<s:form>
	<s:submit key="btn.search" action="SearchForm" />
	<s:actionerror />
	<display:table id="publicationTable" name="publicationList"
		pagesize="5" cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list" value="Keine Publikationen gefunden" />
		<display:column>
			<input type="radio" name="publicationId"
				value="${publicationTable.publicationId}" />
		</display:column>
		<display:column title="Nak-ID" property="nakId"
			sortable="true" />
		<display:column title="Titel" property="title"
			sortable="true" />
		<display:column title="Datum der Veröffentlichung"
			property="dateOfPublication" sortable="true"
			format="{0,date,dd.MM.yyyy}" />
		<display:column title="Verlag"
			property="publisher.publisherName" sortable="true" />
		<display:column title="Publikationart"
			property="publicationType.name" sortable="true" />
		<display:column title="ISBN" property="isbn"
			sortable="true" />
		<display:column title="Bestandsmenge" property="quantity"
			sortable="true" />
	</display:table>

	<s:submit key="btn.add" action="AddPublication" align="left" />
	<s:submit key="btn.edit" action="EditPublication" align="left" />
	<s:submit key="btn.delete" action="DeletePublication" align="left" />
</s:form>
