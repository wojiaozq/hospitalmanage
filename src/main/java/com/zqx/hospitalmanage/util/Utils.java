package com.zqx.hospitalmanage.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @version 1.0
 * @program: hospitalmanage.Utils
 * @description:
 * @author:
 * @create: 2019-03-19 15:19:17
 **/
public class Utils {
    //私有构造函数
    private Utils(){}

    /**
     * @author
     * @date 2019-03-19 15:21
     * @param null
     * @return String，uuid，主要用于当主键
     * @throws
     * @since 1.0
     * @description: uuid，用于主键生成策略
     */
    public static String getUUID(){
        return UUID.randomUUID().
                toString().
                replace("-","").
                intern();
    }

    /**
     * @author
     * @date 2019-03-19 18:08
     * @param num=总数量，size=每页数量
     * @return 总页数
     * @throws
     * @since 1.0
     * @description:  分页，公式如下
     * page.getNum()/(page.getSize()+0.0)==0?page.getNum()/page.getSize():page.getNum()/page.getSize()+1
     */
    public static int pageTotal(int num,int size){
        return num/(size+0.0)==0?num/size:num/size+1;
    }


    public static Date stringParseDate(String str) throws ParseException {
        String s = "yyyy-MM-dd";
        if(str.contains(".")){
            s = "yyyy.MM.dd";
        }
        if(str.contains("/")){
            s = "yyyy/MM/dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(s);
        return sdf.parse(str);
    }
    /**
     * @author
     * @date 2019-03-21 14:49
     * @param
     * @return
     * @throws
     * @since 1.0
     * @description: 字符串是否为空，为空返回true，不是返回false
     */
    public static boolean stringIsNull(String s){
        if(s==null || "".equals(s)){
            return true;
        }else{
            return false;
        }
    }


}
