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
	
	<!-- 
	<%-- Liste von Säumnissen --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th></th>
			<th><s:text name="lbl.publicationId"/></th>
			<th><s:text name="lbl.outgoDate"/></th>
			<th><s:text name="lbl.returnDate"/></th>
			<th><s:text name="lbl.lender"/></th>
			<th><s:text name="lbl.amountOfReminders"/></th>
		</tr>
		<s:iterator value="failureList">
			<tr>
				<td><s:radio name="internalId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="publicationId"/></td>
				<td><s:property value="internalOd"/></td>
				<td><s:property value="rentDate"/></td>
				<td><s:property value="returnDate"/></td>
				<td><s:property value="borrower"/></td>
				<td><s:property value="amountOfReminders"/></td>
			</tr>
		</s:iterator>
	</table>
	 -->
	
</s:form>