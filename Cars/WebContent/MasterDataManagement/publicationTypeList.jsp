<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.masterDataManagement.publicationTypes"/>
</h3>
<s:form>

	<s:actionerror/>
	<%-- List of publication types --%>
	<display:table id="publicationTypeTable" name="publicationTypeList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list" value="Keine Publikationsarten vorhanden" />
		<display:column>
			<input type="radio" name="publicationTypeId" value="${publicationTypeTable.publicationTypeId}" />
		</display:column>
		<display:column title="Publikationart" property="name" sortable="true"/>
	</display:table>
	
	<%-- The buttons --%>
	<s:submit align="left" key="btn.add" action="AddPublicationType"/>
	<s:submit align="left" key="btn.delete" action="DeletePublicationType"/>
	<s:submit align="left" key="btn.edit" action="EditPublicationType"/>
</s:form>