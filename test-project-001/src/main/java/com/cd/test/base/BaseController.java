package com.cd.test.base;

import com.cd.test.utils.StringUtil;
import com.cd.test.utils.tls.tlssigature.TlsSignature;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.zip.DataFormatException;

@Log4j2
@Controller
public class BaseController {

/*
    @RequestMapping("/toPage{url}")
    public String dispatcher(HttpSession session, @PathVariable("url") String url) {
        return url;
    }*/

    @RequestMapping("/toPage")
    public String dispatcher(HttpSession session, @RequestParam("url") String url) {
        if (Objects.equals("tencentIM/chartroom", url) && StringUtil.isEmptyStr(String.valueOf(session.getAttribute("user_sig"))) &&
                !StringUtil.isEmptyStr(String.valueOf(session.getAttribute("user_account")))) {
            String userSignature = null;
            try {
                userSignature = TlsSignature.genTLSSigByUserIdentifier(String.valueOf(session.getAttribute("user_account")));
            } catch (IOException e) {

            } catch (DataFormatException e) {

            } catch (JSONException e) {

            }
            session.setAttribute("user_sig", userSignature);
        }
        return url;
    }

    /**
     * get param from request obj
     * @param request
     * @return
     */
    protected Map requestParameters(HttpServletRequest request) {
        Map params = new HashMap();
        for (Enumeration enu = request.getParameterNames(); enu.hasMoreElements(); ) {
            String key = enu.nextElement().toString();
            String val = request.getParameter(key);
            params.put(key, val);
        }
        log.info("request params: " + params);
        return params;
    }
}
    