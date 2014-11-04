<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<s:form>
	<s:actionerror/>
	<%-- list of delayed lendings --%>
	<display:table id="lendingTable" name="lendingList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="lendingId" value="${lendingTable.lendingId}" />
		</display:column>
		<display:column titleKey="lending.publication" property="publication" sortable="true"/>
		<display:column titleKey="lending.outGoDate" property="outGoDate" sortable="true"/>
		<display:column titleKey="lending.expectedReturnDate" property="expectedReturnDate" sortable="true"/>
	</display:table>
	
	<s:submit key="btn.delete" action="DeleteLending"/>
	
	<%-- list of admonition processes--%>
	<display:table id="admonitionProcessTable" name="admonitionProcessList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="admonitionProcessId" value="${admonitionProcessTable.admonitionProcessId}" />
		</display:column>
		<display:column titleKey="lending.publication" property="admonitionProcess.lending.publication" sortable="true"/>
		<display:column titleKey="lending.outGoDate" property="admonitionProcess.lending.outGoDate" sortable="true"/>
	</display:table>
	
</s:form>