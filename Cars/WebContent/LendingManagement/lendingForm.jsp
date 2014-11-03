<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.lendingManagement"/></h3>

<s:form>
<s:hidden name="lendingId"/>

<display:table id="publicationTable" name="publicationList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lending.publication.publicationId"
				value="${publicationTable.publicationId}" />
		</display:column>
		<display:column titleKey="publication.nakId" property="nakId" sortable="true"/>
		<display:column titleKey="publication.title" property="title" sortable="true"/>
		<display:column titleKey="publication.dateOfPublication" property="dateOfPublication" sortable="true"/>
		<display:column titleKey="publication.publisher" property="publisher.publisherName" sortable="true"/>
		<display:column titleKey="publication.publicationType" property="publicationType.name" sortable="true"/>
		<display:column titleKey="publication.isbn" property="isbn" sortable="true"/>
	</display:table>

<display:table id="lenderTable" name="lenderList" 
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lending.lender.lenderId" value="${lenderTable.lenderId}" />
		</display:column>
		<display:column titleKey="lender.matriculationNumber" property="matriculationNumber" sortable="true"/>
		<display:column titleKey="firstname" property="firstName" sortable="true"/>
		<display:column titleKey="lender.lastname" property="lastName" sortable="true"/>
	</display:table>

<s:submit key="btn.save" action="SaveLending"/>
<s:submit key="btn.cancel" action="CancelLending"/>
</s:form>
