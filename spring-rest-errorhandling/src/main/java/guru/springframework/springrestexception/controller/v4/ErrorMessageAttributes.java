package guru.springframework.springrestexception.controller.v4;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class ErrorMessageAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    Map<String, Object> reqAttrs = super.getErrorAttributes(webRequest, includeStackTrace);
    Map<String, Object> errMsgAttrs = new LinkedHashMap<>();
    errMsgAttrs.put("status", reqAttrs.get("status"));
    errMsgAttrs.put("reason", reqAttrs.get("message"));
    errMsgAttrs.put("timestamp",
        LocalDateTime.ofInstant(((Date) reqAttrs.get("timestamp")).toInstant(), ZoneId.of("UTC")));

    return errMsgAttrs;
  }
}
