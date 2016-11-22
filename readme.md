### java8 in action

* lambda表达式

```
  定义:Lambda表达式理解为简洁地表示可传递的匿名函数的一种方式

  三种表达方式: 1: (parameters) -> expression
               2: (parameters) -> {statements;}
               3: () -> expression
               4：Object::method

  怎么使用Lambda表达式: lambda表达式的使用需要借助函数式接口。

  使用Lambda付诸实践: 1:行为参数化

                     2:使用函数式接口来传递行为

                     3:执行一个行为

                     4：传递Lambda

  类型检查、类型推断：


  复合Lambda表达式的用法

```

 * Optional

 ```
  问题:
    1 : null引用引发的问题，以及为什么要避免null引用
    2 : 从null到Optional:以null安全的方式重写你的域模型
    3 ：读取Optional中可能值得几种方法

  解决:1: 第一种采用防御式检查减少NullPointerException：每次引用一个变量都会做一次null检查
       2: 用Optional重写你的域模型：变量Optional类只是对类简单封装
          如果变量不存在缺失的值会被建模成一个空的Optional对象Optional<Object>
       3: 使用map从Optional对象中提取和转换值 map 对值进行转换
          使用flatMap链接Optional对象  flatMap会用流的内容替换每个新生成的流

       4: 两个Optional对象的组合

 ```

  * CompletableFuture:构建异步应用

  ```
  问题：1 ：同步API与异步API的区别
        2 :最佳价格查询器： {
          1：如何为你的客户提供异步API
          2：如何让你使用了同步API的代码变为非阻塞代码
          3：如何以响应式的方式处理异步操作的完成事件
        }

  解决：1：同步API与异步API
        同步API:你调用了某个方法，调用方在被调用方运行的过程中会等待，被调用方运行
        结束返回。
        异步API：在被调用方计算完成之前，将它剩余的计算任务交给另一个线程去做，
        将线程和调用方式异步的。执行剩余计算任务的线程会将它的计算结果返回给调用方，
        返回的方式要么是通过回调函数，要么是由调用方再次执行一个“等待”，直到计算完成

        2： 1 ：为客户提供异步API：
  ```
  
  * 高阶函数
  
  ```
   定义：1:接受至少一个函数作为参数
         2:返回的结果是一个函数
         
   科里化：是一种将具备2个参数(比如，x和y)的函数f转化为使用一个参数的函数
   g，并且这个函数的返回值也是一个函数，它会作为新函数的一个参数
   
   持久化数据结构：
         
  ```
  
  * 模式匹配
  
  ```
  
  ```
  
  * stream新增
  
 ```
 com.java8.stream.stream增加第五章和第六章的代码，流的操作，用流收集数据
 ```
