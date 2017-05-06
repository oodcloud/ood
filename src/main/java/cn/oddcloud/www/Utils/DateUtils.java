package cn.oddcloud.www.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vog1g on 2017/4/30.
 */
public class DateUtils {

    public static String dateToString(long time){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");

        String d = format.format(time);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
    /*
    * 将时间转换为时间戳
    */
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /*
    * 将时间戳转换为时间
    */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * 系统时间转时间戳
     */
    public static Integer systemTimeToStamp()
    {
       Date date=new Date(System.currentTimeMillis());

       Long longtime=new Long(date.getTime()/1000);

       return  longtime.intValue();
    }




}
