<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3>
	<s:text name="txt.admonitionManagement" />
</h3>
<s:form>
	<s:actionerror />
	<display:table id="lendingTable" name="delayedLendingList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list"
			value="Keine überzogenenen Ausleihvorgänge vorhanden" />
		<display:column>
			<input type="radio" name="lendingId"
				value="${lendingTable.lendingId}" />
		</display:column>
		<display:column title="Publikation" property="publication.title"
			sortable="true" />
		<display:column title="Verleihdatum" property="outgoDate"
			sortable="true" format="{0,date,dd.MM.yyyy}" />
		<display:column title="Ausleiher - Mat-Nr"
			property="lender.matriculationNumber" sortable="true" />
		<display:column title="Rückgabedatum" property="expectedReturnDate"
			sortable="true" format="{0,date,dd.MM.yyyy}" />
		<display:column title="Anzahl Verlängerungn"
			property="numberOfLendingExtensions" sortable="true" />
		<display:column title="Status Mahnvorgang" sortable="true"
			value="${ lendingTable.admonitionProcess == null ? 'Nicht erstellt' : 'Erstellt' }" />
		<display:column title="Anzahl der Mahnungen"
			value="${lendingTable.admonitionProcess.admonitions != null ? lendingTable.admonitionProcess.admonitions.size() : 0}"
			sortable="true" />
	</display:table>


	<s:submit key="btn.lost" action="FinishLendingByLost" align="left" />
	<s:submit key="btn.addAdmonitionProcess" align="left" action="AddAdmonitionProcess"/>
	<s:submit key="btn.addAdmonition" action="AddAdmonition" align="left" />
</s:form>