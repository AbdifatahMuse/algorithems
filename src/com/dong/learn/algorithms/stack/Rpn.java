package com.dong.learn.algorithms.stack;

import java.util.regex.Pattern;

/**
 * Created by coding-dong on 2017/10/21.
 * 逆波兰表达式
 */
public class Rpn {
    public static final String SEP_WHITESPACE = " ";

    public static final String NUM_PATTERN_STR = "[0-9]+[\\.]?[0-9]*";

    public static final Pattern PATTERN = Pattern.compile(NUM_PATTERN_STR);

    public String transfer(String sourceStr){
        if(sourceStr == null || sourceStr.length() == 0){
            return null;
        }

        StringBuilder buffer = new StringBuilder();
        LinkedStack<String> operatorStack = new LinkedStack<>();

        char[] chars = sourceStr.toCharArray();

        for(int i = 0; i < chars.length; i++){
            char charEle = chars[i];
            if(Character.isDigit(charEle)){
                buffer.append(charEle);
                if(i + 1 < chars.length && !Character.isDigit(chars[i + 1]) && chars[i + 1] != '.'){
                    buffer.append(SEP_WHITESPACE);
                }
            }else if(charEle == '.'){
                buffer.append(charEle);
            }else if(Character.isWhitespace(charEle)){
                continue;
            }else {
                //对于操作符，进行入栈
                if(charEle == '('){
                    operatorStack.push(charEle + "");
                }else if(charEle == ')') {
                    do{
                        String topEle = operatorStack.pop();
                        if("(".equals(topEle)){
                            break;
                        }else {
                            buffer.append(topEle).append(SEP_WHITESPACE);
                        }
                    }while (true);
                }else if(charEle == '*' || charEle == '/'){
                    do {
                        String topEle = operatorStack.peek();
                        if(topEle != null){
                            //判断栈顶操作符，如果是'*'，'/'，则要出战，按着从左到右的顺序
                            if("*".equals(topEle) || "/".equals(topEle)){
                                topEle = operatorStack.pop();
                                buffer.append(topEle).append(SEP_WHITESPACE);
                            }else {
                                operatorStack.push(charEle + "");
                                break;
                            }
                        }else {
                            operatorStack.push(charEle + "");
                            break;
                        }
                    }while (true);
                }else if(charEle == '+' || charEle == '-'){
                    do{
                        String topEle = operatorStack.peek();
                        if(topEle != null){
                            if(!"(".equals(topEle)){
                                topEle = operatorStack.pop();
                                buffer.append(topEle).append(SEP_WHITESPACE);
                            }else {
                                operatorStack.push(charEle + "");
                                break;
                            }
                        }else {
                            operatorStack.push(charEle + "");
                            break;
                        }
                    }while (true);
                }else {
                    System.out.println("special char : " + charEle);
                }
            }
        }

        //栈未空，则全部出战
        String temp = null;
        while ((temp = operatorStack.pop()) != null){
            buffer.append(SEP_WHITESPACE).append(temp);
        }

        return buffer.toString().trim();
    }

    public double calRpn(String rpnStr){
        if(rpnStr == null || rpnStr.trim().length() == 0){
            return 0d;
        }

        String[] strEleArray = rpnStr.trim().split(SEP_WHITESPACE);

        if(strEleArray == null || strEleArray.length == 0){
            return 0D;
        }

        LinkedStack<Double> numStack = new LinkedStack<>();

        for(String strEle : strEleArray){
            if(!strEle.equals(SEP_WHITESPACE)){
                if(isNum(strEle)){
                    //操作数入栈
                    numStack.push(Double.parseDouble(strEle));
                }else {
                    if("+".equals(strEle) || "-".equals(strEle) || "*".equals(strEle) || "/".equals(strEle)){
                        double d1 = numStack.pop();
                        double d2 = numStack.pop();


                        if("+".equals(strEle)){
                            numStack.push(d2 + d1);
                        }else if("-".equals(strEle)){
                            numStack.push(d2 - d1);
                        }else if("*".equals(strEle)){
                            numStack.push(d2 * d1);
                        }else if("/".equals(strEle)){
                            numStack.push(d2 / d1);
                        }
                    }
                }
            }else {
                System.out.println("it exist whitespace");
            }
        }

        return numStack.pop();
    }

    public static boolean isNum(String str){
        if(str == null || str.length() == 0){
            return false;
        }

        return PATTERN.matcher(str).matches();
    }

    public static void main(String[] args){
        Rpn rpn = new Rpn();
        String sourceStr = "1 + (2 - 3) * 4 - (3.5 + 6 / 3) * 15 + ( 8 - 7 ) * 9";
        String rpnStr = rpn.transfer(sourceStr);
        System.out.println(sourceStr);
        System.out.println("<==========================>");
        System.out.println(rpnStr);
        System.out.println("<==========================>");
        System.out.println("result : " + rpn.calRpn(rpnStr));
    }
}
