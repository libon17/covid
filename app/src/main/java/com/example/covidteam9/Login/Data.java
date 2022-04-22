package com.example.covidteam9.Login;

import com.google.gson.annotations.SerializedName;

public class Data{

    @SerializedName("remember_exp")
    private Object rememberExp;

    @SerializedName("company_id")
    private String companyId;

    @SerializedName("last_login")
    private String lastLogin;

    @SerializedName("date_created")
    private String dateCreated;

    @SerializedName("oauth_uid")
    private Object oauthUid;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("ip_address")
    private String ipAddress;

    @SerializedName("forgot_exp")
    private Object forgotExp;

    @SerializedName("remember_time")
    private Object rememberTime;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("last_activity")
    private Object lastActivity;

    @SerializedName("top_secret")
    private Object topSecret;

    @SerializedName("oauth_provider")
    private Object oauthProvider;

    @SerializedName("id")
    private String id;

    @SerializedName("banned")
    private String banned;

    @SerializedName("verification_code")
    private Object verificationCode;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    public void setRememberExp(Object rememberExp){
        this.rememberExp = rememberExp;
    }

    public Object getRememberExp(){
        return rememberExp;
    }

    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getCompanyId(){
        return companyId;
    }

    public void setLastLogin(String lastLogin){
        this.lastLogin = lastLogin;
    }

    public String getLastLogin(){
        return lastLogin;
    }

    public void setDateCreated(String dateCreated){
        this.dateCreated = dateCreated;
    }

    public String getDateCreated(){
        return dateCreated;
    }

    public void setOauthUid(Object oauthUid){
        this.oauthUid = oauthUid;
    }

    public Object getOauthUid(){
        return oauthUid;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAvatar(){
        return avatar;
    }

    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public String getIpAddress(){
        return ipAddress;
    }

    public void setForgotExp(Object forgotExp){
        this.forgotExp = forgotExp;
    }

    public Object getForgotExp(){
        return forgotExp;
    }

    public void setRememberTime(Object rememberTime){
        this.rememberTime = rememberTime;
    }

    public Object getRememberTime(){
        return rememberTime;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getFullName(){
        return fullName;
    }

    public void setLastActivity(Object lastActivity){
        this.lastActivity = lastActivity;
    }

    public Object getLastActivity(){
        return lastActivity;
    }

    public void setTopSecret(Object topSecret){
        this.topSecret = topSecret;
    }

    public Object getTopSecret(){
        return topSecret;
    }

    public void setOauthProvider(Object oauthProvider){
        this.oauthProvider = oauthProvider;
    }

    public Object getOauthProvider(){
        return oauthProvider;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setBanned(String banned){
        this.banned = banned;
    }

    public String getBanned(){
        return banned;
    }

    public void setVerificationCode(Object verificationCode){
        this.verificationCode = verificationCode;
    }

    public Object getVerificationCode(){
        return verificationCode;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    @Override
     public String toString(){
        return 
            "Data{" + 
            "remember_exp = '" + rememberExp + '\'' + 
            ",company_id = '" + companyId + '\'' + 
            ",last_login = '" + lastLogin + '\'' + 
            ",date_created = '" + dateCreated + '\'' + 
            ",oauth_uid = '" + oauthUid + '\'' + 
            ",avatar = '" + avatar + '\'' + 
            ",ip_address = '" + ipAddress + '\'' + 
            ",forgot_exp = '" + forgotExp + '\'' + 
            ",remember_time = '" + rememberTime + '\'' + 
            ",full_name = '" + fullName + '\'' + 
            ",last_activity = '" + lastActivity + '\'' + 
            ",top_secret = '" + topSecret + '\'' + 
            ",oauth_provider = '" + oauthProvider + '\'' + 
            ",id = '" + id + '\'' + 
            ",banned = '" + banned + '\'' + 
            ",verification_code = '" + verificationCode + '\'' + 
            ",email = '" + email + '\'' + 
            ",username = '" + username + '\'' + 
            "}";
        }
}