### java基础知识

* HashMap
    
``````
1.每次新建一个HashMap时，都会初始化一个table数组。table数组的元素为Entry
节点,解决hash冲突用链表HashMap其实就是一个Entry数组，Entry对象中包含了键
和值，其中next也是一个Entry对象，它就是用来处理hash冲突的，形成一个链表。

注:重写了equals和hashcode方法

1.put方法：
    若key不为空，则先计算key的hash值，然后根据hash值搜索在table数组中的
    索引位置，如果table数组在该位置处有元素，则通过比较是否存在相同的key
    若存在则覆盖原来key的value，否则将该元素保存在链头（HashMap中没
    有两个相同的key）
    
    HashMap的每个“桶”只存储一个元素（一个entry），由于entry对象可以包
    含一个引用变量用于指向下个entry
   get方法：
    若
``````


* Object 对象

```
equals方法：
public boolean equals(Object obj) {
        return (this == obj);
    }
Object对象中直接调用==，比较对象地址。
String类中equals方法 先比较地址，如果是同一个对象的引用，可知对象相等，
返回true，若不是同一个对象则比较字符是否相等

hashcode()方法:Object中的hashCode()返回对象的32位jvm内存地址
        用处:hashcode方法只有在集合中用到

```

* ArrayList

```

```

* java内存模型

```
堆:
栈:
常量池:
```