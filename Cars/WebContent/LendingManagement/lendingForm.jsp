<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.lendingManagement"/></h3>

<s:form>
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
		<display:column titleKey="publication.publisher" property="publisher.publisherName" sortable="true"/>
		<display:column titleKey="publication.publicationType" property="publicationType.name" sortable="true"/>
		<display:column titleKey="publication.isbn" property="isbn" sortable="true"/>
		<display:column titleKey="publication.quantity" property="quantity" sortable="true"/>
	</display:table>

<display:table id="lenderTable" name="lenderList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lenderId" value="${lenderTable.lenderId}" />
		</display:column>
		<display:column titleKey="lender.matriculationNumber" property="matriculationNumber" sortable="true"/>
		<display:column titleKey="lender.firstname" property="firstName" sortable="true"/>
		<display:column titleKey="lender.lastname" property="lastName" sortable="true"/>
	</display:table>

<s:submit key="btn.save" action="SaveLending"/>
<s:submit key="btn.cancel" action="CancelLending"/>
</s:form>
