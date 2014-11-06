<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.lendingManagement"/></h3>

<s:form>
<s:actionerror/>
<display:table id="lendingTable" name="lendingList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lendingId"
				value="${lendingTable.lendingId}" />
		</display:column>
		<display:column title="Publikation" property="publication.title" sortable="true"/>
		<display:column title="Herausgabedatum" property="outgoDate" sortable="true" format="{0,date,dd.MM.yyyy}"/>
		<display:column title="Ausleiher - Mat.NR." property="lender.matriculationNumber" sortable="true"/>
		<display:column title="Rückgabedatum" property="expectedReturnDate" sortable="true" format="{0,date,dd.MM.yyyy}"/>
		<display:column title="Anzahl der Verlängerungen" property="numberOfLendingExtensions" sortable="true"/>
	</display:table>
<s:submit key="btn.add" action="AddLending" align="left"/>
<s:submit key="btn.finish" action="FinishLendingByReturn" align="left"/>
<s:submit key="btn.extend" action="ExtendLending" align="left"/>
</s:form>
