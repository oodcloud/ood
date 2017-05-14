package cn.oddcloud.www.Utils;

/**
 * Created by vog1g on 2017/5/13.
 */
public enum VideoDataLoadType {
    CommonQuery("common"),DynamicQuery("dynamic");

    private VideoDataLoadType(String type){
        this.type=type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
