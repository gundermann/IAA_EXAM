<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>txt.inventoryManagement</h3>

<s:form>
	<s:submit key="btn.search" action="SearchForm"/>

<display:table id="publicationTable" name="publicationList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="id"
				value="${publicationTable.id}" />
		</display:column>
		<display:column titleKey="publication.title" property="title" sortable="true"/>
		<display:column titleKey="publication.yearOfPublication" property="yearOfPublication" sortable="true"/>
		<display:column titleKey="publication.publisher" property="publisher" sortable="true"/>
		<display:column titleKey="publication.publicationType" property="publicationType" sortable="true"/>
		<display:column titleKey="publication.isbn" property="isbn" sortable="true"/>
		<display:column titleKey="publication.quantity" property="quantity" sortable="true"/>
	</display:table>

	<s:submit key="btn.add" action="AddPublication"/>
	<s:submit key="btn.add" action="EditPublication"/>
</s:form>
