package dto;

import java.io.InputStream;

public class userinfodto 
{
    String uname,ubranch,usem,ugen,uphone,umail,upass,ucpass;
    InputStream inputStream = null;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

   
    public String getUbranch() {
        return ubranch;
    }

    public void setUbranch(String ubranch) {
        this.ubranch = ubranch;
    }

    public String getUsem() {
        return usem;
    }

    public void setUsem(String usem) {
        this.usem = usem;
    }

    public String getUgen() {
        return ugen;
    }

    public void setUgen(String ugen) {
        this.ugen = ugen;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUcpass() {
        return ucpass;
    }

    public void setUcpass(String ucpass) {
        this.ucpass = ucpass;
    }
}
