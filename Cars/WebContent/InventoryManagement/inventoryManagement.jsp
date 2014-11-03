<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>txt.inventoryManagement</h3>

<s:form>
	<s:submit key="btn.search" action="SearchForm"/>
<s:actionerror/>
<display:table id="publicationTable" name="publicationList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="publicationId"
				value="${publicationTable.publicationId}" />
		</display:column>
		<display:column titleKey="publication.title" property="title" sortable="true"/>
		<display:column titleKey="publication.dateOfPublication" property="dateOfPublication" sortable="true"/>
		<display:column titleKey="publication.publisher" property="publisher.publisherName" sortable="true"/>
		<display:column titleKey="publication.publicationType" property="publicationType.name" sortable="true"/>
		<display:column titleKey="publication.isbn" property="isbn" sortable="true"/>
		<display:column titleKey="publication.quantity" property="quantity" sortable="true"/>
	</display:table>

	<s:submit key="btn.add" action="AddPublication"/>
	<s:submit key="btn.edit" action="EditPublication"/>
	<s:submit key="btn.delete" action="DeletePublication"/>
</s:form>
