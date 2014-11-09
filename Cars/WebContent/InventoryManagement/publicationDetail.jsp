<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.inventoryManagement.editPublication" />
</h3>
<s:form>
	<s:actionerror />

	<%-- the list of authors of the publication --%>
	<h3>
		<s:text name="publication.authors" />
	</h3>
	<s:iterator value="publication.authors">
		<s:text name="name"></s:text>
		<br />
	</s:iterator>
	<br />

	<%-- the list of keywords of the publication --%>
	<h3>
		<s:text name="publication.keywords" />
	</h3>
	<s:iterator value="publication.keywords">
		<s:text name="keyword" />
		<br />
	</s:iterator>
	<br />

	<%-- the left attributes of publication--%>
	<s:hidden name="publicationId" />
	<s:label name="publication.nakId" key="publication.nakId" />
	<s:label name="publication.title" key="publication.title" />
	<s:date name="publication.dateOfPublication" id="dateOfPublication"
		format="dd.MM.yyyy" />
	<s:label key="publication.dateOfPublication"
		name="publication.dateOfPublication" value="%{dateOfPublication}" />
	<s:label name="publication.isbn" key="publication.isbn" />
	<s:label name="publication.quantity" key="publication.quantity" />
	<s:label key="publication.publicationType"
		name="publication.publicationType.name" />
	<s:label key="publication.publisher"
		name="publication.publisher.publisherName"
		value="%{publication.publisher == null ? '' : publication.publisher.publisherName}" />
		
		<br/>
		<s:label key="lendings" value="%{lendingList.size()}"/>
	<%-- The table of all lending --%>
	<display:table id="lendingTable" name="lendingList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list"
			value="" />
		<display:column title="Herausgabedatum" property="outgoDate"
			sortable="true" format="{0,date,dd.MM.yyyy}" />
		<display:column title="Ausleiher - Mat.NR."
			property="lender.matriculationNumber" sortable="true" />
		<display:column title="Rückgabedatum" property="expectedReturnDate"
			sortable="true" format="{0,date,dd.MM.yyyy}" />
		<display:column title="Anzahl der Verlängerungen"
			property="numberOfLendingExtensions" sortable="true" />
	</display:table>

	<%-- The buttons --%>
	<s:submit key="btn.edit" align="left"
		action="EditPublicationFromDetail" />
</s:form>
