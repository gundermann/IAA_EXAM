<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.masterDataManagement.publisher"/></h3>
<s:form>

	<s:actionerror/>
	<%-- List of publisher --%>
	<display:table id="publisherTable" name="publisherList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list" value="Keine Verlage vorhanden" />
		<display:column>
			<input type="radio" name="publisherId" value="${publisherTable.publisherId}" />
		</display:column>
		<display:column title="Bezeichnung" property="publisherName" sortable="true"/>
	</display:table>
	
	<%-- The buttons --%>
	<s:submit key="btn.add" action="AddPublisher" align="left"/>
	<s:submit key="btn.delete" action="DeletePublisher" align="left"/>
	<s:submit key="btn.edit" action="EditPublisher" align="left"/>
</s:form>