<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.lendingManagement"/></h3>

<s:form>

<display:table id="lendingTable" name="lendingList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lendingId"
				value="${lendingTable.lendingId}" />
		</display:column>
		<display:column titleKey="lending.publication" property="publication.title" sortable="true"/>
		<display:column titleKey="lending.outgoDate" property="outgoDate" sortable="true"/>
		<display:column titleKey="lending.lender" property="lender.matriculationNumber" sortable="true"/>
		<display:column titleKey="lending.expectedReturnDate" property="expectedReturnDate" sortable="true"/>
		<display:column titleKey="lending.numberOfLendingExtensions" property="numberOfLendingExtensions" sortable="true"/>
	</display:table>
<s:submit key="btn.lost" action="FinishLendingByDelete"/>
</s:form>
