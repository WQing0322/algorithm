package com.wqing.demo.pattern.proxy;	
public class $Proxy0 implements com.wqing.demo.pattern.proxy.MoveApi {	
   private com.wqing.demo.pattern.proxy.MoveApi inter;	
public $Proxy0(com.wqing.demo.pattern.proxy.MoveApi inter) {	
       super();	
      this.inter = inter;	
 }	
            @Override	
           public void move() {	
              System.out.println(" 我是时间代理类 ");	
             System.out.println(" 汽车行驶开始......");	
           long startTime = System.currentTimeMillis();	
           inter.move();	
          long endTime = System.currentTimeMillis();	
         System.out.println(" 汽车行驶结束，用时:"	
 + (endTime - startTime) + " 毫秒 ");	
     }	
}