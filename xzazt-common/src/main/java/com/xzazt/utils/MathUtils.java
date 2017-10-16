package com.xzazt.utils;

import com.xzazt.exception.MathException;

import java.math.BigDecimal;

/**
 * float和double只能用来做科学计算或者是工程计算，在商业计算中我们要用java.math.BigDecimal。
 * 我们如果需要精确计算，非要用String来够造BigDecimal不可！
 * (1)商业计算使用BigDecimal。(
 * (2)尽量使用参数类型为String的构造函数。
 * (3) BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
 * (4)我们往往容易忽略JDK底层的一些实现细节，导致出现错误，需要多加注意。
 * @author xzazt
 */

/*
 BigDecimal的setScale方法
 BigDecimal.setScale()
 方法用于格式化小数点
 表示保留一位小数，默认用四舍五入方式
 setScale(1)
 直接删除多余的小数位，如2.35会变成2.3 setScale(1,BigDecimal.ROUND_DOWN)
 进位处理，2.35变成2.4  setScale(1,BigDecimal.ROUND_UP)
 四舍五入，2.35变成2.4  setScale(1,BigDecimal.ROUND_HALF_UP)
 四入五舍，2.35变成2.3，如果是5则向下舍setScaler(1,BigDecimal.ROUND_HALF_DOWN)

BigDecimal枚举常量用法摘要  ：
CEILING   向正无限大方向舍入的舍入模式。
DOWN      向零方向舍入的舍入模式。
FLOOR     向负无限大方向舍入的舍入模式。
HALF_DOWN 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向下舍入。
HALF_EVEN 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
HALF_UP   向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向上舍入。
UNNECESSARY 用于断言请求的操作具有精确结果的舍入模式，因此不需要舍入。
UP        远离零方向舍入的舍入模式。
 */
public class MathUtils {
    /**
     * 默认不能被实例化
     */
    private MathUtils(){}

    /**
     * 默认除法保留精度
     */
    private final static int DEFAULT_DIV_SCALE = 2;

    /**
     * 四舍五入保留sacle位小数
     * @param d
     * @param scale
     * @return
     */
    public static double round(double d,int scale){
        if(scale < 0){
            throw new MathException("This value must be integer or 0");
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        return bigDecimal.setScale(DEFAULT_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double add(double d1,double d2){
       return add(d1,d2,DEFAULT_DIV_SCALE);
    }

    public static double add(double d1,double d2,int scale){
        if(scale < 0){
            throw new MathException("This value must be integer or 0");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        double doubleValue = b1.add(b2).doubleValue();
        return round(doubleValue,scale);
    }

    public static double subtract(double d1,double d2){
        return subtract(d1,d2,DEFAULT_DIV_SCALE);
    }

    public static double subtract(double d1,double d2,int scale){
        if(scale < 0){
            throw new MathException("This value must be integer or 0");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        double doubleValue = b1.subtract(b2).doubleValue();
        return round(doubleValue,scale);
    }

    public static double multiply(double d1,double d2){
        return multiply(d1,d2,DEFAULT_DIV_SCALE);
    }

    public static double multiply(double d1,double d2,int scale){
        if(scale < 0){
            throw new MathException("This value must be integer or 0");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        double doubleValue = b1.multiply(b2).doubleValue();
        return round(doubleValue,scale);
    }

    public static double divide(double d1,double d2){
        return divide(d1,d2,DEFAULT_DIV_SCALE);
    }

    public static double divide(double d1,double d2,int scale){
        if(scale < 0){
            throw new MathException("This value must be integer or 0");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        double doubleValue = b1.divide(b2).doubleValue();
        return round(doubleValue,scale);
    }
}
