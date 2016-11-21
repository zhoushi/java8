package com.java8.util;

/**
 * Created by Administrator on 2016/11/21.
 */

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * json工具类
 */
public class JsonUtils {

    /**
     * 通过反射实现bean转json
     */
    public static String toJsonString(Object obj)throws InstantiationException,IllegalAccessException{

        //如果传入的对象为集合
        if (obj instanceof Collection){
            return colectionTojson(obj);
        }
        //如果获取的对象类型学为一个Map集合
        else if (obj instanceof Map){

        }
        //普通的对象
        else {

        }
        return null;

    }

    private static String colectionTojson(Object obj)throws IllegalAccessException {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");

        //得到class
        Class<? extends Object> clazz = obj.getClass();

        //得到该类的所有字段
        Field[] declaredFields = clazz.getDeclaredFields();

        //设置可以获得私有字段的value
        Field.setAccessible(declaredFields,true);

        //定义全局变量
        boolean listf = false;
        boolean setf = false;
        Set<Object> set = null;
        List<Object> list = null;

        //遍历获取到的所有字段
        for (Field field : declaredFields){
            String simpleName = clazz.getSimpleName();

            //判断获取到的类型
            if(simpleName.equals("ArrayList")||simpleName.equals("LinkedList")){
                list = (List<Object>) obj;
                listf=true;
            }
            if(simpleName.equals("HashSet")||simpleName.equals("TreeSet")){
                set = (Set<Object>) obj;
                setf=true;
            }

        }

        //java8
//        Arrays.stream(declaredFields).map(String::getSimpleName())

        //如果获取的对象类型为一个List集合
        if(listf == true){

            return listTojson(buffer, list).toString();

        }

        //如果获取的对象类型为一个Set集合
        if(setf == true){

            buffer = setTojson(set, buffer);

        }

        buffer.append("]");

        return buffer.toString();

    }

    //将list数组转换为StringBuffer
    private static StringBuffer listTojson(StringBuffer buffer, List<Object> list)throws IllegalAccessException{

        //遍历list<T> 拿到T
        for (Object obj:list) {
            if (obj == null){
                buffer.append(",");
            }else {
                Class<? extends Object> class1 = obj.getClass();
                String simpleName = class1.getSimpleName();

                if(simpleName.equals("String")){

                    buffer.append("\""+obj.toString()+"\",");
                }
                else if(simpleName.equals("Boolean")||simpleName.equals("Integer")||simpleName.equals("Double")||simpleName.equals("Float")||simpleName.equals("Long")){

                    buffer.append(""+obj.toString()+",");
                }
                else if(simpleName.equals("Date")){
                    Date date = (Date) obj;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String simdate = simpleDateFormat.format(date);
                    buffer.append(""+simdate+",");
                }
                else {
                    Class<? extends Object> class2 = obj.getClass();
                    //得到该类的所有字段
                    Field[] fields = class2.getDeclaredFields();
                    Field.setAccessible(fields,true);
                    buffer.append("{");

                    //遍历list里面的对象将所有字段拼成json字符串
                    for (Field field : fields){

                        //得到 对象里面的属性
                        Object fieldobj = field.get(obj);
                        String fieldName = field.getType().getSimpleName();
                        if (fieldobj == null){
                            //
                            if (fieldobj.equals("String")){
                                buffer.append("\""+field.getName()+"\":\"\",");
                            }else{
                                buffer.append("\""+field.getName()+"\":null,");
                            }
                        }
                        else {
                            String fsimpleName = fieldobj.getClass().getSimpleName();

                            if(fsimpleName.equals("String")){

                                buffer.append("\""+field.getName()+"\":\""+field.get(obj)+"\",");
                            }
                            else if(fsimpleName.equals("Boolean")||fsimpleName.equals("Integer")||fsimpleName.equals("Double")||fsimpleName.equals("Float")||fsimpleName.equals("Long")){

                                buffer.append("\""+field.getName()+"\":"+field.get(obj)+",");
                            }
                            else if(fsimpleName.equals("Date")){

                                Date date = (Date) obj;
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                String simdate = simpleDateFormat.format(date);
                                buffer.append("\""+field.getName()+"\":"+simdate+",");
                            }
                            else{

                                buffer = beanTojson(fieldobj, buffer).append(",");
                            }
                        }


                    }
                    buffer =  new StringBuffer(""+buffer.substring(0,buffer.length()-1)+"");
                    buffer.append("},");

                }
            }
        }
        buffer =  new StringBuffer(""+buffer.substring(0,buffer.length()-1)+"");
        buffer.append("]");
        return buffer;
    }

    private static StringBuffer beanTojson(Object obj, StringBuffer buffer)throws IllegalAccessException {
        Class<? extends Object> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field.setAccessible(declaredFields, true);

        buffer.append("\""+clazz.getSimpleName()+"\":{");

        for (Field field : declaredFields) {

            Object object = field.get(obj);
            String fieldName = field.getType().getSimpleName();

            if(object == null){
                if(fieldName.equals("String"))
                {
                    buffer.append("\""+field.getName()+"\":\"\",");
                }

                else{
                    buffer.append("\""+field.getName()+"\":null,");
                }

            }
            else{

                Class<? extends Object> fieldclass = object.getClass();
                String simpleName = fieldclass.getSimpleName();

                if(simpleName.equals("String")){

                    buffer.append("\""+field.getName()+"\":\""+field.get(obj)+"\",");
                }
                else if(simpleName.equals("Boolean")||simpleName.equals("Integer")||simpleName.equals("Double")||simpleName.equals("Float")||simpleName.equals("Long")){

                    buffer.append("\""+field.getName()+"\":"+field.get(obj)+",");
                }
                else if(simpleName.equals("Date")){

                    Date date = (Date) object;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String simdate = simpleDateFormat.format(date);
                    buffer.append("\""+field.getName()+"\":\""+simdate+"\",");
                }
                else if(simpleName.equals("ArrayList")||simpleName.equals("LinkedList")){

                    List<Object> list = (List<Object>) object;

                    buffer = listTojson(buffer, list);

                }
                else if(simpleName.equals("HashSet")||simpleName.equals("TreeSet")){

                    Set<Object> set = (Set<Object>) object;
                    buffer = setTojson(set, buffer);
                }
                else if(simpleName.equals("HashMap")||simpleName.equals("HashTable")){

                    buffer.append("\""+field.getName()+"\":");
                    StringBuffer mapbuffer = new StringBuffer(mapTojson(object));
                    mapbuffer.deleteCharAt(0);
                    buffer.append(mapbuffer);
                }
                else{
                    buffer = beanTojson(object,buffer).append("}");
                }
            }

        }

        buffer =  new StringBuffer(""+buffer.substring(0,buffer.length()-1)+"");
        buffer.append("}");

        return buffer;
    }

    private static StringBuffer mapTojson(Object object) {
        return null;
    }

    private static StringBuffer setTojson(Set<Object> set, StringBuffer buffer) {
        return null;
    }




}
