package tcp.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arrA = parseInts(br.readLine().split(" "));
		int[] arrB = parseInts(br.readLine().split(" "));
		int m = arrA[0];
		int n = arrA[1];
		ListNode head = null;
		ListNode pre = null;
		for (int v : arrB) {
			ListNode listNode = new ListNode(v);
			if (head == null) {
				head = listNode;
			}
			if (pre != null) {
				pre.next = listNode;
			}
			pre = listNode;
		}
		solution(head, m, n);

	}

	private static void solution(ListNode head, int n, int m) {

		 if(m>=n||head == null){
	            return ;
	        }
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        head = dummy;
	        for(int i = 1;i<m;i++){
	            if(head == null){
	                return ;
	            }
	            head = head.next;
	        }
	        ListNode pmNode = head;
	        ListNode mNode = head.next;
	        ListNode nNode = mNode;
	        ListNode pnNode = mNode.next;
	        for(int i = m;i<n;i++){
	            if(pnNode == null){
	                return ;
	            }
	            ListNode tmp = pnNode.next;
	            pnNode.next = nNode;
	            nNode = pnNode;
	            pnNode = tmp;
	        }
	        pmNode.next = nNode;
	        mNode.next = pnNode;
	        
	        printNode(dummy.next);
	}
	
 
	//打印
	private static void printNode(ListNode c) { 
		if (c==null) {
			return;
		}
		ListNode tmp=c;
		while (tmp!=null) {
			System.out.println(tmp.val);
			tmp=tmp.next;
		}
		
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int v) {
			val = v;
			next = null;
		}

		public String toString() {
			String str = val + " ";
			ListNode node = next;
			while (node != null) {
				str += node.val + " ";
				node = node.next;
			}
			return str;
		}
	}

	private static int[] parseInts(String[] strArr) {
		if (strArr == null || strArr.length == 0) {
			return new int[0];
		}
		int[] intArr = new int[strArr.length];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

}
