package aaa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TagHello extends BodyTagSupport{
    String name="";
    String body;
    @Override
    public int doStartTag(){
            
        return EVAL_BODY_BUFFERED;
    }
    @Override
    public int doAfterBody(){
       BodyContent bc = getBodyContent();
       if(bc==null){ return SKIP_BODY; }
       body = bc.getString();
       return SKIP_BODY;
       
       
    }

    @Override
    public int doEndTag(){
     JspWriter out = pageContext.getOut();
        try {
            out.print(body);
        } catch (IOException ex) {
            Logger.getLogger(TagHello.class.getName()).log(Level.SEVERE, null, ex);
        }

        return EVAL_PAGE;
    }
    public void setName(String value){
        this.name=value;
    }
    
}
