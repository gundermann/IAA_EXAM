<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<h3>
	<s:text name="txt.masterDataManagement" />
</h3>
<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.publicationType" action="ShowPublicationTypeList"
		align="left" />
	<s:submit key="btn.keywords" action="ShowKeywordList" align="left" />
	<s:submit key="btn.lender" action="ShowLenderList" align="left" />
	<s:submit key="btn.author" action="ShowAuthorList" align="left" />
	<s:submit key="btn.publisher" action="ShowPublisherList" align="left" />
</s:form>