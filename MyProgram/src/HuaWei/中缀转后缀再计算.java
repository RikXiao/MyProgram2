package HuaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 中缀转后缀再计算 {

	/**
	 * @param args
	 */
	//需要定义一个优先级
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input = in.nextLine();
			Stack<Character> stack = new Stack<>();
			Map<Character, Integer> prior = new HashMap<Character, Integer>();			
			prior.put('+', 1);
			prior.put('-', 1);
			prior.put('*', 2);
			prior.put('/', 2);
			String lastsString = getLastString(stack, input, prior);
			System.out.println(lastsString);
			System.out.println(calculate(lastsString));
			
		}
       in.close();
	}
	//中缀表达式转换成后缀表达式
	public static String getLastString(Stack<Character> stack,String input,Map<Character, Integer> prior){
		char[] arr = input.toCharArray();
		StringBuilder result = new StringBuilder();
		String tmp = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>='0'&&arr[i]<='9') {
				tmp+=arr[i];
			}else {
				result.append(tmp+" ");   //中间连续的操作出列入1*(8-2),\会插入两个空格
				tmp="";
				if(stack.isEmpty()){
					stack.push(arr[i]);
				}else {
					if (arr[i]=='('||arr[i]=='['||arr[i]=='{') {//如果是左括号，就直接压入栈内
						stack.push(arr[i]);
					}
					else if (arr[i]==')'||arr[i]==']'||arr[i]=='}') {  //如果是右括号，输出栈顶操作符，知道等于相应的左括号
						while(true){//输出操作符，知道遇见对应的左括号
							char fuhao = stack.pop();
							if (fuhao=='('||fuhao=='['||fuhao=='{') {
								break;
							}else {
								result.append(fuhao+" ");
							}
						}
					}
					else {  //如果是其他普通操作符,负号和减号的判断
					/*	if ((arr[i-1]<'0'||arr[i-1]>'9')&&arr[i]=='-') {//判断这个符号是否为负号，若为负号则在前面加一个操作数0；
							result.append(0+" ");牛客网不考虑负号可以过
						}*/
						Integer nowPri = prior.get(arr[i]);
						Integer peekPri = prior.get(stack.peek());
						while(peekPri!=null&&peekPri>=nowPri){//栈顶的操作符优先级高于当前操作符，并且不是左括号
							result.append(stack.pop()+" ");
							//输出栈顶操作符
							if (stack.isEmpty()) {//输出完后，判读栈里面是否还有元素
								break;
							}else {
								peekPri = prior.get(stack.peek());
							}							
						}
						stack.push(arr[i]);
					}
				}
			}
		}
		//输出最后一个数
		result.append(tmp+" ");
		// 最后记得输出栈内剩余操作符
		while(!stack.isEmpty()){
			result.append(stack.pop()+" ");
		}
		return result.toString();
	}

	//后缀表达式求值
	public static int calculate(String lastString){
		lastString = lastString.trim();
		String[] input = lastString.split("\\s+");
		
		Stack<Integer> data = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			String tmp = input[i];
			if (isData(tmp)) {
				data.push(Integer.valueOf(tmp));
			}else {
				Integer later = data.pop();
				Integer front = data.pop();
				if (tmp.equals("+")) {
					data.push(front+later);
				}else if (tmp.equals("-")) {
					data.push(front-later);
				}else if (tmp.equals("*")) {
					data.push(front*later);
				}else if (tmp.equals("/")) {//严格来说除需要判读除数是否合法
					data.push(front/later);
				}
			}
		}
		return data.pop();
	}
	public static boolean isData(String data){
		if (data.equals("+")||data.equals("-")||data.equals("*")||data.equals("/")) {
			return false;
		}else {
			return true;
		}
		
	}
}
