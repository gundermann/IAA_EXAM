<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<s:form>
	<s:text name="txt.masterDataManagement.publicationTypes"/>
	<s:submit align="left" key="btn.add" action="AddPublicationType"/>
	<s:submit align="left" key="btn.delete" action="DeletePublicationType"/>
	<s:submit align="left" key="btn.edit" action="EditPublicationType"/>

	<s:actionerror/>
	<%-- Liste von Publikationsarten --%>
	<display:table id="publicationTypeTable" name="publicationTypeList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="publicationTypeId" value="${publicationTypeTable.publicationTypeId}" />
		</display:column>
		<display:column titleKey="lbl.publicationType.name" property="name" sortable="true"/>
	</display:table>
	
</s:form>