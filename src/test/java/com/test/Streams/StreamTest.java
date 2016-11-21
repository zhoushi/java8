package com.test.Streams;

import com.java8.stream.stream.StreamApi;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2016/11/21.
 */
public class StreamTest {

    public final static StreamApi streamApi = new StreamApi();
    @Test
    public void BeanToName(){
        List<String> s =  streamApi.DishToName();
        s.stream().forEach(System.out::println);

        List<Integer> integerList = streamApi.wordsInteger();
        integerList.stream().forEach(System.out::println);
    }
    @Test
    public void  wordsSplitApi(){
        List<String[]> strings = streamApi.wordsSplit();

//        for (String[] s:strings){
//            for (int i=0;i<s.length;i++){
//                System.out.println(s[i]);
//            }
//        }
        strings.stream().map(strings1 -> strings1.length).forEach(System.out::println);
//        strings.stream().map(str->str.charAt(0)).forEach(System.out::println);
    }

    @Test
    public void wordsFlatMap(){
        List<String> strings = streamApi.flatMapStream();
        strings.stream().forEach(System.out::println);
    }

    @Test
    public void findFristTest(){
        Optional<Integer> optionals = streamApi.findFrist();

        optionals.toString();
        System.out.println(optionals.get());
    }
}
