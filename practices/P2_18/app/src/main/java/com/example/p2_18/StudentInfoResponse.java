
package com.example.p2_18;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StudentInfoResponse {

    @SerializedName("result_code")
    @Expose
    private Integer resultCode;
    @SerializedName("message_type")
    @Expose
    private String messageType;
    @SerializedName("message_text")
    @Expose
    private String messageText;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StudentInfoResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("resultCode");
        sb.append('=');
        sb.append(((this.resultCode == null)?"<null>":this.resultCode));
        sb.append(',');
        sb.append("messageType");
        sb.append('=');
        sb.append(((this.messageType == null)?"<null>":this.messageType));
        sb.append(',');
        sb.append("messageText");
        sb.append('=');
        sb.append(((this.messageText == null)?"<null>":this.messageText));
        sb.append(',');
        sb.append("avatar");
        sb.append('=');
        sb.append(((this.avatar == null)?"<null>":this.avatar));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
