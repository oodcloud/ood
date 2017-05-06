package cn.oddcloud.www.Spider.PageProcessor.Interface;

import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by vog1g on 2017/4/30.
 */
public interface SpiderWebEntendUrlRuleInterface<T>{
    PageProcessor setExtendUrlRule(T t);
}
