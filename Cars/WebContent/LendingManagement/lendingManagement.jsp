<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<h3><s:text name="txt.lendingManagement"/></h3>

<s:form>
<s:submit key="btn.delayedLendings" action="ShowDelayedLendingList" align="left"/>
<s:submit key="btn.lendings" action="ShowLendingList" align="left"/>
</s:form>
