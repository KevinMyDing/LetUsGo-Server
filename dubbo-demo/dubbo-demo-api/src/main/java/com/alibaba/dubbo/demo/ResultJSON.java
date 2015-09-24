package com.alibaba.dubbo.demo;



import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Result JSON formatter
 * Created by HOME on 2015/9/25.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultJSON {

    /**
     * Result success
     */
    @JsonProperty("success")
    @XmlElement(name = "success")
    private boolean success = true;

    /**
     * Tips message
     */
    @JsonProperty("msg")
    @XmlElement(name = "msg")
    private String msg = "操作成功";

    /**
     * Result object
     */
    @JsonProperty("obj")
    @XmlElement(name = "obj")
    private Object obj = null;

    /**
     * Other attributes
     */
    @JsonProperty("attributes")
    @XmlElement(name = "attributes")
    private Map<String, Object> attributes;

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

//    public String getJsonStr() {
//        JSONObject obj = new JSONObject();
//        obj.put("success", this.isSuccess());
//        obj.put("msg", this.getMsg());
//        obj.put("obj", this.obj);
//        obj.put("attributes", this.attributes);
//        return obj.toJSONString();
//    }

}