<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="lbl.failureList"/></h3>
<s:form>
	<s:actionerror/>
	<%-- Liste von Säumnissen --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th></th>
			<th><s:text name="lbl.publication"/></th>
			<th><s:text name="lbl.rentDate"/></th>
			<th><s:text name="lbl.returnDate"/></th>
			<th><s:text name="lbl.borrower"/></th>
			<th><s:text name="lbl.amountOfReminders"/></th>
		</tr>
		<s:iterator value="reminderList">
			<tr>
				<td><s:radio name="internalId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="publication"/></td>
				<td><s:property value="internalOd"/></td>
				<td><s:property value="rentDate"/></td>
				<td><s:property value="returnDate"/></td>
				<td><s:property value="borrower"/></td>
				<td><s:property value="amountOfReminders"/></td>
			</tr>
		</s:iterator>
	</table>
	
</s:form>