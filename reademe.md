


参考资料
    https://www.cnblogs.com/mr-yang-localhost/p/7812038.html

步骤：
1、请求参数校验
    1.1校验bean的方式
        如demo里示例的，验证请求参数时，在@RequestBody DemoModel demo之间加注解 @Valid，然后后面加BindindResult即可；
        多个参数的，可以加多个@Valid和BindingResult
        如：
        public void test()(@RequestBody @Valid DemoModel demo, BindingResult result)
        public void test()(@RequestBody @Valid DemoModel demo, BindingResult result,@RequestBody @Valid DemoModel demo2, BindingResult result2)
    1.2 get请求参数校验
        1.2.1使用校验bean的方式，没有办法校验RequestParam的内容，一般在处理Get请求(或参数比较少)的时候，会使用下面这样的代码：
            @RequestMapping(value = "/demo3", method = RequestMethod.GET)
            public void demo3(@RequestParam(name = "grade", required = true) int grade,@RequestParam(name = "classroom", required = true) int classroom) {
                System.out.println(grade + "," + classroom);
            }
        1.2.2使用@Validated
            （1）Controller上加注解@Validated(不要加在方法上，否则不起作用)
            （2）验证不通过时，抛出了ConstraintViolationException异常，使用同一捕获异常处理
三、hibernate的校验模式
细心的读者肯定发现了：上面例子中一次性返回了所有验证不通过的集合，通常按顺序验证到第一个字段不符合验证要求时，就可以直接拒绝请求了。
Hibernate Validator有以下两种验证模式：
1、普通模式（默认是这个模式）
　　普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
2、快速失败返回模式
　　快速失败返回模式(只要有一个验证失败，则返回)


备注：
    1.spring-boot-starter-web包里面有hibernate-validator包，不需要引用hibernate validator依赖。