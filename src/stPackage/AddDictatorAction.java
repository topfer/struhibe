package stPackage;

import java.util.Map;
import java.util.Hashtable;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AddDictatorAction extends Action {

    private static Logger logger = Logger.getLogger("sttest");

    public AddDictatorAction() {
	logger.debug(getClass().getName() + "::AddDictatorAction()");
    }

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
	try {
	    logger.debug(getClass().getName() + "::execute()");

	    //DictatorBean oneDict = (DictatorBean) form;
	    DynaActionForm oneDict = (DynaActionForm) form;

	    Map tempMap = new Hashtable();

	    tempMap.put("firstName", (String)oneDict.get("firstName"));
	    tempMap.put("lastName", (String)oneDict.get("lastName"));
	    tempMap.put("birthDate", (String)oneDict.get("birthDate"));
	    tempMap.put("id", (String)oneDict.get("id"));

	    SQLUtil.executeUpdate( request.getSession().getServletContext().getRealPath("/misc") + "/insertdict.sql", tempMap);

	    return mapping.findForward("success");
	}
	catch (Exception e) {
	    logger.error(getClass().getName() + "::execute:" + e.getMessage());	    
	    return mapping.findForward("failure");
	} 
    } 
}

