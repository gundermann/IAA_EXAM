<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="lbl.keywordList"/></h3>
<s:form>
	<s:actionerror/>
	<%-- Liste von Schlüsselwörtern --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th></th>
			<th><s:text name="btn.keywords"/></th>
		</tr>
		<s:iterator value="keywordList">
			<tr>
				<td><s:radio name="keywordId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="keyword"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<s:submit key="btn.add" action="AddKeyword"/>
	<s:submit key="btn.delete" action="DeleteKeyword"/>
	<s:submit key="btn.edit" action="EditKeyword"/>
</s:form>