<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.admonitionManagement"/></h3>
<s:form>
	<s:actionerror/>
	<s:text name="txt.delayedLendings"/>
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
	
	<s:submit key="btn.delete" action="DeleteLending" align="left"/>
	
	<s:text name="txt.admonitionProcesses"/>
	<%-- list of admonition processes--%>
	<display:table id="admonitionProcessTable" name="admonitionProcessList" pagesize="5"
		cellpadding="5px;" cellspacing="5px;" 
		style="margin-left:50px;margin-top:20px;" requestURI="#">
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:column>
			<input type="radio" name="admonitionProcessId" value="${admonitionProcessTable.admonitionProcessId}" />
		</display:column>
		<display:column titleKey="lending.publication" property="lending.publication.title" sortable="true"/>
		<display:column titleKey="lending.expectedReturnDate" property="lending.expectedReturnDate" sortable="true"/>
		<display:column titleKey="admonitionProcess.admonitions" value="${admonitions.size()==null ? 0 : admonitons.size()}"/>
	</display:table>
	
	
	<s:submit key="btn.finish" action="FinishAdmonitionProcess" align="left"/>
	<s:submit key="btn.addAdmonition" action="AddAdmonition" align="left"/>
</s:form>