package HLD;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3[a]2[bc]";
		String res = new Solution().decodeString(s);
		System.out.println(res);
	}

}

class Solution {
	public String decodeString(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		Stack<String> vals = new Stack<String>();
		int curr = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				curr = curr * 10 + (ch - '0');
			} else {
				if (ch == '[') {
					nums.push(curr);
					curr = 0;
				}
				if (ch != ']')
					vals.push(String.valueOf(ch));
				else {
					String str = "";
					while (!vals.peek().equals("["))
						str = vals.pop() + str;
					vals.pop();
					int count = nums.pop();
					StringBuilder sb = new StringBuilder();
					while (count-- > 0)
						sb.append(str);
					vals.push(sb.toString());
				}
			}
			System.out.println(vals);
		}
		String res = "";
		while (!vals.isEmpty())
			res = vals.pop() + res;
		return res;
	}
}